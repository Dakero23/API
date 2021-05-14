package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Empresa;
import co.com.api.prueba.Interface.InterfaceEmpresaDao;
import co.com.api.prueba.Controller.EmpresaDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractEmpresaDao {

    static InterfaceEmpresaDao empresaD = new EmpresaDao();

    public static GestionRetornoObjeto insertaEmpresa(Empresa p_empresa) {
        return empresaD.insertaEmpresa(p_empresa);
    }

    public static GestionRetornoObjeto actualizaEmpresa(Empresa p_empresa) {
        return empresaD.actualizaEmpresa(p_empresa);
    }

    public static GestionRetornoObjeto eliminaEmpresa(Empresa p_empresa) {
        return empresaD.eliminaEmpresa(p_empresa);
    }

    public static GestionRetornoObjeto query_pk_Empresa(Empresa p_empresa) {
        return empresaD.query_pk_Empresa(p_empresa);
    }

    public static GestionRetornoObjeto query_todos_Empresa() {
        return empresaD.query_todos_Empresa();
    }

}
