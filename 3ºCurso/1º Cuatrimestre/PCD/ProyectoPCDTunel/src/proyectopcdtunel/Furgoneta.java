/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcdtunel;

/**
 *
 * @author usuario
 */
public class Furgoneta implements Runnable{
    
    private Tunel tunel=null;
    
    public Furgoneta(Tunel tunel){
        this.tunel=tunel;
    }
    
    @Override
    public void run(){
        try {
            int posicion=tunel.EntraFurgo();
            Thread.sleep(2000);
            tunel.SaleFurgo(posicion);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
