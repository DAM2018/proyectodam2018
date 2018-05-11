


package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerEquiposVer {

    public static List<TriggerEquipo> triggerEquipos() throws SQLException, ClassNotFoundException {

        List<TriggerEquipo> triggerEquipos = new ArrayList<TriggerEquipo>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from tablatriggerequipo order by fecha desc";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            triggerEquipos.add(new TriggerEquipo(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getTimestamp(3),
                    rs.getString(4)));

        }

        return triggerEquipos;
    }


}



