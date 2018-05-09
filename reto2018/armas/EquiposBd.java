package jose.armas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquiposBd {

    public static List<Equipo> equiposDeLaBD (){

        List<Equipo>listaDeEquiposDeLaBD = new ArrayList<>();

        Connection conexion = ContraladorBd.abrirConecxion();

        Statement declaracion;

        {
            try {
                declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery("SELECT * FROM EQUIPO");

                while (rs.next()) {
                    listaDeEquiposDeLaBD.add(
                            new Equipo(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getInt(4),
                                    rs.getInt(5),
                                    rs.getString(6)
                            )
                    );
                }
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
                ContraladorBd.cerrarConexion(conexion);
            }
            ContraladorBd.cerrarConexion(conexion);
        }

        return listaDeEquiposDeLaBD;
    }


    /**
     * @method método que se encarga de realizar el INSERT en la BD.
     * @param equipo es el objeto de tipo Equipo que se pasa para ser INSERTADO en la BD.
     * @return retorna si el INSERT está realizada o no (True or false).
     * @throws SQLException que se recoge de las posibles restricciones de la BD.
     */
    public static boolean crear(Equipo equipo)throws SQLException{

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean registro = false;

        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO equipo VALUES (?,?,?,?,?,?)");


            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCodigo());
            stmt.setInt(3, equipo.getGanado());
            stmt.setInt(4, equipo.getEmpatado());
            stmt.setInt(5, equipo.getPerdido());
            stmt.setString(6, equipo.getDniDuenyoEquipo());

            int filas = stmt.executeUpdate();
            System.out.println("Filas afectadas: " + filas);

            if (filas != 0) {
                registro = true;
            }


        } catch (SQLException e) {
            System.out.println("ERROR: ");
            ContraladorBd.cerrarConexion(conexion);
            throw e;
        }
        ContraladorBd.cerrarConexion(conexion);

        return registro;

    }

    /**
     * @method método que se encarga de realizar el UPDATE en la BD.
     * @param equipo es el objeto de tipo Equipo que se pasa para ser actualizado en la BD.
     * @return retorna si la actualización está realizada o no (True or false).
     * @throws SQLException que se recoge de las posibles restricciones de la BD.
     */
    public static boolean actualizar(Equipo equipo) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean actualizacion = false;

        String nombre = equipo.getNombre();
        String dni = equipo.getDniDuenyoEquipo();
        String codigo = equipo.getCodigo();
        int ganado = equipo.getGanado();
        int empatado = equipo.getEmpatado();
        int perdido = equipo.getPerdido();


        try {

            PreparedStatement stmt;
            stmt = conexion.prepareStatement("UPDATE equipo SET nombreequi=?,codigoequi=?,ganados=?,empates=?,perdidos=?,dnidueequi=?  WHERE codigoequi=?");
            stmt.setString(1, nombre);
            stmt.setString(2, codigo);
            stmt.setInt(3, ganado);
            stmt.setInt(4, empatado);
            stmt.setInt(5, perdido);
            stmt.setString(6, dni);
            stmt.setString(7, codigo);

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

    /**
     * @method borrarJugador  que se encarga de eliminar un equipo.
     * @param equipo que se le pasa a función para que sea eliminado.
     * @return la variable borrado como True, si es borrado o False si es el caso contrario.
     * @throws SQLException que se lanza en el caso de detectar restricciones de la BD.
     */
    public static boolean borrarEquipo(Equipo equipo) throws SQLException  {
        boolean borrado = false;
        Connection conexion = ContraladorBd.abrirConecxion();

        try {

            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM EQUIPO  WHERE CODIGOEQUI=?");
            stmt.setString(1,equipo.getCodigo());

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted>0) {
                borrado = true;
            }

        } catch (SQLException e) {
            System.out.println("ERROR: ");
            ContraladorBd.cerrarConexion(conexion);
            throw e;

        }
        ContraladorBd.cerrarConexion(conexion);

        return borrado;

    }


}
