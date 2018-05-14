package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaUsuariosModel extends AbstractTableModel {

    private String[] columnas = {"Nombre", "Email", "Password"};

    private List<Usuarios> usuarios;

    public TablaUsuariosModel() {
        usuarios = new ArrayList<Usuarios>();
    }

    public TablaUsuariosModel(int jugador) throws SQLException, ClassNotFoundException {
        usuarios = UsuariosVer.usuarios();
    }

    public void actualizarLista() throws SQLException, ClassNotFoundException {

        usuarios.clear();
        usuarios = UsuariosVer.usuarios();

    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Usuarios u = usuarios.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return u.getNombre();
            case 1:
                return u.getEmail();
            case 2:
                return u.getPassword();

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}