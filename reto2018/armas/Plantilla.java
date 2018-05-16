package jose.armas;

import java.util.List;
import java.util.Objects;

public class Plantilla {

    private String codigo;
    private String nameJugador;
    private Integer sueldo;

    //Asociacion.
    private List<Jugador> jugadores;

    public Plantilla(String string, String rsString, int anInt) {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNameJugador() {
        return nameJugador;
    }

    public void setNameJugador(String nameJugador) {
        this.nameJugador = nameJugador;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plantilla plantilla = (Plantilla) o;
        return Objects.equals(codigo, plantilla.codigo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Plantilla{" +
                "codigo='" + codigo + '\'' +
                ", nameJugador='" + nameJugador + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
