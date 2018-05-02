package com.reto2018;

public class Dueños {

    private String nombredue;
    private String dnidue;
    private String codigoequidue;

    public Dueños(String nombredue, String dnidue, String codigoequidue) {
        this.nombredue = nombredue;
        this.dnidue = dnidue;
        this.codigoequidue = codigoequidue;
    }

    public String getNombredue() {
        return nombredue;
    }

    public void setNombredue(String nombredue) {
        this.nombredue = nombredue;
    }

    public String getDnidue() {
        return dnidue;
    }

    public void setDnidue(String dnidue) {
        this.dnidue = dnidue;
    }

    public String getCodigoequidue() {
        return codigoequidue;
    }

    public void setCodigoequidue(String codigoequidue) {
        this.codigoequidue = codigoequidue;
    }
}
