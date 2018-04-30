package com.reto2018;

public class Resultado {

    private int resultado1;
    private int resultado2;
    private String fecha;



    public Resultado(int resultado1, int resultado2, String fecha) {
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getResultado1() {
        return resultado1;
    }

    public void setResultado1(int resultado1) {
        this.resultado1 = resultado1;
    }

    public int getResultado2() {
        return resultado2;
    }

    public void setResultado2(int resultado2) {
        this.resultado2 = resultado2;
    }
}
