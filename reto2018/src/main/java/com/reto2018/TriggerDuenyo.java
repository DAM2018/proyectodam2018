package com.reto2018;

import java.util.Date;

public class TriggerDuenyo {


    private String duenyo;
    private String accion;
    private Date fecha;
    private String administrador;


    public TriggerDuenyo(String duenyo, String accion, Date fecha, String administrador) {
        this.duenyo = duenyo;
        this.accion = accion;
        this.fecha = fecha;
        this.administrador = administrador;
    }


    public String getDuenyo() {
        return duenyo;
    }

    public void setDuenyo(String duenyo) {
        this.duenyo = duenyo;
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
