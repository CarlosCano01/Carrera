/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterator;

/**
 *
 * @author feligomeez
 */
public class AgregadoConcreto implements IAgregado{
    private int numeros[];
    private int posicion;
    public AgregadoConcreto(){
        numeros = new int[10];
        posicion = 0;
    }
    
    @Override
    public void Agregar(int a){
        numeros[posicion++] = a;
    }

    @Override
    public IIterador crearIterador() {
        return new Cola(numeros);
    }

    @Override
    public IIterador crearIterador2() {
        return new Pila(numeros);
    }
        
    
}
