package com.reto2018;

import oracle.jdbc.internal.OracleTypes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abre la ventana de los administradores
 *
 * @author Iñigo, Jose, Mikel
 * @since 2018 -05-11
 */
public class Dueño {
    /**
     * <p></p>
     */
    private JPanel panel11;
    /**
     * <p></p>
     */
    private JTable table1;
    /**
     * <p></p>
     */
    private JTable table2;
    /**
     * <p></p>
     */
    private JScrollPane scrollPane1;
    /**
     * <p></p>
     */
    private JScrollPane scrollPane2;
    /**
     * <p></p>
     */
    private JLabel equipo;
    /**
     * <p></p>
     */
    private JPanel añadir;
    /**
     * <p></p>
     */
    private JPanel eliminar;
    /**
     * <p></p>
     */
    private JLabel equipo1;
    /**
     * <p></p>
     */
    private JLabel equipo2;
    /**
     * <p></p>
     */
    private JLabel equipo3;
    /**
     * <p></p>
     */
    private JLabel equipo4;
    /**
     * <p></p>
     */
    private JLabel equipo5;
    /**
     * <p></p>
     */
    private JLabel equipo6;
    /**
     * <p></p>
     */
    private JLabel equipo7;
    /**
     * <p></p>
     */
    private JLabel equipo8;
    /**
     * <p></p>
     */
    private JLabel res1;
    /**
     * <p></p>
     */
    private JLabel res2;
    /**
     * <p></p>
     */
    private JLabel res3;
    /**
     * <p></p>
     */
    private JLabel res4;
    /**
     * <p></p>
     */
    private JLabel res5;
    /**
     * <p></p>
     */
    private JLabel res6;
    /**
     * <p></p>
     */
    private JLabel res7;
    /**
     * <p></p>
     */
    private JLabel res8;
    /**
     * <p></p>
     */
    private JLabel fecha1;
    /**
     * <p></p>
     */
    private JLabel fecha2;
    /**
     * <p></p>
     */
    private JLabel fecha3;
    /**
     * <p></p>
     */
    private JLabel fecha4;
    /**
     * <p></p>
     */
    private JLabel jornada1;
    /**
     * <p></p>
     */
    private JLabel jornada2;
    /**
     * <p></p>
     */
    private JLabel e1;
    /**
     * <p></p>
     */
    private JLabel e2;
    /**
     * <p></p>
     */
    private JLabel e3;
    /**
     * <p></p>
     */
    private JLabel e4;
    /**
     * <p></p>
     */
    private JLabel e5;
    /**
     * <p></p>
     */
    private JLabel e6;
    /**
     * <p></p>
     */
    private JLabel e7;
    /**
     * <p></p>
     */
    private JLabel e8;
    /**
     * <p></p>
     */
    private JLabel puntos1;
    /**
     * <p></p>
     */
    private JLabel puntos2;
    /**
     * <p></p>
     */
    private JLabel puntos3;
    /**
     * <p></p>
     */
    private JLabel puntos4;
    /**
     * <p></p>
     */
    private JLabel puntos5;
    /**
     * <p></p>
     */
    private JLabel puntos6;
    /**
     * <p></p>
     */
    private JLabel puntos7;
    /**
     * <p></p>
     */
    private JLabel puntos8;
    /**
     * <p></p>
     */
    private JLabel ganados1;
    /**
     * <p></p>
     */
    private JLabel ganados2;
    /**
     * <p></p>
     */
    private JLabel ganados3;
    /**
     * <p></p>
     */
    private JLabel ganados4;
    /**
     * <p></p>
     */
    private JLabel ganados5;
    /**
     * <p></p>
     */
    private JLabel ganados6;
    /**
     * <p></p>
     */
    private JLabel ganados7;
    /**
     * <p></p>
     */
    private JLabel ganados8;
    /**
     * <p></p>
     */
    private JLabel empatados1;
    /**
     * <p></p>
     */
    private JLabel empatados2;
    /**
     * <p></p>
     */
    private JLabel empatados3;
    /**
     * <p></p>
     */
    private JLabel empatados4;
    /**
     * <p></p>
     */
    private JLabel empatados5;
    /**
     * <p></p>
     */
    private JLabel empatados6;
    /**
     * <p></p>
     */
    private JLabel empatados7;
    /**
     * <p></p>
     */
    private JLabel empatados8;
    /**
     * <p></p>
     */
    private JLabel perdidos1;
    /**
     * <p></p>
     */
    private JLabel perdidos2;
    /**
     * <p></p>
     */
    private JLabel perdidos3;
    /**
     * <p></p>
     */
    private JLabel perdidos4;
    /**
     * <p></p>
     */
    private JLabel perdidos5;
    /**
     * <p></p>
     */
    private JLabel perdidos6;
    /**
     * <p></p>
     */
    private JLabel perdidos7;
    /**
     * <p></p>
     */
    private JLabel perdidos8;
    /**
     * <p></p>
     */
    private JTextField textField1;
    /**
     * <p></p>
     */
    private JPasswordField passwordField1;
    /**
     * <p></p>
     */
    private JTextField textField2;
    /**
     * <p></p>
     */
    private JPasswordField passwordField2;
    /**
     * <p></p>
     */
    private JButton cambiarButton;
    /**
     * <p></p>
     */
    private JTextField textField3;
    /**
     * <p></p>
     */
    private JTextField textField4;
    /**
     * <p></p>
     */
    private JTextField textField5;
    /**
     * <p></p>
     */
    private JTextField textField6;
    /**
     * <p></p>
     */
    private JTextField textField7;
    /**
     * <p></p>
     */
    private JTextField textField8;
    /**
     * <p></p>
     */
    private JTextField textField9;
    /**
     * <p></p>
     */
    private JButton actualizarButton;
    /**
     * <p></p>
     */
    private JLabel bienvenida;
    /**
     * <p></p>
     */
    private JTextField textField11;
    /**
     * <p></p>
     */
    private List<String> listaEquipos;
    /**
     * <p></p>
     */
    private int jornada = 0;
    /**
     * <p></p>
     */
    private TablaJugadoresModel tjm = new TablaJugadoresModel(0);
    /**
     * <p></p>
     */
    private TablaJugadoresModel tjm2 = new TablaJugadoresModel(0, 0);
    /**
     * <p></p>
     */
    private Connection conexion = Conexion.conexion;


    /**
     * <p>
     * Controla las acciones permitidas a los dueños
     *
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     * @author Iñigo, Jose, Mikel
     * @since 2018 -05-11
     * </p>
     */

    public Dueño() throws SQLException, ClassNotFoundException {

        JFrame frame = new JFrame("Dueño");
        frame.setContentPane(panel11);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Bienvenida
        bienvenida.setText(Inicio.getLogin().getNombreDue().get(Inicio.getLogin().getDu() - 1));


        datosCrearPlantilla();

        datosUltimosResultados();

        datosUltimaClasificacion();

        datosConfiguracion();

        crearPlantilla();
    }

    public void crearPlantilla() {

        añadirJugador();

        eliminarJugador();

    }

    public void configuracion() {

        actualizarDatos();

        cambiarPassword();

    }

    public void datosCrearPlantilla() throws SQLException, ClassNotFoundException {


        String sql2 = "{call calendario.verEquipos(?)}";

        CallableStatement callableStatement2 = conexion.prepareCall(sql2);

        callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

        callableStatement2.executeUpdate();
        ResultSet rs = (ResultSet) callableStatement2.getObject(1);
        listaEquipos = new ArrayList<String>();
        while (rs.next())

        {
            String nombreequi = rs.getString("nombreequi");

            listaEquipos.add(nombreequi);


        }

        equipo.setText(listaEquipos.get(Inicio.getLogin().getDu() - 1));


        table1.setModel(tjm);
        table2.setModel(tjm2);

        scrollPane1.setViewportView(table1);
        scrollPane2.setViewportView(table2);
    }


    public void datosUltimosResultados() {


        try

        {

            Statement st = conexion.createStatement();

            String sql = "select max(jornada) from clasificacion2";

            ResultSet rs = st.executeQuery(sql);
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

            sql = "{call calendario.verResultados(?,?)}";

            callableStatement = conexion.prepareCall(sql);
            //int j = Integer.parseInt(dcm2.getSelectedItem().toString());

            callableStatement.setInt(1, jornada);
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

            callableStatement.executeUpdate();
            rs = (ResultSet) callableStatement.getObject(2);

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


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void datosUltimaClasificacion() throws SQLException {

        List<Clasificacion> clasificacion = new ArrayList<Clasificacion>();

        jornada2.setText(String.valueOf(jornada));


        Statement st = null;

        st = conexion.createStatement();


        String sql = "select equipo,sum(puntos),sum(ganados),sum(empatados),sum(perdidos) from clasificacion2 where " +
                " jornada=" + 1 +
                " or jornada=" + 2 +
                " or jornada=" + 3 +
                " or jornada=" + 4 +
                " or jornada=" + 5 +
                " or jornada=" + 6 +
                " or jornada=" + 7 +
                " or jornada=" + 8 +
                " or jornada=" + 9 +
                " or jornada=" + 10 +
                " or jornada=" + 11 +
                " or jornada=" + 12 +
                " or jornada=" + 13 +
                " or jornada=" + 14 +

                " group by equipo order by sum(puntos) desc, equipo";

        ResultSet rs = null;

        rs = st.executeQuery(sql);


        while (rs.next())

        {

            clasificacion.add(new Clasificacion(
                    rs.getString(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5)));

        }


        e1.setText(clasificacion.get(0).

                getEquipo());
        e2.setText(clasificacion.get(1).

                getEquipo());
        e3.setText(clasificacion.get(2).

                getEquipo());
        e4.setText(clasificacion.get(3).

                getEquipo());
        e5.setText(clasificacion.get(4).

                getEquipo());
        e6.setText(clasificacion.get(5).

                getEquipo());
        e7.setText(clasificacion.get(6).

                getEquipo());
        e8.setText(clasificacion.get(7).

                getEquipo());

        puntos1.setText(String.valueOf(clasificacion.get(0).

                getPuntos()));
        puntos2.setText(String.valueOf(clasificacion.get(1).

                getPuntos()));
        puntos3.setText(String.valueOf(clasificacion.get(2).

                getPuntos()));
        puntos4.setText(String.valueOf(clasificacion.get(3).

                getPuntos()));
        puntos5.setText(String.valueOf(clasificacion.get(4).

                getPuntos()));
        puntos6.setText(String.valueOf(clasificacion.get(5).

                getPuntos()));
        puntos7.setText(String.valueOf(clasificacion.get(6).

                getPuntos()));
        puntos8.setText(String.valueOf(clasificacion.get(7).

                getPuntos()));

        ganados1.setText(String.valueOf(clasificacion.get(0).

                getGanados()));
        ganados2.setText(String.valueOf(clasificacion.get(1).

                getGanados()));
        ganados3.setText(String.valueOf(clasificacion.get(2).

                getGanados()));
        ganados4.setText(String.valueOf(clasificacion.get(3).

                getGanados()));
        ganados5.setText(String.valueOf(clasificacion.get(4).

                getGanados()));
        ganados6.setText(String.valueOf(clasificacion.get(5).

                getGanados()));
        ganados7.setText(String.valueOf(clasificacion.get(6).

                getGanados()));
        ganados8.setText(String.valueOf(clasificacion.get(7).

                getGanados()));

        empatados1.setText(String.valueOf(clasificacion.get(0).

                getEmpatados()));
        empatados2.setText(String.valueOf(clasificacion.get(1).

                getEmpatados()));
        empatados3.setText(String.valueOf(clasificacion.get(2).

                getEmpatados()));
        empatados4.setText(String.valueOf(clasificacion.get(3).

                getEmpatados()));
        empatados5.setText(String.valueOf(clasificacion.get(4).

                getEmpatados()));
        empatados6.setText(String.valueOf(clasificacion.get(5).

                getEmpatados()));
        empatados7.setText(String.valueOf(clasificacion.get(6).

                getEmpatados()));
        empatados8.setText(String.valueOf(clasificacion.get(7).

                getEmpatados()));

        perdidos1.setText(String.valueOf(clasificacion.get(0).

                getPerdidos()));
        perdidos2.setText(String.valueOf(clasificacion.get(1).

                getPerdidos()));
        perdidos3.setText(String.valueOf(clasificacion.get(2).

                getPerdidos()));
        perdidos4.setText(String.valueOf(clasificacion.get(3).

                getPerdidos()));
        perdidos5.setText(String.valueOf(clasificacion.get(4).

                getPerdidos()));
        perdidos6.setText(String.valueOf(clasificacion.get(5).

                getPerdidos()));
        perdidos7.setText(String.valueOf(clasificacion.get(6).

                getPerdidos()));
        perdidos8.setText(String.valueOf(clasificacion.get(7).

                getPerdidos()));

        clasificacion.clear();


    }


    public void datosConfiguracion() throws SQLException {


        Statement st = conexion.createStatement();

        String sql = "select fundacion,ciudad,estadio,capacidad,titulos from equipo where nombreequi='" + equipo.getText() + "'";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next())

        {


            textField3.setText(String.valueOf(rs.getInt(1)));
            textField4.setText(rs.getString(2));
            textField5.setText(rs.getString(3));
            textField6.setText(String.valueOf(rs.getInt(4)));
            textField11.setText(String.valueOf(rs.getInt(5)));

        }

        sql = "select nombre,edad,profesion from dueño where nombredue='" + bienvenida.getText() + "'";

        rs = st.executeQuery(sql);

        while (rs.next())

        {


            textField7.setText(rs.getString(1));
            textField8.setText(String.valueOf(rs.getInt(2)));
            textField9.setText(rs.getString(3));


        }


    }



    private void añadirJugador() {

        añadir.addMouseListener(new

                                        MouseAdapter() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                super.mouseClicked(e);


                                                try {
                                                    Connection conexion = Conexion.conexion;

                                                    String sql = "alter trigger numJug enable";

                                                    Statement st5 = conexion.prepareStatement(sql);

                                                    st5 = conexion.prepareStatement(sql);

                                                    st5.execute(sql);


                                                    sql = "update jugador set CodigoEquiJug=?,actualizacion=seq.nextval where dnijug='" + tjm.getValueAt(table1.getSelectedRow(), 3).toString() + "'";


                                                    PreparedStatement st = conexion.prepareStatement(sql);

                                                    st = conexion.prepareStatement(sql);

                                                    st.setString(1, listaEquipos.get(Inicio.getLogin().getDu() - 1));
                                                    //st.setInt(2, seq.nextval);

                                                    st.executeUpdate();

                                                    tjm.actualizarLista();
                                                    table1.revalidate();
                                                    table1.repaint();

                                                    tjm2.actualizarLista2();
                                                    table2.revalidate();
                                                    table2.repaint();


                                                } catch (SQLException e1) {
                                                    e1.printStackTrace();
                                                } catch (ClassNotFoundException e1) {
                                                    e1.printStackTrace();
                                                } catch (java.lang.NumberFormatException e1) {
                                                    e1.printStackTrace();
                                                } catch (java.lang.NullPointerException e1) {
                                                    e1.printStackTrace();
                                                }


                                            }
                                        });
    }

    private void eliminarJugador() {

        eliminar.addMouseListener(new

                                          MouseAdapter() {
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


    }




    private void actualizarDatos() {

        actualizarButton.addMouseListener(new
                                                  MouseAdapter() {
                                                      @Override
                                                      public void mouseClicked(MouseEvent e) {
                                                          super.mouseClicked(e);


                                                          try {

                                                              Connection conexion = Conexion.conexion;

                                                              PreparedStatement st;


                                                              String sql = "update equipo set fundacion=?,ciudad=?,estadio=?,capacidad=?,titulos=? " +
                                                                      "where nombreequi='" + equipo.getText() + "'";
                                                              st = conexion.prepareStatement(sql);
                                                              st.setInt(1, Integer.parseInt(textField3.getText()));
                                                              st.setString(2, textField4.getText());
                                                              st.setString(3, textField5.getText());
                                                              st.setInt(4, Integer.parseInt(textField6.getText()));
                                                              st.setInt(5, Integer.parseInt(textField11.getText()));

                                                              st.executeUpdate();


                                                              sql = "update dueño set nombre=?,edad=?,profesion=? " +
                                                                      "where nombredue='" + bienvenida.getText() + "'";
                                                              st = conexion.prepareStatement(sql);
                                                              st.setString(1, textField7.getText());
                                                              st.setInt(2, Integer.parseInt(textField8.getText()));
                                                              st.setString(3, textField9.getText());

                                                              st.executeUpdate();


                                                          } catch (SQLException e1) {
                                                              // e1.printStackTrace();
                                                          } catch (java.lang.NumberFormatException e1) {
                                                              //  e1.printStackTrace();
                                                          }


                                                      }
                                                  });
    }

    private void cambiarPassword() {

        cambiarButton.addMouseListener(new

                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);


                                                       if (textField1.getText().equals(textField2.getText()) &&
                                                               new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) {

                                                           try {
                                                               Connection conexion = Conexion.conexion;
                                                               PreparedStatement st;
                                                               String sql = "update dueño set nombredue=?,passworddue=? where " +
                                                                       "equidue=?";
                                                               st = conexion.prepareStatement(sql);

                                                               st.setString(1, textField1.getText());
                                                               st.setString(2, new String(passwordField1.getPassword()));
                                                               st.setString(3, listaEquipos.get(Inicio.getLogin().getDu() - 1));


                                                               st.executeUpdate();


                                                               JOptionPane.showMessageDialog(null, "Cambiado con exito!!", "Cambiar", JOptionPane.OK_OPTION);


                                                           } catch (SQLException e9) {
                                                               e9.printStackTrace();
                                                           }

                                                       } else {
                                                           System.out.println("error");
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
