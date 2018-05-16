package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTriggerEquiposModel extends AbstractTableModel {

    private String[] columnas = {"Equipo", "Accion", "Fecha", "Administrador"};

    private List<TriggerEquipo> triggerEquipos;


    public TablaTriggerEquiposModel(int j) throws SQLException, ClassNotFoundException {
        triggerEquipos = TriggerEquiposVer.triggerEquipos();
    }


    public void actualizarLista() throws SQLException, ClassNotFoundException {

        triggerEquipos.clear();
        triggerEquipos = TriggerEquiposVer.triggerEquipos();

    }


    @Override
    public int getRowCount() {
        return triggerEquipos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            TriggerEquipo t = triggerEquipos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return t.getEquipo();
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