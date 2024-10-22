/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plant_decorador2;

/**
 *
 * @author carlo
 */
public class DecoradorConcretoA extends Decorador{
    
    private String decripcion_BasicaA="\nDescripcion decorador A";
    private float precio=100;
    
    public DecoradorConcretoA(ICompoennte c) {
        super(c);
    }
    
    public float getPrecioDecoradorA(){
        return precio;
    }
    public String getDescripcionDecoradorA(){
        return decripcion_BasicaA;
    }
    public String getDescripcion(){
        return super.getDescripcion()+this.getDescripcionDecoradorA();
    }
    public float getPrecio(){
        float suma;
        suma=super.getPrecio()+this.getPrecioDecoradorA();
        return suma;
    }
}
