package co.com.API;

import co.com.API.controller.AbstractValidacion;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Empresa;
import co.com.api.prueba.classabstract.AbstractEmpresaDao;
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

@Path("/empresaApp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class empresaApp {

    @Context
    private HttpHeaders headers;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizarEmpresa(Empresa p_empresa) {

        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        return Response.status(Response.Status.ACCEPTED).entity(AbstractEmpresaDao.actualizaEmpresa(p_empresa)).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consultarEmpresa(@QueryParam("id") int id) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query;
        if (id > 0) {
            Empresa p_empresa = new Empresa();
            p_empresa.setEmpId(id);
            query = AbstractEmpresaDao.query_pk_Empresa(p_empresa);
        } else {
            query = AbstractEmpresaDao.query_todos_Empresa();
        }
        if (query.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(query).build();
        }
        List<Empresa> Empresa = (List<Empresa>) query.getObjetoRetorno();
        if (Empresa.isEmpty()) {
            query.setEstadoProceso("N");
            query.setMensajeProceso("No se encontro información con el identificador" + id);
            return Response.status(200).entity(query).build();
        }

        Gson jsonConverter = new GsonBuilder().create();
        return Response.status(Response.Status.ACCEPTED).entity(jsonConverter.toJson(Empresa)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearEmpresa(Empresa p_empresa) {
        GestionRetornoObjeto obj = AbstractValidacion.validarToken(headers);
        if (obj.getEstadoProceso().equals("N")) {
            return Response.status(406).entity(obj).build();
        }
        GestionRetornoObjeto query = AbstractEmpresaDao.insertaEmpresa(p_empresa);
        Gson gson = new Gson();
        String jsonString = gson.toJson(query);
        jsonString = jsonString.replace("objetoRetorno", "ID_Empresa");
        JSONObject request = new JSONObject();
        request.put("Respuesta", new JSONObject(jsonString));
        return Response.status(Response.Status.ACCEPTED).entity(request.toString()).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public GestionRetornoObjeto eliminarEmpresa(@QueryParam("id") String id) {
        Empresa p_empresa = new Empresa();
        p_empresa.setTipDoc(id);
        return AbstractEmpresaDao.eliminaEmpresa(p_empresa);
    }

}
