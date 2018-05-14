package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministradoresVer {

    public static List<Administradores> administradores() throws SQLException, ClassNotFoundException {

        List<Administradores> administradores = new ArrayList<Administradores>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from administradores";

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){

            administradores.add(new Administradores(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)));

        }

        return administradores;
    }
}
