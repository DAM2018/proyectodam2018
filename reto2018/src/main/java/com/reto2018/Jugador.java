package com.reto2018;

import java.math.BigDecimal;

public class Jugador {

    private String nombrejug;
    private String nick;
    private int sueldo;
    private String dnijug;
    private String caracteristicas;
    private String codigoequijug;


    public Jugador(String nombrejug, String nick, int sueldo, String dnijug, String caracteristicas, String equipo_codigoequi) {
        this.nombrejug = nombrejug;
        this.nick = nick;
        this.sueldo = sueldo;
        this.dnijug = dnijug;
        this.caracteristicas = caracteristicas;
        this.codigoequijug = equipo_codigoequi;
    }

    @Override
    public String toString() {
        return nombrejug + '\t' +
                nick + '\t' +
                sueldo + '\t' +
                dnijug + '\t' +
                caracteristicas + '\t' +
                codigoequijug;
    }

    public String getNombrejug() {
        return nombrejug;
    }

    public void setNombrejug(String nombrejug) {
        this.nombrejug = nombrejug;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getDnijug() {
        return dnijug;
    }

    public void setDnijug(String dnijug) {
        this.dnijug = dnijug;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getcodigoequijug() {
        return codigoequijug;
    }

    public void setEquipo_codigoequi(String equipo_codigoequi) {
        this.codigoequijug = codigoequijug;
    }
}
