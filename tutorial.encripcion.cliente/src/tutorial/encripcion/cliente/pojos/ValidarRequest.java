/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.encripcion.cliente.pojos;

/**
 *
 * @author JOHN JAIRO
 */
public class ValidarRequest {
    
    private byte[] msgEncriptado;
    private String msg;
    private long identificador;

    public ValidarRequest(byte[] msgEncriptado, String msg, long identificador) {
        this.msgEncriptado = msgEncriptado;
        this.msg = msg;
        this.identificador = identificador;
    }        

    /**
     * @return the msgEncriptado
     */
    public byte[] getMsgEncriptado() {
        return msgEncriptado;
    }

    /**
     * @param msgEncriptado the msgEncriptado to set
     */
    public void setMsgEncriptado(byte[] msgEncriptado) {
        this.msgEncriptado = msgEncriptado;
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
    
}
