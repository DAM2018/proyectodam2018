package com.reto2018;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Administrador {

    Connection conexion = Conexion.conexion;
    PreparedStatement st;

    public Administrador() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("Administrador");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        final DefaultListModel modelList1 = new DefaultListModel();

        for (int i = 0; i < JugadoresVer.jugadores().size(); i++) {
            modelList1.addElement(JugadoresVer.jugadores().get(i));
        }
        list1.setModel(modelList1);


        insertarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String sql = "insert into Jugador values(?,?,?,?,?,?);commit";

                try {
                    st = conexion.prepareStatement(sql);
                    //  st.setInt(1, Types.NULL);
                    st.setString(1, textField1.getText());
                    st.setString(2, textField2.getText());
                    st.setInt(3, Integer.parseInt(textField3.getText()));
                    st.setString(4, textField4.getText());
                    st.setString(5, textField5.getText());
                   // st.setString(6, textField5.getText());

                    st.setNull(6, Types.NULL);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }




            }
        });
    }



    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel Jugadore;
    private JPanel Dueños;
    private JPanel Equipos;
    private JPanel Calendario;
    private JPanel Resultados;
    private JPanel Usuarios;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JTabbedPane tabbedPane5;
    private JList list1;
    private JButton insertarButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
}
