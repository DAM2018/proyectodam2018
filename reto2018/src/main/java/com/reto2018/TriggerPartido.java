package com.reto2018;

import java.util.Date;

public class TriggerPartido {

    private String equipoloc;
    private String equipovis;
    private String accion;
    private Date fecha;
    private String administrador;


    public TriggerPartido(String equipoloc, String equipovis, String accion, Date fecha, String administrador) {
        this.equipoloc = equipoloc;
        this.equipovis = equipovis;
        this.accion = accion;
        this.fecha = fecha;
        this.administrador = administrador;
    }


    public String getEquipoloc() {
        return equipoloc;
    }

    public void setEquipoloc(String equipoloc) {
        this.equipoloc = equipoloc;
    }

    public String getEquipovis() {
        return equipovis;
    }

    public void setEquipovis(String equipovis) {
        this.equipovis = equipovis;
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
