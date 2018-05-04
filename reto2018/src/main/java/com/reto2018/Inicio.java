package com.reto2018;

import org.jasypt.util.text.StrongTextEncryptor;

import javax.swing.*;
import java.sql.SQLException;

public class Inicio {
    private static Login login;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        login = new Login();


    }

    public static Login getLogin() {
        return login;
    }

    public static void setLogin(Login login) {
        Inicio.login = login;
    }
}
