/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algodeclase;

/**
 *
 * @author carlo
 */
public class Cuadrado implements IFigura{
    private int lado;
    private int coordenadaX;
    private int coordenadaY;
    private String nombre;

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getCordenadoX() {
        return coordenadaX;
    }

    public void setCordenadoX(int cordenadoX) {
        this.coordenadaX = cordenadoX;
    }

    public int getCordenadoY() {
        return coordenadaY;
    }

    public void setCordenadoY(int cordenadoY) {
        this.coordenadaY = cordenadoY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Figura clonar(){
        Figura f=new Cuadrado();
        f.setNombre(nombre);
        f.mover(coordenadaX,coordenadaY,lado);
    }
    
    
}

