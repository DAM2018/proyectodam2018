package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTriggerDueñosModel extends AbstractTableModel {

    private String[] columnas = {"Dueño", "Accion", "Fecha", "Administrador"};

    private List<TriggerDueño> triggerDueños;


    public TablaTriggerDueñosModel(int j) throws SQLException, ClassNotFoundException {
        triggerDueños = TriggerDueñoVer.triggerdueño();
    }


    public void actualizarLista() throws SQLException, ClassNotFoundException {

        triggerDueños.clear();
        triggerDueños = TriggerDueñoVer.triggerdueño();

    }


    @Override
    public int getRowCount() {
        return triggerDueños.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            TriggerDueño t = triggerDueños.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return t.getDueño();
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