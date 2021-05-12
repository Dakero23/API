package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.ServiciosToken;
import co.com.api.prueba.Interface.InterfaceServiciosTokenDao;
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
public class ServiciosTokenDao implements InterfaceServiciosTokenDao {

    private static final Logger log = Logger.getLogger(ServiciosTokenDao.class.getName());
    private ServiciosToken serviciosToken;
    private List<ServiciosToken> listaServiciosToken;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public ServiciosTokenDao() {
    }

    @Override
    public GestionRetornoObjeto insertaServiciosToken(ServiciosToken p_serviciosToken) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        serviciosToken = p_serviciosToken;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_SERVICIOS_TOKEN(?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMSRT_ID", serviciosToken.getSrtId());
            callableStatement.setInt("NMTKN_ID", serviciosToken.getTknId());
            callableStatement.setInt("NMSRV_ID", serviciosToken.getSrvId());
            callableStatement.setString/*Tipo de dato desconocido.*/("VCSRT_ESTADO", serviciosToken.getSrtEstado());
            callableStatement.setString("VCAUD_USUARIO", serviciosToken.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMSRT_ID;
            NMSRT_ID = (String) callableStatement.getString("NMSRT_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMSRT_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en ServiciosTokenDao.insertaServiciosToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en ServiciosTokenDao.insertaServiciosToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaServiciosToken(ServiciosToken p_serviciosToken) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        serviciosToken = p_serviciosToken;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_SERVICIOS_TOKEN(?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMSRT_ID", serviciosToken.getSrtId());
            callableStatement.setInt("NMTKN_ID", serviciosToken.getTknId());
            callableStatement.setInt("NMSRV_ID", serviciosToken.getSrvId());
            callableStatement.setString/*Tipo de dato desconocido.*/("VCSRT_ESTADO", serviciosToken.getSrtEstado());
            callableStatement.setString("VCAUD_USUARIO", serviciosToken.getAudUsuario());

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
            mensajeProceso = "Error en ServiciosTokenDao.actualizaServiciosToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en ServiciosTokenDao.actualizaServiciosToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaServiciosToken(ServiciosToken p_serviciosToken) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        serviciosToken = p_serviciosToken;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_SERVICIOS_TOKEN(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMSRT_ID", serviciosToken.getSrtId());

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
            mensajeProceso = "Error en ServiciosTokenDao.eliminaServiciosToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en ServiciosTokenDao.eliminaServiciosToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_ServiciosToken(ServiciosToken p_serviciosToken) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        serviciosToken = p_serviciosToken;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_SERVICIOS_TOKEN(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMSRT_ID", serviciosToken.getSrtId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_ServiciosToken: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaServiciosToken, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaServiciosToken = new ArrayList<ServiciosToken>();
            while (rs.next()) {
                serviciosToken = new ServiciosToken(
                        rs.getInt("SRT_ID"),
                        rs.getInt("TKN_ID"),
                        rs.getInt("SRV_ID"),
                        rs.getString/*Tipo de dato desconocido.*/("SRT_ESTADO"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaServiciosToken.add(serviciosToken);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaServiciosToken, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en ServiciosTokenDao.query_pk_ServiciosToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en ServiciosTokenDao.query_pk_ServiciosToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_ServiciosToken() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_SERVICIOS_TOKEN(?,?,?)    }";
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
                log.log(Priority.FATAL, "Error en query_todos_ServiciosToken: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaServiciosToken, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaServiciosToken = new ArrayList<ServiciosToken>();
            while (rs.next()) {
                serviciosToken = new ServiciosToken(
                        rs.getInt("SRT_ID"),
                        rs.getInt("TKN_ID"),
                        rs.getInt("SRV_ID"),
                        rs.getString/*Tipo de dato desconocido.*/("SRT_ESTADO"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaServiciosToken.add(serviciosToken);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaServiciosToken, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en ServiciosTokenDao.query_todos_ServiciosToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en ServiciosTokenDao.query_todos_ServiciosToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

}
