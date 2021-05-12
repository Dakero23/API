package co.com.API;

import co.com.API.controller.AbstractValidacion;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Usuario;
import co.com.api.prueba.classabstract.AbstractUsuarioDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.JSONObject;

/**
 *
 * @author dakero
 */
@Path("/usuarioApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class usuarioApp {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(Usuario user) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Status.ACCEPTED).entity(AbstractUsuarioDao.actualizaUsuario(user)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarUsuario(@QueryParam("id") int id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id > 0) {
            Usuario p_usuario = new Usuario();
            p_usuario.setUsuId(id);
            query = AbstractUsuarioDao.query_pk_Usuario(p_usuario);

        } else {
            query = AbstractUsuarioDao.query_todos_Usuario();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<Usuario> usuario = (List<Usuario>) query.getObjetoRetorno();
        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Status.ACCEPTED).entity(jsonConverter.toJson(usuario)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario p_usuario) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractUsuarioDao.insertaUsuario(p_usuario);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_USUARIO");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarUsuario(@QueryParam("id") int id) {
        Usuario p_usuario = new Usuario();
        p_usuario.setUsuId(id);
        return AbstractUsuarioDao.eliminaUsuario(p_usuario);
    }
}
