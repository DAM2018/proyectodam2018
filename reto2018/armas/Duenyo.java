package jose.armas;

import java.util.List;
import java.util.Objects;

public class Duenyo {

    private String nombreDuenyo;
    private String dniDuenyo;
    private String codigoEquipo;

    //Asociación.
    private List<Jugador> jugadorList;
    private Equipo equipo;
    private VentanaMenuDuenyo ventanaMenuDuenyo;

    public VentanaMenuDuenyo getVentanaMenuDuenyo() {
        return ventanaMenuDuenyo;
    }

    public void setVentanaMenuDuenyo(VentanaMenuDuenyo ventanaMenuDuenyo) {
        this.ventanaMenuDuenyo = ventanaMenuDuenyo;
    }

    public Equipo getEquipo() {
        return equipo;
    }



    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }


    //Constructores.

    public Duenyo() {
    }

    public Duenyo(String nombreDueño, String dniDueño, String codigoEquipo) {
        this.nombreDuenyo = nombreDueño;
        this.dniDuenyo = dniDueño;
        this.codigoEquipo = codigoEquipo;
    }

    public String getNombreDueño() {
        return nombreDuenyo;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDuenyo = nombreDueño;
    }

    public String getDniDuenyo() {
        return dniDuenyo;
    }

    public void setDniDuenyo(String dniDuenyo) {
        this.dniDuenyo = dniDuenyo;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duenyo duenyo = (Duenyo) o;
        return Objects.equals(nombreDuenyo, duenyo.nombreDuenyo) &&
                Objects.equals(dniDuenyo, duenyo.dniDuenyo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombreDuenyo, dniDuenyo);
    }

    @Override
    public String toString() {
        return nombreDuenyo;
    }
}
