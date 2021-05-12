
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoDocumento;


/**
*
*@author dakero
 */  

public interface InterfaceTipoDocumentoDao	{

GestionRetornoObjeto	insertaTipoDocumento(TipoDocumento	p_tipoDocumento);

GestionRetornoObjeto	actualizaTipoDocumento(TipoDocumento	p_tipoDocumento);

GestionRetornoObjeto	eliminaTipoDocumento(TipoDocumento	p_tipoDocumento);

GestionRetornoObjeto	query_pk_TipoDocumento(TipoDocumento	p_tipoDocumento);

GestionRetornoObjeto	query_todos_TipoDocumento();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	