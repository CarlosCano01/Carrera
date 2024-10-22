/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantilladecorador1;

/**
 *
 * @author carlo
 */
public class DecoradorConcretroA extends Decorador{
    
    public DecoradorConcretroA(IComponenteAbstracto componente) {
        super(componente);
    }
    protected void visualizaInformacionDecorador1(){
        System.out.println("Informacion que añade decorador1");
    }
    public void visualiza(){
        super.visualiza();
        this.visualizaInformacionDecorador1();
    }
}
