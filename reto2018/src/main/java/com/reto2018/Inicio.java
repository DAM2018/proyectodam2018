package com.reto2018;

import javax.swing.*;
import java.sql.SQLException;

public class Inicio {
    private static Login login;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
 login =new Login();

       // Usuario usuario=new Usuario();
    }

    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        Inicio.login = login;
    }
}
