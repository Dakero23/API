package co.com.activos.Utilidad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class OracleFactory {

    static Connection conexion;

    public static void setConexion(Connection conexion) {
        OracleFactory.conexion = conexion;
    }

    public static Connection getConexion() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            conexion = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=off)(FAILOVER=on)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.21.59)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.21.59)(PORT=1521))(ADDRESS=(PROTOCOL=TCP)(HOST=192.168.21.59)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=DESA)))", "DAKERO", "DAKERO23");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DAKERO", "dakero23");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }//*/

    public static void main(String[] args) {
        getConexion();
    }
    /*
     * Metodo para la conexión mediante datasource servidores weblogic. test, desarrollo y produccion
     *
     * @return
     */
 /*public static Connection getConexion() {
        try {
            InitialContext ic = new InitialContext();
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            DataSource dt = (DataSource) ic.lookup("DS_datasource");
            conexion = dt.getConnection();

        catch (SQLException e) {
            Logger.getLogger(OracleFactory.class.getName()).error(e);
        }
        catch (NamingException e) {
            Logger.getLogger(OracleFactory.class.getName()).error(e);
        }
        return conexion;
    }//*/

}
