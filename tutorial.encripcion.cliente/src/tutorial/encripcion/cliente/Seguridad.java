/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorial.encripcion.cliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author johnmartinez
 */
public class Seguridad {
 
    /**
     * Genera un par de llaves asimetricas RSA. 
     * @return Par de llaves.
     * @throws NoSuchAlgorithmException 
     */
    public static KeyPair GenerarNuevoParLlaves() throws NoSuchAlgorithmException {
        KeyPairGenerator generadorLlaves = KeyPairGenerator.getInstance("RSA");
        generadorLlaves.initialize(2048);
        KeyPair retorno = generadorLlaves.generateKeyPair();        
        return retorno;
    }
    
    /**
     * Guarda la llave privada en la direccion dada
     * @param parLlaves par de llaves generado
     * @param direccion dirección donde se va a guardar
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void GuardarLlavePrivada(KeyPair parLlaves, String direccion) 
            throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException, IOException {
        KeyFactory fabricaLlaves = KeyFactory.getInstance("RSA");
        PrivateKey llavePrivada = parLlaves.getPrivate();
        RSAPrivateKeySpec especificacionLlavePrivada = fabricaLlaves.getKeySpec(llavePrivada, RSAPrivateKeySpec.class);
        BigInteger modulo = especificacionLlavePrivada.getModulus();
        BigInteger exponente = especificacionLlavePrivada.getPrivateExponent();        
        try (ObjectOutputStream objetoSalida = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(direccion)))) {
            objetoSalida.writeObject(modulo);
            objetoSalida.writeObject(exponente);
        }
    }
    
    /**
     * Guarda la llave publica en la dirección dada
     * @param parLlaves par de llaves
     * @param direccion dirección donde se va a guardar
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void GuardarLlavePublica(KeyPair parLlaves, String direccion) 
            throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException, IOException {
        KeyFactory fabricaLlaves = KeyFactory.getInstance("RSA");
        PublicKey llavePublica = parLlaves.getPublic();
        RSAPublicKeySpec especificacionLlavePrivada = fabricaLlaves.getKeySpec(llavePublica, RSAPublicKeySpec.class);
        BigInteger modulo = especificacionLlavePrivada.getModulus();
        BigInteger exponente = especificacionLlavePrivada.getPublicExponent();
        try (ObjectOutputStream objetoSalida = 
                new ObjectOutputStream(new BufferedOutputStream(
                        new FileOutputStream(direccion)))) {
            objetoSalida.writeObject(modulo);
            objetoSalida.writeObject(exponente);
        }
    }
    
    /**
     * Lee la llave pública de la dirección dada.
     * @param direccion dirección de la cual se va a leer la llave pública
     * @return Llave pública leída.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public static PublicKey LeerLlavePublica(String direccion) throws FileNotFoundException, IOException, 
            ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream in = new FileInputStream(direccion);
        ObjectInputStream streamObjetoEntrada = new ObjectInputStream(new BufferedInputStream(in));        
        BigInteger modulo = (BigInteger) streamObjetoEntrada.readObject();
        BigInteger exponente = (BigInteger) streamObjetoEntrada.readObject();
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulo, exponente);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        PublicKey pubKey = fact.generatePublic(keySpec);
        return pubKey;        
    }    
    
    /**
     * Lee la llave privada de la dirección dada.
     * @param direccion dirección de la cual se va a leer la llave pública
     * @return Llave pública leída.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException 
     */
    public static PrivateKey LeerLlavePrivada(String direccion) throws FileNotFoundException, IOException, 
            ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException {
        FileInputStream in = new FileInputStream(direccion);
        ObjectInputStream streamObjetoEntrada = new ObjectInputStream(new BufferedInputStream(in));        
        BigInteger modulo = (BigInteger) streamObjetoEntrada.readObject();
        BigInteger exponente = (BigInteger) streamObjetoEntrada.readObject();
        RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(modulo, exponente);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        PrivateKey privKey = fact.generatePrivate(keySpec);
        return privKey;        
    }
    
    /**
     * 
     * @param mensajeAEncriptar
     * @param llavePrivada
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException 
     */
    public static byte[] EncriptarMensaje(String mensajeAEncriptar, PrivateKey llavePrivada) 
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {        
        Cipher encriptador;        
        encriptador = Cipher.getInstance("RSA");
        encriptador.init(Cipher.ENCRYPT_MODE, llavePrivada);
        byte[] retorno = encriptador.doFinal(mensajeAEncriptar.getBytes());
        return retorno;
    }
    
}
