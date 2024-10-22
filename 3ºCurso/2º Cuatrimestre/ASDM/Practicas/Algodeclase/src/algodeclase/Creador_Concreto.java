/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algodeclase;

/**
 *
 * @author carlo
 */
public class Creador_Concreto extends Creador{
    private int tipo;
    private Figura f;
    private boolean circulo;
    private boolean cuadrado;
    
    
    
    public Creador_Concreto() {
        circulo=false;
        cuadrado=false;
    }
    @Override
    public Figura Factory_method (int t){
        this.tipo=t;
        if (tipo == 1) {
            f=new Circulo();
            circulo=true;
            return f;
        }
        else if(tipo==2 && circulo==true){
            return f.clonar();
        }
        else if(tipo==3){
            f=new Cuadrado();
            cuadrado=true;
            return f;
            
        }else if(tipo==4 && cuadrado==true){
            return f.clonar();
        }
        
    }
    
}
