/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public class Actividad {
    
    String idActividad;
    String nombre;
    String descripcion;
    String precioBasesMes;
    
    public Actividad(){
        idActividad = null;
        nombre = null;
        descripcion = null;
        precioBasesMes = null;    
    }
    
    public Actividad(String idActividad,String nombre,String descripcion,String precioBasesMes){
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBasesMes = precioBasesMes;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioBasesMes(String precioBasesMes) {
        this.precioBasesMes = precioBasesMes;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecioBasesMes() {
        return precioBasesMes;
    }
    
}
