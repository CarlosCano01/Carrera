/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantilladecorador1;

/**
 *
 * @author carlo
 */
public abstract class Decorador implements IComponenteAbstracto{
    protected IComponenteAbstracto compoente;

    public Decorador(IComponenteAbstracto co) {
        this.compoente=co;
    }
    
    public void visualiza(){
        compoente.visualiza();
    }
}
