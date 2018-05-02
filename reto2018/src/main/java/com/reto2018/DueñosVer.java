package com.reto2018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DueñosVer {

    public static List<Dueños> dueños() throws SQLException, ClassNotFoundException {

        List<Dueños> dueños = new ArrayList<Dueños>();


        Connection conexion = Conexion.conexion;

        Statement st = conexion.createStatement();

        String sql = "select * from dueño";

        ResultSet rs=st.executeQuery(sql);

        while(rs.next()){

            dueños.add(new Dueños(

                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)));

        }

        return dueños;
    }


}
