package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTriggerPartidosModel extends AbstractTableModel {

    private String[] columnas = {"Equipo Local","Equipo visitante", "Accion", "Fecha", "Administrador"};

    private List<TriggerPartido> triggerPartidos;


    public TablaTriggerPartidosModel(int j) throws SQLException, ClassNotFoundException {
        triggerPartidos = TriggerPartidoVer.triggerPartidos();
    }


    public void actualizarLista() throws SQLException, ClassNotFoundException {

        triggerPartidos.clear();
        triggerPartidos = TriggerPartidoVer.triggerPartidos();

    }


    @Override
    public int getRowCount() {
        return triggerPartidos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            TriggerPartido t = triggerPartidos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return t.getEquipoloc();
                case 1:
                    return t.getEquipovis();
                case 2:
                    return t.getAccion();
                case 3:
                    return t.getFecha();
                case 4:
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