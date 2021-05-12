package co.com.api.prueba.Entidad;

import java.io.Serializable;
import java.util.Date;

public class TipoDocumento implements Serializable {

    private String tipDoc;
    private String tipNombre;

    public TipoDocumento() {
    }

    public TipoDocumento(
            String tipDoc,
            String tipNombre) {
        this.tipDoc = tipDoc;
        this.tipNombre = tipNombre;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

}
