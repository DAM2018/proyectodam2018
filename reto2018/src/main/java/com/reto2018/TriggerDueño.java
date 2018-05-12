package com.reto2018;

import java.util.Date;

public class TriggerDueño {


    private String dueño;
    private String accion;
    private Date fecha;
    private String administrador;


    public TriggerDueño(String dueño, String accion, Date fecha, String administrador) {
        this.dueño = dueño;
        this.accion = accion;
        this.fecha = fecha;
        this.administrador = administrador;
    }


    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
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
