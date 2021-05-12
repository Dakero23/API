
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoTarjeta;


/**
*
*@author dakero
 */  

public interface InterfaceTipoTarjetaDao	{

GestionRetornoObjeto	insertaTipoTarjeta(TipoTarjeta	p_tipoTarjeta);

GestionRetornoObjeto	actualizaTipoTarjeta(TipoTarjeta	p_tipoTarjeta);

GestionRetornoObjeto	eliminaTipoTarjeta(TipoTarjeta	p_tipoTarjeta);

GestionRetornoObjeto	query_pk_TipoTarjeta(TipoTarjeta	p_tipoTarjeta);

GestionRetornoObjeto	query_todos_TipoTarjeta();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	