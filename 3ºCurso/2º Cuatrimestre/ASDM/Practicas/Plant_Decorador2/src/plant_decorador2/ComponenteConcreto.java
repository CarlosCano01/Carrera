/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plant_decorador2;

/**
 *
 * @author carlo
 */
public class ComponenteConcreto implements  ICompoennte{
    private String decripcion_Basica="Caracteristica Basica";
    private float precio=100;
    @Override
    public String getDescripcion() {
        return decripcion_Basica;
    }

    @Override
    public float getPrecio() {
        return precio;
    }
    
}
