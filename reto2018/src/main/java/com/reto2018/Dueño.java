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
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JLabel equipo;
    private JPanel añadir;
    private JPanel eliminar;
    private int equiDue;
    private List<String> listaEquipos;


    public Dueño() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("Dueño");
        frame.setContentPane(panel1);
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
        System.out.println(listaEquipos.get(Inicio.getLogin().getDu()-1));

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

                    String sql = "update jugador set CodigoEquiJug=? where dnijug='" + tjm.getValueAt(table1.getSelectedRow(), 4).toString() + "'";


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
                }


            }
        });
    }

    public List<String> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<String> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

}
