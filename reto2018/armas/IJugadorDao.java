package jose.armas;

import java.util.List;

public interface IJugadorDao {

        public void registrar(Jugador jugador);
        public List<Jugador> obtener();
        public boolean actualizar(Jugador jugador);
        public boolean eliminar(Jugador jugador);

}
