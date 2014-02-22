
package publica.servidor.pojos;

/**
 * Clase POJO (Plain Old Java Object) para la respuesta de la operación Registrar
 * @author JOHN JAIRO
 */
public class RegistrarResponse {
    
    /**
     * Identificador de la llave publica creada
     */
    private long id;

    /**
     * Constructor de la clase
     * @param id 
     */
    public RegistrarResponse(long id) {
        this.id = id;
    }

    /**
     * Devuelve el id
     * @return 
     */
    public long getId() {
        return id;
    }

    /**
     * Asigna el id
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }
    
}
