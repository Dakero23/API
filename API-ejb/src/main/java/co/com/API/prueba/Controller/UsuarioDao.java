package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.Usuario;
import co.com.api.prueba.Interface.InterfaceUsuarioDao;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.activos.Utilidad.OracleFactory;
import co.com.api.prueba.Entidad.Token;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/*
    @dakero-09/05/21
 */
public class UsuarioDao implements InterfaceUsuarioDao {

    private static final Logger log = Logger.getLogger(UsuarioDao.class.getName());
    private Usuario usuario;
    private List<Usuario> listaUsuario;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public UsuarioDao() {
    }

    @Override
    public GestionRetornoObjeto insertaUsuario(Usuario p_usuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        usuario = p_usuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_USUARIO(?,?,?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMUSU_ID", usuario.getUsuId());
            callableStatement.setInt("NMINB_ID", usuario.getInbId());
            callableStatement.setInt("NMTPU_ID", usuario.getTpuId());
            callableStatement.setInt("NMEMP_ID", usuario.getEmpId());
            callableStatement.setString("VCUSU_USER", usuario.getUsuUser());
            callableStatement.setString("VCUSU_PASS", usuario.getUsuPass());
            callableStatement.setString("VCAUD_USUARIO", usuario.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMUSU_ID;
            NMUSU_ID = (String) callableStatement.getString("NMUSU_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMUSU_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en UsuarioDao.insertaUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en UsuarioDao.insertaUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaUsuario(Usuario p_usuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        usuario = p_usuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_USUARIO(?,?,?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMUSU_ID", usuario.getUsuId());
            callableStatement.setInt("NMINB_ID", usuario.getInbId());
            callableStatement.setInt("NMTPU_ID", usuario.getTpuId());
            callableStatement.setInt("NMEMP_ID", usuario.getEmpId());
            callableStatement.setString("VCUSU_USER", usuario.getUsuUser());
            callableStatement.setString("VCUSU_PASS", usuario.getUsuPass());
            callableStatement.setString("VCAUD_USUARIO", usuario.getAudUsuario());

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
            mensajeProceso = "Error en UsuarioDao.actualizaUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en UsuarioDao.actualizaUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaUsuario(Usuario p_usuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        usuario = p_usuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_USUARIO(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMUSU_ID", usuario.getUsuId());

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
            mensajeProceso = "Error en UsuarioDao.eliminaUsuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en UsuarioDao.eliminaUsuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_Usuario(Usuario p_usuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        usuario = p_usuario;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_USUARIO(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMUSU_ID", usuario.getUsuId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_Usuario: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaUsuario, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaUsuario = new ArrayList<>();
            while (rs.next()) {
                Usuario usuarioTMP = new Usuario(
                        rs.getInt("USU_ID"),
                        rs.getInt("INB_ID"),
                        rs.getInt("TPU_ID"),
                        rs.getInt("EMP_ID"),
                        rs.getString("USU_USER"),
                        rs.getString("USU_PASS"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaUsuario.add(usuarioTMP);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaUsuario, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en UsuarioDao.query_pk_Usuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en UsuarioDao.query_pk_Usuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_Usuario() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_USUARIO(?,?,?)    }";
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
                log.log(Priority.FATAL, "Error en query_todos_Usuario: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaUsuario, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaUsuario = new ArrayList<Usuario>();
            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("USU_ID"),
                        rs.getInt("INB_ID"),
                        rs.getInt("TPU_ID"),
                        rs.getInt("EMP_ID"),
                        rs.getString("USU_USER"),
                        rs.getString("USU_PASS"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaUsuario.add(usuario);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaUsuario, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en UsuarioDao.query_todos_Usuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en UsuarioDao.query_todos_Usuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto consultarToken(Usuario usuario) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        List<Token> listaToken = new ArrayList<>();
        try {
            ConsultaSql = "{ call DAKERO.QB_LOGICA_APLICACION.pl_val_usuario(?,?,?,?,?) }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //parametros de entrada
            callableStatement.setString("VCUSU_USER", usuario.getUsuUser());
            callableStatement.setString("VCUSU_PASS", usuario.getUsuPass());
            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_todos_Usuario: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }
            Token token=new Token();
            while (rs.next()) {
                token = new Token(
                        rs.getInt("TKN_ID"),
                        rs.getInt("USU_ID"),
                        rs.getString("TKN_TOKEN"),
                        rs.getDate("TKN_FEC_VIG"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

//                listaToken.add(token);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(token, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (SQLException edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en UsuarioDao.query_todos_Usuario: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (SQLException edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en UsuarioDao.query_todos_Usuario: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }
}
