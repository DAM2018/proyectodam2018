package com.reto2018;



import oracle.jdbc.internal.OracleTypes;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Administrador {

    //Connection conexion = Conexion.conexion;
    final TablaUsuariosModel tum;
    public Administrador() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("Administrador");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        if (textField10.getText().equals("") &&
                textField12.getText().equals("") &&
                textField13.getText().equals("") &&
                textField14.getText().equals("") &&
                textField28.getText().equals("") &&
                textField29.getText().equals("") &&
                textField30.getText().equals("") &&
                textField31.getText().equals("")) {
            numEquipos.setText("0");
        }


            Connection conexion = Conexion.conexion;

        String sql2 = "{call calendario.verEquipos(?)}";

        CallableStatement callableStatement2 = conexion.prepareCall(sql2);

        callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

        callableStatement2.executeUpdate();
        ResultSet rs = (ResultSet) callableStatement2.getObject(1);
        List<String>listaEquipos=new ArrayList<String>();
        while (rs.next()) {
            String nombreequi = rs.getString("nombreequi");

            listaEquipos.add(nombreequi);


        }
        try{
        textField10.setText(listaEquipos.get(0));
        textField12.setText(listaEquipos.get(1));
        textField13.setText(listaEquipos.get(2));
        textField14.setText(listaEquipos.get(3));
        textField28.setText(listaEquipos.get(4));
        textField29.setText(listaEquipos.get(5));
        textField30.setText(listaEquipos.get(6));
        textField31.setText(listaEquipos.get(7));


        } catch (java.lang.IndexOutOfBoundsException e1) {
        }









        textField15.setVisible(false);
        textField17.setVisible(false);
        textField18.setVisible(false);
        textField21.setVisible(false);
        textField19.setVisible(false);
        textField22.setVisible(false);
        textField20.setVisible(false);
        textField23.setVisible(false);
        textField24.setVisible(false);
        textField25.setVisible(false);
        textField26.setVisible(false);
        textField27.setVisible(false);
        actualizarResultadoFechaButton.setVisible(false);
        insertarButton4.setVisible(false);
        insertarButton5.setVisible(false);
        insertarButton6.setVisible(false);

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
       // final TablaEquiposModel tem = new TablaEquiposModel(0);
        tum = new TablaUsuariosModel(0);

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
//        table3.setModel(tem);
        table4.setModel(tum);


        scrollPane1.setViewportView(table1);
        scrollPane2.setViewportView(table2);
     //  scrollPane3.setViewportView(table3);
        scrollPane4.setViewportView(table4);


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

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                   // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                  //  e1.printStackTrace();
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
                } catch (java.lang.NumberFormatException e1) {
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
                } catch (java.lang.NumberFormatException e1) {
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

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
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
                } catch (java.lang.NumberFormatException e1) {
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
                } catch (java.lang.NumberFormatException e1) {
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

                    if (!textField10.getText().equals("") &&
                            !textField12.getText().equals("") &&
                            !textField13.getText().equals("") &&
                            !textField14.getText().equals("") &&
                            !textField28.getText().equals("") &&
                            !textField29.getText().equals("") &&
                            !textField30.getText().equals("") &&
                            !textField31.getText().equals("") &&
                            numEquipos.getText().equals("0")
                            )
                    {
                        PreparedStatement st;
                    String sql = "insert into equipo values (?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField10.getText());
                    st.executeUpdate();

                    PreparedStatement st2;
                    String sql2 = "insert into equipo values (?)";
                    st2 = conexion.prepareStatement(sql);
                    st2.setString(1, textField12.getText());
                    st2.executeUpdate();

                    PreparedStatement st3;
                    String sql3 = "insert into equipo values (?)";
                    st3 = conexion.prepareStatement(sql);
                    st3.setString(1, textField13.getText());
                    st3.executeUpdate();

                    PreparedStatement st4;
                    String sql4 = "insert into equipo values (?)";
                    st4 = conexion.prepareStatement(sql);
                    st4.setString(1, textField14.getText());
                    st4.executeUpdate();

                    PreparedStatement st5;
                    String sql5 = "insert into equipo values (?)";
                    st5 = conexion.prepareStatement(sql);
                    st5.setString(1, textField28.getText());
                    st5.executeUpdate();

                    PreparedStatement st6;
                    String sql6 = "insert into equipo values (?)";
                    st6 = conexion.prepareStatement(sql);
                    st6.setString(1, textField29.getText());
                    st6.executeUpdate();

                    PreparedStatement st7;
                    String sql7 = "insert into equipo values (?)";
                    st7 = conexion.prepareStatement(sql);
                    st7.setString(1, textField30.getText());
                    st7.executeUpdate();

                    PreparedStatement st8;
                    String sql8 = "insert into equipo values (?)";
                    st8 = conexion.prepareStatement(sql);
                    st8.setString(1, textField31.getText());
                    st8.executeUpdate();
                    numEquipos.setText("8 OK!");

                }

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                }  catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }


            }
        });

        borrarButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
numEquipos.setText("0");
                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "delete from equipo";
                    st = conexion.prepareStatement(sql);


                    st.executeUpdate();
textField10.setText("");
                    textField12.setText("");
                    textField13.setText("");
                    textField14.setText("");
                    textField28.setText("");
                    textField29.setText("");
                    textField30.setText("");
                    textField31.setText("");


                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }

            }
        });



        final DefaultComboBoxModel dcm = new DefaultComboBoxModel();

       // dcm.addElement(0);
        dcm.addElement(1);
        dcm.addElement(2);
        dcm.addElement(3);
        dcm.addElement(4);
        dcm.addElement(5);
        dcm.addElement(6);
        dcm.addElement(7);
        dcm.addElement(8);
        dcm.addElement(9);
        dcm.addElement(10);
        dcm.addElement(11);
        dcm.addElement(12);
        dcm.addElement(13);
        dcm.addElement(14);

        comboBox1.setModel(dcm);


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField15.setText("");
                textField17.setText("");
                textField18.setText("");
                textField21.setText("");
                textField19.setText("");
                textField22.setText("");
                textField20.setText("");
                textField23.setText("");
                textField24.setText("");
                textField25.setText("");
                textField26.setText("");
                textField27.setText("");
                textField15.setVisible(true);
                textField17.setVisible(true);
                textField18.setVisible(true);
                textField21.setVisible(true);
                textField19.setVisible(true);
                textField22.setVisible(true);
                textField20.setVisible(true);
                textField23.setVisible(true);
                textField24.setVisible(true);
                textField25.setVisible(true);
                textField26.setVisible(true);
                textField27.setVisible(true);
                actualizarResultadoFechaButton.setVisible(true);
                insertarButton4.setVisible(true);
                insertarButton5.setVisible(true);
                insertarButton6.setVisible(true);


                String sql = "{call calendario.crearCalendario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
                try {
                    Connection conexion = Conexion.conexion;
                    CallableStatement callableStatement = conexion.prepareCall(sql);

                    callableStatement.setString(1, textField10.getText());
                    callableStatement.setString(2, textField12.getText());
                    callableStatement.setString(3, textField13.getText());
                    callableStatement.setString(4, textField14.getText());
                    callableStatement.setString(5, textField28.getText());
                    callableStatement.setString(6, textField29.getText());
                    callableStatement.setString(7, textField30.getText());
                    callableStatement.setString(8, textField31.getText());
                    callableStatement.setInt(9, Integer.parseInt(dcm.getSelectedItem().toString()));


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


                    String sql2 = "{call calendario.verResultados(?,?)}";

                    CallableStatement callableStatement2 = conexion.prepareCall(sql2);

                    callableStatement2.setInt(1, Integer.parseInt(dcm.getSelectedItem().toString()));
                    callableStatement2.registerOutParameter(2, OracleTypes.CURSOR);
                    //callableStatement2.registerOutParameter(3, Types.VARCHAR);

                    callableStatement2.executeUpdate();
                    ResultSet rs = (ResultSet) callableStatement2.getObject(2);

                    List<Resultado> resultados = new ArrayList<Resultado>();

                    while (rs.next()) {
                        int resultado1 = rs.getInt("resultado1");
                        int resultado2 = rs.getInt("resultado2");
                        String fecha = rs.getString("fecha");

                        resultados.add(new Resultado(resultado1, resultado2,fecha));


                    }
                    textField15.setText(String.valueOf(resultados.get(0).getResultado1()));
                    textField17.setText(String.valueOf(resultados.get(0).getResultado2()));
                    textField24.setText(String.valueOf(resultados.get(0).getFecha()));
                    textField18.setText(String.valueOf(resultados.get(1).getResultado1()));
                    textField21.setText(String.valueOf(resultados.get(1).getResultado2()));
                    textField25.setText(String.valueOf(resultados.get(1).getFecha()));
                    textField19.setText(String.valueOf(resultados.get(2).getResultado1()));
                    textField22.setText(String.valueOf(resultados.get(2).getResultado2()));
                    textField26.setText(String.valueOf(resultados.get(2).getFecha()));
                    textField20.setText(String.valueOf(resultados.get(3).getResultado1()));
                    textField23.setText(String.valueOf(resultados.get(3).getResultado2()));
                    textField27.setText(String.valueOf(resultados.get(3).getFecha()));


                } catch (SQLException e2) {

                    // System.out.println(e.getMessage());

                } catch (java.lang.NullPointerException e2) {


                }catch (java.lang.IndexOutOfBoundsException e2) {


                }


            }
        });
        actualizarResultadoFechaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into partido values (?,?,?,?,?,?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField24.getText());
                    st.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st.setInt(3, Integer.parseInt(textField15.getText()));
                    st.setInt(4, Integer.parseInt(textField17.getText()));
                    st.setString(5, equipo1.getText());
                    st.setString(6, equipo2.getText());


                    st.executeUpdate();


                    textField15.revalidate();
                    textField15.repaint();
                    textField17.revalidate();
                    textField17.repaint();

                    int ganados=0;
                    int empatados=0;
                    int perdidos=0;
                    int puntos=0;
                    if(Integer.parseInt(textField15.getText())>Integer.parseInt(textField17.getText())){
                        ganados=1;
                        puntos=3;
                    }
                    if(Integer.parseInt(textField15.getText())==Integer.parseInt(textField17.getText())){
                        empatados=1;
                        puntos=1;
                    }
                    if(Integer.parseInt(textField15.getText())<Integer.parseInt(textField17.getText())){
                        perdidos=1;
                    }
                    PreparedStatement st2;
                    String sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st2 = conexion.prepareStatement(sql2);
                    st2.setString(1, equipo1.getText());
                    st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st2.setInt(3, puntos);
                    st2.setInt(4, ganados);
                    st2.setInt(5, empatados);
                    st2.setInt(6, perdidos);
                    st2.executeUpdate();
                    int ganados2=0;
                    int empatados2=0;
                    int perdidos2=0;
                    int puntos2=0;
                    if(Integer.parseInt(textField17.getText())>Integer.parseInt(textField15.getText())){
                        ganados2=1;
                        puntos2=3;
                    }
                    if(Integer.parseInt(textField17.getText())==Integer.parseInt(textField15.getText())){
                        empatados2=1;
                        puntos2=1;
                    }
                    if(Integer.parseInt(textField17.getText())<Integer.parseInt(textField15.getText())){
                        perdidos2=1;
                    }
                    PreparedStatement st3;
                    String sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st3 = conexion.prepareStatement(sql3);
                    st3.setString(1, equipo2.getText());
                    st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st3.setInt(3, puntos2);
                    st3.setInt(4, ganados2);
                    st3.setInt(5, empatados2);
                    st3.setInt(6, perdidos2);
                    st3.executeUpdate();

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }

            }
        });
        insertarButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into partido values (?,?,?,?,?,?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField25.getText());
                    st.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st.setInt(3, Integer.parseInt(textField18.getText()));
                    st.setInt(4, Integer.parseInt(textField21.getText()));
                    st.setString(5, equipo3.getText());
                    st.setString(6, equipo4.getText());


                    st.executeUpdate();


                    textField18.revalidate();
                    textField18.repaint();
                    textField21.revalidate();
                    textField21.repaint();

                    int ganados=0;
                    int empatados=0;
                    int perdidos=0;
                    int puntos=0;
                    if(Integer.parseInt(textField18.getText())>Integer.parseInt(textField21.getText())){
                        ganados=1;
                        puntos=3;
                    }
                    if(Integer.parseInt(textField18.getText())==Integer.parseInt(textField21.getText())){
                        empatados=1;
                        puntos=1;
                    }
                    if(Integer.parseInt(textField18.getText())<Integer.parseInt(textField21.getText())){
                        perdidos=1;
                    }
                    PreparedStatement st2;
                    String sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st2 = conexion.prepareStatement(sql2);
                    st2.setString(1, equipo3.getText());
                    st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st2.setInt(3, puntos);
                    st2.setInt(4, ganados);
                    st2.setInt(5, empatados);
                    st2.setInt(6, perdidos);
                    st2.executeUpdate();
                    int ganados2=0;
                    int empatados2=0;
                    int perdidos2=0;
                    int puntos2=0;
                    if(Integer.parseInt(textField21.getText())>Integer.parseInt(textField18.getText())){
                        ganados2=1;
                        puntos2=3;
                    }
                    if(Integer.parseInt(textField21.getText())==Integer.parseInt(textField18.getText())){
                        empatados2=1;
                        puntos2=1;
                    }
                    if(Integer.parseInt(textField21.getText())<Integer.parseInt(textField18.getText())){
                        perdidos2=1;
                    }
                    PreparedStatement st3;
                    String sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st3 = conexion.prepareStatement(sql3);
                    st3.setString(1, equipo4.getText());
                    st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st3.setInt(3, puntos2);
                    st3.setInt(4, ganados2);
                    st3.setInt(5, empatados2);
                    st3.setInt(6, perdidos2);
                    st3.executeUpdate();

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }
            }
        });
        insertarButton5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into partido values (?,?,?,?,?,?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField26.getText());
                    st.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st.setInt(3, Integer.parseInt(textField19.getText()));
                    st.setInt(4, Integer.parseInt(textField22.getText()));
                    st.setString(5, equipo5.getText());
                    st.setString(6, equipo6.getText());


                    st.executeUpdate();


                    textField19.revalidate();
                    textField19.repaint();
                    textField22.revalidate();
                    textField22.repaint();

                    int ganados=0;
                    int empatados=0;
                    int perdidos=0;
                    int puntos=0;
                    if(Integer.parseInt(textField19.getText())>Integer.parseInt(textField22.getText())){
                        ganados=1;
                        puntos=3;
                    }
                    if(Integer.parseInt(textField19.getText())==Integer.parseInt(textField22.getText())){
                        empatados=1;
                        puntos=1;
                    }
                    if(Integer.parseInt(textField19.getText())<Integer.parseInt(textField22.getText())){
                        perdidos=1;
                    }
                    PreparedStatement st2;
                    String sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st2 = conexion.prepareStatement(sql2);
                    st2.setString(1, equipo5.getText());
                    st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st2.setInt(3, puntos);
                    st2.setInt(4, ganados);
                    st2.setInt(5, empatados);
                    st2.setInt(6, perdidos);
                    st2.executeUpdate();
                    int ganados2=0;
                    int empatados2=0;
                    int perdidos2=0;
                    int puntos2=0;
                    if(Integer.parseInt(textField22.getText())>Integer.parseInt(textField19.getText())){
                        ganados2=1;
                        puntos2=3;
                    }
                    if(Integer.parseInt(textField22.getText())==Integer.parseInt(textField19.getText())){
                        empatados2=1;
                        puntos2=1;
                    }
                    if(Integer.parseInt(textField22.getText())<Integer.parseInt(textField19.getText())){
                        perdidos2=1;
                    }
                    PreparedStatement st3;
                    String sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st3 = conexion.prepareStatement(sql3);
                    st3.setString(1, equipo6.getText());
                    st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st3.setInt(3, puntos2);
                    st3.setInt(4, ganados2);
                    st3.setInt(5, empatados2);
                    st3.setInt(6, perdidos2);
                    st3.executeUpdate();

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }
            }
        });
        insertarButton6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "insert into partido values (?,?,?,?,?,?)";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, textField27.getText());
                    st.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st.setInt(3, Integer.parseInt(textField20.getText()));
                    st.setInt(4, Integer.parseInt(textField23.getText()));
                    st.setString(5, equipo7.getText());
                    st.setString(6, equipo8.getText());


                    st.executeUpdate();


                    textField20.revalidate();
                    textField20.repaint();
                    textField23.revalidate();
                    textField23.repaint();

                    int ganados=0;
                    int empatados=0;
                    int perdidos=0;
                    int puntos=0;
                    if(Integer.parseInt(textField20.getText())>Integer.parseInt(textField23.getText())){
                        ganados=1;
                        puntos=3;
                    }
                    if(Integer.parseInt(textField20.getText())==Integer.parseInt(textField23.getText())){
                        empatados=1;
                        puntos=1;
                    }
                    if(Integer.parseInt(textField20.getText())<Integer.parseInt(textField23.getText())){
                        perdidos=1;
                    }
                    PreparedStatement st2;
                    String sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st2 = conexion.prepareStatement(sql2);
                    st2.setString(1, equipo7.getText());
                    st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st2.setInt(3, puntos);
                    st2.setInt(4, ganados);
                    st2.setInt(5, empatados);
                    st2.setInt(6, perdidos);
                    st2.executeUpdate();
                    int ganados2=0;
                    int empatados2=0;
                    int perdidos2=0;
                    int puntos2=0;
                    if(Integer.parseInt(textField23.getText())>Integer.parseInt(textField20.getText())){
                        ganados2=1;
                        puntos2=3;
                    }
                    if(Integer.parseInt(textField23.getText())==Integer.parseInt(textField20.getText())){
                        empatados2=1;
                        puntos2=1;
                    }
                    if(Integer.parseInt(textField23.getText())<Integer.parseInt(textField20.getText())){
                        perdidos2=1;
                    }
                    PreparedStatement st3;
                    String sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                    st3 = conexion.prepareStatement(sql3);
                    st3.setString(1, equipo8.getText());
                    st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                    st3.setInt(3, puntos2);
                    st3.setInt(4, ganados2);
                    st3.setInt(5, empatados2);
                    st3.setInt(6, perdidos2);
                    st3.executeUpdate();

                } catch (SQLException e1) {
                     e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    e1.printStackTrace();
                }
            }
        });
        borrarTodoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;
                    String sql = "delete from partido";
                    st = conexion.prepareStatement(sql);
                    st.executeUpdate();

                    PreparedStatement st2;
                    String sql2 = "delete from clasificacion2";
                    st2 = conexion.prepareStatement(sql2);
                    st2.executeUpdate();

                } catch (SQLException e1) {
                    // e1.printStackTrace();
                }  catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }
            }
        });
        borrarButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);



                try {

                    Connection conexion = Conexion.conexion;

                    PreparedStatement st;


                    String sql = "delete from usuarios where email=?";
                    st = conexion.prepareStatement(sql);
                    st.setString(1, tum.getValueAt(table4.getSelectedRow(), 1).toString());


                    st.executeUpdate();

                    tum.actualizarLista();
                    table4.revalidate();
                    table4.repaint();

                } catch (SQLException e1) {
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }





            }
        });
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Connection conexion = Conexion.conexion;

                String sql2 = "{call calendario.verEquipos(?)}";

                CallableStatement callableStatement2 = null;
                try {
                    callableStatement2 = conexion.prepareCall(sql2);


                callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

                callableStatement2.executeUpdate();
                ResultSet rs = (ResultSet) callableStatement2.getObject(1);
                List<String>listaEquipos=new ArrayList<String>();
                while (rs.next()) {
                    String nombreequi = rs.getString("nombreequi");

                    listaEquipos.add(nombreequi);


                }

                textField10.setText(listaEquipos.get(0));
                textField12.setText(listaEquipos.get(1));
                textField13.setText(listaEquipos.get(2));
                textField14.setText(listaEquipos.get(3));
                textField28.setText(listaEquipos.get(4));
                textField29.setText(listaEquipos.get(5));
                textField30.setText(listaEquipos.get(6));
                textField31.setText(listaEquipos.get(7));


            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (java.lang.IndexOutOfBoundsException e1) {
            }
            }
        });
    }

    public TablaUsuariosModel getTum() {
        return tum;
    }

    public JTable getTable4() {
        return table4;
    }

    public void setTable4(JTable table4) {
        this.table4 = table4;
    }

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel Jugadore;
    private JPanel Dueños;
    private JPanel Equipos;
    private JPanel Partidos;
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
    private JButton borrarButton2;
    private JTable table4;
    private JButton borrarButton3;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane3;
    private JComboBox comboBox1;
    private JTextField textField15;
    private JTextField textField17;
    private JTextField textField18;
    private JTextField textField19;
    private JTextField textField20;
    private JTextField textField21;
    private JTextField textField22;
    private JTextField textField23;
    private JLabel equipo1;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JLabel equipo6;
    private JLabel equipo7;
    private JLabel equipo8;
    private JButton actualizarResultadoFechaButton;
    private JTextField textField24;
    private JTextField textField25;
    private JTextField textField26;
    private JTextField textField27;
    private JButton insertarButton4;
    private JButton insertarButton5;
    private JButton insertarButton6;
    private JButton borrarTodoButton;
    private JScrollPane scrollPane4;
    private JPasswordField passwordField1;
    private JTextField textField16;
    private JPasswordField passwordField2;
    private JTextField textField28;
    private JTextField textField29;
    private JTextField textField30;
    private JTextField textField31;
    private JButton refreshButton;
    private JLabel numEquipos;
}
