package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Tarjeta;
import co.com.api.prueba.Interface.InterfaceTarjetaDao;
import co.com.api.prueba.Controller.TarjetaDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractTarjetaDao {

    static InterfaceTarjetaDao tarjetaD = new TarjetaDao();

    public static GestionRetornoObjeto insertaTarjeta(Tarjeta p_tarjeta) {
        return tarjetaD.insertaTarjeta(p_tarjeta);
    }

    public static GestionRetornoObjeto actualizaTarjeta(Tarjeta p_tarjeta) {
        return tarjetaD.actualizaTarjeta(p_tarjeta);
    }

    public static GestionRetornoObjeto eliminaTarjeta(Tarjeta p_tarjeta) {
        return tarjetaD.eliminaTarjeta(p_tarjeta);
    }

    public static List<Tarjeta> query_pk_Tarjeta(Tarjeta p_tarjeta) {
        return (List<Tarjeta>) tarjetaD.query_pk_Tarjeta(p_tarjeta).getObjetoRetorno();
    }

    public static List<Tarjeta> query_todos_Tarjeta() {
        return (List<Tarjeta>) tarjetaD.query_todos_Tarjeta().getObjetoRetorno();
    }

}
