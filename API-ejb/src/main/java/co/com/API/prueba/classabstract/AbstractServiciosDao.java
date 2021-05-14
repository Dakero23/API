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

    public static GestionRetornoObjeto query_pk_Servicios(Servicios p_servicios) {
        return serviciosD.query_pk_Servicios(p_servicios);
    }

    public static GestionRetornoObjeto query_todos_Servicios() {
        return serviciosD.query_todos_Servicios();
    }

}
