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
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

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
    public Response consultarToken(@QueryParam("user") String username, @QueryParam("password") String password) {
        Usuario usuario = new Usuario(username, password);
        GestionRetornoObjeto retorno = AbstractUsuarioDao.consultarToken(usuario);
        RespuestaWS respuestaWS = new RespuestaWS();
        Gson gson = new Gson();

        JSONObject request = new JSONObject();
        if (retorno.getEstadoProceso().equals("S")) {
            Token token = (Token) retorno.getObjetoRetorno();
            respuestaWS.setCodigo(200);
            respuestaWS.setMensaje(retorno.getMensajeProceso());
//            respuestaWS.setToken((Token) retorno.getObjetoRetorno());
            request.put("token", token.getTknToken());
        } else {
            respuestaWS.setCodigo(400);
            respuestaWS.setMensaje(retorno.getMensajeProceso());
            return Response.status(Response.Status.CONFLICT).entity(respuestaWS.toString()).build();
        }
        String jsonString = gson.toJson(respuestaWS);
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

}
