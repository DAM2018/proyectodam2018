package jose.armas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class VentanaUsuario {
    private JPanel contenedorPrincipal;
    private JPanel contenedorButtons;
    private JPanel contenedorTextfields;
    private JScrollPane contendorScroll;
    private JList list1Usuarios;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JButton volverButton;
    private JTextField textField1Nombre;
    private JTextField textField2Mail;
    private JTextField textField3Dni;
    private JTextField textField4Usuario;
    private JTextField textField5Contraseña;
    private JLabel nombre;
    private JLabel mail;
    private JLabel dni;
    private JLabel usuario;
    private JLabel contraseña;

    //Asociaciones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;

    public VentanaUsuario(VentanaMenuAdministrador vMad) {

        ventanaMenuAdministrador =vMad;

        JFrame frame = new JFrame("VentanaUsuario");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        obtenerUsuariosBdGenerarModeloListaEinsertarloEnElJlist();
        volverButton.addActionListener(new ActionListener() {
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
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    UsuarioBD.borrarUsuario(nuevoUsuarioExtraidoDeLosDatosTexfields());
                    DefaultListModel<Usuario>usuarioDefaultListModel = new DefaultListModel<>();
                    for (Usuario u:UsuarioBD.usuariosDelaBd()) {
                        usuarioDefaultListModel.addElement(u);
                    }
                    list1Usuarios.setModel(usuarioDefaultListModel);
                    limpiarTexfields();


                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(contenedorPrincipal,exception.getMessage());
                }

            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    UsuarioBD.actualizar(nuevoUsuarioExtraidoDeLosDatosTexfields());
                    DefaultListModel<Usuario>usuarioDefaultListModel = new DefaultListModel<>();
                    for (Usuario u:UsuarioBD.usuariosDelaBd()) {
                        usuarioDefaultListModel.addElement(u);
                    }
                    list1Usuarios.setModel(usuarioDefaultListModel);



                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(contenedorPrincipal,exception.getMessage());
                }



            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    UsuarioBD.crear(nuevoUsuarioExtraidoDeLosDatosTexfields());
                    DefaultListModel<Usuario>usuarioDefaultListModel = new DefaultListModel<>();
                    for (Usuario u:UsuarioBD.usuariosDelaBd()) {
                        usuarioDefaultListModel.addElement(u);
                    }
                    list1Usuarios.setModel(usuarioDefaultListModel);
                    limpiarTexfields();


                } catch (SQLException exception) {
                    JOptionPane.showMessageDialog(contenedorPrincipal,exception.getMessage());
                }

            }
        });
        list1Usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                Usuario usuario = (Usuario)list1Usuarios.getSelectedValue();

                cogerObjetoDelListEinsertarDatosEnTexfields(usuario);
            }
        });
    }

    //Métodos creados para mejor funcionalidad de la VentanaUsuario.

    /**
     * @method limpiarTexfields que se encarga de poner el blanco el contenido de los Texfields.
     */
    private void limpiarTexfields() {
        textField1Nombre.setText("");
        textField2Mail.setText("");
        textField3Dni.setText("");
        textField4Usuario.setText("");
        textField5Contraseña.setText("");
    }

    /**
     * @method que obtiene los Usuarios de la BD para crear un ModeloLista e insertarlo en el Jlist.
     */
    private void obtenerUsuariosBdGenerarModeloListaEinsertarloEnElJlist() {
        List<Usuario> listaDeUsuarios= null;
        try {
            listaDeUsuarios = UsuarioBD.usuariosDelaBd();
            DefaultListModel<Usuario> modeloLista = new DefaultListModel<>();
            for (Usuario u : listaDeUsuarios) {
                modeloLista.addElement(u);
            }

            list1Usuarios.setModel(modeloLista);


        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(contenedorPrincipal,exception.getMessage());
        }
    }

    /**
     * @return un nuevo usuario.
     * @method que recopilando los datos introducidos en en los Texfields por el administrador crea un nuevo Usuario.
     */
    private Usuario nuevoUsuarioExtraidoDeLosDatosTexfields() {
        String nombre = textField1Nombre.getText();
        String mail = textField2Mail.getText();
        String dni = textField3Dni.getText();
        String  user = textField4Usuario.getText();
        String pass = textField5Contraseña.getText();

        Usuario nuevoUsuario = new Usuario(nombre,mail,dni,user,pass);
        return nuevoUsuario;

    }

    /**
     * @method que coge el evento seleccionado del Jlist para extraer sus atributos e insertarlos en los Texfields.
     * @param usuario que se le pasa al método para que obtenga los atributos necesarios.
     */
    private void cogerObjetoDelListEinsertarDatosEnTexfields(Usuario usuario) {
        textField1Nombre.setText(usuario.getNombre());
        textField2Mail.setText(usuario.getMail());
        textField3Dni.setText(usuario.getDni());
        textField4Usuario.setText(usuario.getUser());
        textField5Contraseña.setText(usuario.getPassword());
    }


}
