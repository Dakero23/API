package co.com.activos.Utilidad;

//import co.com.api.prueba.Controller.UsuarioSesionController;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import org.primefaces.context.RequestContext;

/**
 *
 * @author DAKERO-09/05/21
 */
public class UtilidadesFACES {

//    private UsuarioSesionController usuarioSesionControlador;
    private HttpSession sesion;

    //iniciar session 
//    public boolean consultar_session() {
//        sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        this.usuarioSesionControlador = new UsuarioSesionController();
//        return this.usuarioSesionControlador.buscarUsuarioSesion((String) sesion.getAttribute("USS_ID_SESSION"));
//    }
    //consultar atribute httpsession
    public String consultarParam(String atribute) {
        sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        atribute = (String) sesion.getAttribute(atribute);
        return atribute;
    }

    //redireccionar 
    public void ir(String ruta) throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(ruta);
    }

//    //Abre ventana emergente
//    public void abrirVentana(String ruta) {
//        RequestContext requestContext = RequestContext.getCurrentInstance();
//        requestContext.execute("javascript:window.open('" + ruta + "','','width=300,height=400,left=50,top=50,toolbar=yes');");
//    }
    //Convertidor fechas
    public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    //mensajes_growl
    public void agregaMensaje(String tipoMensaje, String textoMensaje) {
        switch (tipoMensaje.toUpperCase()) {
            case "ERROR":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error !", textoMensaje));
                break;
            case "FATAL":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal !", textoMensaje));
                break;
            case "INFO":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info !", textoMensaje));
                break;
            case "WARN":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warm !", textoMensaje));
                break;
            case "ERROR2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, textoMensaje, null));
                break;
            case "FATAL2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, textoMensaje, null));
                break;
            case "INFO2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, textoMensaje, null));
                break;
            case "WARN2":
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, textoMensaje, null));
                break;
            default:
                break;
        }
    }

    //
    public String getRequestURL() {
        Object request = FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request instanceof HttpServletRequest) {
            return ((HttpServletRequest) request).getScheme() + "://" + ((HttpServletRequest) request).getServerName()
                    + ":" + ((HttpServletRequest) request).getServerPort();
        }
        return null;
    }

}
