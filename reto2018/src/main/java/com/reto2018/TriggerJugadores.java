package com.reto2018;

import java.util.Date;

public class TriggerJugadores {

    private String jugador;
    private String accion;
    private Date fecha;
    private String administrador;

    public TriggerJugadores(String jugador, String accion, Date fecha, String administrador) {
        this.jugador = jugador;
        this.accion = accion;
        this.fecha = fecha;
        this.administrador = administrador;
    }


    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }
}
