package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoTarjeta;
import co.com.api.prueba.Interface.InterfaceTipoTarjetaDao;
import co.com.api.prueba.Controller.TipoTarjetaDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractTipoTarjetaDao {

    static InterfaceTipoTarjetaDao tipoTarjetaD = new TipoTarjetaDao();

    public static GestionRetornoObjeto insertaTipoTarjeta(TipoTarjeta p_tipoTarjeta) {
        return tipoTarjetaD.insertaTipoTarjeta(p_tipoTarjeta);
    }

    public static GestionRetornoObjeto actualizaTipoTarjeta(TipoTarjeta p_tipoTarjeta) {
        return tipoTarjetaD.actualizaTipoTarjeta(p_tipoTarjeta);
    }

    public static GestionRetornoObjeto eliminaTipoTarjeta(TipoTarjeta p_tipoTarjeta) {
        return tipoTarjetaD.eliminaTipoTarjeta(p_tipoTarjeta);
    }

    public static List<TipoTarjeta> query_pk_TipoTarjeta(TipoTarjeta p_tipoTarjeta) {
        return (List<TipoTarjeta>) tipoTarjetaD.query_pk_TipoTarjeta(p_tipoTarjeta).getObjetoRetorno();
    }

    public static List<TipoTarjeta> query_todos_TipoTarjeta() {
        return (List<TipoTarjeta>) tipoTarjetaD.query_todos_TipoTarjeta().getObjetoRetorno();
    }

}
