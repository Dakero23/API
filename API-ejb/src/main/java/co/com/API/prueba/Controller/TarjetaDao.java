package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.Tarjeta;
import co.com.api.prueba.Interface.InterfaceTarjetaDao;
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
public class TarjetaDao implements InterfaceTarjetaDao {

    private static final Logger log = Logger.getLogger(TarjetaDao.class.getName());
    private Tarjeta tarjeta;
    private List<Tarjeta> listaTarjeta;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public TarjetaDao() {
    }

    @Override
    public GestionRetornoObjeto insertaTarjeta(Tarjeta p_tarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tarjeta = p_tarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_TARJETA(?,?,?,?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTAR_ID", tarjeta.getTarId());
            callableStatement.setInt("NMTTJ_ID", tarjeta.getTtjId());
            callableStatement.setInt("NMUSU_ID", tarjeta.getUsuId());
            callableStatement.setInt("NMTAR_NUMERO", tarjeta.getTarNumero());
            callableStatement.setString("VCTAR_NOMBRE", tarjeta.getTarNombre());
            callableStatement.setString("VCTAR_FEC_EXP", tarjeta.getTarFecExp());
            callableStatement.setShort("NMTAR_COD_SEG", tarjeta.getTarCodSeg());
            callableStatement.setString("VCAUD_USUARIO", tarjeta.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMTAR_ID;
            NMTAR_ID = (String) callableStatement.getString("NMTAR_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMTAR_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TarjetaDao.insertaTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TarjetaDao.insertaTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaTarjeta(Tarjeta p_tarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tarjeta = p_tarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_TARJETA(?,?,?,?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTAR_ID", tarjeta.getTarId());
            callableStatement.setInt("NMTTJ_ID", tarjeta.getTtjId());
            callableStatement.setInt("NMUSU_ID", tarjeta.getUsuId());
            callableStatement.setInt("NMTAR_NUMERO", tarjeta.getTarNumero());
            callableStatement.setString("VCTAR_NOMBRE", tarjeta.getTarNombre());
            callableStatement.setString("VCTAR_FEC_EXP", tarjeta.getTarFecExp());
            callableStatement.setShort("NMTAR_COD_SEG", tarjeta.getTarCodSeg());
            callableStatement.setString("VCAUD_USUARIO", tarjeta.getAudUsuario());

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
            mensajeProceso = "Error en TarjetaDao.actualizaTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TarjetaDao.actualizaTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaTarjeta(Tarjeta p_tarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tarjeta = p_tarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_TARJETA(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTAR_ID", tarjeta.getTarId());

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
            mensajeProceso = "Error en TarjetaDao.eliminaTarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TarjetaDao.eliminaTarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_Tarjeta(Tarjeta p_tarjeta) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tarjeta = p_tarjeta;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_TARJETA(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTAR_ID", tarjeta.getTarId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_Tarjeta: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaTarjeta, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaTarjeta = new ArrayList<Tarjeta>();
            while (rs.next()) {
                tarjeta = new Tarjeta(
                        rs.getInt("TAR_ID"),
                        rs.getInt("TTJ_ID"),
                        rs.getInt("USU_ID"),
                        rs.getInt("TAR_NUMERO"),
                        rs.getString("TAR_NOMBRE"),
                        rs.getString("TAR_FEC_EXP"),
                        rs.getShort("TAR_COD_SEG"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaTarjeta.add(tarjeta);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaTarjeta, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TarjetaDao.query_pk_Tarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TarjetaDao.query_pk_Tarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_Tarjeta() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_TARJETA(?,?,?)    }";
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
                log.log(Priority.FATAL, "Error en query_todos_Tarjeta: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaTarjeta, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaTarjeta = new ArrayList<Tarjeta>();
            while (rs.next()) {
                tarjeta = new Tarjeta(
                        rs.getInt("TAR_ID"),
                        rs.getInt("TTJ_ID"),
                        rs.getInt("USU_ID"),
                        rs.getInt("TAR_NUMERO"),
                        rs.getString("TAR_NOMBRE"),
                        rs.getString("TAR_FEC_EXP"),
                        rs.getShort("TAR_COD_SEG"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaTarjeta.add(tarjeta);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaTarjeta, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TarjetaDao.query_todos_Tarjeta: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TarjetaDao.query_todos_Tarjeta: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

}
