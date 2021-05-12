package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.InformacionBasica;
import co.com.api.prueba.Interface.InterfaceInformacionBasicaDao;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.activos.Utilidad.OracleFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/*
@dakero-09/05/21
 */
public class InformacionBasicaDao implements InterfaceInformacionBasicaDao {

    private static final Logger log = Logger.getLogger(InformacionBasicaDao.class.getName());
    private InformacionBasica informacionBasica;
    private List<InformacionBasica> listaInformacionBasica;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public InformacionBasicaDao() {
    }

    @Override
    public GestionRetornoObjeto insertaInformacionBasica(InformacionBasica p_informacionBasica) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        informacionBasica = p_informacionBasica;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_INFORMACION_BASICA(?,?,?,?,?,?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMINB_ID", informacionBasica.getInbId());
            callableStatement.setString("VCTIP_DOC", informacionBasica.getTipDoc());
            callableStatement.setInt("NMINB_DOCUMENTO", informacionBasica.getInbDocumento());
            callableStatement.setString("VCINB_NOMBRE", informacionBasica.getInbNombre());
            callableStatement.setString("VCINB_APELLIDO", informacionBasica.getInbApellido());
            callableStatement.setString("VCINB_CORREO", informacionBasica.getInbCorreo());
            callableStatement.setInt("NMINB_CELULAR", informacionBasica.getInbCelular());
            callableStatement.setInt("NMINB_TELEFONO", informacionBasica.getInbTelefono());
            callableStatement.setString("VCINB_DIRECCION", informacionBasica.getInbDireccion());
            callableStatement.setString("VCAUD_USUARIO", informacionBasica.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMINB_ID;
            NMINB_ID = (String) callableStatement.getString("NMINB_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMINB_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en InformacionBasicaDao.insertaInformacionBasica: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en InformacionBasicaDao.insertaInformacionBasica: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaInformacionBasica(InformacionBasica p_informacionBasica) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        informacionBasica = p_informacionBasica;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_INFORMACION_BASICA(?,?,?,?,?,?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMINB_ID", informacionBasica.getInbId());
            callableStatement.setString("VCTIP_DOC", informacionBasica.getTipDoc());
            callableStatement.setInt("NMINB_DOCUMENTO", informacionBasica.getInbDocumento());
            callableStatement.setString("VCINB_NOMBRE", informacionBasica.getInbNombre());
            callableStatement.setString("VCINB_APELLIDO", informacionBasica.getInbApellido());
            callableStatement.setString("VCINB_CORREO", informacionBasica.getInbCorreo());
            callableStatement.setInt("NMINB_CELULAR", informacionBasica.getInbCelular());
            callableStatement.setInt("NMINB_TELEFONO", informacionBasica.getInbTelefono());
            callableStatement.setString("VCINB_DIRECCION", informacionBasica.getInbDireccion());
            callableStatement.setString("VCAUD_USUARIO", informacionBasica.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en InformacionBasicaDao.actualizaInformacionBasica: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en InformacionBasicaDao.actualizaInformacionBasica: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaInformacionBasica(InformacionBasica p_informacionBasica) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        informacionBasica = p_informacionBasica;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_INFORMACION_BASICA(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMINB_ID", informacionBasica.getInbId());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en InformacionBasicaDao.eliminaInformacionBasica: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en InformacionBasicaDao.eliminaInformacionBasica: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_InformacionBasica(InformacionBasica p_informacionBasica) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        informacionBasica = p_informacionBasica;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_INFORMACION_BASICA(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMINB_ID", informacionBasica.getInbId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_InformacionBasica: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaInformacionBasica, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaInformacionBasica = new ArrayList<InformacionBasica>();
            while (rs.next()) {
                informacionBasica = new InformacionBasica(
                        rs.getInt("INB_ID"),
                        rs.getString("TIP_DOC"),
                        rs.getInt("INB_DOCUMENTO"),
                        rs.getString("INB_NOMBRE"),
                        rs.getString("INB_APELLIDO"),
                        rs.getString("INB_CORREO"),
                        rs.getInt("INB_CELULAR"),
                        rs.getInt("INB_TELEFONO"),
                        rs.getString("INB_DIRECCION"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaInformacionBasica.add(informacionBasica);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaInformacionBasica, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en InformacionBasicaDao.query_pk_InformacionBasica: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en InformacionBasicaDao.query_pk_InformacionBasica: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_InformacionBasica() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_INFORMACION_BASICA(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_todos_InformacionBasica: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaInformacionBasica, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaInformacionBasica = new ArrayList<InformacionBasica>();
            while (rs.next()) {
                informacionBasica = new InformacionBasica(
                        rs.getInt("INB_ID"),
                        rs.getString("TIP_DOC"),
                        rs.getInt("INB_DOCUMENTO"),
                        rs.getString("INB_NOMBRE"),
                        rs.getString("INB_APELLIDO"),
                        rs.getString("INB_CORREO"),
                        rs.getInt("INB_CELULAR"),
                        rs.getInt("INB_TELEFONO"),
                        rs.getString("INB_DIRECCION"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaInformacionBasica.add(informacionBasica);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaInformacionBasica, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en InformacionBasicaDao.query_todos_InformacionBasica: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en InformacionBasicaDao.query_todos_InformacionBasica: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

}
