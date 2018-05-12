package jose.armas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadoresBD {

    private VentanaCrudJugadores ventanaCrudJugadores;

    /**
     * @method Este método carga la lista de jugadores de un mismo equipo.
     * @param x que es el código del equipo.
     * @return devuelve una lista de jugadores.
     * @throws SQLException excepción de base de datos.
     */
    public static List<Jugador> ListarJugadoresDeUnMismoEquipo(int x) throws SQLException {

        List<Jugador> lista = new ArrayList<>();

            Connection conexion=null;
            try {
                conexion = ContraladorBd.abrirConecxion();

                Statement st =conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM JOSE_JUGADOR where CODIGOEQUIJUG ="+x);

                while (rs.next()) {

                    lista.add(
                            new Jugador(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6)
                            )
                    );
                }
                st.close();

            } catch (SQLException ex) {
                ContraladorBd.cerrarConexion(conexion);
                throw ex;
            }
                ContraladorBd.cerrarConexion(conexion);

        return lista;
    }

    /**
     * Este método carga la lista de jugadores.
     * @return devuelve una lista de jugadores.
     * @throws SQLException excepción de base de datos.
     */
    public static List<Jugador> ListarJugadores() throws SQLException {

        List<Jugador> lista = new ArrayList<>();

        Connection conexion=null;
        try {
            conexion = ContraladorBd.abrirConecxion();

            Statement st =conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM JOSE_JUGADOR");

            while (rs.next()) {

                lista.add(
                        new Jugador(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6)
                        )
                );
            }
            st.close();

        } catch (SQLException ex) {
            ContraladorBd.cerrarConexion(conexion);
            throw ex;
        }
        ContraladorBd.cerrarConexion(conexion);

        return lista;
    }


    public static boolean registrar(Jugador jugador) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean registro = false;

        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO JOSE_JUGADOR VALUES (?,?,?,?,?,?)");


            stmt.setString(1, jugador.getNombreJugador());
            stmt.setString(2, jugador.getNickJugador());
            stmt.setInt(3, jugador.getSueldoJugador());
            stmt.setString(4, jugador.getDniJugador());
            stmt.setString(5, jugador.getCaracteristicasJugador());
            stmt.setString(6, jugador.getCodigoEquipoJugador());

            int filas = stmt.executeUpdate();
            System.out.println("Filas afectadas: " + filas);

            if (filas != 0) {
                registro = true;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ContraladorBd.cerrarConexion(conexion);
            throw e;
        }
        ContraladorBd.cerrarConexion(conexion);

        return registro;

    }

    /**
     * @param jugador
     * @method actualizar Update el Jugador que recibe por parámetro y loactualiza en la BD.
     */
    public static boolean actualizar(Jugador jugador) throws SQLException {

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
            stmt = conexion.prepareStatement("UPDATE JOSE_JUGADOR SET nombreJug=?,nick=?,sueldo=?,dnijug=?,caracteristicas=?,CODIGOEQUIJUG=?  WHERE dnijug=?");
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

        } catch (SQLException e) {
            System.out.println("ERROR: ");
            System.out.println(e.getMessage());
            ContraladorBd.cerrarConexion(conexion);
            throw e;
        }
        ContraladorBd.cerrarConexion(conexion);

        return actualizacion;

    }

    public static boolean borrarJugador(Jugador jugador) {
        boolean borrado = false;
        Connection conexion = ContraladorBd.abrirConecxion();

        try {

            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM JOSE_JUGADOR WHERE DNIJUG =?");
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
