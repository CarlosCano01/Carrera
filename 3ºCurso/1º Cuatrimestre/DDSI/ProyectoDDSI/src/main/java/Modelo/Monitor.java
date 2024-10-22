/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public class Monitor {

    private String cdMonitor;
    private String nombre;
    private String dni;
    private String telefono;
    private String correo;
    private String fechaEntrada;
    private String nick;

    public Monitor() {
        cdMonitor = null;
        nombre = null;
        dni = null;
        telefono = null;
        correo = null;
        fechaEntrada = null;
        nick = null;
    }
    
    public Monitor(String cdMonitor,String nombre,String dni,String telefono,String correo,String fechaEntrada,String nick){
        this.cdMonitor = cdMonitor;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaEntrada = fechaEntrada;
        this.nick = nick;
     }
    
    public void setCdMonitor(String cdMonitor) {
        this.cdMonitor = cdMonitor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCdMonitor() {
        return cdMonitor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getNick() {
        return nick;
    }
    
}
