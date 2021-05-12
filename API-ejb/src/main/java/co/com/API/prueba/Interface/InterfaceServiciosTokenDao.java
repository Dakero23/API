
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.ServiciosToken;


/**
*
*@author dakero
 */  

public interface InterfaceServiciosTokenDao	{

GestionRetornoObjeto	insertaServiciosToken(ServiciosToken	p_serviciosToken);

GestionRetornoObjeto	actualizaServiciosToken(ServiciosToken	p_serviciosToken);

GestionRetornoObjeto	eliminaServiciosToken(ServiciosToken	p_serviciosToken);

GestionRetornoObjeto	query_pk_ServiciosToken(ServiciosToken	p_serviciosToken);

GestionRetornoObjeto	query_todos_ServiciosToken();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	