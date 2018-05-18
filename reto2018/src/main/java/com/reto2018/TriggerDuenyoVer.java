
package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerDuenyoVer {

    public static List<TriggerDuenyo> triggerduenyo() throws SQLException, ClassNotFoundException {

        List<TriggerDuenyo> triggerDuenyos = new ArrayList<TriggerDuenyo>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from tablatriggerduenyo order by fecha desc";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            triggerDuenyos.add(new TriggerDuenyo(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getTimestamp(3),
                    rs.getString(4)));

        }

        return triggerDuenyos;
    }


}