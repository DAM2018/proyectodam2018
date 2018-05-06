package com.reto2018;

import oracle.jdbc.internal.OracleTypes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Dueño {

    private JTabbedPane tabbedPane1;
    private JPanel panel11;
    private JTable table1;
    private JTable table2;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JLabel equipo;
    private JPanel añadir;
    private JPanel eliminar;
    private JTabbedPane tabbedPane2;
    private JLabel equipo1;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JLabel equipo6;
    private JLabel equipo7;
    private JLabel equipo8;
    private JLabel res1;
    private JLabel res2;
    private JLabel res3;
    private JLabel res4;
    private JLabel res5;
    private JLabel res6;
    private JLabel res7;
    private JLabel res8;
    private JLabel fecha1;
    private JLabel fecha2;
    private JLabel fecha3;
    private JLabel fecha4;
    private JLabel jornada1;
    private int equiDue;
    private List<String> listaEquipos;


    public Dueño() throws SQLException, ClassNotFoundException {

        JFrame frame = new JFrame("Dueño");
        frame.setContentPane(panel11);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        Connection conexion = Conexion.conexion;

        String sql2 = "{call calendario.verEquipos(?)}";

        CallableStatement callableStatement2 = conexion.prepareCall(sql2);

        callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

        callableStatement2.executeUpdate();
        ResultSet rs = (ResultSet) callableStatement2.getObject(1);
        listaEquipos = new ArrayList<String>();
        while (rs.next()) {
            String nombreequi = rs.getString("nombreequi");

            listaEquipos.add(nombreequi);


        }

        equipo.setText(listaEquipos.get(Inicio.getLogin().getDu() - 1));
        System.out.println(listaEquipos.get(Inicio.getLogin().getDu() - 1));

        final TablaJugadoresModel tjm = new TablaJugadoresModel(0);
        final TablaJugadoresModel tjm2 = new TablaJugadoresModel(0, 0);

        table1.setModel(tjm);
        table2.setModel(tjm2);

        scrollPane1.setViewportView(table1);
        scrollPane2.setViewportView(table2);


        añadir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                try {
                    Connection conexion = Conexion.conexion;

                    String sql = "alter trigger numJug enable";

                    Statement st5 = conexion.prepareStatement(sql);

                    st5 = conexion.prepareStatement(sql);

                    st5.execute(sql);





                    sql = "update jugador set CodigoEquiJug=? where dnijug='" + tjm.getValueAt(table1.getSelectedRow(), 3).toString() + "'";


                    PreparedStatement st = conexion.prepareStatement(sql);

                    st = conexion.prepareStatement(sql);

                    st.setString(1, listaEquipos.get(Inicio.getLogin().getDu() - 1));

                    st.executeUpdate();

                    tjm.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                    tjm2.actualizarLista2();
                    table2.revalidate();
                    table2.repaint();


                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                } catch (java.lang.NullPointerException e1) {
                    //e1.printStackTrace();
                }


            }
        });
        eliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                try {


                    Connection conexion = Conexion.conexion;

                    String sql = "alter trigger numJug disable";

                    Statement st5 = conexion.prepareStatement(sql);

                    st5 = conexion.prepareStatement(sql);

                    st5.execute(sql);



                    sql = "update jugador set CodigoEquiJug='0' where dnijug='" + tjm2.getValueAt(table2.getSelectedRow(), 3).toString() + "'";


                    PreparedStatement st;

                    st = conexion.prepareStatement(sql);

                    //st.setNull(1,java.sql.Types.INTEGER);

                    st.executeUpdate();

                    tjm.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                    tjm2.actualizarLista2();
                    table2.revalidate();
                    table2.repaint();


                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                } catch (java.lang.NullPointerException e1) {
                    //e1.printStackTrace();
                }


            }
        });


        try {

            Statement st = conexion.createStatement();

            String sql = "select max(jornada) from clasificacion2";

            rs = st.executeQuery(sql);
            int jornada = 0;
            while (rs.next()) {


                jornada = rs.getInt(1);


            }
            jornada1.setText(String.valueOf(jornada));

            String sql3 = "{call calendario.verEquipos(?)}";

            CallableStatement callableStatement3 = conexion.prepareCall(sql3);

            callableStatement3.registerOutParameter(1, OracleTypes.CURSOR);

            callableStatement3.executeUpdate();

            rs = (ResultSet) callableStatement3.getObject(1);
            List<String> listaEquipos = new ArrayList<String>();
            while (rs.next()) {
                String nombreequi = rs.getString("nombreequi");

                listaEquipos.add(nombreequi);


            }
            sql = "{call calendario.crearCalendario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

            CallableStatement callableStatement = conexion.prepareCall(sql);


            callableStatement.setString(1, listaEquipos.get(0));
            callableStatement.setString(2, listaEquipos.get(1));
            callableStatement.setString(3, listaEquipos.get(2));
            callableStatement.setString(4, listaEquipos.get(3));
            callableStatement.setString(5, listaEquipos.get(4));
            callableStatement.setString(6, listaEquipos.get(5));
            callableStatement.setString(7, listaEquipos.get(6));
            callableStatement.setString(8, listaEquipos.get(7));
            callableStatement.setInt(9, jornada);


            callableStatement.registerOutParameter(10, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(12, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(14, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(15, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(16, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(17, java.sql.Types.VARCHAR);

            callableStatement.executeUpdate();

            equipo1.setText(callableStatement.getString(10));
            equipo2.setText(callableStatement.getString(11));
            equipo3.setText(callableStatement.getString(12));
            equipo4.setText(callableStatement.getString(13));
            equipo5.setText(callableStatement.getString(14));
            equipo6.setText(callableStatement.getString(15));
            equipo7.setText(callableStatement.getString(16));
            equipo8.setText(callableStatement.getString(17));

            sql2 = "{call calendario.verResultados(?,?)}";

            callableStatement2 = conexion.prepareCall(sql2);
            //int j = Integer.parseInt(dcm2.getSelectedItem().toString());

            callableStatement2.setInt(1, jornada);
            callableStatement2.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement2.executeUpdate();
            rs = (ResultSet) callableStatement2.getObject(2);

            List<Resultado> resultados = new ArrayList<Resultado>();

            while (rs.next()) {
                int resultado1 = rs.getInt("resultado1");
                int resultado2 = rs.getInt("resultado2");
                String fecha = rs.getString("fecha");

                resultados.add(new Resultado(resultado1, resultado2, fecha));


            }
            res1.setText(String.valueOf(resultados.get(0).getResultado1()));
            res2.setText(String.valueOf(resultados.get(0).getResultado2()));
            fecha1.setText(String.valueOf(resultados.get(0).getFecha()));
            res3.setText(String.valueOf(resultados.get(1).getResultado1()));
            res4.setText(String.valueOf(resultados.get(1).getResultado2()));
            fecha2.setText(String.valueOf(resultados.get(1).getFecha()));
            res5.setText(String.valueOf(resultados.get(2).getResultado1()));
            res6.setText(String.valueOf(resultados.get(2).getResultado2()));
            fecha3.setText(String.valueOf(resultados.get(2).getFecha()));
            res7.setText(String.valueOf(resultados.get(3).getResultado1()));
            res8.setText(String.valueOf(resultados.get(3).getResultado2()));
            fecha4.setText(String.valueOf(resultados.get(3).getFecha()));


        } catch (SQLException e2) {

            //System.out.println(e2.getMessage());

        } catch (java.lang.NullPointerException e2) {


        } catch (java.lang.IndexOutOfBoundsException e2) {


        }

    }

    public List<String> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<String> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

}
