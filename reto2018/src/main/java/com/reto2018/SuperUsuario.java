package com.reto2018;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuperUsuario {


    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton añadirButton;
    private JButton actualizarButton1;
    private JButton eliminarButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton cambiarButton;
    private JTabbedPane tabbedPane2;
    private JTable table2;
    private JTable table3;
    private JList list1;
    private JList list2;
    private JList list3;
    public SuperUsuario() throws SQLException, ClassNotFoundException {

        JFrame frame = new JFrame("SuperUsuario");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        /*DefaultListModel modelList1 = new DefaultListModel();
        list1.setModel(modelList1);
        DefaultListModel modelList2 = new DefaultListModel();*/


        final TablaAdministradoresModel tam = new TablaAdministradoresModel(0);
        table1.setModel(tam);
        scrollPane1.setViewportView(table1);




        añadirButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                Connection conexion = Conexion.conexion;
                PreparedStatement st;
                String sql = "insert into administradores values (?,?,?)";

                    st = conexion.prepareStatement(sql);

                st.setString(1, textField1.getText());
                st.setString(2, textField2.getText());
                st.setString(3, textField3.getText());

                st.executeUpdate();

                    tam.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }


            }
        });
        actualizarButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    Connection conexion = Conexion.conexion;
                    PreparedStatement st;
                    String sql = "update administradores set usuario=?,password2=? where nombre=?";

                    st = conexion.prepareStatement(sql);

                    st.setString(1, textField2.getText());
                    st.setString(2, textField3.getText());
                    st.setString(3, tam.getValueAt(table1.getSelectedRow(),0).toString());

                    st.executeUpdate();

                    tam.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

            }
        });
        eliminarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    Connection conexion = Conexion.conexion;
                    PreparedStatement st;
                    String sql = "delete from administradores where nombre=?";

                    st = conexion.prepareStatement(sql);

                    st.setString(1, tam.getValueAt(table1.getSelectedRow(),0).toString());

                    st.executeUpdate();

                    tam.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textField1.setText(tam.getValueAt(table1.getSelectedRow(),0).toString());
                textField2.setText(tam.getValueAt(table1.getSelectedRow(),1).toString());
                textField3.setText(tam.getValueAt(table1.getSelectedRow(),2).toString());
            }
        });
        cambiarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    Connection conexion = Conexion.conexion;

                    if(new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) {

                        String sql = "update superusuario set password2=? where usuario='root'";


                        PreparedStatement st = conexion.prepareStatement(sql);

                        st = conexion.prepareStatement(sql);
                        st.setString(1, new String(passwordField1.getPassword()));


                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Cambiado con exito!!", "Cambiar", JOptionPane.OK_OPTION);

                    }

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }
            }
        });
    }
}
