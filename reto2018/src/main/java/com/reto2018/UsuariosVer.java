package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosVer {

    public static List<Usuarios> usuarios() throws SQLException, ClassNotFoundException {

        List<Usuarios> usuarios = new ArrayList<Usuarios>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from usuarios";

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){

            usuarios.add(new Usuarios(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)));

        }

        return usuarios;
    }

}