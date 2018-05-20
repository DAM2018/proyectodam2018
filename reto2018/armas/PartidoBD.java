package jose.armas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidoBD {

    public static List<Partido> partidoBD() throws SQLException {

        List<Partido> listaDePartidosBD = new ArrayList<>();

        Connection conexion = ContraladorBd.abrirConecxion();

        Statement declaracion;

        {
            try {
                declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery("SELECT * FROM JOse_Partido");

                while (rs.next()) {

                                   String fecha = rs.getString(1);
                                   String resultado =rs.getString(2);
                                    String codigo =rs.getString(3);
                                    String codlOc = rs.getString(4);
                                    String codVis = rs.getString(5);
                                    int  golesLoc =rs.getInt(6);
                                    int golesVis = rs.getInt(7);
                                    String jornada = rs.getString(8);
                                    Integer j = Integer.parseInt(jornada);
                                    String equiLoc = rs.getString(9);
                                    String equiVis = rs.getString(10);
                                    listaDePartidosBD.add(new Partido(fecha,resultado,codigo,codlOc,codVis,golesLoc,
                                            golesVis,j,equiLoc,equiVis));

                }
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
                ContraladorBd.cerrarConexion(conexion);
                throw e;
            }
            ContraladorBd.cerrarConexion(conexion);
        }

        return listaDePartidosBD;
    }

    public static boolean crear(Partido partido) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean registro = false;

        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO Jose_partido VALUES (?,?,?,?,?,?,?,?,?,?)");

            List<Equipo >list = EquiposBd.equiposDeLaBD();
            String local=null;
            String visitante=null;
            for (Equipo e:list) {
                if (e.getNombre().equalsIgnoreCase(partido.getLocal())) {
                    local = e.getCodigo();

                }else if (e.getNombre().equalsIgnoreCase(partido.getVisitante())){
                    visitante = e.getCodigo();
                }
            }

            stmt.setString(1,partido.getFecha());
            stmt.setString(2, partido.getResultado());
            stmt.setString(3, partido.getNumeroPartido());
            stmt.setString (4,local);
            stmt.setString (5,visitante);
            stmt.setInt (6,partido.getGolesLocal());
            stmt.setInt (7,partido.getGolesVisitante());
            String jornada = Integer.toString(partido.getNumeroJOrnada());
            stmt.setString (8,jornada);
            stmt.setString (9,partido.getLocal());
            stmt.setString (10,partido.getVisitante());

            System.out.println(partido.getNumeroPartido());


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
     * @param partido es el objeto de tipo Usuario que se pasa para ser actualizado en la BD.
     * @return retorna si la actualización está realizada o no (True or false).
     * @throws SQLException que se recoge de las posibles restricciones de la BD.
     * @method método que se encarga de realizar el UPDATE en la BD.
     */
    public static boolean actualizar(Partido partido) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean actualizacion = false;

        try {
            PreparedStatement stmt;
            stmt = conexion.prepareStatement
                    ("UPDATE jose_partido SET fecha=?,resultado=?,codigopar=?,codigoequiloc=?," +
                            "codigoequivis=?, goleslocal=?,golesvisitante=?,jornada=? WHERE codigopar=?");
            stmt.setString(1,partido.getFecha());
            stmt.setString(2, partido.getResultado());
            stmt.setString(3, partido.getNumeroPartido());
            stmt.setString (4,partido.getLocal());
            stmt.setString (5,partido.getVisitante());
            stmt.setInt (6,partido.getGolesLocal());
            stmt.setInt (7,partido.getGolesVisitante());
            String jornada = String.valueOf(partido.getJornada());
            stmt.setString (8,jornada);

            int i = stmt.executeUpdate();

            if (i > 0) {
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
     * @param partido que se le pasa a función para que sea eliminado.
     * @return la variable borrado como True, si es borrado o False si es el caso contrario.
     * @throws SQLException que se lanza en el caso de detectar restricciones de la BD.
     * @method borrarDuenyo  que se encarga de eliminar un usuario.
     */
    public static boolean borrarUsuario(Partido partido) throws SQLException {
        boolean borrado = false;
        Connection conexion = ContraladorBd.abrirConecxion();

        try {

            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM jose_partido  WHERE codigopar=?");
            stmt.setString(3, partido.getNumeroPartido());

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
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
