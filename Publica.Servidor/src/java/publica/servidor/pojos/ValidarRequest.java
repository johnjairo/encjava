
package publica.servidor.pojos;

/**
 * Clase POJO (Plain Old Java Object) para la operación validar
 * @author JOHN JAIRO
 */
public class ValidarRequest {
    
    /**
     * Representación en base64 del mensaje encriptado
     */
    private String msgEncriptado;
    /**
     * Mensaje sin encriptar
     */
    private String msg;
    /**
     * Identificador de la llave pública
     */
    private long identificador;

    /**
     * Constructor de la clase para hacer solicitud de verificación de un mensaje
     * @param msgEncriptado mensaje encriptado en base64
     * @param msg mensaje en texto plano
     * @param identificador identificador de la llave almacenada en el servidor
     */
    public ValidarRequest(String msgEncriptado, String msg, long identificador) {
        this.msgEncriptado = msgEncriptado;
        this.msg = msg;
        this.identificador = identificador;
    }            

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the identificador
     */
    public long getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the msgEncriptado
     */
    public String getMsgEncriptado() {
        return msgEncriptado;
    }

    /**
     * @param msgEncriptado the msgEncriptado to set
     */
    public void setMsgEncriptado(String msgEncriptado) {
        this.msgEncriptado = msgEncriptado;
    }
    
}
