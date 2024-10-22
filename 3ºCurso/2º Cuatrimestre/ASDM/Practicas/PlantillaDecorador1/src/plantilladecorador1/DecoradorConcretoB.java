/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantilladecorador1;

/**
 *
 * @author carlo
 */
public class DecoradorConcretoB extends Decorador{
    
    public DecoradorConcretoB(IComponenteAbstracto componente) {
        super(componente);
    }
    protected void visualizaInformacionDecorador2(){
        System.out.println("Informacion que añade decorador2");
    }

    public void visualiza(){
        super.visualiza();
        this.visualizaInformacionDecorador2();
    }
    
}
