package co.com.api.prueba.Controller;

import co.com.api.prueba.Entidad.Token;
import co.com.api.prueba.Interface.InterfaceTokenDao;
import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.activos.Utilidad.OracleFactory;
import co.com.activos.Utilidad.UtilidadesFACES;
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
public class TokenDao implements InterfaceTokenDao {

    private static final Logger log = Logger.getLogger(TokenDao.class.getName());
    private Token token;
    private List<Token> listaToken;

    //Gestion de objeto retornado    
    private GestionRetornoObjeto gestionRetornoObjeto;
    private String estadoProceso;
    private String mensajeProceso;

    public TokenDao() {
    }

    @Override
    public GestionRetornoObjeto insertaToken(Token p_token) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        token = p_token;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_INS_TOKEN(?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTKN_ID", token.getTknId());
            callableStatement.setInt("NMUSU_ID", token.getUsuId());
            callableStatement.setString("VCTKN_TOKEN", token.getTknToken());
            callableStatement.setDate("DTTKN_FEC_VIG", UtilidadesFACES.convertUtilToSql(token.getTknFecVig()));
            callableStatement.setString("VCAUD_USUARIO", token.getAudUsuario());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");
            String NMTKN_ID;
            NMTKN_ID = (String) callableStatement.getString("NMTKN_ID");
            callableStatement.close();

            gestionRetornoObjeto = new GestionRetornoObjeto(NMTKN_ID, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TokenDao.insertaToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TokenDao.insertaToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto actualizaToken(Token p_token) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        token = p_token;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_UPD_TOKEN(?,?,?,?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTKN_ID", token.getTknId());
            callableStatement.setInt("NMUSU_ID", token.getUsuId());
            callableStatement.setString("VCTKN_TOKEN", token.getTknToken());
            callableStatement.setDate("DTTKN_FEC_VIG", UtilidadesFACES.convertUtilToSql(token.getTknFecVig()));
            callableStatement.setString("VCAUD_USUARIO", token.getAudUsuario());

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
            mensajeProceso = "Error en TokenDao.actualizaToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TokenDao.actualizaToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto eliminaToken(Token p_token) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        token = p_token;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_DEL_TOKEN(?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTKN_ID", token.getTknId());

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
            mensajeProceso = "Error en TokenDao.eliminaToken: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TokenDao.eliminaToken: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_pk_Token(Token p_token) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        token = p_token;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_QPK_TOKEN(?,?,?,?)    }";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setInt("NMTKN_ID", token.getTknId());

            //Parametros de salida 
            callableStatement.registerOutParameter("CSCONSULTA", OracleTypes.CURSOR);
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            ResultSet rs = (ResultSet) callableStatement.getObject("CSCONSULTA");
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_Token: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaToken, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaToken = new ArrayList<Token>();
            while (rs.next()) {
                token = new Token(
                        rs.getInt("TKN_ID"),
                        rs.getInt("USU_ID"),
                        rs.getString("TKN_TOKEN"),
                        rs.getDate("TKN_FEC_VIG"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaToken.add(token);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaToken, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TokenDao.query_pk_Token: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TokenDao.query_pk_Token: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto query_todos_Token() {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;

        try {
            ConsultaSql = "{ call DAKERO.QB_CRUD_APLICACION.PL_ALL_TOKEN(?,?,?)    }";
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
                log.log(Priority.FATAL, "Error en query_todos_Token: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaToken, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            if (rs == null) {
                return null;
            }

            listaToken = new ArrayList<Token>();
            while (rs.next()) {
                token = new Token(
                        rs.getInt("TKN_ID"),
                        rs.getInt("USU_ID"),
                        rs.getString("TKN_TOKEN"),
                        rs.getDate("TKN_FEC_VIG"),
                        rs.getDate("AUD_FECHA"),
                        rs.getString("AUD_USUARIO"));

                listaToken.add(token);
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaToken, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;
        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TokenDao.query_todos_Token: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TokenDao.query_todos_Token: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

    @Override
    public GestionRetornoObjeto validar_Token(Token p_token) {

        Connection conexion = OracleFactory.getConexion();
        String ConsultaSql;
        token = p_token;

        try {
            ConsultaSql = "{ call DAKERO.QB_LOGICA_APLICACION.PL_VAL_TOKEN(?,?,?)}";
            CallableStatement callableStatement;
            callableStatement = conexion.prepareCall(ConsultaSql);

            //Parametros de entrada
            callableStatement.setString("VCTKN_TOKEN", token.getTknToken());

            //Parametros de salida 
            callableStatement.registerOutParameter("VCESTADO_PROCESO", OracleTypes.VARCHAR);
            callableStatement.registerOutParameter("VCMENSAJE_PROCESO", OracleTypes.VARCHAR);

            callableStatement.execute();
            estadoProceso = (String) callableStatement.getString("VCESTADO_PROCESO");
            mensajeProceso = (String) callableStatement.getString("VCMENSAJE_PROCESO");

            if (estadoProceso.equals("N")) {
                log.log(Priority.FATAL, "Error en query_pk_Token: " + mensajeProceso);
                gestionRetornoObjeto = new GestionRetornoObjeto(listaToken, estadoProceso, mensajeProceso);
                return gestionRetornoObjeto;
            }

            callableStatement.close();
            gestionRetornoObjeto = new GestionRetornoObjeto(listaToken, estadoProceso, mensajeProceso);

            return gestionRetornoObjeto;

        } catch (Exception edb) {
            estadoProceso = "N";
            mensajeProceso = "Error en TokenDao.query_pk_Token: " + edb.getMessage();
            gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
            log.log(Priority.FATAL, mensajeProceso);
            edb.printStackTrace();
            return gestionRetornoObjeto;
        } finally {
            try {
                conexion.close();
            } catch (Exception edb2) {
                estadoProceso = "N";
                mensajeProceso = "Error en TokenDao.query_pk_Token: " + edb2.getMessage();
                gestionRetornoObjeto = new GestionRetornoObjeto(null, estadoProceso, mensajeProceso);
                log.log(Priority.FATAL, mensajeProceso);
                edb2.printStackTrace();
                return gestionRetornoObjeto;
            }
        }

    }

}
