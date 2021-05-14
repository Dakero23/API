package co.com.API;

import co.com.API.controller.AbstractValidacion;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.TipoDocumento;
import co.com.api.prueba.classabstract.AbstractTipoDocumentoDao;
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

@Path("/tipoDocumentoApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class tipoDocumentoApp {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarTipoDocumento(TipoDocumento p_tipoDocumento) {

        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(AbstractTipoDocumentoDao.actualizaTipoDocumento(p_tipoDocumento)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarTipoDocumento(@QueryParam("id") String id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id!= null) {
            TipoDocumento p_tipoDocumento = new TipoDocumento();
            p_tipoDocumento.setTipDoc(id);
            query = AbstractTipoDocumentoDao.query_pk_TipoDocumento(p_tipoDocumento);

        } else {
            query = AbstractTipoDocumentoDao.query_todos_TipoDocumento();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<TipoDocumento> TipoDocumento = (List<TipoDocumento>) query.getObjetoRetorno();
        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Response.Status.ACCEPTED).entity(jsonConverter.toJson(TipoDocumento)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearTipoDocumento(TipoDocumento p_tipoDocumento) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractTipoDocumentoDao.insertaTipoDocumento(p_tipoDocumento);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_TipoDocumento");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarTipoDocumento(@QueryParam("id") String id) {
        TipoDocumento p_tipoDocumento = new TipoDocumento();
        p_tipoDocumento.setTipDoc(id);
        return AbstractTipoDocumentoDao.eliminaTipoDocumento(p_tipoDocumento);
    }

}
