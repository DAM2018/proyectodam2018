package com.reto2018;

import oracle.jdbc.internal.OracleTypes;
import org.jasypt.util.text.StrongTextEncryptor;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Inicio {
    private static Login login;
    private static List<String> listaEquipos;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        login = new Login();


    }

    public static List<String> verEquipos() throws SQLException {
        Connection conexion = Conexion.conexion;

        String sql2 = "{call calendario.verEquipos(?)}";

        CallableStatement callableStatement2 = conexion.prepareCall(sql2);

        callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

        callableStatement2.executeUpdate();
        ResultSet rs = (ResultSet) callableStatement2.getObject(1);
        listaEquipos = new ArrayList<String>();
        while (rs.next())

        {
            String nombreequi = rs.getString("nombreequi");

            listaEquipos.add(nombreequi);
        }
        return listaEquipos;

    }



    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        Inicio.login = login;
    }
}
