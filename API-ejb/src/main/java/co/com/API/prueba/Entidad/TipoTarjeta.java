package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class TipoTarjeta implements Serializable {

    private int ttjId;
    private String ttjNombre;
    private Date audFecha;
    private String audUsuario;

    public TipoTarjeta() {
    }

    public TipoTarjeta(
            int ttjId,
            String ttjNombre,
            Date audFecha,
            String audUsuario) {
        this.ttjId = ttjId;
        this.ttjNombre = ttjNombre;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getTtjId() {
        return ttjId;
    }

    public void setTtjId(int ttjId) {
        this.ttjId = ttjId;
    }

    public String getTtjNombre() {
        return ttjNombre;
    }

    public void setTtjNombre(String ttjNombre) {
        this.ttjNombre = ttjNombre;
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
