/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plnatillaadaptador;

import java.awt.BorderLayout;


public class Adaptado {
    private String nombre;
    public Adaptado(String n){
        nombre =n; 
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void mostrarNombre(String forma){
        if(forma.equalsIgnoreCase("MAYUSCULAS"))
            System.out.println("EL NOMBRE ES " + nombre.toUpperCase());
        else 
            System.out.println("El nombre es "+ nombre.toLowerCase());
    }
    
}
