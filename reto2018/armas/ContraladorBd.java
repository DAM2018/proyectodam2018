package jose.armas;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContraladorBd {


    /**
     *  Este método gestiona la conexión a una Base de Datos.
     * @return devuuelve objeto de tipo Conexión
     */
    public static Connection abrirConecxion() {
        Connection conn = null;
        try {
            // Cargar el driver Oracle JDBC Thin (ojdbc7.jar)
            // REF: Descarga: http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            // Cadena de conexión: driver@machineName:port:SID, userid, password
            conn = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102", "scott", "oracle");
            System.out.println("INFO: Conexión abierta");

        } catch (SQLException ex) {
            Logger.getLogger(ContraladorBd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  conn;

    }

    /**
     * Este gestiona el cierre de la conexión que se le pasa por parámetros.
     * @param c conexión que se desea cerrar.
     */
    public static void  cerrarConexion(Connection c){

        try {
            c.close();
            System.out.println("INFO: Conexión cerrada");
        } catch (SQLException ex) {
            Logger.getLogger(ContraladorBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }





}
