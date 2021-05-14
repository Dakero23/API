package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoUsuario;
import co.com.api.prueba.Interface.InterfaceTipoUsuarioDao;
import co.com.api.prueba.Controller.TipoUsuarioDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractTipoUsuarioDao {

    static InterfaceTipoUsuarioDao tipoUsuarioD = new TipoUsuarioDao();

    public static GestionRetornoObjeto insertaTipoUsuario(TipoUsuario p_tipoUsuario) {
        return tipoUsuarioD.insertaTipoUsuario(p_tipoUsuario);
    }

    public static GestionRetornoObjeto actualizaTipoUsuario(TipoUsuario p_tipoUsuario) {
        return tipoUsuarioD.actualizaTipoUsuario(p_tipoUsuario);
    }

    public static GestionRetornoObjeto eliminaTipoUsuario(TipoUsuario p_tipoUsuario) {
        return tipoUsuarioD.eliminaTipoUsuario(p_tipoUsuario);
    }

    public static GestionRetornoObjeto query_pk_TipoUsuario(TipoUsuario p_tipoUsuario) {
        return tipoUsuarioD.query_pk_TipoUsuario(p_tipoUsuario);
    }

    public static GestionRetornoObjeto query_todos_TipoUsuario() {
        return tipoUsuarioD.query_todos_TipoUsuario();
    }

}
