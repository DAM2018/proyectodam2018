package jose.armas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaUsuarioContrasenya {
    private JPanel contenedorPrincipal;
    private JPanel contenedorUsuario;
    private JTextField textField1;
    private JPanel contenedorContrasenya;
    private JPasswordField passwordField1;
    private JLabel Usuario;
    private JLabel contrasenya;
    private JButton validarButton;

    //Conexiones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;
    private VentanaMenuDuenyo ventanaMenuDuenyo;

    VentanaUsuarioContrasenya ventanaUsuarioContrasenya;


    public VentanaUsuarioContrasenya() {

        ventanaUsuarioContrasenya = this;
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String user = textField1.getText();
                char[] password = passwordField1.getPassword();

                switch (user){

                    case "administrador":
                        if (!user.equalsIgnoreCase("administrador")) {
                            JOptionPane.showMessageDialog(contenedorUsuario, "Usuario incorrecto");
                        } else if (verificarPasswordAministrador(password) == false) {
                            JOptionPane.showMessageDialog(contenedorContrasenya,
                                    "Invalid password. Try again.",
                                    "Error Message",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            ventanaMenuAdministrador = new VentanaMenuAdministrador(ventanaUsuarioContrasenya);
                        }
                        break;
                    case "dueño":
                        if (!user.equalsIgnoreCase("dueño")) {
                            JOptionPane.showMessageDialog(contenedorUsuario, "Usuario incorrecto");
                        } else if (verificarPassworDuenyo(password) == false) {
                            JOptionPane.showMessageDialog(contenedorContrasenya,
                                    "Invalid password. Try again.",
                                    "Error Message",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                ventanaMenuDuenyo = new VentanaMenuDuenyo(ventanaUsuarioContrasenya);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(contenedorPrincipal,"error");

                }

                textField1.setText("");
                passwordField1.setText("");


            }

        });


    }

    public static boolean verificarPasswordAministrador(char[] pas) {

        boolean ok = false;

        String clave = "administrador";
        String union = "";

        for (int i = 0; i < pas.length; i++) {
            union = union + pas[i];
        }

        if (clave.equalsIgnoreCase(union)) {
            ok = true;
        }


        return ok;
    }

    public static boolean verificarPassworDuenyo(char[] pas) {

        boolean ok = false;

        String clave = "dueño";
        String union = "";

        for (int i = 0; i < pas.length; i++) {
            union = union + pas[i];
        }

        if (clave.equalsIgnoreCase(union)) {
            ok = true;
        }


        return ok;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaUsuarioContrasenya");
        frame.setContentPane(new VentanaUsuarioContrasenya().contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
