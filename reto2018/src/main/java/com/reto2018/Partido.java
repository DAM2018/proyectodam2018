package com.reto2018;

public class Partido {

    private String fecha;
    private int jornada;
    private int resultado1;
    private int resultado2;
   // private String codigopar;
    private String nombreequiloc;
    private String nombreequivis;




    public Partido(String fecha, int jornada, int resultado1, int resultado2, String codigopar, String codigoequiloc, String codigoequivis) {
        this.fecha = fecha;
        this.jornada = jornada;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
     //   this.codigopar = codigopar;
        this.nombreequiloc = codigoequiloc;
        this.nombreequivis = codigoequivis;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
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


    public String getCodigoequiloc() {
        return nombreequiloc;
    }

    public void setCodigoequiloc(String codigoequiloc) {
        this.nombreequiloc = codigoequiloc;
    }

    public String getCodigoequivis() {
        return nombreequivis;
    }

    public void setCodigoequivis(String codigoequivis) {
        this.nombreequivis = codigoequivis;
    }
}
