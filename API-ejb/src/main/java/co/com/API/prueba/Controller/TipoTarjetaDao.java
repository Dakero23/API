package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.TipoTarjeta;
import co.com.api.prueba.Interface.InterfaceTipoTarjetaDao;
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
public class TipoTarjetaDao implements InterfaceTipoTarjetaDao {

    private static final Logger log = Logger.getLogger(TipoTarjetaDao.class.getName());
    private TipoTarjeta tipoTarjeta;
    private List<TipoTarjeta> listaTipoTarjeta;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public TipoTarjetaDao() {
    }

    @Override
    public GestionRetornoObjeto insertaTipoTarjeta(TipoTarjeta p_tipoTarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoTarjeta = p_tipoTarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_TIPO_TARJETA(?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTTJ_ID", tipoTarjeta.getTtjId());
            callableStatement.setString("VCTTJ_NOMBRE", tipoTarjeta.getTtjNombre());
            callableStatement.setString("VCAUD_USUARIO", tipoTarjeta.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMTTJ_ID;
            NMTTJ_ID = (String) callableStatement.getString("NMTTJ_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMTTJ_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TipoTarjetaDao.insertaTipoTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoTarjetaDao.insertaTipoTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaTipoTarjeta(TipoTarjeta p_tipoTarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoTarjeta = p_tipoTarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_TIPO_TARJETA(?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTTJ_ID", tipoTarjeta.getTtjId());
            callableStatement.setString("VCTTJ_NOMBRE", tipoTarjeta.getTtjNombre());
            callableStatement.setString("VCAUD_USUARIO", tipoTarjeta.getAudUsuario());

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
            mensajeProceso = "Error en TipoTarjetaDao.actualizaTipoTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoTarjetaDao.actualizaTipoTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaTipoTarjeta(TipoTarjeta p_tipoTarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoTarjeta = p_tipoTarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_TIPO_TARJETA(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTTJ_ID", tipoTarjeta.getTtjId());

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
            mensajeProceso = "Error en TipoTarjetaDao.eliminaTipoTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoTarjetaDao.eliminaTipoTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_TipoTarjeta(TipoTarjeta p_tipoTarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoTarjeta = p_tipoTarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_TIPO_TARJETA(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTTJ_ID", tipoTarjeta.getTtjId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_TipoTarjeta: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoTarjeta, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaTipoTarjeta = new ArrayList<TipoTarjeta>();
            while (rs.next()) {
                tipoTarjeta = new TipoTarjeta(
                        rs.getInt("TTJ_ID"),
                        rs.getString("TTJ_NOMBRE"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaTipoTarjeta.add(tipoTarjeta);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoTarjeta, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TipoTarjetaDao.query_pk_TipoTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoTarjetaDao.query_pk_TipoTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_TipoTarjeta() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_TIPO_TARJETA(?,?,?)    }";
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
                log.log(Priority.FATAL, "Error en query_todos_TipoTarjeta: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoTarjeta, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaTipoTarjeta = new ArrayList<TipoTarjeta>();
            while (rs.next()) {
                tipoTarjeta = new TipoTarjeta(
                        rs.getInt("TTJ_ID"),
                        rs.getString("TTJ_NOMBRE"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaTipoTarjeta.add(tipoTarjeta);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoTarjeta, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TipoTarjetaDao.query_todos_TipoTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoTarjetaDao.query_todos_TipoTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

}
