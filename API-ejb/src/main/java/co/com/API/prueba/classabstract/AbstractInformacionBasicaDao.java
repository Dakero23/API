package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.InformacionBasica;
import co.com.api.prueba.Interface.InterfaceInformacionBasicaDao;
import co.com.api.prueba.Controller.InformacionBasicaDao;

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

    public static GestionRetornoObjeto query_pk_InformacionBasica(InformacionBasica p_informacionBasica) {
        return informacionBasicaD.query_pk_InformacionBasica(p_informacionBasica);
    }

    public static GestionRetornoObjeto query_todos_InformacionBasica() {
        return informacionBasicaD.query_todos_InformacionBasica();
    }

}
