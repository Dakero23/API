package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Servicios;
import co.com.api.prueba.Interface.InterfaceServiciosDao;
import co.com.api.prueba.Controller.ServiciosDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractServiciosDao {

    static InterfaceServiciosDao serviciosD = new ServiciosDao();

    public static GestionRetornoObjeto insertaServicios(Servicios p_servicios) {
        return serviciosD.insertaServicios(p_servicios);
    }

    public static GestionRetornoObjeto actualizaServicios(Servicios p_servicios) {
        return serviciosD.actualizaServicios(p_servicios);
    }

    public static GestionRetornoObjeto eliminaServicios(Servicios p_servicios) {
        return serviciosD.eliminaServicios(p_servicios);
    }

    public static List<Servicios> query_pk_Servicios(Servicios p_servicios) {
        return (List<Servicios>) serviciosD.query_pk_Servicios(p_servicios).getObjetoRetorno();
    }

    public static List<Servicios> query_todos_Servicios() {
        return (List<Servicios>) serviciosD.query_todos_Servicios().getObjetoRetorno();
    }

}
