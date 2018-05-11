package com.reto2018;


import oracle.jdbc.internal.OracleTypes;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abre la ventana de los administradores
 *
 * @author Iñigo, Jose, Mikel
 * @since 2018 -05-11
 */
public class Administrador {

    private int administrador;
    /**
     * <p>lista de los 8 equipos en orden de insercion</p>
     */
    private List<String> listaEquipos;
    /**
     * <p></p>
     */
    private JPanel panel1;
    /**
     * <p></p>
     */
    private JButton insertarButton;
    /**
     * <p></p>
     */
    private JButton actualizarButton;
    /**
     * <p></p>
     */
    private JButton borrarButton;
    /**
     * <p></p>
     */
    private JTextField textField1;
    /**
     * <p></p>
     */
    private JTextField textField2;
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
    private JTable table1;
    /**
     * <p></p>
     */
    private JTextField textField7;
    /**
     * <p></p>
     */
    private JTextField textField10;
    /**
     * <p></p>
     */
    private JTextField textField11;
    /**
     * <p></p>
     */
    private JTextField textField12;
    /**
     * <p></p>
     */
    private JTextField textField13;
    /**
     * <p></p>
     */
    private JTextField textField14;
    /**
     * <p></p>
     */
    private JLabel insertarButton2;
    /**
     * <p></p>
     */
    private JLabel borrarButton2;
    /**
     * <p></p>
     */
    private JTable table4;
    /**
     * <p></p>
     */
    private JButton borrarButton3;
    /**
     * <p></p>
     */
    private JScrollPane scrollPane1;
    /**
     * <p></p>
     */
    private JComboBox comboBox1;
    /**
     * <p></p>
     */
    private JTextField textField15;
    /**
     * <p></p>
     */
    private JTextField textField17;
    /**
     * <p></p>
     */
    private JTextField textField18;
    /**
     * <p></p>
     */
    private JTextField textField19;
    /**
     * <p></p>
     */
    private JTextField textField20;
    /**
     * <p></p>
     */
    private JTextField textField21;
    /**
     * <p></p>
     */
    private JTextField textField22;
    /**
     * <p></p>
     */
    private JTextField textField23;
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
    private JButton actualizarResultadoFechaButton;
    /**
     * <p></p>
     */
    private JTextField textField24;
    /**
     * <p></p>
     */
    private JTextField textField25;
    /**
     * <p></p>
     */
    private JTextField textField26;
    /**
     * <p></p>
     */
    private JTextField textField27;
    /**
     * <p></p>
     */
    private JButton borrarTodoButton;
    /**
     * <p></p>
     */
    private JScrollPane scrollPane4;
    /**
     * <p></p>
     */
    private JPasswordField passwordField1;
    /**
     * <p></p>
     */
    private JTextField textField16;
    /**
     * <p></p>
     */
    private JPasswordField passwordField2;
    /**
     * <p></p>
     */
    private JTextField textField28;
    /**
     * <p></p>
     */
    private JTextField textField29;
    /**
     * <p></p>
     */
    private JTextField textField30;
    /**
     * <p></p>
     */
    private JTextField textField31;
    /**
     * <p></p>
     */
    private JLabel refreshButton;
    /**
     * <p></p>
     */
    private JLabel numEquipos;
    /**
     * <p></p>
     */
    private JButton cambiarButton;
    /**
     * <p></p>
     */
    private JLabel dueñosEq1;
    /**
     * <p></p>
     */
    private JLabel dueñosEq2;
    /**
     * <p></p>
     */
    private JLabel dueñosEq3;
    /**
     * <p></p>
     */
    private JLabel dueñosEq4;
    /**
     * <p></p>
     */
    private JLabel dueñosEq5;
    /**
     * <p></p>
     */
    private JLabel dueñosEq6;
    /**
     * <p></p>
     */
    private JLabel dueñosEq7;
    /**
     * <p></p>
     */
    private JLabel dueñosEq8;
    /**
     * <p></p>
     */
    private JLabel dueñosInsertar;
    /**
     * <p></p>
     */
    private JLabel dueñosRefresh;
    /**
     * <p></p>
     */
    private JLabel dueñosBorrar;
    /**
     * <p></p>
     */
    private JLabel numDueños;
    /**
     * <p></p>
     */
    private JTextField d2;
    /**
     * <p></p>
     */
    private JTextField d3;
    /**
     * <p></p>
     */
    private JTextField d4;
    /**
     * <p></p>
     */
    private JTextField d5;
    /**
     * <p></p>
     */
    private JTextField d6;
    /**
     * <p></p>
     */
    private JTextField d7;
    /**
     * <p></p>
     */
    private JTextField d8;
    /**
     * <p></p>
     */
    private JLabel bienvenida;
    /**
     * <p></p>
     */
    private JLabel a1;
    /**
     * <p></p>
     */
    private JLabel a2;
    /**
     * <p></p>
     */
    private JLabel a3;
    /**
     * <p></p>
     */
    private JLabel a4;
    /**
     * <p></p>
     */
    private JLabel a5;
    /**
     * <p></p>
     */
    private JLabel a6;
    /**
     * <p></p>
     */
    private JLabel a7;
    /**
     * <p></p>
     */
    private JLabel a8;
    /**
     * <p></p>
     */
    private JLabel ae1;
    /**
     * <p></p>
     */
    private JLabel ae2;
    /**
     * <p></p>
     */
    private JLabel ae3;
    /**
     * <p></p>
     */
    private JLabel ae4;
    /**
     * <p></p>
     */
    private JLabel ae5;
    /**
     * <p></p>
     */
    private JLabel ae6;
    /**
     * <p></p>
     */
    private JLabel ae7;
    /**
     * <p></p>
     */
    private JLabel ae8;
    /**
     * <p></p>
     */
    private JLabel ar1;
    /**
     * <p></p>
     */
    private JLabel ar2;
    /**
     * <p></p>
     */
    private JLabel ar3;
    /**
     * <p></p>
     */
    private JLabel ar4;
    /**
     * <p></p>
     */
    private DefaultComboBoxModel dcm = new DefaultComboBoxModel();
    /**
     * <p></p>
     */
    private TablaJugadoresModel tjm = new TablaJugadoresModel(0);
    /**
     * <p></p>
     */
    private TablaUsuariosModel tum = new TablaUsuariosModel(0);
    /**
     * <p></p>
     */
    private Connection conexion = Conexion.conexion;

    /**
     * <p>
     * Controla las acciones permitidas a los administradores
     *
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     * @author Iñigo, Jose, Mikel
     * @since 2018 -05-11
     * </p>
     */
    public Administrador() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("Administrador");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        /// Bienvenida al administrador

        bienvenida.setText(Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));


        datosEquipos();

        datosPartidos();

        datosJugadores();

        datosUsuarios();


        funcionesEquipos();

        funcionesDueños();

        funcionesPartidos();

        funcionesJugadores();

        funcionesUsuarios();

        funcionesConfiguracion();

    }

    /**
     * <p>Carga las acciones del mouse relacionadas con la pestaña EQUIPOS
     * <p>
     * insertarEquipos();
     * <p>
     * refreshEquipos();
     * <p>
     * borrarEquipos();
     * <p>
     * actualizarEquipos();
     */

    private void funcionesEquipos() throws SQLException, ClassNotFoundException {

        insertarEquipos();

        refreshEquipos();

        borrarEquipos();

        actualizarEquipos();
    }

    /**
     * <p>Carga las acciones del mouse relacionadas con la pestaña DUEÑOS
     * <p>
     * insertarDueños();
     * <p>
     * refreshDueños();
     * <p>
     * borrarDueños();
     * <p>
     * actualizarDueños();
     */

    private void funcionesDueños() throws SQLException, ClassNotFoundException {

        insertarDueños();

        refreshDueños();

        borrarDueños();

        actualizarDueños();
    }

    /**
     * <p>Carga las acciones del mouse relacionadas con la pestaña PARTIDOS
     * <p>
     * insertarResultados();
     * <p>
     * actualizarResultados();
     * <p>
     * borrarResultados();
     */

    private void funcionesPartidos() {

        insertarResultados();

        actualizarResultados();

        borrarResultados();
    }

    /**
     * <p>Carga las acciones del mouse relacionadas con la pestaña JUGADORES
     * <p>
     * insertarJugador();
     * <p>
     * actualizarJugador();
     * <p>
     * borrarJugador();
     */

    private void funcionesJugadores() {

        insertarJugador();

        actualizarJugador();

        borrarJugador();
    }

    /**
     * <p>Carga las acciones del mouse relacionadas con la pestaña USUARIOS
     * <p>
     * borrarUsuario();
     */

    private void funcionesUsuarios() {

        borrarUsuario();
    }

    /**
     * <p>Carga las acciones del mouse relacionadas con la pestaña CONFIGURACION
     * <p>
     * cambiarPassword();
     */

    private void funcionesConfiguracion() {

        cambiarPassword();

    }

    /**
     * <p>Carga los equipos
     */

    private void datosEquipos() throws SQLException {


        final Connection conexion = Conexion.conexion;

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
        try

        {
            textField10.setText(listaEquipos.get(0));
            textField12.setText(listaEquipos.get(1));
            textField13.setText(listaEquipos.get(2));
            textField14.setText(listaEquipos.get(3));
            textField28.setText(listaEquipos.get(4));
            textField29.setText(listaEquipos.get(5));
            textField30.setText(listaEquipos.get(6));
            textField31.setText(listaEquipos.get(7));


        } catch (
                java.lang.IndexOutOfBoundsException e1)

        {
        }


        if (textField10.getText().

                equals("") &&
                textField12.getText().

                        equals("") &&
                textField13.getText().

                        equals("") &&
                textField14.getText().

                        equals("") &&
                textField28.getText().

                        equals("") &&
                textField29.getText().

                        equals("") &&
                textField30.getText().

                        equals("") &&
                textField31.getText().

                        equals(""))

        {
            numEquipos.setText("0");
        } else

        {
            numEquipos.setText("8 OK!");
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


        if (numEquipos.getText().

                equals("8 OK!"))

        {
            dueñosEq1.setText(textField10.getText());
            dueñosEq2.setText(textField12.getText());
            dueñosEq3.setText(textField13.getText());
            dueñosEq4.setText(textField14.getText());
            dueñosEq5.setText(textField28.getText());
            dueñosEq6.setText(textField29.getText());
            dueñosEq7.setText(textField30.getText());
            dueñosEq8.setText(textField31.getText());
        }

        String sql6 = "{call calendario.verDueños(?)}";

        CallableStatement callableStatement6 = null;
        try

        {
            callableStatement6 = conexion.prepareCall(sql6);


            callableStatement6.registerOutParameter(1, OracleTypes.CURSOR);

            callableStatement6.executeUpdate();
            rs = (ResultSet) callableStatement6.getObject(1);
            List<String> listaDueños = new ArrayList<String>();
            while (rs.next()) {
                String nombreDue = rs.getString("NombreDue");
                String passwordDue = rs.getString("PasswordDue");

                listaDueños.add(nombreDue);
                listaDueños.add(passwordDue);


            }

            textField7.setText(listaDueños.get(0));
            d2.setText(listaDueños.get(2));
            d3.setText(listaDueños.get(4));
            d4.setText(listaDueños.get(6));
            d5.setText(listaDueños.get(8));
            d6.setText(listaDueños.get(10));
            d7.setText(listaDueños.get(12));
            d8.setText(listaDueños.get(14));

            listaDueños.clear();

        } catch (
                SQLException e1)

        {
            e1.printStackTrace();
        } catch (
                java.lang.IndexOutOfBoundsException e1)

        {
        }
        if (textField7.getText().

                equals("") &&
                d2.getText().

                        equals("") &&
                d3.getText().

                        equals("") &&
                d4.getText().

                        equals("") &&
                d5.getText().

                        equals("") &&
                d6.getText().

                        equals("") &&
                d7.getText().

                        equals("") &&
                d8.getText().

                        equals(""))

        {
            numDueños.setText("0");
        } else

        {
            numDueños.setText("8 OK!");
        }


    }

    /**
     * <p>Carga los partidos
     */

    private void datosPartidos() {


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
        dcm.setSelectedItem("");


        comboBox1.addActionListener(new

                                            ActionListener() {
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

                                                        callableStatement2.executeUpdate();
                                                        ResultSet rs = (ResultSet) callableStatement2.getObject(2);

                                                        List<Resultado> resultados = new ArrayList<Resultado>();

                                                        while (rs.next()) {
                                                            int resultado1 = rs.getInt("resultado1");
                                                            int resultado2 = rs.getInt("resultado2");
                                                            String fecha = rs.getString("fecha");

                                                            resultados.add(new Resultado(resultado1, resultado2, fecha));


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


                                                    } catch (java.lang.IndexOutOfBoundsException e2) {


                                                    }


                                                }
                                            });


    }

    /**
     * <p>Carga la tabla con los jugadores
     */
    private void datosJugadores() throws SQLException, ClassNotFoundException {


        table1.setModel(tjm);

        table4.setModel(tum);


        scrollPane1.setViewportView(table1);

        scrollPane4.setViewportView(table4);

        table1.getSelectionModel().

                addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        textField1.setText(tjm.getValueAt(table1.getSelectedRow(), 0).toString());
                        textField2.setText(tjm.getValueAt(table1.getSelectedRow(), 1).toString());
                        textField3.setText(tjm.getValueAt(table1.getSelectedRow(), 2).toString());
                        textField4.setText(tjm.getValueAt(table1.getSelectedRow(), 3).toString());
                        textField5.setText(tjm.getValueAt(table1.getSelectedRow(), 4).toString());

                    }
                });

    }

    /**
     * <p>Carga la tabla con los usuarios
     */

    private void datosUsuarios() throws SQLException, ClassNotFoundException {


        table4.setModel(tum);

        scrollPane4.setViewportView(table4);
    }

    /**
     * <p>Inserta 8 equipos(al mismo tiempo) en la base de datos
     */

    private void insertarEquipos() {


        insertarButton2.addMouseListener(new
                                                 MouseAdapter() {
                                                     @Override
                                                     public void mouseClicked(MouseEvent e) {
                                                         super.mouseClicked(e);


                                                         try {

                                                             Connection conexion = Conexion.conexion;

                                                             if (!textField10.getText().isEmpty() &&
                                                                     !textField12.getText().isEmpty() &&
                                                                     !textField13.getText().isEmpty() &&
                                                                     !textField14.getText().isEmpty() &&
                                                                     !textField28.getText().isEmpty() &&
                                                                     !textField29.getText().isEmpty() &&
                                                                     !textField30.getText().isEmpty() &&
                                                                     !textField31.getText().isEmpty() &&
                                                                     numEquipos.getText().equals("0")
                                                                     ) {
                                                                 PreparedStatement st;
                                                                 String sql = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st = conexion.prepareStatement(sql);
                                                                 st.setString(1, textField10.getText());
                                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st.executeUpdate();

                                                                 PreparedStatement st2;
                                                                 String sql2 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st2 = conexion.prepareStatement(sql2);
                                                                 st2.setString(1, textField12.getText());
                                                                 st2.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st2.executeUpdate();

                                                                 PreparedStatement st3;
                                                                 String sql3 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st3 = conexion.prepareStatement(sql3);
                                                                 st3.setString(1, textField13.getText());
                                                                 st3.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st3.executeUpdate();

                                                                 PreparedStatement st4;
                                                                 String sql4 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st4 = conexion.prepareStatement(sql4);
                                                                 st4.setString(1, textField14.getText());
                                                                 st4.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st4.executeUpdate();

                                                                 PreparedStatement st5;
                                                                 String sql5 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st5 = conexion.prepareStatement(sql5);
                                                                 st5.setString(1, textField28.getText());
                                                                 st5.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st5.executeUpdate();

                                                                 PreparedStatement st6;
                                                                 String sql6 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st6 = conexion.prepareStatement(sql6);
                                                                 st6.setString(1, textField29.getText());
                                                                 st6.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st6.executeUpdate();

                                                                 PreparedStatement st7;
                                                                 String sql7 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st7 = conexion.prepareStatement(sql7);
                                                                 st7.setString(1, textField30.getText());
                                                                 st7.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st7.executeUpdate();

                                                                 PreparedStatement st8;
                                                                 String sql8 = "insert into equipo(nombreequi,ordenInsertar,administradorodueño) values (?,seq.nextval,?)";
                                                                 st8 = conexion.prepareStatement(sql8);
                                                                 st8.setString(1, textField31.getText());
                                                                 st8.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                                 st8.executeUpdate();
                                                                 numEquipos.setText("8 OK!");

                                                                 dueñosEq1.setText(textField10.getText());
                                                                 dueñosEq2.setText(textField12.getText());
                                                                 dueñosEq3.setText(textField13.getText());
                                                                 dueñosEq4.setText(textField14.getText());
                                                                 dueñosEq5.setText(textField28.getText());
                                                                 dueñosEq6.setText(textField29.getText());
                                                                 dueñosEq7.setText(textField30.getText());
                                                                 dueñosEq8.setText(textField31.getText());

                                                             }


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

                                                         } catch (SQLException e1) {
                                                             e1.printStackTrace();
                                                         } catch (java.lang.NumberFormatException e1) {
                                                             //e1.printStackTrace();
                                                         }


                                                     }
                                                 });
    }

    /**
     * <p>Actualiza los nombres de los equipos ordenados por orden de insercion en la base de datos
     */

    private void refreshEquipos() throws SQLException, ClassNotFoundException {

        refreshButton.addMouseListener(new

                                               MouseAdapter() {
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
                                                           List<String> listaEquipos = new ArrayList<String>();
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

    /**
     * <p>Borra los equipos, los dueños, y los resultados de la base de datos
     */

    private void borrarEquipos() {

        borrarButton2.addMouseListener(new
                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);
                                                       numEquipos.setText("0");
                                                       numDueños.setText("0");

                                                       listaEquipos.clear();
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

                                                           sql = "delete from partido";
                                                           st = conexion.prepareStatement(sql);


                                                           st.executeUpdate();
                                                           textField15.setText("");
                                                           textField17.setText("");
                                                           textField18.setText("");
                                                           textField21.setText("");
                                                           textField19.setText("");
                                                           textField22.setText("");
                                                           textField20.setText("");
                                                           textField23.setText("");


                                                           sql = "alter trigger numJug disable";

                                                           Statement st5 = conexion.prepareStatement(sql);

                                                           st5 = conexion.prepareStatement(sql);

                                                           st5.execute(sql);


                                                           sql = "update jugador set CodigoEquiJug='0'";


                                                           st = conexion.prepareStatement(sql);

                                                           st.executeUpdate();

                                                           tjm.actualizarLista();
                                                           table1.revalidate();
                                                           table1.repaint();


                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();
                                                       } catch (java.lang.NumberFormatException e1) {
                                                           e1.printStackTrace();
                                                       } catch (ClassNotFoundException e1) {
                                                           e1.printStackTrace();
                                                       }

                                                   }
                                               });
    }

    /**
     * <p>Actualiza los nombres de los equipos uno por uno
     */

    private void actualizarEquipos() {


        ae1.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);

                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField10.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));
                                                 st.setString(3, listaEquipos.get(0));

                                                 st.executeUpdate();


                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField10.getText());
                                                 st.setString(2, textField7.getText());

                                                 st.executeUpdate();


                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField10.getText());
                                                 st.setString(2, listaEquipos.get(0));

                                                 st.executeUpdate();


                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField10.getText());
                                                 st.setString(2, listaEquipos.get(0));

                                                 st.executeUpdate();


                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField10.getText());
                                                 st3.setString(2, equipo1.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField10.getText());
                                                 st3.setString(2, equipo1.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 e1.printStackTrace();
                                             }
                                         }
                                     });
        ae2.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField12.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));
                                                 st.setString(3, listaEquipos.get(1));

                                                 st.executeUpdate();

                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField12.getText());
                                                 st.setString(2, d2.getText());

                                                 st.executeUpdate();

                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField12.getText());
                                                 st.setString(2, listaEquipos.get(1));

                                                 st.executeUpdate();


                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField12.getText());
                                                 st.setString(2, listaEquipos.get(1));

                                                 st.executeUpdate();


                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField12.getText());
                                                 st3.setString(2, equipo2.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField12.getText());
                                                 st3.setString(2, equipo2.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });
        ae3.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField13.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));
                                                 st.setString(3, listaEquipos.get(2));

                                                 st.executeUpdate();

                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField13.getText());
                                                 st.setString(2, d3.getText());

                                                 st.executeUpdate();

                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField13.getText());
                                                 st.setString(2, listaEquipos.get(2));

                                                 st.executeUpdate();


                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField13.getText());
                                                 st.setString(2, listaEquipos.get(2));

                                                 st.executeUpdate();


                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField13.getText());
                                                 st3.setString(2, equipo3.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField13.getText());
                                                 st3.setString(2, equipo3.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });
        ae4.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField14.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                 st.setString(3, listaEquipos.get(3));

                                                 st.executeUpdate();

                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField14.getText());
                                                 st.setString(2, d4.getText());

                                                 st.executeUpdate();

                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField14.getText());
                                                 st.setString(2, listaEquipos.get(3));

                                                 st.executeUpdate();


                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField14.getText());
                                                 st.setString(2, listaEquipos.get(3));

                                                 st.executeUpdate();


                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField14.getText());
                                                 st3.setString(2, equipo4.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField14.getText());
                                                 st3.setString(2, equipo4.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });
        ae5.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField28.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                 st.setString(3, listaEquipos.get(4));

                                                 st.executeUpdate();

                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField28.getText());
                                                 st.setString(2, d5.getText());

                                                 st.executeUpdate();

                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField28.getText());
                                                 st.setString(2, listaEquipos.get(4));

                                                 st.executeUpdate();

                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField28.getText());
                                                 st.setString(2, listaEquipos.get(4));

                                                 st.executeUpdate();


                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField28.getText());
                                                 st3.setString(2, equipo5.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField28.getText());
                                                 st3.setString(2, equipo5.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });
        ae6.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField29.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                 st.setString(3, listaEquipos.get(5));

                                                 st.executeUpdate();

                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField29.getText());
                                                 st.setString(2, d6.getText());

                                                 st.executeUpdate();

                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField29.getText());
                                                 st.setString(2, listaEquipos.get(5));

                                                 st.executeUpdate();

                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField29.getText());
                                                 st.setString(2, listaEquipos.get(5));

                                                 st.executeUpdate();

                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField29.getText());
                                                 st3.setString(2, equipo6.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField29.getText());
                                                 st3.setString(2, equipo6.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });
        ae7.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField30.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                 st.setString(3, listaEquipos.get(6));

                                                 st.executeUpdate();


                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField30.getText());
                                                 st.setString(2, d7.getText());

                                                 st.executeUpdate();

                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField30.getText());
                                                 st.setString(2, listaEquipos.get(6));

                                                 st.executeUpdate();


                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);
                                                 st.setString(1, textField30.getText());
                                                 st.setString(2, listaEquipos.get(6));

                                                 st.executeUpdate();


                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField30.getText());
                                                 st3.setString(2, equipo7.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField30.getText());
                                                 st3.setString(2, equipo7.getText());
                                                 st3.executeUpdate();


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

                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });
        ae8.addMouseListener(new
                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {

                                                 Connection conexion = Conexion.conexion;

                                                 PreparedStatement st;


                                                 String sql = "update equipo set nombreequi=?,administradorodueño=? where nombreequi=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField31.getText());
                                                 st.setString(2, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));

                                                 st.setString(3, listaEquipos.get(7));

                                                 st.executeUpdate();

                                                 sql = "update dueño set equidue=? where nombredue=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField31.getText());
                                                 st.setString(2, d8.getText());

                                                 st.executeUpdate();


                                                 sql = "update jugador set CodigoEquiJug=? where CodigoEquiJug=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField31.getText());
                                                 st.setString(2, listaEquipos.get(7));

                                                 st.executeUpdate();

                                                 sql = "update clasificacion2 set equipo=? where equipo=?";

                                                 st = conexion.prepareStatement(sql);

                                                 st.setString(1, textField31.getText());
                                                 st.setString(2, listaEquipos.get(7));

                                                 st.executeUpdate();

                                                 String sql3 = "update partido set nombreequiloc=? " +
                                                         " where nombreequiloc=?";
                                                 PreparedStatement st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField31.getText());
                                                 st3.setString(2, equipo8.getText());
                                                 st3.executeUpdate();
                                                 sql3 = "update partido set nombreequivis=? " +
                                                         " where nombreequivis=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setString(1, textField31.getText());
                                                 st3.setString(2, equipo8.getText());
                                                 st3.executeUpdate();


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


                                             } catch (SQLException e1) {
                                                 // e1.printStackTrace();
                                             } catch (java.lang.NumberFormatException e1) {
                                                 //e1.printStackTrace();
                                             }
                                         }
                                     });


    }

    /**
     * <p>Inserta 8 dueños(al mismo tiempo) en la base de datos
     */

    private void insertarDueños() {

        dueñosInsertar.addMouseListener(new

                                                MouseAdapter() {
                                                    @Override
                                                    public void mouseClicked(MouseEvent e) {
                                                        super.mouseClicked(e);


                                                        if (numDueños.getText().equals("0") &&
                                                                !textField7.getText().equals("") && //!textField8.getText().equals("") &&
                                                                !d2.getText().equals("") && //!p2.getText().equals("") &&
                                                                !d3.getText().equals("") && //!p3.getText().equals("") &&
                                                                !d4.getText().equals("") && //!p4.getText().equals("") &&
                                                                !d5.getText().equals("") && //!p5.getText().equals("") &&
                                                                !d6.getText().equals("") && //!p6.getText().equals("") &&
                                                                !d7.getText().equals("") && //!p7.getText().equals("") &&
                                                                !d8.getText().equals("")) { //&& !p8.getText().equals("")) {

                                                            try {

                                                                Connection conexion = Conexion.conexion;
                                                                PreparedStatement st;
                                                                String sql = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st = conexion.prepareStatement(sql);
                                                                st.setString(1, textField7.getText());
                                                                st.setString(2, textField7.getText());
                                                                st.setString(3, dueñosEq1.getText());

                                                                st.executeUpdate();

                                                                PreparedStatement st2;
                                                                String sql2 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st2 = conexion.prepareStatement(sql2);
                                                                st2.setString(1, d2.getText());
                                                                st2.setString(2, d2.getText());
                                                                st2.setString(3, dueñosEq2.getText());

                                                                st2.executeUpdate();

                                                                PreparedStatement st3;
                                                                String sql3 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st3 = conexion.prepareStatement(sql3);
                                                                st3.setString(1, d3.getText());
                                                                st3.setString(2, d3.getText());
                                                                st3.setString(3, dueñosEq3.getText());
                                                                st3.executeUpdate();

                                                                PreparedStatement st4;
                                                                String sql4 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st4 = conexion.prepareStatement(sql4);
                                                                st4.setString(1, d4.getText());
                                                                st4.setString(2, d4.getText());
                                                                st4.setString(3, dueñosEq4.getText());
                                                                st4.executeUpdate();

                                                                PreparedStatement st5;
                                                                String sql5 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st5 = conexion.prepareStatement(sql5);
                                                                st5.setString(1, d5.getText());
                                                                st5.setString(2, d5.getText());
                                                                st5.setString(3, dueñosEq5.getText());
                                                                st5.executeUpdate();

                                                                PreparedStatement st6;
                                                                String sql6 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st6 = conexion.prepareStatement(sql6);
                                                                st6.setString(1, d6.getText());
                                                                st6.setString(2, d6.getText());
                                                                st6.setString(3, dueñosEq6.getText());
                                                                st6.executeUpdate();

                                                                PreparedStatement st7;
                                                                String sql7 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st7 = conexion.prepareStatement(sql7);
                                                                st7.setString(1, d7.getText());
                                                                st7.setString(2, d7.getText());
                                                                st7.setString(3, dueñosEq7.getText());
                                                                st7.executeUpdate();

                                                                PreparedStatement st8;
                                                                String sql8 = "insert into dueño(nombredue,passworddue,equidue,ordenInsertar) values (?,?,?,seq2.nextval)";
                                                                st8 = conexion.prepareStatement(sql8);
                                                                st8.setString(1, d8.getText());
                                                                st8.setString(2, d8.getText());
                                                                st8.setString(3, dueñosEq8.getText());
                                                                st8.executeUpdate();
                                                                numDueños.setText("8 OK!");

                                                            } catch (SQLException e1) {
                                                                //  e1.printStackTrace();
                                                            } catch (java.lang.NumberFormatException e1) {
                                                                //e1.printStackTrace();
                                                            }
                                                        }


                                                    }
                                                });
    }

    /**
     * <p>Actualiza los nombres de los dueños ordenados por orden de insercion en la base de datos
     */

    private void refreshDueños() {

        dueñosRefresh.addMouseListener(new

                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);


                                                       dueñosEq1.setText("");
                                                       dueñosEq2.setText("");
                                                       dueñosEq3.setText("");
                                                       dueñosEq4.setText("");
                                                       dueñosEq5.setText("");
                                                       dueñosEq6.setText("");
                                                       dueñosEq7.setText("");
                                                       dueñosEq8.setText("");

                                                       textField7.setText("");
                                                       d2.setText("");
                                                       d3.setText("");
                                                       d4.setText("");
                                                       d5.setText("");
                                                       d6.setText("");
                                                       d7.setText("");
                                                       d8.setText("");


                                                       Connection conexion = Conexion.conexion;


                                                       String sql2 = "{call calendario.verEquipos(?)}";

                                                       CallableStatement callableStatement2 = null;
                                                       try {
                                                           callableStatement2 = conexion.prepareCall(sql2);


                                                           callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

                                                           callableStatement2.executeUpdate();
                                                           ResultSet rs = (ResultSet) callableStatement2.getObject(1);
                                                           List<String> listaEquipos = new ArrayList<String>();
                                                           while (rs.next()) {
                                                               String nombreequi = rs.getString("nombreequi");

                                                               listaEquipos.add(nombreequi);


                                                           }

                                                           dueñosEq1.setText(listaEquipos.get(0));
                                                           dueñosEq2.setText(listaEquipos.get(1));
                                                           dueñosEq3.setText(listaEquipos.get(2));
                                                           dueñosEq4.setText(listaEquipos.get(3));
                                                           dueñosEq5.setText(listaEquipos.get(4));
                                                           dueñosEq6.setText(listaEquipos.get(5));
                                                           dueñosEq7.setText(listaEquipos.get(6));
                                                           dueñosEq8.setText(listaEquipos.get(7));


                                                           sql2 = "{call calendario.verDueños(?)}";


                                                           callableStatement2 = conexion.prepareCall(sql2);


                                                           callableStatement2.registerOutParameter(1, OracleTypes.CURSOR);

                                                           callableStatement2.executeUpdate();
                                                           rs = (ResultSet) callableStatement2.getObject(1);
                                                           List<String> listaDueños = new ArrayList<String>();
                                                           while (rs.next()) {
                                                               String nombreDue = rs.getString("nombreDue");
                                                               String passwordDue = rs.getString("passwordDue");

                                                               listaDueños.add(nombreDue);
                                                               listaDueños.add(passwordDue);


                                                           }

                                                           textField7.setText(listaDueños.get(0));
                                                           //  textField8.setText(listaDueños.get(1));
                                                           d2.setText(listaDueños.get(2));
                                                           //   p2.setText(listaDueños.get(3));
                                                           d3.setText(listaDueños.get(4));
                                                           //    p3.setText(listaDueños.get(5));
                                                           d4.setText(listaDueños.get(6));
                                                           //   p4.setText(listaDueños.get(7));
                                                           d5.setText(listaDueños.get(8));
                                                           //    p5.setText(listaDueños.get(9));
                                                           d6.setText(listaDueños.get(10));
                                                           //   p6.setText(listaDueños.get(11));
                                                           d7.setText(listaDueños.get(12));
                                                           //    p7.setText(listaDueños.get(13));
                                                           d8.setText(listaDueños.get(14));
                                                           //    p8.setText(listaDueños.get(15));

                                                           listaDueños.clear();

                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();
                                                       } catch (java.lang.IndexOutOfBoundsException e1) {
                                                       }


                                                   }
                                               });
    }

    /**
     * <p>Borra los los dueños de la base de datos
     */

    private void borrarDueños() {


        dueñosBorrar.addMouseListener(new

                                              MouseAdapter() {
                                                  @Override
                                                  public void mouseClicked(MouseEvent e) {
                                                      super.mouseClicked(e);

                                                      numDueños.setText("0");
                                                      try {

                                                          Connection conexion = Conexion.conexion;

                                                          PreparedStatement st;


                                                          String sql = "delete from dueño";
                                                          st = conexion.prepareStatement(sql);


                                                          st.executeUpdate();
                                                          textField7.setText("");
                                                          //   textField8.setText("");
                                                          d2.setText("");
                                                          //  p2.setText("");
                                                          d3.setText("");
                                                          //   p3.setText("");
                                                          d4.setText("");
                                                          //   p4.setText("");
                                                          d5.setText("");
                                                          //  p5.setText("");
                                                          d6.setText("");
                                                          //  p6.setText("");
                                                          d7.setText("");
                                                          //  p7.setText("");
                                                          d8.setText("");
                                                          //   p8.setText("");


                                                      } catch (SQLException e1) {
                                                          // e1.printStackTrace();
                                                      } catch (java.lang.NumberFormatException e1) {
                                                          //e1.printStackTrace();
                                                      }
                                                  }
                                              });
    }

    /**
     * <p>Borra los los dueños de la base de datos uno por uno
     */

    private void actualizarDueños() {

        a1.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);

                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, textField7.getText());
                                                st.setString(2, textField7.getText());
                                                st.setString(3, dueñosEq1.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a2.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d2.getText());
                                                st.setString(2, d2.getText());
                                                st.setString(3, dueñosEq2.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a3.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d3.getText());
                                                st.setString(2, d3.getText());
                                                st.setString(3, dueñosEq3.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a4.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d4.getText());
                                                st.setString(2, d4.getText());
                                                st.setString(3, dueñosEq4.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a5.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d5.getText());
                                                st.setString(2, d5.getText());
                                                st.setString(3, dueñosEq5.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a6.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d6.getText());
                                                st.setString(2, d6.getText());
                                                st.setString(3, dueñosEq6.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a7.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d7.getText());
                                                st.setString(2, d7.getText());
                                                st.setString(3, dueñosEq7.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });
        a8.addMouseListener(new

                                    MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            super.mouseClicked(e);
                                            try {

                                                Connection conexion = Conexion.conexion;

                                                PreparedStatement st;


                                                String sql = "update dueño set nombredue=?,passworddue=? where equidue=?";

                                                st = conexion.prepareStatement(sql);

                                                st.setString(1, d8.getText());
                                                st.setString(2, d8.getText());
                                                st.setString(3, dueñosEq8.getText());

                                                st.executeUpdate();


                                            } catch (SQLException e1) {
                                                // e1.printStackTrace();
                                            } catch (java.lang.NumberFormatException e1) {
                                                //e1.printStackTrace();
                                            }
                                        }
                                    });


    }

    /**
     * <p>Inserta los 4 resultados(al mismo tiempo) en la base de batos
     */

    private void insertarResultados() {


        actualizarResultadoFechaButton.addMouseListener(new

                                                                MouseAdapter() {
                                                                    @Override
                                                                    public void mouseClicked(MouseEvent e) {
                                                                        super.mouseClicked(e);

                                                                        if (!textField15.getText().equals("") && !textField17.getText().equals("") && !textField24.getText().equals("") &&
                                                                                !textField18.getText().equals("") && !textField21.getText().equals("") && !textField25.getText().equals("") &&
                                                                                !textField19.getText().equals("") && !textField22.getText().equals("") && !textField26.getText().equals("") &&
                                                                                !textField20.getText().equals("") && !textField23.getText().equals("") && !textField27.getText().equals("")) {
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

                                                                                int ganados = 0;
                                                                                int empatados = 0;
                                                                                int perdidos = 0;
                                                                                int puntos = 0;
                                                                                if (Integer.parseInt(textField15.getText()) > Integer.parseInt(textField17.getText())) {
                                                                                    ganados = 1;
                                                                                    puntos = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField15.getText()) == Integer.parseInt(textField17.getText())) {
                                                                                    empatados = 1;
                                                                                    puntos = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField15.getText()) < Integer.parseInt(textField17.getText())) {
                                                                                    perdidos = 1;
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
                                                                                int ganados2 = 0;
                                                                                int empatados2 = 0;
                                                                                int perdidos2 = 0;
                                                                                int puntos2 = 0;
                                                                                if (Integer.parseInt(textField17.getText()) > Integer.parseInt(textField15.getText())) {
                                                                                    ganados2 = 1;
                                                                                    puntos2 = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField17.getText()) == Integer.parseInt(textField15.getText())) {
                                                                                    empatados2 = 1;
                                                                                    puntos2 = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField17.getText()) < Integer.parseInt(textField15.getText())) {
                                                                                    perdidos2 = 1;
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


                                                                                sql = "insert into partido values (?,?,?,?,?,?)";
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

                                                                                ganados = 0;
                                                                                empatados = 0;
                                                                                perdidos = 0;
                                                                                puntos = 0;
                                                                                if (Integer.parseInt(textField18.getText()) > Integer.parseInt(textField21.getText())) {
                                                                                    ganados = 1;
                                                                                    puntos = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField18.getText()) == Integer.parseInt(textField21.getText())) {
                                                                                    empatados = 1;
                                                                                    puntos = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField18.getText()) < Integer.parseInt(textField21.getText())) {
                                                                                    perdidos = 1;
                                                                                }
                                                                                sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                                                                                st2 = conexion.prepareStatement(sql2);
                                                                                st2.setString(1, equipo3.getText());
                                                                                st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                                                st2.setInt(3, puntos);
                                                                                st2.setInt(4, ganados);
                                                                                st2.setInt(5, empatados);
                                                                                st2.setInt(6, perdidos);
                                                                                st2.executeUpdate();
                                                                                ganados2 = 0;
                                                                                empatados2 = 0;
                                                                                perdidos2 = 0;
                                                                                puntos2 = 0;
                                                                                if (Integer.parseInt(textField21.getText()) > Integer.parseInt(textField18.getText())) {
                                                                                    ganados2 = 1;
                                                                                    puntos2 = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField21.getText()) == Integer.parseInt(textField18.getText())) {
                                                                                    empatados2 = 1;
                                                                                    puntos2 = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField21.getText()) < Integer.parseInt(textField18.getText())) {
                                                                                    perdidos2 = 1;
                                                                                }
                                                                                sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                                                                                st3 = conexion.prepareStatement(sql3);
                                                                                st3.setString(1, equipo4.getText());
                                                                                st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                                                st3.setInt(3, puntos2);
                                                                                st3.setInt(4, ganados2);
                                                                                st3.setInt(5, empatados2);
                                                                                st3.setInt(6, perdidos2);
                                                                                st3.executeUpdate();


                                                                                sql = "insert into partido values (?,?,?,?,?,?)";
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

                                                                                ganados = 0;
                                                                                empatados = 0;
                                                                                perdidos = 0;
                                                                                puntos = 0;
                                                                                if (Integer.parseInt(textField19.getText()) > Integer.parseInt(textField22.getText())) {
                                                                                    ganados = 1;
                                                                                    puntos = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField19.getText()) == Integer.parseInt(textField22.getText())) {
                                                                                    empatados = 1;
                                                                                    puntos = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField19.getText()) < Integer.parseInt(textField22.getText())) {
                                                                                    perdidos = 1;
                                                                                }
                                                                                sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                                                                                st2 = conexion.prepareStatement(sql2);
                                                                                st2.setString(1, equipo5.getText());
                                                                                st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                                                st2.setInt(3, puntos);
                                                                                st2.setInt(4, ganados);
                                                                                st2.setInt(5, empatados);
                                                                                st2.setInt(6, perdidos);
                                                                                st2.executeUpdate();
                                                                                ganados2 = 0;
                                                                                empatados2 = 0;
                                                                                perdidos2 = 0;
                                                                                puntos2 = 0;
                                                                                if (Integer.parseInt(textField22.getText()) > Integer.parseInt(textField19.getText())) {
                                                                                    ganados2 = 1;
                                                                                    puntos2 = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField22.getText()) == Integer.parseInt(textField19.getText())) {
                                                                                    empatados2 = 1;
                                                                                    puntos2 = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField22.getText()) < Integer.parseInt(textField19.getText())) {
                                                                                    perdidos2 = 1;
                                                                                }
                                                                                sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                                                                                st3 = conexion.prepareStatement(sql3);
                                                                                st3.setString(1, equipo6.getText());
                                                                                st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                                                st3.setInt(3, puntos2);
                                                                                st3.setInt(4, ganados2);
                                                                                st3.setInt(5, empatados2);
                                                                                st3.setInt(6, perdidos2);
                                                                                st3.executeUpdate();


                                                                                sql = "insert into partido values (?,?,?,?,?,?)";
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

                                                                                ganados = 0;
                                                                                empatados = 0;
                                                                                perdidos = 0;
                                                                                puntos = 0;
                                                                                if (Integer.parseInt(textField20.getText()) > Integer.parseInt(textField23.getText())) {
                                                                                    ganados = 1;
                                                                                    puntos = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField20.getText()) == Integer.parseInt(textField23.getText())) {
                                                                                    empatados = 1;
                                                                                    puntos = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField20.getText()) < Integer.parseInt(textField23.getText())) {
                                                                                    perdidos = 1;
                                                                                }
                                                                                sql2 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                                                                                st2 = conexion.prepareStatement(sql2);
                                                                                st2.setString(1, equipo7.getText());
                                                                                st2.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                                                st2.setInt(3, puntos);
                                                                                st2.setInt(4, ganados);
                                                                                st2.setInt(5, empatados);
                                                                                st2.setInt(6, perdidos);
                                                                                st2.executeUpdate();
                                                                                ganados2 = 0;
                                                                                empatados2 = 0;
                                                                                perdidos2 = 0;
                                                                                puntos2 = 0;
                                                                                if (Integer.parseInt(textField23.getText()) > Integer.parseInt(textField20.getText())) {
                                                                                    ganados2 = 1;
                                                                                    puntos2 = 3;
                                                                                }
                                                                                if (Integer.parseInt(textField23.getText()) == Integer.parseInt(textField20.getText())) {
                                                                                    empatados2 = 1;
                                                                                    puntos2 = 1;
                                                                                }
                                                                                if (Integer.parseInt(textField23.getText()) < Integer.parseInt(textField20.getText())) {
                                                                                    perdidos2 = 1;
                                                                                }
                                                                                sql3 = "insert into clasificacion2 values (?,?,?,?,?,?)";
                                                                                st3 = conexion.prepareStatement(sql3);
                                                                                st3.setString(1, equipo8.getText());
                                                                                st3.setInt(2, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                                                st3.setInt(3, puntos2);
                                                                                st3.setInt(4, ganados2);
                                                                                st3.setInt(5, empatados2);
                                                                                st3.setInt(6, perdidos2);
                                                                                st3.executeUpdate();


                                                                            } catch (SQLException e1) {
                                                                                // e1.printStackTrace();
                                                                            } catch (java.lang.NumberFormatException e1) {
                                                                                // e1.printStackTrace();
                                                                            }
                                                                        }
                                                                    }
                                                                });

    }

    /**
     * <p>Actualiza los resultados uno por uno
     */

    private void actualizarResultados() {


        ar1.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);
                                             try {
                                                 PreparedStatement st;
                                                 String sql = "update partido set fecha=?,jornada=?,resultado1=?,resultado2=? where " +
                                                         "nombreequiloc=? and nombreequivis=?";
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

                                                 int ganados = 0;
                                                 int empatados = 0;
                                                 int perdidos = 0;
                                                 int puntos = 0;
                                                 if (Integer.parseInt(textField15.getText()) > Integer.parseInt(textField17.getText())) {
                                                     ganados = 1;
                                                     puntos = 3;
                                                 }
                                                 if (Integer.parseInt(textField15.getText()) == Integer.parseInt(textField17.getText())) {
                                                     empatados = 1;
                                                     puntos = 1;
                                                 }
                                                 if (Integer.parseInt(textField15.getText()) < Integer.parseInt(textField17.getText())) {
                                                     perdidos = 1;
                                                 }
                                                 PreparedStatement st2;

                                                 String sql2 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st2 = conexion.prepareStatement(sql2);

                                                 st2.setInt(1, puntos);
                                                 st2.setInt(2, ganados);
                                                 st2.setInt(3, empatados);
                                                 st2.setInt(4, perdidos);
                                                 st2.setString(5, equipo1.getText());
                                                 st2.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st2.executeUpdate();


                                                 int ganados2 = 0;
                                                 int empatados2 = 0;
                                                 int perdidos2 = 0;
                                                 int puntos2 = 0;
                                                 if (Integer.parseInt(textField17.getText()) > Integer.parseInt(textField15.getText())) {
                                                     ganados2 = 1;
                                                     puntos2 = 3;
                                                 }
                                                 if (Integer.parseInt(textField17.getText()) == Integer.parseInt(textField15.getText())) {
                                                     empatados2 = 1;
                                                     puntos2 = 1;
                                                 }
                                                 if (Integer.parseInt(textField17.getText()) < Integer.parseInt(textField15.getText())) {
                                                     perdidos2 = 1;
                                                 }
                                                 PreparedStatement st3;

                                                 String sql3 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setInt(1, puntos2);
                                                 st3.setInt(2, ganados2);
                                                 st3.setInt(3, empatados2);
                                                 st3.setInt(4, perdidos2);
                                                 st3.setString(5, equipo2.getText());
                                                 st3.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st3.executeUpdate();


                                             } catch (SQLException e1) {
                                                 e1.printStackTrace();
                                             }
                                         }
                                     });
        ar2.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);

                                             try {
                                                 PreparedStatement st;
                                                 String sql = "update partido set fecha=?,jornada=?,resultado1=?,resultado2=? where " +
                                                         "nombreequiloc=? and nombreequivis=?";
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

                                                 int ganados = 0;
                                                 int empatados = 0;
                                                 int perdidos = 0;
                                                 int puntos = 0;
                                                 if (Integer.parseInt(textField18.getText()) > Integer.parseInt(textField21.getText())) {
                                                     ganados = 1;
                                                     puntos = 3;
                                                 }
                                                 if (Integer.parseInt(textField18.getText()) == Integer.parseInt(textField21.getText())) {
                                                     empatados = 1;
                                                     puntos = 1;
                                                 }
                                                 if (Integer.parseInt(textField18.getText()) < Integer.parseInt(textField21.getText())) {
                                                     perdidos = 1;
                                                 }
                                                 PreparedStatement st2;

                                                 String sql2 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st2 = conexion.prepareStatement(sql2);

                                                 st2.setInt(1, puntos);
                                                 st2.setInt(2, ganados);
                                                 st2.setInt(3, empatados);
                                                 st2.setInt(4, perdidos);
                                                 st2.setString(5, equipo3.getText());
                                                 st2.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st2.executeUpdate();


                                                 int ganados2 = 0;
                                                 int empatados2 = 0;
                                                 int perdidos2 = 0;
                                                 int puntos2 = 0;
                                                 if (Integer.parseInt(textField21.getText()) > Integer.parseInt(textField18.getText())) {
                                                     ganados2 = 1;
                                                     puntos2 = 3;
                                                 }
                                                 if (Integer.parseInt(textField21.getText()) == Integer.parseInt(textField18.getText())) {
                                                     empatados2 = 1;
                                                     puntos2 = 1;
                                                 }
                                                 if (Integer.parseInt(textField21.getText()) < Integer.parseInt(textField18.getText())) {
                                                     perdidos2 = 1;
                                                 }
                                                 PreparedStatement st3;

                                                 String sql3 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setInt(1, puntos2);
                                                 st3.setInt(2, ganados2);
                                                 st3.setInt(3, empatados2);
                                                 st3.setInt(4, perdidos2);
                                                 st3.setString(5, equipo4.getText());
                                                 st3.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st3.executeUpdate();

                                             } catch (SQLException e1) {
                                                 e1.printStackTrace();
                                             }
                                         }
                                     });
        ar3.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);

                                             try {
                                                 PreparedStatement st;
                                                 String sql = "update partido set fecha=?,jornada=?,resultado1=?,resultado2=? where " +
                                                         "nombreequiloc=? and nombreequivis=?";
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

                                                 int ganados = 0;
                                                 int empatados = 0;
                                                 int perdidos = 0;
                                                 int puntos = 0;
                                                 if (Integer.parseInt(textField19.getText()) > Integer.parseInt(textField22.getText())) {
                                                     ganados = 1;
                                                     puntos = 3;
                                                 }
                                                 if (Integer.parseInt(textField19.getText()) == Integer.parseInt(textField22.getText())) {
                                                     empatados = 1;
                                                     puntos = 1;
                                                 }
                                                 if (Integer.parseInt(textField19.getText()) < Integer.parseInt(textField22.getText())) {
                                                     perdidos = 1;
                                                 }
                                                 PreparedStatement st2;

                                                 String sql2 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st2 = conexion.prepareStatement(sql2);

                                                 st2.setInt(1, puntos);
                                                 st2.setInt(2, ganados);
                                                 st2.setInt(3, empatados);
                                                 st2.setInt(4, perdidos);
                                                 st2.setString(5, equipo5.getText());
                                                 st2.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st2.executeUpdate();


                                                 int ganados2 = 0;
                                                 int empatados2 = 0;
                                                 int perdidos2 = 0;
                                                 int puntos2 = 0;
                                                 if (Integer.parseInt(textField22.getText()) > Integer.parseInt(textField19.getText())) {
                                                     ganados2 = 1;
                                                     puntos2 = 3;
                                                 }
                                                 if (Integer.parseInt(textField22.getText()) == Integer.parseInt(textField19.getText())) {
                                                     empatados2 = 1;
                                                     puntos2 = 1;
                                                 }
                                                 if (Integer.parseInt(textField22.getText()) < Integer.parseInt(textField19.getText())) {
                                                     perdidos2 = 1;
                                                 }
                                                 PreparedStatement st3;

                                                 String sql3 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setInt(1, puntos2);
                                                 st3.setInt(2, ganados2);
                                                 st3.setInt(3, empatados2);
                                                 st3.setInt(4, perdidos2);
                                                 st3.setString(5, equipo6.getText());
                                                 st3.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st3.executeUpdate();

                                             } catch (SQLException e1) {
                                                 e1.printStackTrace();
                                             }
                                         }
                                     });
        ar4.addMouseListener(new

                                     MouseAdapter() {
                                         @Override
                                         public void mouseClicked(MouseEvent e) {
                                             super.mouseClicked(e);

                                             try {
                                                 PreparedStatement st;
                                                 String sql = "update partido set fecha=?,jornada=?,resultado1=?,resultado2=? where " +
                                                         "nombreequiloc=? and nombreequivis=?";
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

                                                 int ganados = 0;
                                                 int empatados = 0;
                                                 int perdidos = 0;
                                                 int puntos = 0;
                                                 if (Integer.parseInt(textField20.getText()) > Integer.parseInt(textField23.getText())) {
                                                     ganados = 1;
                                                     puntos = 3;
                                                 }
                                                 if (Integer.parseInt(textField20.getText()) == Integer.parseInt(textField23.getText())) {
                                                     empatados = 1;
                                                     puntos = 1;
                                                 }
                                                 if (Integer.parseInt(textField20.getText()) < Integer.parseInt(textField23.getText())) {
                                                     perdidos = 1;
                                                 }
                                                 PreparedStatement st2;

                                                 String sql2 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st2 = conexion.prepareStatement(sql2);

                                                 st2.setInt(1, puntos);
                                                 st2.setInt(2, ganados);
                                                 st2.setInt(3, empatados);
                                                 st2.setInt(4, perdidos);
                                                 st2.setString(5, equipo7.getText());
                                                 st2.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st2.executeUpdate();


                                                 int ganados2 = 0;
                                                 int empatados2 = 0;
                                                 int perdidos2 = 0;
                                                 int puntos2 = 0;
                                                 if (Integer.parseInt(textField23.getText()) > Integer.parseInt(textField20.getText())) {
                                                     ganados2 = 1;
                                                     puntos2 = 3;
                                                 }
                                                 if (Integer.parseInt(textField23.getText()) == Integer.parseInt(textField20.getText())) {
                                                     empatados2 = 1;
                                                     puntos2 = 1;
                                                 }
                                                 if (Integer.parseInt(textField23.getText()) < Integer.parseInt(textField20.getText())) {
                                                     perdidos2 = 1;
                                                 }
                                                 PreparedStatement st3;

                                                 String sql3 = "update clasificacion2 set puntos=?,ganados=?,empatados=?," +
                                                         "perdidos=? where equipo=? and jornada=?";
                                                 st3 = conexion.prepareStatement(sql3);

                                                 st3.setInt(1, puntos2);
                                                 st3.setInt(2, ganados2);
                                                 st3.setInt(3, empatados2);
                                                 st3.setInt(4, perdidos2);
                                                 st3.setString(5, equipo8.getText());
                                                 st3.setInt(6, Integer.parseInt(dcm.getSelectedItem().toString()));
                                                 st3.executeUpdate();

                                             } catch (SQLException e1) {
                                                 e1.printStackTrace();
                                             }
                                         }
                                     });


    }

    /**
     * <p>Borra todos los resultados
     */

    private void borrarResultados() {


        borrarTodoButton.addMouseListener(new

                                                  MouseAdapter() {
                                                      @Override
                                                      public void mouseClicked(MouseEvent e) {
                                                          super.mouseClicked(e);

                                                          try {


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
                                                          } catch (java.lang.NumberFormatException e1) {
                                                              //e1.printStackTrace();
                                                          }
                                                      }
                                                  });


    }

    /**
     * <p>Inserta un jugador en la base de batos
     */

    private void insertarJugador() {

        insertarButton.addMouseListener(new

                                                MouseAdapter() {
                                                    @Override
                                                    public void mouseClicked(MouseEvent e) {
                                                        super.mouseClicked(e);


                                                        try {


                                                            PreparedStatement st;


                                                            String sql = "insert into jugador(nombrejug,nick,sueldo,dnijug,caracteristicas,codigoequijug) values (?,?,?,?,?,?)";
                                                            st = conexion.prepareStatement(sql);
                                                            st.setString(1, textField1.getText());
                                                            st.setString(2, textField2.getText());
                                                            st.setInt(3, Integer.parseInt(textField3.getText()));

                                                            st.setString(4, textField4.getText());
                                                            st.setString(5, textField5.getText());
                                                            st.setString(6, "0");

                                                            st.executeUpdate();

                                                            tjm.actualizarLista();
                                                            table1.revalidate();
                                                            table1.repaint();


                                                        } catch (SQLException e1) {
                                                            // e1.printStackTrace();
                                                        } catch (ClassNotFoundException e1) {
                                                            // e1.printStackTrace();
                                                        } catch (java.lang.NumberFormatException e1) {
                                                            //  e1.printStackTrace();
                                                        }


                                                    }
                                                });
    }

    /**
     * <p>Actualiza los datos del jugaodor seleccionado
     */

    private void actualizarJugador() {


        actualizarButton.addMouseListener(new

                                                  MouseAdapter() {
                                                      @Override
                                                      public void mouseClicked(MouseEvent e) {
                                                          super.mouseClicked(e);


                                                          try {

                                                              String sql = "update jugador set nombrejug=?, nick=?, sueldo=?, dnijug=?," +
                                                                      "caracteristicas=? where dnijug='" + tjm.getValueAt(table1.getSelectedRow(), 3).toString() + "'";


                                                              PreparedStatement st = conexion.prepareStatement(sql);

                                                              st = conexion.prepareStatement(sql);
                                                              st.setString(1, textField1.getText());
                                                              st.setString(2, textField2.getText());
                                                              st.setInt(3, Integer.parseInt(textField3.getText()));

                                                              st.setString(4, textField4.getText());
                                                              st.setString(5, textField5.getText());


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


    }

    /**
     * <p>Borra los datos del jugador seleccionado
     */

    private void borrarJugador() {
        borrarButton.addMouseListener(new

                                              MouseAdapter() {
                                                  @Override
                                                  public void mouseClicked(MouseEvent e) {
                                                      super.mouseClicked(e);

                                                      try {


                                                          PreparedStatement st;


                                                          String sql = "delete from jugador where dnijug=?";
                                                          st = conexion.prepareStatement(sql);
                                                          st.setString(1, tjm.getValueAt(table1.getSelectedRow(), 3).toString());


                                                          st.executeUpdate();

                                                          tjm.actualizarLista();
                                                          table1.revalidate();
                                                          table1.repaint();


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

    }

    /**
     * <p>Borra los datos del usuario seleccionado
     */

    private void borrarUsuario() {

        borrarButton3.addMouseListener(new

                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);


                                                       try {

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
    }

    /**
     * <p>Cambia el usuario y la contraseña del administrador connectado
     */

    private void cambiarPassword() {


        cambiarButton.addMouseListener(new

                                               MouseAdapter() {
                                                   @Override
                                                   public void mouseClicked(MouseEvent e) {
                                                       super.mouseClicked(e);


                                                       if (textField11.getText().equals(textField16.getText()) &&
                                                               new String(passwordField1.getPassword()).equals(new String(passwordField2.getPassword()))) {

                                                           try {
                                                               PreparedStatement st;
                                                               String sql = "update administradores set usuario=?,password2=? where " +
                                                                       "usuario=?";
                                                               st = conexion.prepareStatement(sql);

                                                               st.setString(1, textField11.getText());
                                                               st.setString(2, new String(passwordField1.getPassword()));
                                                               st.setString(3, Inicio.getLogin().getUsuarios().get(Inicio.getLogin().getAd() - 1));


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


    /**
     * Sets administrador.
     *
     * @param administrador the administrador
     */
    public void setAdministrador(int administrador) {
        this.administrador = administrador;
    }


}


