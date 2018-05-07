package jose.armas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JugadoresBD {

    private VentanaCrudJugadores ventanaCrudJugadores;

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
                ResultSet rs = st.executeQuery("SELECT * FROM JUGADOR");

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


    public static void crearJugadores (){

    }

}
