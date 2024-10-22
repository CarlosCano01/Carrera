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
public class ViajeroMaleta extends Thread{
    Semaphore cuidador=null;            
    Semaphore perro=null;              
    Semaphore rayoMaleta=null;
    CanvasAduana canvas=null;
    
    public ViajeroMaleta(Semaphore cui,Semaphore per,Semaphore rMaleta, CanvasAduana can) throws InterruptedException{
        this.cuidador=cui;
        this.perro=per;
        this.rayoMaleta=rMaleta;
        this.canvas=can;
    }

    @Override
    public void run(){
        try {
            int id=(int) threadId();
            canvas.colaMaleta(id);
            rayoMaleta.acquire();
            canvas.contador_maletaRayo(id);
            int espera=(int)(Math.random()*(5000-2000+1)+1000);
            System.out.println("Perosna " +Thread.currentThread().getId()+ " esperando rayo Maleta");
            perro.acquire();
            rayoMaleta.release();
            canvas.perroMaleta(id);
            //Perro
            System.out.println("Perro olfanteando a " +Thread.currentThread().getId());
            Thread.sleep(espera);
            System.out.println("Perro termina de olfantear a " +Thread.currentThread().getId());
            canvas.perroSale(id);
            System.out.println("Perosna "+ Thread.currentThread().getId()+" se va");
            cuidador.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ViajeroMaleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
