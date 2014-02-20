/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publica.servidor.pojos;

/**
 *
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
