package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    private int usuId;
    private int inbId;
    private int tpuId;
    private int empId;
    private String usuUser;
    private String usuPass;
    private Date audFecha;
    private String audUsuario;

    public Usuario() {
    }

    public Usuario(String usuUser, String usuPass) {
        this.usuUser = usuUser;
        this.usuPass = usuPass;
    }

    public Usuario(
            int usuId,
            int inbId,
            int tpuId,
            int empId,
            String usuUser,
            String usuPass,
            Date audFecha,
            String audUsuario) {
        this.usuId = usuId;
        this.inbId = inbId;
        this.tpuId = tpuId;
        this.empId = empId;
        this.usuUser = usuUser;
        this.usuPass = usuPass;
        this.audFecha = audFecha;
        this.audUsuario = audUsuario;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public int getInbId() {
        return inbId;
    }

    public void setInbId(int inbId) {
        this.inbId = inbId;
    }

    public int getTpuId() {
        return tpuId;
    }

    public void setTpuId(int tpuId) {
        this.tpuId = tpuId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getUsuUser() {
        return usuUser;
    }

    public void setUsuUser(String usuUser) {
        this.usuUser = usuUser;
    }

    public String getUsuPass() {
        return usuPass;
    }

    public void setUsuPass(String usuPass) {
        this.usuPass = usuPass;
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
