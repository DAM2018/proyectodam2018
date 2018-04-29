package com.reto2018;

public class Equipo {

    private String nombreequi;
    private String codigoequi;
    private int ganandos;
    private int empates;
    private int perdidos;

    public Equipo(String nombreequi, String codigoequi, int ganandos, int empates, int perdidos) {
        this.nombreequi = nombreequi;
        this.codigoequi = codigoequi;
        this.ganandos = ganandos;
        this.empates = empates;
        this.perdidos = perdidos;
    }

    public String getNombreequi() {
        return nombreequi;
    }

    public void setNombreequi(String nombreequi) {
        this.nombreequi = nombreequi;
    }

    public String getCodigoequi() {
        return codigoequi;
    }

    public void setCodigoequi(String codigoequi) {
        this.codigoequi = codigoequi;
    }

    public int getGanandos() {
        return ganandos;
    }

    public void setGanandos(int ganandos) {
        this.ganandos = ganandos;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }
}
