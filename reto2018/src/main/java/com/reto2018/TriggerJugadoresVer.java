
package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerJugadoresVer {

    public static List<TriggerJugadores> triggerJugadores() throws SQLException, ClassNotFoundException {

        List<TriggerJugadores> triggerJugadores = new ArrayList<TriggerJugadores>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from tablatriggerjugador order by fecha desc";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            triggerJugadores.add(new TriggerJugadores(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getTimestamp(3),
                    rs.getString(4)));

        }

        return triggerJugadores;
    }


}