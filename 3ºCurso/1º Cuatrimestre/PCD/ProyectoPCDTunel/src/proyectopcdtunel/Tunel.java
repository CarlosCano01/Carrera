/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcdtunel;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Tunel {
    
    public final int NTuneles=3;
    public int libres;                                 //Esta variable controla los espacios libres que quedan en los tuneles
    private CanvasTunel Canvas= null;
    ArrayList<String> Tunel=null;                                       //Creamos una ArrayList
    
    public Tunel(CanvasTunel v){
        Tunel=new ArrayList<>(NTuneles);
        libres=NTuneles; 
        for (int i = 0; i < NTuneles; i++) {
            Tunel.add(i, "v");
        }
        Canvas=v ;
    }
    public synchronized int EntraCoche() throws InterruptedException{
        int tunelQueOcupa=0;
        boolean encontrado=false;           //Creamos un booleano para salir del while cuando encontremos el hueco                        
                                            //Meterlo en la cola
        while(libres==0){                   //Mientras que no haya un espacio libre
            wait();                         //esperamos a que un espacio quede libre 
        }
        libres--;                           //Quitamos un espacio libre
        while(tunelQueOcupa<NTuneles && !encontrado){
            if(Tunel.get(tunelQueOcupa)=="v"){
                Tunel.remove(tunelQueOcupa);
                Tunel.add(tunelQueOcupa, "c");
                encontrado=true;
            }else
                tunelQueOcupa++;
        }
        encontrado=false;
        
        System.out.println("Coche entra en el tunel: "+tunelQueOcupa);
        pintaSolucion();
        return tunelQueOcupa;
    }
    public synchronized void SaleCoche(int posicion){        
        libres++;                                       //Dejamos el espacio libre
        Tunel.remove(posicion);
        Tunel.add(posicion, "v");
        System.out.println("Coche sale del tunel: "+posicion);
        pintaSolucion();
        notifyAll();                                    //Se lo indicamos a todos los hilos tanto de coche como de furgonetas
    }
    public synchronized int EntraFurgo() throws InterruptedException{
        int tunelQueOcupa=0;
        boolean encontrado=false; 
        while(libres==0 || Tunel.get(1)=="f" || (Tunel.get(0)=="f" && Tunel.get(NTuneles-1)=="f") ){                   //Mientras que no haya un espacio libre
            wait();                                                                                                              //esperamos a que un espacio quede libre 
        }
        libres--;
        while(tunelQueOcupa<NTuneles && !encontrado){
            if(Tunel.get(tunelQueOcupa)=="v"&&Tunel.get(0)!="f"&&Tunel.get(1)!="f"&&Tunel.get(2)!="f"){
                Tunel.remove(tunelQueOcupa);
                Tunel.add(tunelQueOcupa, "f");
                encontrado=true;
            }else if(Tunel.get(tunelQueOcupa)=="v" && Tunel.get(0)=="f"){
                Tunel.remove(tunelQueOcupa);
                Tunel.add(NTuneles-1, "f");
                tunelQueOcupa=2;
                encontrado=true;
            }else if(Tunel.get(tunelQueOcupa)=="v" && Tunel.get(NTuneles-1)=="f"){
                Tunel.remove(tunelQueOcupa);
                Tunel.add(0, "f");
                tunelQueOcupa=0;
                encontrado=true;
            }else if(Tunel.get(tunelQueOcupa)=="v" && Tunel.get(0)!="f"&& Tunel.get(2)!="f"){
                Tunel.remove(tunelQueOcupa);
                Tunel.add(1, "f");
                tunelQueOcupa=1;
                encontrado=true;
            }else
                tunelQueOcupa++;
        }
        encontrado=false;
        System.out.println("Furgo entra en el tunel: "+tunelQueOcupa+" "+tunelQueOcupa);
        pintaSolucion();
        return tunelQueOcupa;
    }
    public synchronized void SaleFurgo(int posicion){                                                     //Dejamos el espacio libre
        System.out.println("Furgo Sale del tunel: "+ posicion);
        Tunel.remove(posicion);
        Tunel.add(posicion, "v");
        pintaSolucion();
        libres++;
        notifyAll();                            //Se lo indicamos a todos los hilos tanto de coche como de furgonetas
    }
    public synchronized void pintaSolucion(){
        
            System.out.println(Tunel.get(0)+Tunel.get(1)+Tunel.get(2));

    }
}
