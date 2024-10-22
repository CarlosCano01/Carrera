/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcd;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Consumidor implements Runnable{
    ColaLenta lacola;
    Object elemneto;
    public Consumidor(ColaLenta cola){
        this.lacola=cola;
        elemneto=null;
    }
    
    public void consumir() throws Exception{
        java.util.Random aleatorio = new java.util.Random();
        for (int i = 0; i < 15; i++) {
            int t = (int)(aleatorio.nextInt(1,3));
            Thread.sleep(t);
            elemneto=lacola.Desacola();
            System.out.println("Desacolando el dato "+elemneto+ "por el hilo "+Thread.currentThread().getName() +"\n" );
        }
        System.out.println("Cerrando aplicacion");
        System.exit(1);
    }
    
    @Override
    public void run(){
        try {
            consumir();
        } catch (Exception ex) {
            System.out.println("ERROR "+ ex.getMessage());
        }
    }
}
