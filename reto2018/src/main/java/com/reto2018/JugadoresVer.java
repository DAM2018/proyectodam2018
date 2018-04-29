package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JugadoresVer {

    public static List<Jugador> jugadores() throws SQLException, ClassNotFoundException {

        List<Jugador> jugadores = new ArrayList<Jugador>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from jugador";

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){

            jugadores.add(new Jugador(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)));

        }

        return jugadores;
    }

}
