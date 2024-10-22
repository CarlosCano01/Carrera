/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplocoche;

/**
 *
 * @author carlo
 */
public class Adaptador extends CocheManual implements IMandos{
    public float getRevoluciones(){
        return revoluciones;
    }

    public int getMarcha() {
        return marcha;
    }

    public float getVelocidad() {
        return velocidad;
    }
    @Override
    public void acelera(float rev) {
            if(getMarcha()==0){
                subirMarcha(1);
            }else
                acelera(rev);
            if(getRevoluciones()>4500){
                subirMarcha(4);
            }else if(getRevoluciones()>3500){
                subirMarcha(3);
            }else if(getRevoluciones()>2500){
                subirMarcha(2);
            }else if(getRevoluciones()>1500){
                subirMarcha(1);
            }
            System.out.println("Estas en la marcha "+ marcha);
            System.out.println("Estas en la velocidad " + velocidad);
    }
    

    @Override
    public void frena(float rev) {
        
            frena(rev);
            if(getRevoluciones()<4500){
                bajaMarcha(1);
            }else if(getRevoluciones()<3500){
                bajaMarcha(1);
            }else if(getRevoluciones()<2500){
                bajaMarcha(1);
            }else if(getRevoluciones()<1500){
                bajaMarcha(1);
            }
            velocidad +=rev*03;
            System.out.println("Estas en la marcha "+ marcha);
            System.out.println("Estas en la velocidad " + velocidad);
    }
    
}
