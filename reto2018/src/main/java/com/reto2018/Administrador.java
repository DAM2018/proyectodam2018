package com.reto2018;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Administrador {

    //Connection conexion = Conexion.conexion;

    public Administrador() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("Administrador");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // final DefaultListModel modelList1 = new DefaultListModel();
        // DefaultTableModel modelTable1=new DefaultTableModel();
       /* for (int i = 0; i < JugadoresVer.jugadores().size(); i++) {
            modelList1.addElement(JugadoresVer.jugadores().get(i));
        }
        list1.setModel(modelList1);*/
        /*modelTable1.addColumn("Code");
        modelTable1.addColumn("Name");
        modelTable1.addColumn("Quantity");
        modelTable1.addColumn("Unit Price");
        modelTable1.addColumn("Price");
        modelTable1.addColumn("Price");*/
        final TablaJugadoresModel tjm = new TablaJugadoresModel(0);
        final TablaDueñosModel tdm = new TablaDueñosModel(0);
        final TablaEquiposModel tem = new TablaEquiposModel(0);

       /* for (int i = 0; i < JugadoresVer.jugadores().size(); i++) {

            tjm.addRow(new Object[]{JugadoresVer.jugadores().get(i).getNombrejug(),
                    JugadoresVer.jugadores().get(i).getNick(),
                    JugadoresVer.jugadores().get(i).getSueldo(),
                    JugadoresVer.jugadores().get(i).getDnijug(),
                    JugadoresVer.jugadores().get(i).getCaracteristicas(),
                    JugadoresVer.jugadores().get(i).getEquipo_codigoequi()
            });
        }*/
        table1.setModel(tjm);
        table2.setModel(tdm);
        table3.setModel(tem);


        scrollPane1.setViewportView(table1);
        scrollPane2.setViewportView(table2);
        scrollPane3.setViewportView(table3);


        insertarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into jugador values (?,?,?,?,?,?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField1.getText());
                    st.setString(2, textField2.getText());
                    st.setInt(3, Integer.parseInt(textField3.getText()));

                    st.setString(4, textField4.getText());
                    st.setString(5, textField5.getText());
                    st.setString(6, textField6.getText());

                    st.executeUpdate();

                    tjm.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                    /*    modelList1.removeAllElements();

                    for (int i = 0; i < JugadoresVer.jugadores().size(); i++) {
                        modelList1.addElement(JugadoresVer.jugadores().get(i));
                    }*/

                    System.out.println(sql);
                } catch (SQLException e1) {
                   // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }


            }
        });
        actualizarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                try {
                    Connection conexion = Conexion.conexion;

                    String sql = "update jugador set nombrejug=?, nick=?, sueldo=?, dnijug=?," +
                            "caracteristicas=?, codigoequijug=? where dnijug='" + tjm.getValueAt(table1.getSelectedRow(), 3).toString() + "'";


                    PreparedStatement st = conexion.prepareStatement(sql);

                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField1.getText());
                    st.setString(2, textField2.getText());
                    st.setInt(3, Integer.parseInt(textField3.getText()));

                    st.setString(4, textField4.getText());
                    st.setString(5, textField5.getText());
                    st.setString(6, textField6.getText());
                    // st.setString(7, textField4.getText());

                    st.executeUpdate();

                    tjm.actualizarLista();
                    table1.revalidate();
                    table1.repaint();


                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }


            }
        });
       /* list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                textField1.setText(list1.getComponent(0).toString());
                textField2.setText(list1.getModel().getElementAt(0).toString());
                textField3.setText(list1.getSelectedValue().toString());
                textField4.setText(list1.getSelectedValue().toString());
                textField5.setText(list1.getSelectedValue().toString());
                textField6.setText(list1.getSelectedValue().toString());

            }
        });*/
        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                textField1.setText(tjm.getValueAt(table1.getSelectedRow(), 0).toString());
                textField2.setText(tjm.getValueAt(table1.getSelectedRow(), 1).toString());
                textField3.setText(tjm.getValueAt(table1.getSelectedRow(), 2).toString());
                textField4.setText(tjm.getValueAt(table1.getSelectedRow(), 3).toString());
                textField5.setText(tjm.getValueAt(table1.getSelectedRow(), 4).toString());
                textField6.setText(tjm.getValueAt(table1.getSelectedRow(), 5).toString());

            }
        });

        borrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "delete from jugador where dnijug=?";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, tjm.getValueAt(table1.getSelectedRow(), 3).toString());


                    st.executeUpdate();

                    tjm.actualizarLista();
                    table1.revalidate();
                    table1.repaint();

                    /*    modelList1.removeAllElements();

                    for (int i = 0; i < JugadoresVer.jugadores().size(); i++) {
                        modelList1.addElement(JugadoresVer.jugadores().get(i));
                    }*/

                    System.out.println(sql);
                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }

            }
        });
        insertarButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into dueño values (?,?,?)";
                    st = conexion.prepareStatement(sql);

                    st.setString(1, textField7.getText());
                    st.setString(2, textField8.getText());
                    st.setString(3, textField9.getText());

                    st.executeUpdate();

                    tdm.actualizarLista();
                    table2.revalidate();
                    table2.repaint();

                    System.out.println(sql);
                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }

            }
        });
        actualizarButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    Connection conexion = Conexion.conexion;

                    String sql = "update dueño set nombredue=?, dnidue=?,codigoequidue=? where dnidue='" + tdm.getValueAt(table2.getSelectedRow(), 1).toString() + "'";


                    PreparedStatement st = conexion.prepareStatement(sql);

                    st = conexion.prepareStatement(sql);

                    st.setString(1, textField7.getText());
                    st.setString(2, textField8.getText());
                    st.setString(3, textField9.getText());

                    st.executeUpdate();

                    tdm.actualizarLista();
                    table2.revalidate();
                    table2.repaint();


                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }


            }

        });
        borrarButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "delete from dueño where dnidue=?";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, tdm.getValueAt(table2.getSelectedRow(), 1).toString());


                    st.executeUpdate();

                    tdm.actualizarLista();
                    table2.revalidate();
                    table2.repaint();

                    System.out.println(sql);
                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }
            }
        });

        table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                textField7.setText(tdm.getValueAt(table2.getSelectedRow(), 0).toString());
                textField8.setText(tdm.getValueAt(table2.getSelectedRow(), 1).toString());
                textField9.setText(tdm.getValueAt(table2.getSelectedRow(), 2).toString());


            }
        });


        insertarButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into equipo values (?,?,?,?,?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField10.getText());
                    st.setString(2, textField11.getText());
                    st.setInt(3, Integer.parseInt(textField12.getText()));
                    st.setInt(4, Integer.parseInt(textField13.getText()));
                    st.setInt(5, Integer.parseInt(textField14.getText()));



                    st.executeUpdate();

                    tem.actualizarLista();
                    table3.revalidate();
                    table3.repaint();


                    System.out.println(sql);
                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }



            }
        });
        actualizarButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    Connection conexion = Conexion.conexion;

                    String sql = "update equipo set nombreequi=?, codigoequi=?,gannados=?," +
                            "empates=?,perdidos=? where codigoequi='" + tem.getValueAt(table3.getSelectedRow(), 1).toString() + "'";


                    PreparedStatement st = conexion.prepareStatement(sql);

                    st = conexion.prepareStatement(sql);

                    st.setString(1, textField10.getText());
                    st.setString(2, textField11.getText());
                    st.setInt(3, Integer.parseInt(textField12.getText()));
                    st.setInt(4, Integer.parseInt(textField13.getText()));
                    st.setInt(5, Integer.parseInt(textField14.getText()));

                    st.executeUpdate();

                    tem.actualizarLista();
                    table3.revalidate();
                    table3.repaint();


                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }

            }
        });
        borrarButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "delete from equipo where codigoequi=?";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, tem.getValueAt(table3.getSelectedRow(), 1).toString());


                    st.executeUpdate();

                    tem.actualizarLista();
                    table3.revalidate();
                    table3.repaint();

                    System.out.println(sql);
                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }

            }
        });

        table3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                textField10.setText(tem.getValueAt(table3.getSelectedRow(), 0).toString());
                textField11.setText(tem.getValueAt(table3.getSelectedRow(), 1).toString());
                textField12.setText(tem.getValueAt(table3.getSelectedRow(), 2).toString());
                textField13.setText(tem.getValueAt(table3.getSelectedRow(), 3).toString());
                textField14.setText(tem.getValueAt(table3.getSelectedRow(), 4).toString());

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
    private JTable table1;
    private JTable table2;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton insertarButton1;
    private JButton actualizarButton1;
    private JButton borrarButton1;
    private JTable table3;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JButton insertarButton2;
    private JButton actualizarButton2;
    private JButton borrarButton2;
    private JTable table4;
    private JTextField textField16;
    private JButton insertarButton3;
    private JButton actualizarButton3;
    private JButton borrarButton3;
    private JScrollPane scrollPane1;
    private JTable table5;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane3;
}
