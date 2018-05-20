
package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerPartidoVer {

    public static List<TriggerPartido> triggerPartidos() throws SQLException, ClassNotFoundException {

        List<TriggerPartido> triggerPartidos = new ArrayList<TriggerPartido>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from tablatriggerpartido order by fecha desc";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            triggerPartidos.add(new TriggerPartido(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getTimestamp(4),
                    rs.getString(5)));

        }

        return triggerPartidos;
    }


}