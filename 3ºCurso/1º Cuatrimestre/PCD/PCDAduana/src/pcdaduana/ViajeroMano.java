/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcdaduana;

import java.awt.Canvas;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ViajeroMano implements Runnable{
    Semaphore cuidador=null;            
    Semaphore perro=null;              
    Semaphore rayoMano=null;
    CanvasAduana canvas=null;
    
    public ViajeroMano(Semaphore cui,Semaphore per,Semaphore rMano, CanvasAduana can) throws InterruptedException{
        this.cuidador=cui;
        this.perro=per;
        this.rayoMano=rMano;
        this.canvas=can;
    }

    
    @Override
    public void run(){
        try {
            int id=(int) Thread.currentThread().getId();
            canvas.colaMano(id);
            rayoMano.acquire();
            //Rayos Maleta
            canvas.contador_manoRayo(id);
            int espera=(int)(Math.random()*(4000-1000+1)+1000);
            System.out.println("Perosna " +Thread.currentThread().getId()+ " esperando rayo Mano");
            Thread.sleep(espera);
            perro.acquire();
            rayoMano.release();
            canvas.perroMano();
            //Perro
            System.out.println("Perro olfanteando a " +Thread.currentThread().getId());

            Thread.sleep(espera);
            System.out.println("Perro termina de olfantear a " +Thread.currentThread().getId());
            canvas.perroSale(id);
            System.out.println("Perosna "+ Thread.currentThread().getId()+" se va");
            cuidador.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ViajeroMano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
