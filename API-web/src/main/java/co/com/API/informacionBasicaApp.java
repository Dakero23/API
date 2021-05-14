package co.com.API;

import co.com.API.controller.AbstractValidacion;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.InformacionBasica;
import co.com.api.prueba.classabstract.AbstractInformacionBasicaDao;
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

@Path("/informacionBasicaApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class informacionBasicaApp {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarInformacionBasica(InformacionBasica p_informacionBasica) {

        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(AbstractInformacionBasicaDao.actualizaInformacionBasica(p_informacionBasica)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarInformacionBasica(@QueryParam("id") String id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id!= null) {
            InformacionBasica p_informacionBasica = new InformacionBasica();
            p_informacionBasica.setTipDoc(id);
            query = AbstractInformacionBasicaDao.query_pk_InformacionBasica(p_informacionBasica);

        } else {
            query = AbstractInformacionBasicaDao.query_todos_InformacionBasica();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<InformacionBasica> InformacionBasica = (List<InformacionBasica>) query.getObjetoRetorno();
        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Response.Status.ACCEPTED).entity(jsonConverter.toJson(InformacionBasica)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearInformacionBasica(InformacionBasica p_informacionBasica) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractInformacionBasicaDao.insertaInformacionBasica(p_informacionBasica);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_InformacionBasica");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarInformacionBasica(@QueryParam("id") String id) {
        InformacionBasica p_informacionBasica = new InformacionBasica();
        p_informacionBasica.setTipDoc(id);
        return AbstractInformacionBasicaDao.eliminaInformacionBasica(p_informacionBasica);
    }

}
