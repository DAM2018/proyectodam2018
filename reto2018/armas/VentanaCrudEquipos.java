package jose.armas;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class VentanaCrudEquipos {
    private JPanel contenedorPrincipal;
    private JPanel contenedorTexfields;
    private JPanel contenedorButtons;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton limpiarButton;
    private JButton verEquipoButton;
    private JButton verTodosLosEquiposButton;
    private JPanel contenedorBusqueda;
    private JButton buscarButton;
    private JTextField textFieldDeBusqueda;
    private JTextField textFieldNombreEquipo;
    private JTextField textFieldCodigo;
    private JTextField textFieldGanados;
    private JTextField textFieldEmpates;
    private JTextField textFieldPerdidos;
    private JTextField textFieldDniDuenyo;
    private JScrollPane scrollEquipos;
    private JList list1Equipos;
    private JButton borrarButton;
    private JLabel dniDuenyo;
    private JLabel empates;
    private JLabel perdidos;
    private JLabel ganados;
    private JLabel codigoEquipo;
    private JLabel nombreEquipo;
    private JButton volverAlMenuButton;

    //Conexiones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;


    public VentanaCrudEquipos(VentanaMenuAdministrador parameterVentanaMenuAdministrador) {

        ventanaMenuAdministrador = parameterVentanaMenuAdministrador;

        JFrame frame = new JFrame("VentanaCrudEquipos");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        obtenerEquiposBdGenerarModeloListaEinsertarloEnElJlist();

        volverAlMenuButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                frame.dispose();
            }
        });

        volverAlMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                frame.dispose();
            }
        });

        verTodosLosEquiposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obtenerEquiposBdGenerarModeloListaEinsertarloEnElJlist();
            }
        });
        buscarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                List<Equipo> equipos = EquiposBd.equiposDeLaBD();
                String texto = textFieldDeBusqueda.getText();
                char c = texto.charAt(0);
                String compracion = "" + c + "";

                DefaultListModel<Equipo> equipoDefaultListModel = new DefaultListModel<>();

                for (Equipo equipo : equipos) {
                    char ca = equipo.getNombre().charAt(0);
                    String g = "" + ca + "";

                    if (g.equalsIgnoreCase(compracion)) {
                        equipoDefaultListModel.addElement(equipo);
                    }
                }

                list1Equipos.setModel(equipoDefaultListModel);
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    EquiposBd.crear(nuevoEquipoExtraidoDeLosDatosTexfields());
                    DefaultListModel<Equipo> equipoDefaultListModel = new DefaultListModel<>();
                    for (Equipo equipe : EquiposBd.equiposDeLaBD()) {
                        equipoDefaultListModel.addElement(equipe);
                    }
                    list1Equipos.setModel(equipoDefaultListModel);
                    limpiarTexfields();
                } catch (SQLException excepcion) {
                    JOptionPane.showMessageDialog(contenedorPrincipal, excepcion.getMessage());
                }

            }
        });
        list1Equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                Equipo equipo = (Equipo) list1Equipos.getSelectedValue();

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTexfields();
            }
        });
        list1Equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                Equipo equipo = (Equipo) list1Equipos.getSelectedValue();

                cogerObjetoDelListEinsertarDatosEnTexfields(equipo);

            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    EquiposBd.borrarEquipo(nuevoEquipoExtraidoDeLosDatosTexfields());
                    DefaultListModel<Equipo> equipoDefaultListModel = new DefaultListModel<>();

                    for (Equipo equipe : EquiposBd.equiposDeLaBD()) {
                        equipoDefaultListModel.addElement(equipe);
                    }
                    list1Equipos.setModel(equipoDefaultListModel);
                    limpiarTexfields();
                } catch (SQLException excepcion) {
                    JOptionPane.showMessageDialog(contenedorPrincipal, excepcion.getMessage());
                }catch (NumberFormatException n){
                    JOptionPane.showMessageDialog(null,"Elija un equipo de la lista");
                }
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                try {
                    EquiposBd.actualizar(nuevoEquipoExtraidoDeLosDatosTexfields());
                    DefaultListModel<Equipo> equipoDefaultListModel = new DefaultListModel<>();
                    for (Equipo equipe : EquiposBd.equiposDeLaBD()) {
                        equipoDefaultListModel.addElement(equipe);
                    }
                    list1Equipos.setModel(equipoDefaultListModel);

                } catch (SQLException excepcion) {
                    JOptionPane.showMessageDialog(contenedorPrincipal, excepcion.getMessage());
                }catch (NumberFormatException n){
                    JOptionPane.showMessageDialog(null,"Inserte datos en los espacios en blanco");
                }

            }
        });
    }

    /**
     * @param equipo que se pasa a la función para su extracción de sus atributos.
     * @method que se encarga de obtener los datos de un objeto seleccionado del Jlist y de insertarlos en los Texfields.
     */
    private void cogerObjetoDelListEinsertarDatosEnTexfields(Equipo equipo) {
        textFieldNombreEquipo.setText(equipo.getNombre());
        textFieldCodigo.setText(equipo.getCodigo());
        String ganado = Integer.toString(equipo.getGanado());
        String empatado = Integer.toString(equipo.getEmpatado());
        String perdido = Integer.toString(equipo.getPerdido());
        textFieldGanados.setText(ganado);
        textFieldEmpates.setText(empatado);
        textFieldPerdidos.setText(perdido);
        textFieldDniDuenyo.setText(equipo.getDniDuenyoEquipo());
    }


    /**
     * @method que obtiene los jugadores de la BD para crear un ModeloLista e insertarlo en el Jlist.
     */
    private void obtenerEquiposBdGenerarModeloListaEinsertarloEnElJlist() {
        List<Equipo> listaDeEquipos = EquiposBd.equiposDeLaBD();

        DefaultListModel<Equipo> modeloLista = new DefaultListModel<>();
        for (Equipo e : listaDeEquipos) {
            modeloLista.addElement(e);
        }
        list1Equipos.setModel(modeloLista);
    }

    private void controlDeInserccionesTextFields(DefaultListModel<Equipo> modeloEquipo, int seleccion) throws SQLException {

        //int seleccion = listJugadores.getSelectedIndex();
        Equipo equipoArellenar = modeloEquipo.getElementAt(seleccion);

        System.out.println(equipoArellenar.getNombre());


    }

    /**
     * @return un nuevo equipo.
     * @method que recopilando los datos introducidos en en los Texfields por el usuario crea un nuevo Equipo.
     */
    private Equipo nuevoEquipoExtraidoDeLosDatosTexfields() {
        String codEquipo = textFieldCodigo.getText();
        String nombre = textFieldNombreEquipo.getText();
        String dni = textFieldDniDuenyo.getText();
        int ganados = Integer.parseInt(textFieldGanados.getText());
        int empates = Integer.parseInt(textFieldEmpates.getText());
        int perdidos = Integer.parseInt(textFieldPerdidos.getText());

        Equipo nuevoEquipo = new Equipo(nombre, codEquipo, ganados, empates, perdidos, dni);

        return nuevoEquipo;

    }

    /**
     * @method que limpia el contenido de los TexFields para dejarlos en blanco.
     */
    private void limpiarTexfields() {
        textFieldNombreEquipo.setText("");
        textFieldCodigo.setText("");
        textFieldGanados.setText("");
        textFieldEmpates.setText("");
        textFieldPerdidos.setText("");
        textFieldDniDuenyo.setText("");
    }

}


