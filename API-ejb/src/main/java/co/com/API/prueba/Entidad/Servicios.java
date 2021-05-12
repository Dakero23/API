package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class Servicios implements Serializable {

    private int srvId;
    private String srvNombre;
    private String srvDescripcion;
    private Date srvFecVig;
    private String srvVersion;
    private Date audFecha;
    private String audUsuario;

    public Servicios() {
    }

    public Servicios(
            int srvId,
            String srvNombre,
            String srvDescripcion,
            Date srvFecVig,
            String srvVersion,
            Date audFecha,
            String audUsuario) {
        this.srvId = srvId;
        this.srvNombre = srvNombre;
        this.srvDescripcion = srvDescripcion;
        this.srvFecVig = srvFecVig;
        this.srvVersion = srvVersion;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getSrvId() {
        return srvId;
    }

    public void setSrvId(int srvId) {
        this.srvId = srvId;
    }

    public String getSrvNombre() {
        return srvNombre;
    }

    public void setSrvNombre(String srvNombre) {
        this.srvNombre = srvNombre;
    }

    public String getSrvDescripcion() {
        return srvDescripcion;
    }

    public void setSrvDescripcion(String srvDescripcion) {
        this.srvDescripcion = srvDescripcion;
    }

    public Date getSrvFecVig() {
        return srvFecVig;
    }

    public void setSrvFecVig(Date srvFecVig) {
        this.srvFecVig = srvFecVig;
    }

    public String getSrvVersion() {
        return srvVersion;
    }

    public void setSrvVersion(String srvVersion) {
        this.srvVersion = srvVersion;
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
