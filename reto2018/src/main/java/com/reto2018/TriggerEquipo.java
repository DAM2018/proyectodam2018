package com.reto2018;

import java.util.Date;

public class TriggerEquipo {


    private String equipo;
    private String accion;
    private Date fecha;
    private String administrador;

    public TriggerEquipo(String equipo, String accion, Date fecha, String administrador) {
        this.equipo = equipo;
        this.accion = accion;
        this.fecha = fecha;
        this.administrador = administrador;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
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
