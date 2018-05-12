
package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerDueñoVer {

    public static List<TriggerDueño> triggerdueño() throws SQLException, ClassNotFoundException {

        List<TriggerDueño> triggerDueños = new ArrayList<TriggerDueño>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from tablatriggerdueño order by fecha desc";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            triggerDueños.add(new TriggerDueño(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getTimestamp(3),
                    rs.getString(4)));

        }

        return triggerDueños;
    }


}