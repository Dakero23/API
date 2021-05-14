package co.com.API;

import co.com.API.controller.AbstractValidacion;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Servicios;
import co.com.api.prueba.classabstract.AbstractServiciosDao;
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

@Path("/serviciosApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class serviciosApp {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarServicios(Servicios p_Servicios) {

        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(AbstractServiciosDao.actualizaServicios(p_Servicios)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarServicios(@QueryParam("id") int id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id > 0) {
            Servicios p_Servicios = new Servicios();
            p_Servicios.setSrvId(id);
            query = AbstractServiciosDao.query_pk_Servicios(p_Servicios);

        } else {
            query = AbstractServiciosDao.query_todos_Servicios();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<Servicios> Servicios = (List<Servicios>) query.getObjetoRetorno();
        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Response.Status.ACCEPTED).entity(jsonConverter.toJson(Servicios)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearServicios(Servicios p_Servicios) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractServiciosDao.insertaServicios(p_Servicios);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_Servicios");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarServicios(@QueryParam("id") int id) {
        Servicios p_Servicios = new Servicios();
        p_Servicios.setSrvId(id);
        return AbstractServiciosDao.eliminaServicios(p_Servicios);
    }

}
