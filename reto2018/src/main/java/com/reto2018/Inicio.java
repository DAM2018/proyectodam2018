package com.reto2018;

import javax.swing.*;
import java.sql.SQLException;

public class Inicio {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Conexion.EstablecerConexion();
        System.out.println("Conectado");
        Administrador administrador = new Administrador();
        Usuario usuario=new Usuario();
    }

}
