package co.com.api.prueba.Interface;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Token;

/**
 *
 * @author dakero
 */
public interface InterfaceTokenDao {

    GestionRetornoObjeto insertaToken(Token p_token);

    GestionRetornoObjeto actualizaToken(Token p_token);

    GestionRetornoObjeto eliminaToken(Token p_token);

    GestionRetornoObjeto query_pk_Token(Token p_token);

    GestionRetornoObjeto query_todos_Token();

    GestionRetornoObjeto validar_Token(Token p_token);

}
