package jose.armas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class VentanaCrudDuenyo {
    private JPanel contendorPrincipal;
    private JPanel contendorButtons;
    private JPanel contenedorTexfields;
    private JScrollPane contenedorScroll;
    private JTextField textField1Nombre;
    private JLabel dni;
    private JLabel nombre;
    private JLabel codigoEquipo;
    private JTextField textField2Dni;
    private JTextField textField3Codigo;
    private JList list1Duenyos;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JButton volverAlMenu;
    private JButton limpiarButton;
    private JScrollPane contenedorScrollEquipos;
    private JList list1Equipos;

    //Conexiones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;

    public VentanaCrudDuenyo(VentanaMenuAdministrador vMAdmon) {

        ventanaMenuAdministrador = vMAdmon;

        JFrame frame = new JFrame("VentanaCrudDueño");
        frame.setContentPane(contendorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        obtenerDueñosBdGenerarModeloListaEinsertarloEnElJlist();
        obtenerEquiposBdGenerarModeloListaEinsertarloEnElJlist();


        list1Duenyos.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                Duenyo d =(Duenyo)list1Duenyos.getSelectedValue();
                cogerObjetoDelListEinsertarDatosEnTexfields(d);

            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTexfields();
            }
        });
        volverAlMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    DuenyoBD.crear(nuevoDuenyoExtraidoDeLosDatosTexfields());
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(contendorPrincipal,exception.getMessage());
                }

            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    DuenyoBD.actualizar(nuevoDuenyoExtraidoDeLosDatosTexfields());
                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(contendorPrincipal,exception.getMessage());
                }

            }
        });
    }

    //Métodos.

    /**
     * @method que obtiene los dueños de la BD para crear un ModeloLista e insertarlo en el Jlist.
     */
    private void obtenerDueñosBdGenerarModeloListaEinsertarloEnElJlist() {
        List<Duenyo> listaDeDuenyos = null;
        try {
            listaDeDuenyos = DuenyoBD.duenyosDelaBd();
            DefaultListModel<Duenyo> modeloLista = new DefaultListModel<>();
            for (Duenyo d : listaDeDuenyos) {
                modeloLista.addElement(d);
            }

            list1Duenyos.setModel(modeloLista);


        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(contendorPrincipal,exception.getMessage());
        }
    }

    private void obtenerEquiposBdGenerarModeloListaEinsertarloEnElJlist() {
        List<Equipo> listaDeEquipos = EquiposBd.equiposDeLaBD();

        DefaultListModel<Equipo> modeloLista = new DefaultListModel<>();
        for (Equipo e : listaDeEquipos) {
            modeloLista.addElement(e);
        }
        list1Equipos.setModel(modeloLista);
    }

    private void cogerObjetoDelListEinsertarDatosEnTexfields(Duenyo duenyo) {
        textField1Nombre.setText(duenyo.getNombreDueño());
        textField2Dni.setText(duenyo.getDniDuenyo());
        textField3Codigo.setText(duenyo.getCodigoEquipo());
    }

    /**
     * @method que limpia el contenido de los TexFields para dejarlos en blanco.
     */
    private void limpiarTexfields() {
        textField1Nombre.setText("");
        textField2Dni.setText("");
        textField3Codigo.setText("");

    }

    /**
     * @return un nuevo duenyo.
     * @method que recopilando los datos introducidos en en los Texfields por el usuario crea un nuevo Duenyo.
     */
    private Duenyo nuevoDuenyoExtraidoDeLosDatosTexfields() {
        String nombre = textField1Nombre.getText();
        String dni = textField2Dni.getText();
        String cod = textField3Codigo.getText();

        Duenyo nuevoDuenyo = new Duenyo(nombre,dni,cod);
        return nuevoDuenyo;

    }




}
