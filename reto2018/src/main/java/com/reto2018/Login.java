package com.reto2018;

import org.apache.commons.validator.routines.EmailValidator;

import javax.swing.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Login {

    private Administrador administrador;
    private Usuario usuario;
    private SuperUsuario superUsuario;
    private Dueño dueño;
    private List<String> claves = new ArrayList<String>();
    private List<String> usuarios = new ArrayList<String>();
    private List<String> nombresAdministradores = new ArrayList<String>();
    private List<String> nombresUsuarios = new ArrayList<String>();
    private List<String> emails = new ArrayList<String>();
    private List<String> passwords = new ArrayList<String>();
    private List<String> nombreDue = new ArrayList<String>();
    private List<String> passwordDue = new ArrayList<String>();
    private int du = 0;
    private int ad = 0;
    private int us = 0;
    private Connection conexion;
    private String superusuario;
    private String superpassword;
    private JPasswordField textField1;
    private JPasswordField textField2;
    private JPasswordField textField3;
    private JPasswordField textField4;
    private JPasswordField textField5;
    private JTextField textField6;
    private JPasswordField passwordField1;
    private JPanel login;
    private JButton entrarButton;
    private JTextField textField7;
    private JTextField textField8;
    private JButton aceptarButton;
    private JPasswordField passwordField2;

    public Login() {
        final JFrame frame = new JFrame("Login");
        frame.setContentPane(login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        datosLogin();
        funcionesLogin();
    }

    private void datosLogin() {


        textField1.setText(Conexion.getServidor());
        textField2.setText(Conexion.getPuerto());
        textField3.setText(Conexion.getSid());
        textField4.setText(Conexion.getLogin());
        textField5.setText(Conexion.getPassword());


    }

    private void funcionesLogin() {

        entrar();
        crearUsuario();


    }


    private void entrar() {


        entrarButton.addMouseListener(new
                                              MouseAdapter() {
                                                  @Override
                                                  public void mouseClicked(MouseEvent e) {
                                                      super.mouseClicked(e);


                                                    /*  String servidor = Inicio.getLogin().getTextField1().getText();
                                                      String puerto = Inicio.getLogin().getTextField2().getText();
                                                      String sid = Inicio.getLogin().getTextField3().getText();
                                                      String login = Inicio.getLogin().getTextField4().getText();
                                                      String password = Inicio.getLogin().getTextField5().getText();
                                                      String url = "jdbc:oracle:thin:@" + servidor + ":" + puerto + ":" + sid;*/
                                                      boolean accesoUsuario = false;
                                                      boolean accesoDueños = false;


                                                      try {
                                                          Conexion.EstablecerConexion();
                                                          // conexion = DriverManager.getConnection(url, login, password);
                                                          conexion = Conexion.getConexion();


                                                          System.out.println("Conectado");

                                                          Statement st;

                                                          st = conexion.createStatement();


                                                          String sql = "select email,password2,nombre from usuarios";

                                                          ResultSet rs;
                                                          rs = st.executeQuery(sql);
// Cargar listas con los datos de los usuarios
                                                          while (rs.next()) {

                                                              emails.add(rs.getString("email"));
                                                              passwords.add(rs.getString("password2"));
                                                              nombresUsuarios.add(rs.getString("nombre"));


                                                          }

                                                          for (int i = 0; i < emails.size(); i++) {
                                                              if (emails.get(i).equals(textField6.getText()) && new String(passwordField1.getPassword()).equals(passwords.get(i))) {
                                                                  accesoUsuario = true;
                                                                  us = i + 1;
                                                              }
                                                          }


                                                          st = conexion.createStatement();


                                                          sql = "select nombreDue,passwordDue from dueño order by ordenInsertar";

                                                          rs = st.executeQuery(sql);
// Cargar listas con los datos de los dueños

                                                          while (rs.next()) {

                                                              nombreDue.add(rs.getString(1));
                                                              passwordDue.add(rs.getString(2));


                                                          }

                                                          int i;
                                                          for (i = 0; i < nombreDue.size(); i++) {
                                                              if (nombreDue.get(i).equals(textField6.getText()) && new String(passwordField1.getPassword()).equals(passwordDue.get(i))) {
                                                                  accesoDueños = true;
                                                                  du = i + 1;
                                                              }

                                                          }


                                                          st = conexion.createStatement();

// Cargar listas con los datos de los administradores

                                                          sql = "select usuario,password2 from administradores";

                                                          rs = st.executeQuery(sql);

                                                          while (rs.next()) {

                                                              usuarios.add(rs.getString("usuario"));
                                                              claves.add(rs.getString("password2"));
                                                              nombresAdministradores.add(rs.getString("nombre"));


                                                          }

                                                          st = conexion.createStatement();

// Cargar listas con los datos del superusuario

                                                          sql = "select usuario,password2 from superusuario";

                                                          rs = st.executeQuery(sql);
                                                          while (rs.next()) {

                                                              superusuario = (rs.getString("usuario"));
                                                              superpassword = (rs.getString("password2"));
                                                          }


                                                          boolean aceptarAdmin = false;
                                                          for (i = 0; i < usuarios.size(); i++) {

                                                              if (usuarios.get(i).equals(textField6.getText()) && claves.get(i).equals(new String(passwordField1.getPassword()))) {
                                                                  aceptarAdmin = true;
                                                                  ad = i + 1;
                                                              }

                                                          }

// Comprobar si el superusuario entra

                                                          if (textField6.getText().equals(superusuario) && new String(passwordField1.getPassword()).equals(superpassword)) {


                                                              System.out.println("Conectado");

                                                              superUsuario = new SuperUsuario();

                                                              // Comprobar si el administrador entra

                                                          } else if (aceptarAdmin) {


                                                              administrador = new Administrador();
                                                              administrador.setAdministrador(ad);


                                                              // Comprobar si el usuario entra

                                                          } else if (accesoUsuario) {

                                                              usuario = new Usuario();


                                                              // Comprobar si el dueño entra

                                                          } else if (accesoDueños) {

                                                              Conexion.EstablecerConexion();

                                                              dueño = new Dueño();

                                                          } else {

                                                              JOptionPane.showMessageDialog(null, "El usuario y/o la clave son incorrectas!", "Error", JOptionPane.ERROR_MESSAGE);


                                                          }
                                                          passwords.clear();
                                                          nombreDue.clear();
                                                          passwordDue.clear();
                                                      } catch (SQLException e1) {
                                                          e1.printStackTrace();
                                                      } catch (ClassNotFoundException e1) {
                                                          e1.printStackTrace();
                                                      } catch (UnsupportedFlavorException e1) {
                                                          e1.printStackTrace();
                                                      } catch (IOException e1) {
                                                          e1.printStackTrace();
                                                      }
                                                  }
                                              });


    }


    private void crearUsuario() {


        aceptarButton.addMouseListener(new

                                               MouseAdapter() {
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

                                                           //  Apache Commons validator

                                                           String email = textField8.getText();
                                                           boolean valid = EmailValidator.getInstance().isValid(email);

                                                           if (valid && new String(passwordField2.getPassword()).length() > 7) {
                                                               String sql = "insert into usuarios values (?,?,?,seq3.nextval,?)";
                                                               st = conexion.prepareStatement(sql);

                                                               st.setString(1, textField7.getText());
                                                               st.setString(2, textField8.getText());
                                                               st.setString(3, new String(passwordField2.getPassword()));
                                                               st.setString(4, "usuario");

                                                               st.executeUpdate();


                                                           } else if (!valid) {

                                                               JOptionPane.showMessageDialog(null, "Email NO válido!!!!!!", "Error", JOptionPane.ERROR_MESSAGE);

                                                           } else {

                                                               JOptionPane.showMessageDialog(null, "La contraseña tiene que tener más de 7 caracteres...", "Error", JOptionPane.ERROR_MESSAGE);

                                                           }


                                                       } catch (SQLException e1) {
                                                           e1.printStackTrace();

                                                           JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                                                       } catch (java.lang.NumberFormatException e1) {
                                                           //e1.printStackTrace();
                                                       }


                                                   }
                                               });


    }


    public JTextField getTextField1() {
        return textField1;
    }


    public JTextField getTextField2() {
        return textField2;
    }


    public JTextField getTextField3() {
        return textField3;
    }


    public JPasswordField getTextField4() {
        return textField4;
    }


    public JPasswordField getTextField5() {
        return textField5;
    }


    public List<String> getEmails() {
        return emails;
    }


    public List<String> getUsuarios() {
        return usuarios;
    }


    public int getDu() {
        return du;
    }


    public int getAd() {
        return ad;
    }


    public List<String> getNombreDue() {
        return nombreDue;
    }


    public List<String> getNombresUsuarios() {
        return nombresUsuarios;
    }


    public int getUs() {
        return us;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<String> getNombresAdministradores() {
        return nombresAdministradores;
    }
}
