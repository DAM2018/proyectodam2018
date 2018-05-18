package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTriggerDuenyosModel extends AbstractTableModel {

    private String[] columnas = {"Duenyo", "Accion", "Fecha", "Administrador"};

    private List<TriggerDuenyo> triggerDuenyos;


    public TablaTriggerDuenyosModel(int j) throws SQLException, ClassNotFoundException {
        triggerDuenyos = TriggerDuenyoVer.triggerduenyo();
    }


    public void actualizarLista() throws SQLException, ClassNotFoundException {

        triggerDuenyos.clear();
        triggerDuenyos = TriggerDuenyoVer.triggerduenyo();

    }


    @Override
    public int getRowCount() {
        return triggerDuenyos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            TriggerDuenyo t = triggerDuenyos.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return t.getDuenyo();
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