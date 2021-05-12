/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.API;

import co.com.API.entidad.RespuestaWS;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Token;
import co.com.api.prueba.Entidad.Usuario;
import co.com.api.prueba.classabstract.AbstractUsuarioDao;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dakero
 */
@Path("/app")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class aplicacion {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaWS consultarToken(@QueryParam("user") String username, @QueryParam("password") String password) {
        

        Usuario usuario = new Usuario(username, password);
        GestionRetornoObjeto retorno = AbstractUsuarioDao.consultarToken(usuario);
        RespuestaWS respuestaWS = new RespuestaWS();
        if (retorno.getEstadoProceso().equals("S")) {
            respuestaWS.setCodigo(200);
            respuestaWS.setMensaje(retorno.getMensajeProceso());
            respuestaWS.setToken((Token) retorno.getObjetoRetorno());

        } else {
            respuestaWS.setCodigo(400);
            respuestaWS.setMensaje(retorno.getMensajeProceso());

        }
        return respuestaWS;
    }

}
