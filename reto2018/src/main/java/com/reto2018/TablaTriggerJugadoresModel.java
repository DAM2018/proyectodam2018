package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTriggerJugadoresModel extends AbstractTableModel {

    private String[] columnas = {"Jugador", "Accion", "Fecha", "Administrador"};

    private List<TriggerJugadores> triggerJugadores;


    public TablaTriggerJugadoresModel(int j) throws SQLException, ClassNotFoundException {
        triggerJugadores = TriggerJugadoresVer.triggerJugadores();
    }


    public void actualizarLista() throws SQLException, ClassNotFoundException {

        triggerJugadores.clear();
        triggerJugadores = TriggerJugadoresVer.triggerJugadores();

    }


    @Override
    public int getRowCount() {
        return triggerJugadores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            TriggerJugadores t = triggerJugadores.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return t.getJugador();
                case 1:
                    return t.getAccion();
                case 2:
                    return t.getFecha();
                case 3:
                    return t.getAdministrador();

            }
        } catch (java.lang.IndexOutOfBoundsException e1) {
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}