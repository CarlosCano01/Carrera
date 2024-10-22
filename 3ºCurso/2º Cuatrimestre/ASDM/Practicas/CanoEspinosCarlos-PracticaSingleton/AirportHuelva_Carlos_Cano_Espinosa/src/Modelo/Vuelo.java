/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author carlo
 */
public class Vuelo {
    private String compañia;
    private String destino;
    private String numerovuelo;
    private String Puertaembarque;
    private String Estado;
    private String horasalida;
    private String horaLlegada;

    public Vuelo() {
    
    }

    public Vuelo(String compañia, String destino, String numerovuelo, String Puertaembarque, String Estado, String horasalida, String horaLlegada) {
        this.compañia = compañia;
        this.destino = destino;
        this.numerovuelo = numerovuelo;
        this.Puertaembarque = Puertaembarque;
        this.Estado = Estado;
        this.horasalida = horasalida;
        this.horaLlegada = horaLlegada;
    }
    public String getCompañia() {
        return compañia;
    }

    public String getDestino() {
        return destino;
    }

    public String getNumerovuelo() {
        return numerovuelo;
    }

    public String getPuertaembarque() {
        return Puertaembarque;
    }

    public String getEstado() {
        return Estado;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setNumerovuelo(String numerovuelo) {
        this.numerovuelo = numerovuelo;
    }

    public void setPuertaembarque(String Puertaembarque) {
        this.Puertaembarque = Puertaembarque;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    
}
