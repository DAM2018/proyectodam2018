package com.reto2018;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conexion;
    private static String servidor= "10.10.10.9";
    private static String puerto= "1521";
    private static String sid= "db12102";
    private static String login = "clase";
    private static String password= "clase";
    private static String url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;
    public static Connection EstablecerConexion() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        /*String servidor = "srvoracle";
        String puerto = "1521";
        String sid = "orcl";
        String login = "eqdam02";
        String password = "eqdam02";*/

        servidor = Inicio.getLogin().getTextField1().getText();
        puerto = Inicio.getLogin().getTextField2().getText();
        sid = Inicio.getLogin().getTextField3().getText();
        login = new String (Inicio.getLogin().getTextField4().getPassword());
        password = new String (Inicio.getLogin().getTextField5().getPassword());
        url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;

               return conexion= DriverManager.getConnection(url, login, password);

    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        Conexion.conexion = conexion;
    }

    public static String getServidor() {
        return servidor;
    }

    public static void setServidor(String servidor) {
        Conexion.servidor = servidor;
    }

    public static String getPuerto() {
        return puerto;
    }

    public static void setPuerto(String puerto) {
        Conexion.puerto = puerto;
    }

    public static String getSid() {
        return sid;
    }

    public static void setSid(String sid) {
        Conexion.sid = sid;
    }

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Conexion.login = login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Conexion.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }
}
