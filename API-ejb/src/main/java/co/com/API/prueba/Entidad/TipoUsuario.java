package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class TipoUsuario implements Serializable {

    private int tpuId;
    private String tpuDescripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(
            int tpuId,
            String tpuDescripcion) {
        this.tpuId = tpuId;
        this.tpuDescripcion = tpuDescripcion;
    }

    public int getTpuId() {
        return tpuId;
    }

    public void setTpuId(int tpuId) {
        this.tpuId = tpuId;
    }

    public String getTpuDescripcion() {
        return tpuDescripcion;
    }

    public void setTpuDescripcion(String tpuDescripcion) {
        this.tpuDescripcion = tpuDescripcion;
    }
    

}
