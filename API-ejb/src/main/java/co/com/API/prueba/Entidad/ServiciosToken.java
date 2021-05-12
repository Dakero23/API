package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class ServiciosToken implements Serializable {

    private int srtId;
    private int tknId;
    private int srvId;
    private String/*Tipo de dato desconocido.*/ srtEstado;
    private Date audFecha;
    private String audUsuario;

    public ServiciosToken() {
    }

    public ServiciosToken(
            int srtId,
            int tknId,
            int srvId,
            String/*Tipo de dato desconocido.*/ srtEstado,
            Date audFecha,
            String audUsuario) {
        this.srtId = srtId;
        this.tknId = tknId;
        this.srvId = srvId;
        this.srtEstado = srtEstado;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getSrtId() {
        return srtId;
    }

    public void setSrtId(int srtId) {
        this.srtId = srtId;
    }

    public int getTknId() {
        return tknId;
    }

    public void setTknId(int tknId) {
        this.tknId = tknId;
    }

    public int getSrvId() {
        return srvId;
    }

    public void setSrvId(int srvId) {
        this.srvId = srvId;
    }

    public String getSrtEstado() {
        return srtEstado;
    }

    public void setSrtEstado(String srtEstado) {
        this.srtEstado = srtEstado;
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
