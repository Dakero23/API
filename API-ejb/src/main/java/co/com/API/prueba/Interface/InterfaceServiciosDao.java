
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Servicios;


/**
*
*@author dakero
 */  

public interface InterfaceServiciosDao	{

GestionRetornoObjeto	insertaServicios(Servicios	p_servicios);

GestionRetornoObjeto	actualizaServicios(Servicios	p_servicios);

GestionRetornoObjeto	eliminaServicios(Servicios	p_servicios);

GestionRetornoObjeto	query_pk_Servicios(Servicios	p_servicios);

GestionRetornoObjeto	query_todos_Servicios();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	