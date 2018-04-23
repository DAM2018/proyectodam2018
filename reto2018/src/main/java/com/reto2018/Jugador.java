package com.reto2018;

public class Jugador {

    private String nombrejug;
    private String nick;
    private int sueldo;
    private String dnijug;
    private String caracteristicas;
    private int equipo_codigoequi;


    public Jugador(String nombrejug, String nick, int sueldo, String dnijug, String caracteristicas, int equipo_codigoequi) {
        this.nombrejug = nombrejug;
        this.nick = nick;
        this.sueldo = sueldo;
        this.dnijug = dnijug;
        this.caracteristicas = caracteristicas;
        this.equipo_codigoequi = equipo_codigoequi;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombrejug='" + nombrejug + '\'' +
                ", nick='" + nick + '\'' +
                ", sueldo=" + sueldo +
                ", dnijug='" + dnijug + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", equipo_codigoequi=" + equipo_codigoequi +
                '}';
    }
}
