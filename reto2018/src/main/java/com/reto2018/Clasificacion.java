package com.reto2018;

public class Clasificacion {

    private String equipo;
    private int puntos;
    private int ganados;
    private int empatados;
    private int perdidos;

    public Clasificacion(String equipo, int puntos, int ganados, int empatados, int perdidos) {
        this.equipo = equipo;
        this.puntos = puntos;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }



    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getEmpatados() {
        return empatados;
    }

    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }
}
