
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.InformacionBasica;


/**
*
*@author dakero
 */  

public interface InterfaceInformacionBasicaDao	{

GestionRetornoObjeto	insertaInformacionBasica(InformacionBasica	p_informacionBasica);

GestionRetornoObjeto	actualizaInformacionBasica(InformacionBasica	p_informacionBasica);

GestionRetornoObjeto	eliminaInformacionBasica(InformacionBasica	p_informacionBasica);

GestionRetornoObjeto	query_pk_InformacionBasica(InformacionBasica	p_informacionBasica);

GestionRetornoObjeto	query_todos_InformacionBasica();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	