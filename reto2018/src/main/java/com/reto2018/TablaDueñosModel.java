package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaDueñosModel extends AbstractTableModel {

    private String[] columnas = {"Nombre", "DNI", "Codigo Equipo"};

    private int viaje;
    private List<Dueños> dueños;

    public TablaDueñosModel() {
        this.viaje = -1;
        dueños = new ArrayList<Dueños>();
    }

    public TablaDueñosModel(int jugador) throws SQLException, ClassNotFoundException {
        this.viaje = viaje;
        dueños = DueñosVer.dueños();
    }

    public void actualizarLista() throws SQLException, ClassNotFoundException {

        dueños.clear();
        dueños = DueñosVer.dueños();

    }

    @Override
    public int getRowCount() {
        return dueños.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Dueños d = dueños.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return d.getNombredue();
            case 1:
                return d.getDnidue();
            case 2:
                return d.getCodigoequidue();

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}