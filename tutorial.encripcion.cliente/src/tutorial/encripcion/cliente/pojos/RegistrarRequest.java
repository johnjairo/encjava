
package tutorial.encripcion.cliente.pojos;

/**
 * Clase POJO (Plain Old Java Object) para la operación registrar post
 * @author JOHN JAIRO
 */
public class RegistrarRequest {
    
    /**
     * Llave publica a recibir
     */
    private String modulo;
    
    /**
     * Exponente de la llave publica
     */
    private String exponente;

    /**
     * Constructor de la clase. 
     * @param modulo Representación del modulo en base64
     * @param exponente Representación del modula en base64
     */
    public RegistrarRequest(String modulo, String exponente) {
        this.modulo = modulo;
        this.exponente = exponente;
    }        
    
    /**
     * @return the modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the exponente
     */
    public String getExponente() {
        return exponente;
    }

    /**
     * @param exponente the exponente to set
     */
    public void setExponente(String exponente) {
        this.exponente = exponente;
    }

}
