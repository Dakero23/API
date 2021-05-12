
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Tarjeta;


/**
*
*@author dakero
 */  

public interface InterfaceTarjetaDao	{

GestionRetornoObjeto	insertaTarjeta(Tarjeta	p_tarjeta);

GestionRetornoObjeto	actualizaTarjeta(Tarjeta	p_tarjeta);

GestionRetornoObjeto	eliminaTarjeta(Tarjeta	p_tarjeta);

GestionRetornoObjeto	query_pk_Tarjeta(Tarjeta	p_tarjeta);

GestionRetornoObjeto	query_todos_Tarjeta();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	