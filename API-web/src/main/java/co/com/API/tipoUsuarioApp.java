package co.com.API;

import co.com.API.controller.AbstractValidacion;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoUsuario;
import co.com.api.prueba.classabstract.AbstractTipoUsuarioDao;
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
import org.json.JSONObject;

@Path("/tipoUsuarioApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class tipoUsuarioApp {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarTipoUsuario(TipoUsuario p_TipoUsuario) {

        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(AbstractTipoUsuarioDao.actualizaTipoUsuario(p_TipoUsuario)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarTipoUsuario(@QueryParam("id") int id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id > 0) {
            TipoUsuario p_TipoUsuario = new TipoUsuario();
            p_TipoUsuario.setTpuId(id);
            query = AbstractTipoUsuarioDao.query_pk_TipoUsuario(p_TipoUsuario);

        } else {
            query = AbstractTipoUsuarioDao.query_todos_TipoUsuario();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<TipoUsuario> TipoUsuario = (List<TipoUsuario>) query.getObjetoRetorno();
        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Response.Status.ACCEPTED).entity(jsonConverter.toJson(TipoUsuario)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearTipoUsuario(TipoUsuario p_TipoUsuario) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractTipoUsuarioDao.insertaTipoUsuario(p_TipoUsuario);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_TipoUsuario");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarTipoUsuario(@QueryParam("id") int id) {
        TipoUsuario p_TipoUsuario = new TipoUsuario();
        p_TipoUsuario.setTpuId(id);
        return AbstractTipoUsuarioDao.eliminaTipoUsuario(p_TipoUsuario);
    }

}
