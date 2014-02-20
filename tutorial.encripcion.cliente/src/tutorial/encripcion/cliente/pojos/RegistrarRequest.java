/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.encripcion.cliente.pojos;

/**
 * Clase POJO para la operación registrar post
 * @author JOHN JAIRO
 */
public class RegistrarRequest {
    
    /**
     * Llave publica a recibir
     */
    private byte[] modulo;
    
    /**
     * Exponente de la llave publica
     */
    private byte[] exponente;

    public RegistrarRequest(byte[] modulo, byte[] exponente) {
        this.modulo = modulo;
        this.exponente = exponente;
    }

    /**
     * @return the modulo
     */
    public byte[] getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(byte[] modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the exponente
     */
    public byte[] getExponente() {
        return exponente;
    }

    /**
     * @param exponente the exponente to set
     */
    public void setExponente(byte[] exponente) {
        this.exponente = exponente;
    }

    
    
}
