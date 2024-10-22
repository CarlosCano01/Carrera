/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plnatillaadaptador;

/**
 *
 * @author carlo
 */
public class Adaptador extends Adaptado implements ITarget{
    
    public Adaptador(String n) {
        super(n);
    }
    
    @Override
    public void mostrarNombre(int n){
        if(n==1){
            mostrarNombre("Mayuscula");
        }else
            mostrarNombre("minuscula");
    }
}
