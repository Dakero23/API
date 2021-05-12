package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class Tarjeta implements Serializable {

    private int tarId;
    private int ttjId;
    private int usuId;
    private int tarNumero;
    private String tarNombre;
    private String tarFecExp;
    private Short tarCodSeg;
    private Date audFecha;
    private String audUsuario;

    public Tarjeta() {
    }

    public Tarjeta(
            int tarId,
            int ttjId,
            int usuId,
            int tarNumero,
            String tarNombre,
            String tarFecExp,
            Short tarCodSeg,
            Date audFecha,
            String audUsuario) {
        this.tarId = tarId;
        this.ttjId = ttjId;
        this.usuId = usuId;
        this.tarNumero = tarNumero;
        this.tarNombre = tarNombre;
        this.tarFecExp = tarFecExp;
        this.tarCodSeg = tarCodSeg;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getTarId() {
        return tarId;
    }

    public void setTarId(int tarId) {
        this.tarId = tarId;
    }

    public int getTtjId() {
        return ttjId;
    }

    public void setTtjId(int ttjId) {
        this.ttjId = ttjId;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public int getTarNumero() {
        return tarNumero;
    }

    public void setTarNumero(int tarNumero) {
        this.tarNumero = tarNumero;
    }

    public String getTarNombre() {
        return tarNombre;
    }

    public void setTarNombre(String tarNombre) {
        this.tarNombre = tarNombre;
    }

    public String getTarFecExp() {
        return tarFecExp;
    }

    public void setTarFecExp(String tarFecExp) {
        this.tarFecExp = tarFecExp;
    }

    public Short getTarCodSeg() {
        return tarCodSeg;
    }

    public void setTarCodSeg(Short tarCodSeg) {
        this.tarCodSeg = tarCodSeg;
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
