package jose.armas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentanaMenuDuenyo {
    private JPanel contenedorPrincipal;
    private JPanel contenedorCrearEquipo;
    private JPanel conetenedorClasificación;
    private JPanel contendorResultados;
    private JList list1;
    private JPanel contenedorLIst;
    private JTable table1;
    private JPanel contendorFunciones;
    private JButton ficharButton;
    private JButton borrarButton;
    private JScrollPane contendorEquipo;


    //Asociaciones.
    private VentanaUsuarioContrasenya ventanaUsuarioContrasenya;


    VentanaMenuDuenyo ventanaMenuDuenyo;


    public VentanaMenuDuenyo(VentanaUsuarioContrasenya vUc) throws SQLException {

        ventanaUsuarioContrasenya = vUc;

        JFrame frame = new JFrame("VentanaMenuDuenyo");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Duenyo duenyo = DuenyoBD.duenyoEquipo1();
        List<Equipo> equipos = EquiposBd.equiposDeLaBD();

        String titulo = "";

        for (Equipo e : equipos) {
            if (e.getCodigo().equalsIgnoreCase(duenyo.getCodigoEquipo())) {
                titulo = e.getNombre();
            }
        }


        //Conexión bidireccional para acceder al nombre del equipo del dueño.

        contendorEquipo.setBorder(javax.swing.BorderFactory.createTitledBorder(titulo));

        ponerEnJlistLosJugadoresLIbres();
        generarModeloTablaConLosJugadoresDeEseEquipo();


        ficharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (list1.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un jugador de la lista.");
                } else {
                    Jugador jugadorAfichar = (Jugador) list1.getSelectedValue();
                    int fila = table1.getSelectedRow();
                    if (fila < 0) {
                        JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                    } else {

                        for (int x = 0; x < 6; x++) {
                            switch (x) {
                                case 0:
                                    table1.setValueAt(jugadorAfichar.getNombreJugador(), fila, x);
                                    break;
                                case 1:
                                    table1.setValueAt(jugadorAfichar.getNickJugador(), fila, x);
                                    break;
                                case 2:
                                    table1.setValueAt(jugadorAfichar.getSueldoJugador(),fila, x);
                                    break;
                                case 3:
                                    table1.setValueAt(jugadorAfichar.getDniJugador(), fila, x);
                                    break;
                                case 4:
                                    table1.setValueAt(jugadorAfichar.getCaracteristicasJugador(), fila, x);
                                    break;
                                case 5:
                                    table1.setValueAt(jugadorAfichar.getCodigoEquipoJugador(), fila, x);
                                    break;
                            }

                        }

                    }


                }


            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Jugador jugadorAborrar = (Jugador) list1.getSelectedValue();
                int fila = table1.getSelectedRow();
                if (fila < 0) {
                    JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");
                } else{
                    for (int x = 0; x < 6; x++) {
                        switch (x) {
                            case 0:
                                table1.setValueAt("", fila, x);
                                break;
                            case 1:
                                table1.setValueAt("", fila, x);
                                break;
                            case 2:
                                table1.setValueAt("",fila, x);
                                break;
                            case 3:
                                table1.setValueAt("", fila, x);
                                break;
                            case 4:
                                table1.setValueAt("", fila, x);
                                break;
                            case 5:
                                table1.setValueAt("", fila, x);
                                break;
                        }

                        jugadorAborrar.setLibre(true);
                        jugadorAborrar.setCodigoEquipoJugador("");
                    }

                }

            }
        });
    }


    /**
     * @throws SQLException
     * @method generarModeloTablaConLosJugadoresDeEseEquipo() que se encarga de elaborar el modelo de la tabla y añadir
     * los jugadores del equipo 1.
     */
    private void generarModeloTablaConLosJugadoresDeEseEquipo() throws SQLException {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        String[] columnas = {"Nombre", "Nick", "Sueldo", "DNI", "caracteristicas", "Equipo"};

        modeloTabla.setColumnCount(6);
        modeloTabla.setNumRows(6);
        modeloTabla.setColumnIdentifiers(columnas);

        table1.setModel(modeloTabla);

        List<Jugador> jugadoresDelMismoEquipo = JugadoresBD.ListarJugadoresDeUnMismoEquipo(1);

        for (int i = 0; i < jugadoresDelMismoEquipo.size(); i++) {
            System.out.println(jugadoresDelMismoEquipo.get(i).getNombreJugador());
        }

        for (int i = 0; i < jugadoresDelMismoEquipo.size(); i++) {
            for (int x = 0; x < 6; x++) {
                switch (x) {
                    case 0:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getNombreJugador(), i, x);
                        break;
                    case 1:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getNickJugador(), i, x);
                        break;
                    case 2:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getSueldoJugador(), i, x);
                        break;
                    case 3:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getDniJugador(), i, x);
                        break;
                    case 4:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getCaracteristicasJugador(), i, x);
                        break;
                    case 5:
                        modeloTabla.setValueAt(jugadoresDelMismoEquipo.get(i).getCodigoEquipoJugador(), i, x);
                        break;
                }

            }
        }
    }


    /**
     * @method ponerEnJlistLosJugadoresLIbres() que obtiene los jugadores de la BD para seleccionar cuál de ellos
     * está sin equipo y así mostrarlo en el Jlist cómo libres para que los pueda fichar el dueño.
     */
    private void ponerEnJlistLosJugadoresLIbres() {
        try {
            List<Jugador> jugadors = JugadoresBD.ListarJugadores();
            DefaultListModel<Jugador> jugadores = new DefaultListModel<>();

            for (Jugador jug : jugadors) {
                if (jug.getCodigoEquipoJugador() == null) {
                    jugadores.addElement(jug);
                }
            }

            list1.setModel(jugadores);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
