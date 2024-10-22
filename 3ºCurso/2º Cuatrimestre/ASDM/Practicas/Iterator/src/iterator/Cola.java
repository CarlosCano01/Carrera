/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterator;

/**
 *
 * @author feligomeez
 */
public class Cola implements IIterador{
    private int numeros[];
    private int posicion;
    
    public Cola(int num[]){
        this.numeros = num;
        posicion = 0;
    }

    @Override
    public Object Siguiente() {
        return numeros[posicion++];
    }

    @Override
    public Object Anterior() {
        if(posicion > 0)
            return numeros[--posicion];
        else 
            return null;
    }

    @Override
    public boolean tieneSiguiente() {
        if(posicion < numeros.length && numeros[posicion] != -1)
            return true;
        else 
            return false;
    }
    
}
