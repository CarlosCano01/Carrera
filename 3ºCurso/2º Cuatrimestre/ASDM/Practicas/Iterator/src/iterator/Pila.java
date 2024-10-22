/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterator;

/**
 *
 * @author feligomeez
 */
public class Pila implements IIterador{
    private int numeros[];
    private int posicion;
    
    public Pila(int num[]){
        this.numeros = num;
        this.posicion = num.length - 1;
    }
    
    
    @Override
    public Object Siguiente() {
        return numeros[posicion--];
    }

    @Override
    public Object Anterior() {
        if(posicion < numeros.length - 1)
            return numeros[++posicion];
        else 
            return null;
    }

    @Override
    public boolean tieneSiguiente() {
        if(posicion >= 0)
            return true;
        else 
            return false;
    }
    
}
