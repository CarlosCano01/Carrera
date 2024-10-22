/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public class Socio {
    String numSocio;
    String nombre;
    String dni;
    String fechaNacimiento;
    String telefono;
    String correo;
    String fechaEntrada;
    String categoria;
    
    public Socio(){
        numSocio = null;
        nombre = null;
        dni = null;
        fechaNacimiento = null;
        telefono = null;
        correo = null;
        fechaEntrada = null;
        categoria = null;
    }
    public Socio(String numSocio,String nombre,String dni,String fechaNacimiento,String telefono,String correo,String fechaEntrada,String categoria){
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaEntrada = fechaEntrada;
        this.categoria = categoria;
    }

    public void setNumSocio(String numSocio) {
        this.numSocio = numSocio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
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

    public String getCategoria() {
        return categoria;
    }
    
}
