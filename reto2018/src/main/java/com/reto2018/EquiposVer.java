package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquiposVer {

    public static List<Equipo> equipos() throws SQLException, ClassNotFoundException {

        List<Equipo> equipos = new ArrayList<Equipo>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from equipo";

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){

            equipos.add(new Equipo(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5)));

        }

        return equipos;
    }
}
