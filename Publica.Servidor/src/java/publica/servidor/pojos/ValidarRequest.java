/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package publica.servidor.pojos;

/**
 *
 * @author JOHN JAIRO
 */
public class ValidarRequest {
    
    private String msgEncriptado;
    private String msg;
    private long identificador;

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
