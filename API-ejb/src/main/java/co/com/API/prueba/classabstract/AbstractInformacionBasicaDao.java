package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.InformacionBasica;
import co.com.api.prueba.Interface.InterfaceInformacionBasicaDao;
import co.com.api.prueba.Controller.InformacionBasicaDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractInformacionBasicaDao {

    static InterfaceInformacionBasicaDao informacionBasicaD = new InformacionBasicaDao();

    public static GestionRetornoObjeto insertaInformacionBasica(InformacionBasica p_informacionBasica) {
        return informacionBasicaD.insertaInformacionBasica(p_informacionBasica);
    }

    public static GestionRetornoObjeto actualizaInformacionBasica(InformacionBasica p_informacionBasica) {
        return informacionBasicaD.actualizaInformacionBasica(p_informacionBasica);
    }

    public static GestionRetornoObjeto eliminaInformacionBasica(InformacionBasica p_informacionBasica) {
        return informacionBasicaD.eliminaInformacionBasica(p_informacionBasica);
    }

    public static List<InformacionBasica> query_pk_InformacionBasica(InformacionBasica p_informacionBasica) {
        return (List<InformacionBasica>) informacionBasicaD.query_pk_InformacionBasica(p_informacionBasica).getObjetoRetorno();
    }

    public static List<InformacionBasica> query_todos_InformacionBasica() {
        return (List<InformacionBasica>) informacionBasicaD.query_todos_InformacionBasica().getObjetoRetorno();
    }

}
