/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcd;

/**
 *
 * @author carlo
 */
public class ColaLenta implements ICola{
    private int head;
    private int tail;
    private int capacidad;
    private final int numelementos;
    private Object[] datos;
    private CanvasCola canvas=null;
    public ColaLenta(int capacidad,CanvasCola canvas ){
        
        this.capacidad=capacidad;
        numelementos=capacidad;
        head=0;
        tail=0;
        this.canvas=canvas;
        datos = new Object[capacidad];

    }

    private boolean colavacia(){
        return GetNum()== numelementos;
    } 
    
    private boolean colallena(){
        return GetNum()==0;
    } 
    
    @Override
    public int GetNum() {
        return this.capacidad;
    }

    @Override
    public synchronized void Acola(Object elemento) throws Exception {
        
        int intentos=0;
        while(colallena()&& intentos<3){
            wait();
            intentos++;
        }
        if(intentos>=3){
            throw new Exception("Intentos agotados "+intentos);
        }
        Thread.sleep(100);
        datos[this.head] = elemento;
        Thread.sleep(100);
        capacidad--;
        Thread.sleep(100);
        head=(++head)%numelementos;
        Thread.sleep(100);
        canvas.representa(datos, head, tail,capacidad );
        if(colallena()){
            canvas.avisa("Cola llena");
        }
        notifyAll();
        
    }

    @Override
    public synchronized Object Desacola() throws Exception {
        
        int intentos=0;
        while(colavacia()&& intentos < 3){
            wait();
            intentos++;
            
        }
        if(intentos>=3){
            throw new Exception("intentoos agotoados");
        }
       
        Thread.sleep(100);
        Object ElementoDesacolado = datos[tail];
        Thread.sleep(100);
        tail=(++tail)%numelementos;
        Thread.sleep(100);
        capacidad++;
        Thread.sleep(100);
        canvas.representa(datos, head, tail, capacidad);
        if(colavacia())
            canvas.avisa("Cola vacia");
        notifyAll();
        return ElementoDesacolado;
    }

    @Override
    public Object Primero()throws Exception {
        if(GetNum()==numelementos){
            throw new Exception("Cola vacia");
        }else{
            Object ElementoDesacolado = datos[tail];
            return ElementoDesacolado;
        }
    }
    
    
}
