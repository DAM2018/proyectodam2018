package jose.armas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBD {

    public static List<Usuario> usuariosDelaBd() throws SQLException {

        List<Usuario> listaDeUsuariosDeLaBD = new ArrayList<>();

        Connection conexion = ContraladorBd.abrirConecxion();

        Statement declaracion;

        {
            try {
                declaracion = conexion.createStatement();
                ResultSet rs = declaracion.executeQuery("SELECT * FROM usuario");

                while (rs.next()) {
                    listaDeUsuariosDeLaBD.add(
                            new Usuario(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5)
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

        return listaDeUsuariosDeLaBD;
    }

    public static boolean crear(Usuario usuario) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean registro = false;

        try {
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?,?)");


            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getMail());
            stmt.setString(3, usuario.getDni());
            stmt.setString (4,usuario.getUser());
            stmt.setString (5,usuario.getPassword());


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
     * @param usuario es el objeto de tipo Usuario que se pasa para ser actualizado en la BD.
     * @return retorna si la actualización está realizada o no (True or false).
     * @throws SQLException que se recoge de las posibles restricciones de la BD.
     * @method método que se encarga de realizar el UPDATE en la BD.
     */
    public static boolean actualizar(Usuario usuario) throws SQLException {

        Statement stm = null;
        Connection conexion = ContraladorBd.abrirConecxion();

        boolean actualizacion = false;

        String nombre = usuario.getNombre();
        String dni = usuario.getDni();
        String mail = usuario.getMail();
        String user = usuario.getUser();
        String contra = usuario.getPassword();

        try {

            PreparedStatement stmt;
            stmt = conexion.prepareStatement
                    ("UPDATE usuario SET nombre=?,mail=?,dni=?,usuario=?,contraseña=? WHERE dni=?");
            stmt.setString(1, nombre);
            stmt.setString(2, mail);
            stmt.setString(3, dni);
            stmt.setString(4, user);
            stmt.setString(5, contra);
            stmt.setString(6, dni);


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
     * @param usuario que se le pasa a función para que sea eliminado.
     * @return la variable borrado como True, si es borrado o False si es el caso contrario.
     * @throws SQLException que se lanza en el caso de detectar restricciones de la BD.
     * @method borrarDuenyo  que se encarga de eliminar un usuario.
     */
    public static boolean borrarUsuario(Usuario usuario) throws SQLException {
        boolean borrado = false;
        Connection conexion = ContraladorBd.abrirConecxion();

        try {

            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM usuario  WHERE dni=?");
            stmt.setString(1, usuario.getDni());

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
