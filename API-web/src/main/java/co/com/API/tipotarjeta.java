package co.com.API;

import co.com.API.controller.AbstractValidacion;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoTarjeta;
import co.com.api.prueba.classabstract.AbstractTipoTarjetaDao;
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

@Path("/tipotarjetaApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class tipotarjeta {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarTipoTarjeta(TipoTarjeta p_TipoTarjeta) {

        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(AbstractTipoTarjetaDao.actualizaTipoTarjeta(p_TipoTarjeta)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarTipoTarjeta(@QueryParam("id") int id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id > 0) {
            TipoTarjeta p_TipoTarjeta = new TipoTarjeta();
            p_TipoTarjeta.setTtjId(id);
            query = AbstractTipoTarjetaDao.query_pk_TipoTarjeta(p_TipoTarjeta);

        } else {
            query = AbstractTipoTarjetaDao.query_todos_TipoTarjeta();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<TipoTarjeta> TipoTarjeta = (List<TipoTarjeta>) query.getObjetoRetorno();
        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Response.Status.ACCEPTED).entity(jsonConverter.toJson(TipoTarjeta)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearTipoTarjeta(TipoTarjeta p_TipoTarjeta) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractTipoTarjetaDao.insertaTipoTarjeta(p_TipoTarjeta);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_TipoTarjeta");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarTipoTarjeta(@QueryParam("id") int id) {
        TipoTarjeta p_TipoTarjeta = new TipoTarjeta();
        p_TipoTarjeta.setTtjId(id);
        return AbstractTipoTarjetaDao.eliminaTipoTarjeta(p_TipoTarjeta);
    }

}
