/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcd;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class Productor extends Thread{
    private ColaLenta lacola;

    
    public Productor(ColaLenta cola){
        this.lacola=cola;
    }
    public void Producir() throws Exception{
        java.util.Random aleatorio = new java.util.Random();
        for (int i = 0; i < 15; i++) {
            int random = (int)(aleatorio.nextInt(10));
            int t = (int)(aleatorio.nextInt(1,3));
            Thread.sleep(t);
            System.out.println("Acolando el dato "+random + " por el hilo "+Thread.currentThread().getName()+"\n"  );
            lacola.Acola(random);
        }
    }
    @Override
    public void run(){
        try {
            Producir();
        } catch (Exception ex) {
            System.out.println("ERROR "+ ex.getMessage()+" " +Thread.currentThread().getName());
        }
    }
}
