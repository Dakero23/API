
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoUsuario;


/**
*
*@author dakero
 */  

public interface InterfaceTipoUsuarioDao	{

GestionRetornoObjeto	insertaTipoUsuario(TipoUsuario	p_tipoUsuario);

GestionRetornoObjeto	actualizaTipoUsuario(TipoUsuario	p_tipoUsuario);

GestionRetornoObjeto	eliminaTipoUsuario(TipoUsuario	p_tipoUsuario);

GestionRetornoObjeto	query_pk_TipoUsuario(TipoUsuario	p_tipoUsuario);

GestionRetornoObjeto	query_todos_TipoUsuario();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	