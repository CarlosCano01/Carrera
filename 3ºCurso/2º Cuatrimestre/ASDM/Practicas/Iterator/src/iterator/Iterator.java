/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iterator;

/**
 *
 * @author feligomeez
 */
public class Iterator {

    public static void main(String[] args) {
        IAgregado in = new AgregadoConcreto();
        System.out.println("Introduzco datos: ");
        for (int i = 0; i < 10; i++) 
            in.Agregar(i);
            
         IIterador it = in.crearIterador();
         while(it.tieneSiguiente())
             System.out.print(it.Siguiente());
        
         System.out.println("");
         IIterador it2 = in.crearIterador2();
         while(it2.tieneSiguiente())
             System.out.print(it2.Siguiente());
    }
    
}
