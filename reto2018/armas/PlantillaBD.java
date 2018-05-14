package jose.armas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlantillaBD {

    public static List<Plantilla> listarPlantilla() throws SQLException {

        List<Plantilla> lista = new ArrayList<>();

        Connection conexion=null;
        try {
            conexion = ContraladorBd.abrirConecxion();

            Statement st =conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM JOSE_Plantilla");

            while (rs.next()) {

                lista.add(
                        new Plantilla(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3)
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


}
