package jose.armas;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TablaJugadoresModel extends AbstractTableModel {

    private String[] columnas = {"Nombre", "Nick", "Sueldo", "DNI", "caracteristicas", "Equipo"};

    private List<Jugador> jugadores;

    public TablaJugadoresModel() {

        jugadores = new ArrayList<Jugador>();

    }

    public TablaJugadoresModel(int j) throws SQLException, ClassNotFoundException {
        jugadores = JugadoresBD.ListarJugadores();
    }

    public void actualizarLista() throws SQLException, ClassNotFoundException {

        jugadores.clear();
        jugadores = JugadoresBD.ListarJugadores();

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
        try{
            Jugador j = jugadores.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return j.getNombreJugador();
                case 1:
                    return j.getNickJugador();
                case 2:
                    return j.getSueldoJugador();
                case 3:
                    return j.getDniJugador();
                case 4:
                    return j.getCaracteristicasJugador();
                case 5:
                    return j.getCodigoEquipoJugador();
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
