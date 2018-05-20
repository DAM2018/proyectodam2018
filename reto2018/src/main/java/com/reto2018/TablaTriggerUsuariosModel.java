package com.reto2018;

import javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaTriggerUsuariosModel extends AbstractTableModel {

    private String[] columnas = {"Usuario", "Accion", "Fecha", "Administrador"};

    private List<TriggerUsuarios> triggerUsuarios;


    public TablaTriggerUsuariosModel(int j) throws SQLException, ClassNotFoundException {
        triggerUsuarios = TriggerUsuariosVer.triggerUsuarios();
    }


    public void actualizarLista() throws SQLException, ClassNotFoundException {

        triggerUsuarios.clear();
        triggerUsuarios = TriggerUsuariosVer.triggerUsuarios();

    }


    @Override
    public int getRowCount() {
        return triggerUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try{
            TriggerUsuarios t = triggerUsuarios.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return t.getUsuario();
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