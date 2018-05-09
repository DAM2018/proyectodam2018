package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaAdministradoresModel extends AbstractTableModel {

    private String[] columnas = {"Nombre", "Usuario", "Password"};

    private int viaje;
    private List<Administradores> administradores;

    public TablaAdministradoresModel() {
        this.viaje = -1;
        administradores = new ArrayList<Administradores>();
    }

    public TablaAdministradoresModel(int jugador) throws SQLException, ClassNotFoundException {
        this.viaje = viaje;
        administradores = AdministradoresVer.administradores();
    }

    public void actualizarLista() throws SQLException, ClassNotFoundException {

        administradores.clear();
        administradores = AdministradoresVer.administradores();

    }

    @Override
    public int getRowCount() {
        return administradores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Administradores a = administradores.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return a.getNombre();
            case 1:
                return a.getUsuario();
            case 2:
                return a.getPassword();

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}