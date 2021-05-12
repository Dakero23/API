package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Usuario;
import co.com.api.prueba.Interface.InterfaceUsuarioDao;
import co.com.api.prueba.Controller.UsuarioDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractUsuarioDao {

    static InterfaceUsuarioDao usuarioD = new UsuarioDao();

    public static GestionRetornoObjeto insertaUsuario(Usuario p_usuario) {
        return usuarioD.insertaUsuario(p_usuario);
    }

    public static GestionRetornoObjeto actualizaUsuario(Usuario p_usuario) {
        return usuarioD.actualizaUsuario(p_usuario);
    }

    public static GestionRetornoObjeto eliminaUsuario(Usuario p_usuario) {
        return usuarioD.eliminaUsuario(p_usuario);
    }

    public static GestionRetornoObjeto query_pk_Usuario(Usuario p_usuario) {
        return usuarioD.query_pk_Usuario(p_usuario);
    }

    public static GestionRetornoObjeto query_todos_Usuario() {
        return  usuarioD.query_todos_Usuario();
    }
    
    public static GestionRetornoObjeto consultarToken(Usuario usuario) {
        return usuarioD.consultarToken(usuario);
    }
    
    

}
