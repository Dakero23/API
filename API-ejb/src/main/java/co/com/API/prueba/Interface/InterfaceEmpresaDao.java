
	/*||****************************||
	||||||||||||||||||||||||||||||||
	*/

package co.com.api.prueba.Interface;


import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Empresa;


/**
*
*@author dakero
 */  

public interface InterfaceEmpresaDao	{

GestionRetornoObjeto	insertaEmpresa(Empresa	p_empresa);

GestionRetornoObjeto	actualizaEmpresa(Empresa	p_empresa);

GestionRetornoObjeto	eliminaEmpresa(Empresa	p_empresa);

GestionRetornoObjeto	query_pk_Empresa(Empresa	p_empresa);

GestionRetornoObjeto	query_todos_Empresa();

}
	/*
	||||||||||||||||||||||||||||||||
	||****************************||*/
	