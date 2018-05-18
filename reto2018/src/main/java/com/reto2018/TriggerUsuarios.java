package com.reto2018;

import java.util.Date;

public class TriggerUsuarios {

    private String usuario;
    private String accion;
    private Date fecha;
    private String administrador;

    public TriggerUsuarios(String usuario, String accion, Date fecha, String administrador) {
        this.usuario = usuario;
        this.accion = accion;
        this.fecha = fecha;
        this.administrador = administrador;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
