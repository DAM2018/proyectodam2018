package com.reto2018;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Login {

    private Administrador administrador;
    private Usuario usuario;

    public Login() {
        final JFrame frame = new JFrame("Login");
        frame.setContentPane(login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        textField1.setText(Conexion.getServidor());
        textField2.setText(Conexion.getPuerto());
        textField3.setText(Conexion.getSid());
        textField4.setText(Conexion.getLogin());
        textField5.setText(Conexion.getPassword());


        entrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                List<String> emails = new ArrayList<String>();
                List<String> passwords = new ArrayList<String>();

                String servidor = Inicio.getLogin().getTextField1().getText();
                String puerto = Inicio.getLogin().getTextField2().getText();
                String sid = Inicio.getLogin().getTextField3().getText();
                String login = Inicio.getLogin().getTextField4().getText();
                String password = Inicio.getLogin().getTextField5().getText();
                String url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;

                Connection conexion = null;
                Statement st = null;

                try {
                    conexion = DriverManager.getConnection(url, login, password);

                    st = conexion.createStatement();


                    String sql = "select email,password from usuarios";

                    ResultSet rs = null;
                    rs = st.executeQuery(sql);

                    while (rs.next()) {

                        emails.add(rs.getString(1));
                        passwords.add(rs.getString(2));



                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                boolean accesoUsuario=false;
                for (int i = 0; i < emails.size(); i++) {
                    if(emails.get(i).equals(textField6.getText()) && new String(passwordField1.getPassword()).equals(passwords.get(i)))
                        accesoUsuario=true;
                }
                List<String>claves=new ArrayList<String>();
                List<String>usuarios=new ArrayList<String>();

                try {
                    BufferedReader in = new BufferedReader(new FileReader("src/passwords.txt"));
                    BufferedReader in2 = new BufferedReader(new FileReader("src/usuarios.txt"));

                    String line;
                    String line2;

                    claves=new ArrayList<String>();
                    usuarios=new ArrayList<String>();

                    while((line = in.readLine()) !=null)
                    {
                        claves.add(line);

                    }
                    in.close();
                    while((line2 = in2.readLine()) !=null)
                    {
                        usuarios.add(line2);

                    }
                    in2.close();

                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


                //char[] password2 = ;
                //char[] correctPass = new char[]{'a', 'd', 'm', 'i', 'n'};

                boolean aceptarAdmin=false;
                for (int i = 0; i < usuarios.size(); i++) {

                    if (usuarios.get(i).equals(textField6.getText()) && claves.get(i).equals(new String(passwordField1.getPassword())))
                        aceptarAdmin=true;

                }
                if (aceptarAdmin) {

                    try {
                        Conexion.EstablecerConexion();

                    System.out.println("Conectado");

                        administrador = new Administrador();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }


                } else if(accesoUsuario){
                    try {
                        Conexion.EstablecerConexion();

                    System.out.println("Conectado");
                        usuario = new Usuario();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }


                }else{
                    System.out.println("else");}

                emails.clear();
                passwords.clear();


            }
        });
        aceptarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    String servidor = Inicio.getLogin().getTextField1().getText();
                    String puerto = Inicio.getLogin().getTextField2().getText();
                    String sid = Inicio.getLogin().getTextField3().getText();
                    String login = Inicio.getLogin().getTextField4().getText();
                    String password = Inicio.getLogin().getTextField5().getText();
                    String url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;

                    Connection conexion = DriverManager.getConnection(url, login, password);

                    PreparedStatement st;


                    String sql = "insert into usuarios values (?,?,?)";
                    st = conexion.prepareStatement(sql);

                    st.setString(1, textField7.getText());
                    st.setString(2, textField8.getText());
                    st.setString(3, textField9.getText());

                    st.executeUpdate();

                    administrador.getTum().actualizarLista();
                    administrador.getTable4().revalidate();
                    administrador.getTable4().repaint();

                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (java.lang.NumberFormatException e1) {
                    //e1.printStackTrace();
                }


            }
        });
    }


    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPasswordField passwordField1;
    private JPanel login;
    private JButton entrarButton;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton aceptarButton;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public void setTextField5(JTextField textField5) {
        this.textField5 = textField5;
    }
}
