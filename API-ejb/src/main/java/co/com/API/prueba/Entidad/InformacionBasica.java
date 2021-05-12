package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class InformacionBasica implements Serializable {

    private int inbId;
    private String tipDoc;
    private int inbDocumento;
    private String inbNombre;
    private String inbApellido;
    private String inbCorreo;
    private int inbCelular;
    private int inbTelefono;
    private String inbDireccion;
    private Date audFecha;
    private String audUsuario;

    public InformacionBasica() {
    }

    public InformacionBasica(
            int inbId,
            String tipDoc,
            int inbDocumento,
            String inbNombre,
            String inbApellido,
            String inbCorreo,
            int inbCelular,
            int inbTelefono,
            String inbDireccion,
            Date audFecha,
            String audUsuario) {
        this.inbId = inbId;
        this.tipDoc = tipDoc;
        this.inbDocumento = inbDocumento;
        this.inbNombre = inbNombre;
        this.inbApellido = inbApellido;
        this.inbCorreo = inbCorreo;
        this.inbCelular = inbCelular;
        this.inbTelefono = inbTelefono;
        this.inbDireccion = inbDireccion;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getInbId() {
        return inbId;
    }

    public void setInbId(int inbId) {
        this.inbId = inbId;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public int getInbDocumento() {
        return inbDocumento;
    }

    public void setInbDocumento(int inbDocumento) {
        this.inbDocumento = inbDocumento;
    }

    public String getInbNombre() {
        return inbNombre;
    }

    public void setInbNombre(String inbNombre) {
        this.inbNombre = inbNombre;
    }

    public String getInbApellido() {
        return inbApellido;
    }

    public void setInbApellido(String inbApellido) {
        this.inbApellido = inbApellido;
    }

    public String getInbCorreo() {
        return inbCorreo;
    }

    public void setInbCorreo(String inbCorreo) {
        this.inbCorreo = inbCorreo;
    }

    public int getInbCelular() {
        return inbCelular;
    }

    public void setInbCelular(int inbCelular) {
        this.inbCelular = inbCelular;
    }

    public int getInbTelefono() {
        return inbTelefono;
    }

    public void setInbTelefono(int inbTelefono) {
        this.inbTelefono = inbTelefono;
    }

    public String getInbDireccion() {
        return inbDireccion;
    }

    public void setInbDireccion(String inbDireccion) {
        this.inbDireccion = inbDireccion;
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
