package com.reto2018;


import oracle.jdbc.internal.OracleTypes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

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
    private JTable table4;
    private JScrollPane scrollPane4;
    private JButton borrarButton;
    private JButton añadirDatosDePruebaButton;
    private JButton eliminarTodoButton;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane3;
    private JTable table5;
    private JScrollPane scrollPane5;
    private JTable table6;
    private JScrollPane scrollPane6;
    private JButton borrarButton1;
    private JButton borrarButton2;
    private JButton borrarButton3;
    private JButton borrarButton4;
    private TablaAdministradoresModel tam = new TablaAdministradoresModel(0);
    private TablaTriggerEquiposModel ttem = new TablaTriggerEquiposModel(0);
    private TablaTriggerDueñosModel ttdm = new TablaTriggerDueñosModel(0);
    private TablaTriggerPartidosModel ttpm = new TablaTriggerPartidosModel(0);
    private TablaTriggerJugadoresModel ttjm = new TablaTriggerJugadoresModel(0);
    private TablaTriggerUsuariosModel ttum = new TablaTriggerUsuariosModel(0);


    public SuperUsuario() throws SQLException, ClassNotFoundException {

        JFrame frame = new JFrame("SuperUsuario");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        datosAdministradores();
        datosTriggers();
        datosConfiguracion();

        funcionesAdministradores();
        funcionesTriggers();
        funcionesConfiguracion();

    }

    private void datosAdministradores() {


        table1.setModel(tam);
        scrollPane1.setViewportView(table1);


    }

    private void datosTriggers() {


        table4.setModel(ttem);
        scrollPane4.setViewportView(table4);

        table2.setModel(ttdm);
        scrollPane2.setViewportView(table2);

        table3.setModel(ttpm);
        scrollPane3.setViewportView(table3);

        table5.setModel(ttjm);
        scrollPane5.setViewportView(table5);

        table6.setModel(ttum);
        scrollPane6.setViewportView(table6);

    }

    private void datosConfiguracion() {


    }


    private void funcionesAdministradores() {

        insertarAdministrador();
        actualizarAdministrador();
        borrarAdministrador();
        seleccionarAdministrador();

    }


    private void funcionesTriggers() {

        borrarTriggerEquipos();
        //   borrarTriggerDueños();
        //  borrarTriggerPartidos();
        //   borrarTriggerJugadores();
        //   borrarTriggerUsuarios();


    }

    private void funcionesConfiguracion() {

        cambiarPassword();
        cargarDatos();
        borrarDatos();

    }

    private void insertarAdministrador() {


        añadirButton.addMouseListener(new

                                              MouseAdapter() {
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


    }

    private void actualizarAdministrador() {


        actualizarButton1.addMouseListener(new

                                                   MouseAdapter() {
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
                                                               st.setString(3, tam.getValueAt(table1.getSelectedRow(), 0).toString());

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


    }

    private void borrarAdministrador() {


        eliminarButton.addMouseListener(new

                                                MouseAdapter() {
                                                    @Override
                                                    public void mouseClicked(MouseEvent e) {
                                                        super.mouseClicked(e);

                                                        try {
                                                            Connection conexion = Conexion.conexion;
                                                            PreparedStatement st;
                                                            String sql = "delete from administradores where nombre=?";

                                                            st = conexion.prepareStatement(sql);

                                                            st.setString(1, tam.getValueAt(table1.getSelectedRow(), 0).toString());

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


    }

    private void seleccionarAdministrador() {


        table1.addMouseListener(new

                                        MouseAdapter() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                super.mouseClicked(e);
                                                textField1.setText(tam.getValueAt(table1.getSelectedRow(), 0).toString());
                                                textField2.setText(tam.getValueAt(table1.getSelectedRow(), 1).toString());
                                                textField3.setText(tam.getValueAt(table1.getSelectedRow(), 2).toString());
                                            }
                                        });


    }


    private void cambiarPassword() {


        cambiarButton.addMouseListener(new

                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);

                                                       try {
                                                           Connection conexion = Conexion.conexion;

                                                           if (new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) {

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


    private void borrarTriggerEquipos() {

        borrarButton.addMouseListener(new

                                              MouseAdapter() {
                                                  @Override
                                                  public void mouseClicked(MouseEvent e) {
                                                      super.mouseClicked(e);

                                                      try {
                                                          Connection conexion = Conexion.conexion;


                                                          String sql = "delete from tablatriggerequipo";


                                                          Statement st = null;

                                                          st = conexion.createStatement();

                                                          st.executeUpdate(sql);

                                                          ttem.actualizarLista();
                                                          table4.revalidate();
                                                          table4.repaint();

                                                      } catch (SQLException e1) {
                                                          e1.printStackTrace();
                                                      } catch (ClassNotFoundException e1) {
                                                          e1.printStackTrace();
                                                      }


                                                  }

                                              });

        borrarButton1.addMouseListener(new
                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);

                                                       try {
                                                           Connection conexion = Conexion.conexion;


                                                           String sql = "delete from tablatriggedueño";


                                                           Statement st = null;

                                                           st = conexion.createStatement();

                                                           st.executeUpdate(sql);

                                                           ttem.actualizarLista();
                                                           table4.revalidate();
                                                           table4.repaint();

                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();
                                                       } catch (ClassNotFoundException e1) {
                                                           e1.printStackTrace();
                                                       }
                                                   }
                                               });
        borrarButton2.addMouseListener(new
                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);

                                                       try {
                                                           Connection conexion = Conexion.conexion;


                                                           String sql = "delete from tablatriggerpartido";


                                                           Statement st = null;

                                                           st = conexion.createStatement();

                                                           st.executeUpdate(sql);

                                                           ttem.actualizarLista();
                                                           table4.revalidate();
                                                           table4.repaint();

                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();
                                                       } catch (ClassNotFoundException e1) {
                                                           e1.printStackTrace();
                                                       }
                                                   }
                                               });
        borrarButton3.addMouseListener(new
                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);

                                                       try {
                                                           Connection conexion = Conexion.conexion;


                                                           String sql = "delete from tablatriggerjugador";


                                                           Statement st = null;

                                                           st = conexion.createStatement();

                                                           st.executeUpdate(sql);

                                                           ttem.actualizarLista();
                                                           table4.revalidate();
                                                           table4.repaint();

                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();
                                                       } catch (ClassNotFoundException e1) {
                                                           e1.printStackTrace();
                                                       }
                                                   }
                                               });
        borrarButton4.addMouseListener(new
                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);

                                                       try {
                                                           Connection conexion = Conexion.conexion;


                                                           String sql = "delete from tablatriggerusuario";


                                                           Statement st = null;

                                                           st = conexion.createStatement();

                                                           st.executeUpdate(sql);

                                                           ttem.actualizarLista();
                                                           table4.revalidate();
                                                           table4.repaint();

                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();
                                                       } catch (ClassNotFoundException e1) {
                                                           e1.printStackTrace();
                                                       }
                                                   }
                                               });


    }


    private void cargarDatos() {


        añadirDatosDePruebaButton.addMouseListener(new

                                                           MouseAdapter() {
                                                               @Override
                                                               public void mouseClicked(MouseEvent e) {
                                                                   super.mouseClicked(e);

                                                                   Connection conexion = Conexion.conexion;
                                                                   try {
                                                                       String sql2 = "{call calendario.insertarDatos}";

                                                                       CallableStatement callableStatement2 = conexion.prepareCall(sql2);


                                                                       callableStatement2.executeUpdate();
                                                                   } catch (SQLException e1) {
                                                                       e1.printStackTrace();
                                                                   }


                                                               }
                                                           });



    }


    private void borrarDatos() {


        eliminarTodoButton.addMouseListener(new

                                                    MouseAdapter() {
                                                        @Override
                                                        public void mouseClicked(MouseEvent e) {
                                                            super.mouseClicked(e);


                                                            Connection conexion = Conexion.conexion;
                                                            try {
                                                                String sql2 = "{call calendario.eliminarDatos}";

                                                                CallableStatement callableStatement2 = conexion.prepareCall(sql2);


                                                                callableStatement2.executeUpdate();
                                                            } catch (SQLException e1) {
                                                                e1.printStackTrace();
                                                            }
                                                        }
                                                    });


    }


}

