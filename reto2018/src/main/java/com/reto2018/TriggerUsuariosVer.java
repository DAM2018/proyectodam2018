


package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerUsuariosVer {

    public static List<TriggerUsuarios> triggerUsuarios() throws SQLException, ClassNotFoundException {

        List<TriggerUsuarios> triggerUsuarios = new ArrayList<TriggerUsuarios>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from tablatriggerusuario order by fecha desc";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            triggerUsuarios.add(new TriggerUsuarios(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getTimestamp(3),
                    rs.getString(4)));

        }

        return triggerUsuarios;
    }


}