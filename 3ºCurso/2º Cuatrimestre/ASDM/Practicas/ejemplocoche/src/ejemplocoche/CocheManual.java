/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplocoche;

/**
 *
 * @author carlo
 */
public class CocheManual {
    protected float revoluciones;
    protected int marcha;
    protected float velocidad;

    public CocheManual() {
        this.revoluciones = 0;
        this.marcha = 0;
        this.velocidad = 0;
    }
    
    public void aceleraCoche(float rev){
        System.out.println("Estoy en la marcah " + marcha);
        if (marcha==0){
            System.out.println("Estoy parado");
        }else
            velocidad+= (rev *0.3);
            revoluciones+= rev;
            switch (marcha) {
                case 1 :
                   if(revoluciones > 2500){
                       System.out.println("Has roto el motor");
                   }
                break;
                case 2:
                    if(revoluciones > 3500){
                     System.out.println("Has roto el motor");
                   }
                break;
                case 3:
                    if(revoluciones > 4500){
                     System.out.println("Has roto el motor");
                   }
                break;
                case 4:
                   if(revoluciones > 5500){
                     System.out.println("Has roto el motor");
                   }
                break;
                case 5:
                   if(revoluciones > 6500){
                     System.out.println("Has roto el motor");
                   }
                break;
            
        }      
    }
    
    public void subirMarcha(int e){
        marcha+=e;
        System.out.println("estas en la marcha " +marcha );
    }
    public void bajaMarcha(int m){
        marcha-=m;
        System.out.println("estas en la marcha " +marcha );
    }
    public void frenar(float m){
        velocidad-=m;
    }
}
