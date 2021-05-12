/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.API.controller;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Token;
import co.com.api.prueba.classabstract.AbstractTokenDao;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author dakero
 */
public abstract class AbstractValidacion {

    public static GestionRetornoObjeto validarToken(HttpHeaders headers) {
        String token = headers.getHeaderString(HttpHeaders.AUTHORIZATION);
        GestionRetornoObjeto retornoObj = new GestionRetornoObjeto();
        if (token != null && token.contains("Bearer")) {
            token = token.replaceFirst("Bearer ", "");
            Token p_token = new Token();
            p_token.setTknToken(token);
            retornoObj = AbstractTokenDao.validar_Token(p_token);
            return retornoObj;
        }
        retornoObj.setEstadoProceso("N");
        retornoObj.setMensajeProceso("Token No Encontrado.");
        return retornoObj;
    }

}
