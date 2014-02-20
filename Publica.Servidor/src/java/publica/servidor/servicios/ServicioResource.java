/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publica.servidor.servicios;

import com.google.gson.Gson;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import publica.servidor.datos.OperacionesDatos;
import publica.servidor.pojos.RegistrarRequest;
import publica.servidor.pojos.RegistrarResponse;
import publica.servidor.pojos.ValidarRequest;

/**
 * REST Web Service
 *
 * @author JOHN JAIRO
 */
@Path("Servicio")
public class ServicioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioResource
     */
    public ServicioResource() {
    }

    /**
     * Retrieves representation of an instance of publica.servidor.servicios.ServicioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hola Mundo";
    }

    /**
     * PUT method for updating or creating an instance of ServicioResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response registrar(String recibido) {
        Gson gson;        
        RegistrarRequest request;        
        BigInteger modulo;
        BigInteger exponente;
        long retorno = -1;
        try {
            gson = new Gson();
            request = gson.fromJson(recibido, RegistrarRequest.class);
            modulo = new BigInteger(request.getModulo());
            exponente = new BigInteger(request.getExponente());
        } catch (Exception e) {            
            //throw new HTTPException(400); // bad request exception
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        OperacionesDatos bd = new OperacionesDatos();
        try {
            // validar que sea una llave pública
            RSAPublicKeySpec specs = new RSAPublicKeySpec(modulo, exponente);
            KeyFactory fabrica = KeyFactory.getInstance("RSA");
            PublicKey publica = fabrica.generatePublic(specs);
            // insertar en la base de datos
            retorno = bd.AgregarLlavePublica(request.getModulo(), request.getExponente());
        } catch (Exception e) {
            return Response.status(Response.Status.PRECONDITION_FAILED).build();
        }
        RegistrarResponse objRetorno = new RegistrarResponse(retorno);
        String strRetorno = gson.toJson(objRetorno, RegistrarResponse.class);
        return Response.ok(strRetorno).build();
    }
    
    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validar(String recibido) {
        ValidarRequest request;
        Gson gson;
        boolean retorno = false;
        try {
            gson = new Gson();
            request = gson.fromJson(recibido, ValidarRequest.class);                        
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        OperacionesDatos bd = new OperacionesDatos();
        try {
            PublicKey llavePublica = bd.LeerLlavePublica(request.getIdentificador());
            Cipher encriptador;
            encriptador = Cipher.getInstance("RSA");
            encriptador.init(Cipher.DECRYPT_MODE, llavePublica);
            byte[] mensaje = encriptador.doFinal(request.getMsgEncriptado());
            String msgDesencriptado = new String(mensaje);
            retorno = msgDesencriptado.equals(request.getMsg());
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }        
        String strRetorno = gson.toJson(retorno, boolean.class);
        if(retorno) {
            return Response.ok(strRetorno).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }        
    }
    
}
