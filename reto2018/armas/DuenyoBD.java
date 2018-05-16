package jose.armas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenyoBD {

    /**
     * @mtehod duenyoEquipo1() que se encarga de hacer la consulta en la BD para extrar un dueño en concreto.
     * @return duenyo que tiene como equipo asignado de código 1.
     * @throws SQLException
     */
    public static Duenyo duenyoEquipo1() throws SQLException {

        Duenyo duenyo = new Duenyo();

        Connection conexion = ContraladorBd.abrirConecxion();

        Statement declaracion;

        {
            try {
                declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery("SELECT * FROM JOSE_DUEÑO WHERE CODIGOEQUIDUE="+1);

                        while(rs.next()){
                            duenyo= new Duenyo(


                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3)
                            );
                        }



                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
                ContraladorBd.cerrarConexion(conexion);
                throw e;
            }
            ContraladorBd.cerrarConexion(conexion);
        }

        return duenyo;
    }

    public static List<Duenyo> duenyosDelaBd() throws SQLException {

        List<Duenyo> listaDeDuenyosDeLaBD = new ArrayList<>();

        Connection conexion = ContraladorBd.abrirConecxion();

        Statement declaracion;

        {
            try {
                declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery("SELECT * FROM JOSE_DUEÑO");

                while (rs.next()) {
                    listaDeDuenyosDeLaBD.add(
                            new Duenyo(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3)
                            )
                    );
                }
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
                ContraladorBd.cerrarConexion(conexion);
                throw e;
            }
            ContraladorBd.cerrarConexion(conexion);
        }

        return listaDeDuenyosDeLaBD;
    }

    public static boolean crear(Duenyo duenyo) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean registro = false;

        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO JOSE_DUEÑO VALUES (?,?,?)");


            stmt.setString(1, duenyo.getNombreDueño());
            stmt.setString(2, duenyo.getDniDuenyo());
            stmt.setString(3, duenyo.getCodigoEquipo());

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
     * @param duenyo es el objeto de tipo Equipo que se pasa para ser actualizado en la BD.
     * @return retorna si la actualización está realizada o no (True or false).
     * @throws SQLException que se recoge de las posibles restricciones de la BD.
     * @method método que se encarga de realizar el UPDATE en la BD.
     */
    public static boolean actualizar(Duenyo duenyo) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean actualizacion = false;

        String nombre = duenyo.getNombreDueño();
        String dni = duenyo.getDniDuenyo();
        String codigo = duenyo.getCodigoEquipo();

        try {

            PreparedStatement stmt;
            stmt = conexion.prepareStatement("UPDATE JOSE_DUEÑO SET nombredue=?,dnidue=?,codigoequidue=? WHERE dnidue=?");
            stmt.setString(1, nombre);
            stmt.setString(2, dni);
            stmt.setString(3, codigo);
            stmt.setString(4, dni);

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
     * @param duenyo que se le pasa a función para que sea eliminado.
     * @return la variable borrado como True, si es borrado o False si es el caso contrario.
     * @throws SQLException que se lanza en el caso de detectar restricciones de la BD.
     * @method borrarDuenyo  que se encarga de eliminar un duenyo.
     */
    public static boolean borrarDuenyo(Duenyo duenyo) throws SQLException {
        boolean borrado = false;
        Connection conexion = ContraladorBd.abrirConecxion();

        try {

            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM JOSE_DUEÑO WHERE dnidue=?");
            stmt.setString(1, duenyo.getDniDuenyo());

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
