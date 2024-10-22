/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plant_decorador2;

/**
 *
 * @author carlo
 */
public class Decorador implements ICompoennte{
    
    protected ICompoennte componente;

    public Decorador(ICompoennte c) {
        this.componente=c;
    }
    
    @Override
    public String getDescripcion() {
        return componente.getDescripcion();
    }

    @Override
    public float getPrecio() {
         return componente.getPrecio();
    }
    
}
