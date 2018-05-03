package jose.armas;
/**
 * @author jose armas.
 */

import java.util.Objects;

/**
 * Esta clase representa a un jugador.
 */
public class Jugador {
    /**
     * Descripción de nombreJugador.
     */
    private String nombreJugador;
    /**
     *
     */
    private String nickJugador;
    private int sueldoJugador;
    private String dniJugador;
    private String caracteristicasJugador;
    private String codigoEquipoJugador;

    public Jugador() {
    }

    public Jugador(String nombreJugador, String nickJugador, int sueldoJugador, String dniJugador,
                   String caracteristicasJugador, String codigoEquipoJugador) {
        this.nombreJugador = nombreJugador;
        this.nickJugador = nickJugador;
        this.sueldoJugador = sueldoJugador;
        this.dniJugador = dniJugador;
        this.caracteristicasJugador = caracteristicasJugador;
        this.codigoEquipoJugador = codigoEquipoJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNickJugador() {
        return nickJugador;
    }

    public void setNickJugador(String nickJugador) {
        this.nickJugador = nickJugador;
    }

    public int getSueldoJugador() {
        return sueldoJugador;
    }

    public void setSueldoJugador(int sueldoJugador) {
        this.sueldoJugador = sueldoJugador;
    }

    public String getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(String dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getCaracteristicasJugador() {
        return caracteristicasJugador;
    }

    public void setCaracteristicasJugador(String caracteristicasJugador) {
        this.caracteristicasJugador = caracteristicasJugador;
    }

    public String getCodigoEquipoJugador() {
        return codigoEquipoJugador;
    }

    public void setCodigoEquipoJugador(String codigoEquipoJugador) {
        this.codigoEquipoJugador = codigoEquipoJugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombreJugador, jugador.nombreJugador) &&
                Objects.equals(dniJugador, jugador.dniJugador);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombreJugador, dniJugador);
    }

    @Override
    public String toString() {
        return nombreJugador+" "+nickJugador;
    }
}
