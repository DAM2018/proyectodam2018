package jose.armas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JugadorDaoImpl {

    public static boolean registrar(Jugador jugador) {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean registro = false;

        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO jugador VALUES (?,?,?,?,?,?)");


            stmt.setString(1, jugador.getNombreJugador());
            stmt.setString(2, jugador.getDniJugador());
            stmt.setInt(3, jugador.getSueldoJugador());
            stmt.setString(4, jugador.getNickJugador());
            stmt.setString(5, jugador.getCaracteristicasJugador());
            stmt.setString(6, jugador.getCodigoEquipoJugador());

            int filas = stmt.executeUpdate();
            System.out.println("Filas afectadas: " + filas);

            if (filas != 0) {
                registro = true;
            }


        } catch (SQLException e1) {
            System.out.println("ERROR: ");
            ContraladorBd.cerrarConexion(conexion);
        }
        ContraladorBd.cerrarConexion(conexion);

        return registro;

    }

    /**
     * @param jugador
     * @method actualizar Update el Jugador que recibe por parámetro y loactualiza en la BD.
     */
    public static boolean actualizar(Jugador jugador) {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean actualizacion = false;

        String nombre = jugador.getNombreJugador();
        String dni = jugador.getDniJugador();
        Integer salario = jugador.getSueldoJugador();
        String nick = jugador.getNickJugador();
        String caracteristicas = jugador.getCaracteristicasJugador();
        String codigoEquipo = jugador.getCodigoEquipoJugador();

        try {

            PreparedStatement stmt;
            stmt = conexion.prepareStatement("UPDATE jugador SET nombreJug=?,nick=?,sueldo=?,dnijug=?,caracteristicas=?,codiequipo=?  WHERE dnijug=?");
            stmt.setString(1, nombre);
            stmt.setString(2, dni);
            stmt.setInt(3, salario);
            stmt.setString(4, nick);
            stmt.setString(5, caracteristicas);
            stmt.setString(6, codigoEquipo);
            stmt.setString(7, dni);

            int i = stmt.executeUpdate();

            if (i> 0) {
                actualizacion = true;
            }

        } catch (SQLException e1) {
            System.out.println("ERROR: ");
            ContraladorBd.cerrarConexion(conexion);
        }
        ContraladorBd.cerrarConexion(conexion);

        return actualizacion;

    }

    public static boolean borrarJugador(Jugador jugador) {
        boolean borrado = false;
        Connection conexion = ContraladorBd.abrirConecxion();

        try {

            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM JUGADOR WHERE DNIJUG =?");
            stmt.setString(1,jugador.getDniJugador());

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted>0) {
                borrado = true;
            }

        } catch (SQLException e1) {
            System.out.println("ERROR: ");
            ContraladorBd.cerrarConexion(conexion);
        }
        ContraladorBd.cerrarConexion(conexion);

        return borrado;

    }


}
