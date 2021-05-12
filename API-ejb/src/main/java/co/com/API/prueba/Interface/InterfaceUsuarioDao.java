package co.com.api.prueba.Interface;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Usuario;

/**
 *
 * @author dakero
 */
public interface InterfaceUsuarioDao {

    GestionRetornoObjeto insertaUsuario(Usuario p_usuario);

    GestionRetornoObjeto actualizaUsuario(Usuario p_usuario);

    GestionRetornoObjeto eliminaUsuario(Usuario p_usuario);

    GestionRetornoObjeto query_pk_Usuario(Usuario p_usuario);

    GestionRetornoObjeto query_todos_Usuario();

    GestionRetornoObjeto consultarToken(Usuario usuario);

}
