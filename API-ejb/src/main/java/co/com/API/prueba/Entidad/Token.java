package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class Token implements Serializable {

    private int tknId;
    private int usuId;
    private String tknToken;
    private Date tknFecVig;
    private Date audFecha;
    private String audUsuario;

    public Token() {
    }

    public Token(
            int tknId,
            int usuId,
            String tknToken,
            Date tknFecVig,
            Date audFecha,
            String audUsuario) {
        this.tknId = tknId;
        this.usuId = usuId;
        this.tknToken = tknToken;
        this.tknFecVig = tknFecVig;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getTknId() {
        return tknId;
    }

    public void setTknId(int tknId) {
        this.tknId = tknId;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getTknToken() {
        return tknToken;
    }

    public void setTknToken(String tknToken) {
        this.tknToken = tknToken;
    }

    public Date getTknFecVig() {
        return tknFecVig;
    }

    public void setTknFecVig(Date tknFecVig) {
        this.tknFecVig = tknFecVig;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

}
