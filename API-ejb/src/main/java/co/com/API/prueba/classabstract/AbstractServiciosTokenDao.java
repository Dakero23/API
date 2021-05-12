package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.ServiciosToken;
import co.com.api.prueba.Interface.InterfaceServiciosTokenDao;
import co.com.api.prueba.Controller.ServiciosTokenDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractServiciosTokenDao {

    static InterfaceServiciosTokenDao serviciosTokenD = new ServiciosTokenDao();

    public static GestionRetornoObjeto insertaServiciosToken(ServiciosToken p_serviciosToken) {
        return serviciosTokenD.insertaServiciosToken(p_serviciosToken);
    }

    public static GestionRetornoObjeto actualizaServiciosToken(ServiciosToken p_serviciosToken) {
        return serviciosTokenD.actualizaServiciosToken(p_serviciosToken);
    }

    public static GestionRetornoObjeto eliminaServiciosToken(ServiciosToken p_serviciosToken) {
        return serviciosTokenD.eliminaServiciosToken(p_serviciosToken);
    }

    public static List<ServiciosToken> query_pk_ServiciosToken(ServiciosToken p_serviciosToken) {
        return (List<ServiciosToken>) serviciosTokenD.query_pk_ServiciosToken(p_serviciosToken).getObjetoRetorno();
    }

    public static List<ServiciosToken> query_todos_ServiciosToken() {
        return (List<ServiciosToken>) serviciosTokenD.query_todos_ServiciosToken().getObjetoRetorno();
    }

}
