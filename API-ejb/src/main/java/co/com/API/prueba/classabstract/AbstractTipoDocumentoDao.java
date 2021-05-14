package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoDocumento;
import co.com.api.prueba.Interface.InterfaceTipoDocumentoDao;
import co.com.api.prueba.Controller.TipoDocumentoDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractTipoDocumentoDao {

    static InterfaceTipoDocumentoDao tipoDocumentoD = new TipoDocumentoDao();

    public static GestionRetornoObjeto insertaTipoDocumento(TipoDocumento p_tipoDocumento) {
        return tipoDocumentoD.insertaTipoDocumento(p_tipoDocumento);
    }

    public static GestionRetornoObjeto actualizaTipoDocumento(TipoDocumento p_tipoDocumento) {
        return tipoDocumentoD.actualizaTipoDocumento(p_tipoDocumento);
    }

    public static GestionRetornoObjeto eliminaTipoDocumento(TipoDocumento p_tipoDocumento) {
        return tipoDocumentoD.eliminaTipoDocumento(p_tipoDocumento);
    }

    public static GestionRetornoObjeto query_pk_TipoDocumento(TipoDocumento p_tipoDocumento) {
        return tipoDocumentoD.query_pk_TipoDocumento(p_tipoDocumento);
    }

    public static GestionRetornoObjeto query_todos_TipoDocumento() {
        return tipoDocumentoD.query_todos_TipoDocumento();
    }

}
