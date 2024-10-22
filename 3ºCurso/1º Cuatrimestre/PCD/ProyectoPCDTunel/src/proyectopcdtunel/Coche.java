/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcdtunel;

/**
 *
 * @author usuario
 */
public class Coche extends Thread{          //Hereda de la clase Thread
    
    private Tunel tunel=null;
    
    public Coche(Tunel tunel){
        this.tunel=tunel;
    }
    
    @Override
    public void run(){
        try {
            int posicion=tunel.EntraCoche();
            Thread.sleep(1000);
            tunel.SaleCoche(posicion);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
    
}
