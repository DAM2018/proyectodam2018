package jose.armas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenuAdministrador {
    private JPanel contenedorPrincipal;
    private JPanel contenedorCrud;
    private JButton jugadoresButton;
    private JButton equiposButton;
    private JButton duenyosButton;
    private JButton usuariosButton;
    private JTabbedPane tabbedCalendarResults;
    private JPanel calendar;
    private JPanel results;

    //Conexión.
    private VentanaUsuarioContrasenya ventanaUsuarioContrasenya;
    private VentanaCrudJugadores ventanaCrudJugadores;

    VentanaUsuarioContrasenya windowUserpassword;
    VentanaMenuAdministrador windowMenuAdmon;

    public VentanaMenuAdministrador(VentanaUsuarioContrasenya vUc) {

        windowUserpassword = vUc;

        windowMenuAdmon = this;

        JFrame frame = new JFrame("VentanaMenuAdminstrador");
        frame.setContentPane(contenedorPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        jugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ventanaCrudJugadores = new VentanaCrudJugadores(windowMenuAdmon);

            }
        });

    }

}
