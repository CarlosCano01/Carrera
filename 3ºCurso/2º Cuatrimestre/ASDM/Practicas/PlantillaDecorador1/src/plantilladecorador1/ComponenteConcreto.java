/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantilladecorador1;

/**
 *
 * @author carlo
 */
public class ComponenteConcreto implements IComponenteAbstracto{

    
    @Override
    public void visualiza() {
        System.out.println("Visualizacion basica sin decorar");  
    }
    
}
