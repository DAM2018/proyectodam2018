package jose.armas;

import java.util.List;
import java.util.Objects;

public class Equipo {

    private String nombre;
    private String codigo;
    private int ganado;
    private int empatado;
    private int perdido;
    private String dniDuenyoEquipo;
    private boolean asigandoDuenyo;
    private String jornada;

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    //Asociaciones.
    private VentanaMenuAdministrador ventanaMenuAdministrador;
    private Jugador jugadorClaseConexion;
    private List<Jugador> jugadorList;
    private Duenyo duenyo;
    private VentanaMenuDuenyo ventanaMenuDuenyo;
    private List<Jornada>jornadas;
    private List<Partido>partidos;

    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public List<Jornada> getJornadas() {
        return jornadas;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public VentanaMenuDuenyo getVentanaMenuDuenyo() {
        return ventanaMenuDuenyo;
    }

    public void setVentanaMenuDuenyo(VentanaMenuDuenyo ventanaMenuDuenyo) {
        this.ventanaMenuDuenyo = ventanaMenuDuenyo;
    }

    public Duenyo getDuenyo() {
        return duenyo;
    }

    public void setDuenyo(Duenyo duenyo) {
        this.duenyo = duenyo;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public Equipo() {
    }

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

    public boolean isAsigandoDuenyo() {
        return asigandoDuenyo;
    }

    public void setAsigandoDuenyo(boolean asigandoDuenyo) {
        this.asigandoDuenyo = asigandoDuenyo;
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
