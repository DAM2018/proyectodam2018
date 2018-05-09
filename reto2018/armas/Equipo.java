package jose.armas;

import java.util.Objects;

public class Equipo {

    private String nombre;
    private String codigo;
    private int ganado;
    private int empatado;
    private int perdido;
    private String dniDuenyoEquipo;

    //Asociaciones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;
    private Jugador jugadorClaseConexion;


    public Equipo(String nombre, String codigo, int ganado, int empatado, int perdido, String dniDuenyoEquipo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ganado = ganado;
        this.empatado = empatado;
        this.perdido = perdido;
        this.dniDuenyoEquipo = dniDuenyoEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getGanado() {
        return ganado;
    }

    public void setGanado(int ganado) {
        this.ganado = ganado;
    }

    public int getEmpatado() {
        return empatado;
    }

    public void setEmpatado(int empatado) {
        this.empatado = empatado;
    }

    public int getPerdido() {
        return perdido;
    }

    public void setPerdido(int perdido) {
        this.perdido = perdido;
    }

    public String getDniDuenyoEquipo() {
        return dniDuenyoEquipo;
    }

    public void setDniDuenyoEquipo(String dniDuenyoEquipo) {
        this.dniDuenyoEquipo = dniDuenyoEquipo;
    }

    public VentanaMenuAdministrador getVentanaMenuAdministrador() {
        return ventanaMenuAdministrador;
    }

    public void setVentanaMenuAdministrador(VentanaMenuAdministrador ventanaMenuAdministrador) {
        this.ventanaMenuAdministrador = ventanaMenuAdministrador;
    }

    public Jugador getJugadorClaseConexion() {
        return jugadorClaseConexion;
    }

    public void setJugadorClaseConexion(Jugador jugadorClaseConexion) {
        this.jugadorClaseConexion = jugadorClaseConexion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre) &&
                Objects.equals(codigo, equipo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, codigo);
    }

    @Override
    public String toString() {
        return ""+nombre+"  "+codigo;
    }
}
