/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publica.servidor.datos;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JOHN JAIRO
 */
public class OperacionesDatos {

    
    private static final String BASE_DATOS = "jdbc:mysql://localhost/seguridad?user=root&password=development";
    
    public OperacionesDatos() {
    }
    
    /**
     * Agrega una llave pública a la base de datos. Retorna el identificador de la llave registrada
     * @param modulo modulo de la llave publica
     * @param exponente exponente de la llave publica
     * @return Identificador de la llave registrada. -1 en caso de error
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public long AgregarLlavePublica(byte[] modulo, byte[] exponente) 
            throws ClassNotFoundException, SQLException {
        // operación a ejecutar
        String sql = "INSERT INTO LlavesPublicas(modulo, exponente) "
                + "VALUES(?, ?)";     
        // cargar la conexión a la base de datos        
        Connection conexion = this.devolverConexion();
        // Añadir parametros al statement
        PreparedStatement operacion = conexion.prepareStatement(sql);        
        operacion.setBytes(1, modulo);
        operacion.setBytes(2, exponente);
        int validar = operacion.executeUpdate();
        if( validar > 0){
            PreparedStatement ultimoInsert = conexion.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet rs = ultimoInsert.executeQuery();            
            rs.next();
            long retorno = rs.getLong(1);
            return retorno;
        }
        return -1;
    }
    
    /**
     * Lee una llave publica de la base de datos. 
     * @param Identificador identificador de la llave publica
     * @return Llave publica leida de la base de datos
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.spec.InvalidKeySpecException
     */
    public PublicKey LeerLlavePublica(long Identificador) throws ClassNotFoundException, SQLException, 
            NoSuchAlgorithmException, InvalidKeySpecException {
        // Operación a ejecutar
        String sql = "SELECT idLlavesPublicas, modulo, exponente "
                + "FROM LlavesPublicas WHERE idLlavesPublicas = ?";
        // crear conexion a la base de datos
        Connection conexion = this.devolverConexion();
        // añadir parametros al statement
        PreparedStatement consulta = conexion.prepareStatement(sql);
        consulta.setLong(1, Identificador);
        // leer datos
        ResultSet resultado = consulta.executeQuery();
        resultado.next();
        byte[] bdModulo = resultado.getBytes(2);
        byte[] bdExponente = resultado.getBytes(3);
        // convertir datos
        BigInteger modulo = new BigInteger(bdModulo);
        BigInteger exponente = new BigInteger(bdExponente);
        // crear llave publica
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulo, exponente);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        PublicKey pubKey = fact.generatePublic(keySpec);
        return pubKey;                
    }
    
    
    /**
     * Devuelve una conexión a la base de datos.
     * @return Conexión a la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    private Connection devolverConexion() throws ClassNotFoundException, SQLException {
        // cargar la conexión a la base de datos
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(BASE_DATOS);
        // devolver conexion
        return conexion;
    }
    
}
