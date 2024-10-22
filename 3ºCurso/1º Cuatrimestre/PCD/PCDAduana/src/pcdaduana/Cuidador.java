/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcdaduana;

import java.awt.Canvas;
import java.util.concurrent.Semaphore;

/**
 *
 * @author usuario
 */
public class Cuidador extends Thread{
    Semaphore cuidador=null;
    Semaphore perro=null;
    CanvasAduana canvas=null;
    public Cuidador(Semaphore cui,Semaphore per, CanvasAduana can){
        this.cuidador=cui;
        this.perro=per;
        this.canvas=can;
    }
    @Override
    public void run(){
        try{
            while(true){
                int espera=(int)(Math.random()*(4000-1000+1)+1000);
                cuidador.acquire();
                canvas.cuidadorEntra();
                Thread.sleep(espera);
                //Galleta
                System.out.println("Dando galletita");
                canvas.cuidadorSale();
                Thread.sleep(1000);
                perro.release();
            }
        }catch(InterruptedException ex){
            System.out.println("Cuidador descansando");
        }  
    }
            
}
