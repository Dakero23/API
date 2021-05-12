package co.com.activos.Utilidad;

/**
 *
 * @author DAKERO-09/05/21
 */
public class GestionRetornoObjeto {

    private Object objetoRetorno;
    private String estadoProceso;
    private String mensajeProceso;

    public GestionRetornoObjeto() {
    }

    public GestionRetornoObjeto(Object objetoRetorno, String estadoProceso, String mensajeProceso) {
        this.objetoRetorno = objetoRetorno;
        this.estadoProceso = estadoProceso;
        this.mensajeProceso = mensajeProceso;
    }

    public String getMensajeProceso() {
        return mensajeProceso;
    }

    public void setMensajeProceso(String mensajeProceso) {
        this.mensajeProceso = mensajeProceso;
    }

    public Object getObjetoRetorno() {
        return objetoRetorno;
    }

    public void setObjetoRetorno(Object objetoRetorno) {
        this.objetoRetorno = objetoRetorno;
    }

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

}
