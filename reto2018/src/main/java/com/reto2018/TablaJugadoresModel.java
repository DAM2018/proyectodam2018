package com.reto2018;

import javax.swing.table.AbstractTableModel;

        import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
        import java.util.List;

public class TablaJugadoresModel extends AbstractTableModel {

    private String[] columnas = {"Nombre", "Nick", "Sueldo", "DNI", "caracteristicas", "Equipo"};

    private int viaje;
    private List<Jugador> jugadores;

    public TablaJugadoresModel() {
        this.viaje = -1;
        jugadores = new ArrayList<Jugador>();
    }

    public TablaJugadoresModel(int jugador) throws SQLException, ClassNotFoundException {
        this.viaje = viaje;
        jugadores = JugadoresVer.jugadores();
    }

    public void actualizarLista() throws SQLException, ClassNotFoundException {

        jugadores.clear();
        jugadores = JugadoresVer.jugadores();

    }

    @Override
    public int getRowCount() {
        return jugadores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Jugador j = jugadores.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return j.getNombrejug();
            case 1:
                return j.getNick();
            case 2:
                return j.getSueldo();
            case 3:
                return j.getDnijug();
            case 4:
                return j.getCaracteristicas();
            case 5:
                return j.getcodigoequijug();
        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

}