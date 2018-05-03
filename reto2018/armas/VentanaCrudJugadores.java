package jose.armas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentanaCrudJugadores {
    private JPanel contenedorPrincipal;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JTextField textFieldNombre;
    private JTextField textFieldNick;
    private JTextField textFieldSueldo;
    private JTextField textFieldDni;
    private JTextField textFieldCaracteristicas;
    private JTextField textFieldCodigoEquipo;
    private JLabel nombre;
    private JLabel nick;
    private JLabel sueldo;
    private JLabel dni;
    private JLabel características;
    private JLabel codigoequipojugador;
    private JButton volverAlMenu;
    private JPanel contenedorScrollPane;
    private JPanel contenedorBotonesCrud;
    private JScrollPane scrollPane;
    private JTextField textFieldBuscar;
    private JPanel contenedorLupa;
    private JButton buscarButton;
    private JList listJugadores;
    private JButton verJugadorButton;
    private JButton limpiarButton;

    //Conexiones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;
    private JugadoresBD jugadoresBD;


    //Control de datos modelo.
    DefaultListModel<Jugador> jugadoresModel= new DefaultListModel<>();

    //Control de los objetos en una lista de jugadores.



    /**
     * @method controlDeInserccionesTextFields para el control de los textFields.
     * @param playersModel para el manejo de los datos de la lista.
     */
    private void controlDeInserccionesTextFields(DefaultListModel<Jugador>playersModel) throws SQLException {



        int seleccion = listJugadores.getSelectedIndex();
        Jugador jugadorArellenar = playersModel.getElementAt(seleccion);



        System.out.println(jugadorArellenar.getNombreJugador());

        textFieldNombre.setText(jugadorArellenar.getNombreJugador());
        textFieldDni.setText(jugadorArellenar.getDniJugador());
        textFieldNick.setText(jugadorArellenar.getNickJugador());
        textFieldCodigoEquipo.setText(jugadorArellenar.getCodigoEquipoJugador());
        textFieldCaracteristicas.setText(jugadorArellenar.getCaracteristicasJugador());
        int s= jugadorArellenar.getSueldoJugador();
        String  sueldo = ""+s;
        textFieldSueldo.setText(sueldo);
    }


    //Función propia que controla los datos del modeloLista para que aparezcan en el Jlist.
    private void modeloLista(DefaultListModel<Jugador> parametroListModel) throws SQLException {

        List<Jugador> jugadoresList = JugadoresBD.ListarJugadores();

        for (Jugador j:jugadoresList) {
            parametroListModel.addElement(j);
        }

        listJugadores.setModel(parametroListModel);
    }

    public VentanaCrudJugadores(VentanaMenuAdministrador vMad) {

        ventanaMenuAdministrador = vMad;

        JFrame frame = new JFrame("VentanaCrudJugadores");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        try {
            if(jugadoresModel.getSize()==0){
                modeloLista(jugadoresModel);
            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }




        verJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    controlDeInserccionesTextFields(jugadoresModel);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

        volverAlMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTexfields();
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(JugadorDaoImpl.registrar(extraerDatosTexfields())==true){
                    JOptionPane.showMessageDialog(contenedorPrincipal,"Jugador creado correctamente");
                    limpiarTexfields();
                    try {
                        DefaultListModel<Jugador>modelo = new DefaultListModel<>();
                        modeloLista(modelo);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(contenedorPrincipal,"El jugador ya existe");
                }

                limpiarTexfields();


            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(JugadorDaoImpl.actualizar(extraerDatosTexfields())==true){
                    JOptionPane.showMessageDialog(contenedorPrincipal,"Jugador actualizado correctamente");
                    limpiarTexfields();
                    try {
                        DefaultListModel<Jugador>modelo = new DefaultListModel<>();
                        modeloLista(modelo);

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(contenedorPrincipal,"el jugador no ha sido actualizado");
                }

            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(JugadorDaoImpl.borrarJugador(extraerDatosTexfields())==true){
                    JOptionPane.showMessageDialog(contenedorPrincipal,"Jugador eliminado correctamente");
                    limpiarTexfields();
                    try {
                        DefaultListModel<Jugador>modelo = new DefaultListModel<>();
                        modeloLista(modelo);

                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(contenedorPrincipal,"el jugador no ha sido eliminado");
                }

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    List<Jugador>jugadores = JugadoresBD.ListarJugadores();
                    List<Jugador>jugadoresAmostrar = new ArrayList<>();
                    DefaultListModel<Jugador>modelo = new DefaultListModel<>();

                    String dato = textFieldBuscar.getText();

                    for (Jugador j:jugadores) {
                        if(dato.equalsIgnoreCase(j.getNombreJugador())){
                           modelo.addElement(j);
                        }
                    }

                    modeloLista(modelo);
                    
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

    /**
     * @method limpiarTexfields limpia el contenido existente.
     */
    private void limpiarTexfields() {
        textFieldCodigoEquipo.setText("");
        textFieldCaracteristicas.setText("");
        textFieldDni.setText("");
        textFieldSueldo.setText("");
        textFieldNombre.setText("");
        textFieldNick.setText("");
    }
    private Jugador extraerDatosTexfields ( ){
        String codEquipo = textFieldCodigoEquipo.getText();
        String caracteristicas = textFieldCaracteristicas.getText();
        String dni = textFieldDni.getText();
        String sueldo = textFieldSueldo.getText();
        int salario = Integer.parseInt(sueldo);
        String name = textFieldNombre.getText();
        String nick = textFieldNick.getText();
        Jugador nuevoJugador = new Jugador(name,nick,salario,dni,caracteristicas,codEquipo);

        return nuevoJugador;

    }

}
