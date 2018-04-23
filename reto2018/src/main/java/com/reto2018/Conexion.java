package com.reto2018;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conexion;

    public static void EstablecerConexion() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        /*String servidor = "srvoracle";
        String puerto = "1521";
        String sid = "orcl";
        String login = "eqdam02";
        String password = "eqdam02";*/

        String servidor = "10.10.10.9";
        String puerto = "1521";
        String sid = "db12102";
        String login = "clase";
        String password = "clase";
        String url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;

                conexion= DriverManager.getConnection(url, login, password);

    }
}
