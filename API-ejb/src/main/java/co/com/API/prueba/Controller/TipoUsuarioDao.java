package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.TipoUsuario;
import co.com.api.prueba.Interface.InterfaceTipoUsuarioDao;
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
public class TipoUsuarioDao implements InterfaceTipoUsuarioDao {

    private static final Logger log = Logger.getLogger(TipoUsuarioDao.class.getName());
    private TipoUsuario tipoUsuario;
    private List<TipoUsuario> listaTipoUsuario;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public TipoUsuarioDao() {
    }

    @Override
    public GestionRetornoObjeto insertaTipoUsuario(TipoUsuario p_tipoUsuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoUsuario = p_tipoUsuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_TIPO_USUARIO(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTPU_ID", tipoUsuario.getTpuId());
            callableStatement.setString("VCTPU_DESCRIPCION", tipoUsuario.getTpuDescripcion());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMTPU_ID;
            NMTPU_ID = (String) callableStatement.getString("NMTPU_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMTPU_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TipoUsuarioDao.insertaTipoUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoUsuarioDao.insertaTipoUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaTipoUsuario(TipoUsuario p_tipoUsuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoUsuario = p_tipoUsuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_TIPO_USUARIO(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTPU_ID", tipoUsuario.getTpuId());
            callableStatement.setString("VCTPU_DESCRIPCION", tipoUsuario.getTpuDescripcion());

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
            mensajeProceso = "Error en TipoUsuarioDao.actualizaTipoUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoUsuarioDao.actualizaTipoUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaTipoUsuario(TipoUsuario p_tipoUsuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoUsuario = p_tipoUsuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_TIPO_USUARIO(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTPU_ID", tipoUsuario.getTpuId());

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
            mensajeProceso = "Error en TipoUsuarioDao.eliminaTipoUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoUsuarioDao.eliminaTipoUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_TipoUsuario(TipoUsuario p_tipoUsuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        tipoUsuario = p_tipoUsuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_TIPO_USUARIO(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTPU_ID", tipoUsuario.getTpuId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_TipoUsuario: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoUsuario, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaTipoUsuario = new ArrayList<TipoUsuario>();
            while (rs.next()) {
                tipoUsuario = new TipoUsuario(
                        rs.getInt("TPU_ID"),
                        rs.getString("TPU_DESCRIPCION"));

                listaTipoUsuario.add(tipoUsuario);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoUsuario, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TipoUsuarioDao.query_pk_TipoUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoUsuarioDao.query_pk_TipoUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_TipoUsuario() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_TIPO_USUARIO(?,?,?)    }";
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
                log.log(Priority.FATAL, "Error en query_todos_TipoUsuario: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoUsuario, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaTipoUsuario = new ArrayList<TipoUsuario>();
            while (rs.next()) {
                tipoUsuario = new TipoUsuario(
                        rs.getInt("TPU_ID"),
                        rs.getString("TPU_DESCRIPCION"));

                listaTipoUsuario.add(tipoUsuario);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaTipoUsuario, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TipoUsuarioDao.query_todos_TipoUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TipoUsuarioDao.query_todos_TipoUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

}
