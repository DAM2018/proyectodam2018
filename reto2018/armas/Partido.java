package jose.armas;

import java.util.List;
import java.util.Objects;

public class Partido {

    private String numeroPartido;
    private String local;
    private String visitante;
    private String resultado;
    private String fecha;

    //Asociaciones.
    private List<Equipo>equipos;
    private Jornada jornada;

    public Partido() {
    }

    public Partido(String numeroPartido, String local, String visitante, String resultado, Jornada jornada) {
        this.numeroPartido = numeroPartido;
        this.local = local;
        this.visitante = visitante;
        this.resultado = resultado;
        this.jornada = jornada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumeroPartido() {
        return numeroPartido;
    }

    public void setNumeroPartido(String numeroPartido) {
        this.numeroPartido = numeroPartido;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return Objects.equals(numeroPartido, partido.numeroPartido);
    }

    @Override
    public int hashCode() {

        return Objects.hash(numeroPartido);
    }

    @Override
    public String toString() {
        return "Partido{" +
                "numeroPartido='" + numeroPartido + '\'' +
                ", local='" + local + '\'' +
                ", visitante='" + visitante + '\'' +
                ", resultado=" + resultado +
                ", jornada=" + jornada +
                '}';
    }
}
