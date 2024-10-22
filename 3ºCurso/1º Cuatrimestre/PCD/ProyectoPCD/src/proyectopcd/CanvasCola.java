/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcd;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author carlo
 */
public class CanvasCola extends Canvas{
    
    private boolean haymensaje =false;
    private int head;
    private int tail;
    private int capacidad;
    private final int numelementos;
    private Object[] datos;
    String mensaje;
    
    public CanvasCola(int capacidad){
        this.capacidad=capacidad;
        numelementos=capacidad;
        head=0;
        tail=0;
        datos = new Object[capacidad];
        mensaje="";
     
    }
    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    @Override
    public void paint(Graphics g) {

        // Se crea un buffer intermedio para que montar la salida completa
        // y luego pintarla de una vez, evitando el parpadeo
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();
        int alturadelcuadrado=200;
        int Largocuadrado=50;
        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);
        
        for (int i = 1; i < numelementos+1; i++) {
            og.setColor(Color.BLACK);
            og.fillRect(Largocuadrado*i, alturadelcuadrado, 2, 54);
            og.fillRect(Largocuadrado*i, alturadelcuadrado, 50, 2);
            og.setColor(Color.WHITE);
            og.fillRect((Largocuadrado+2)*i, alturadelcuadrado+2, 50, 50);
            og.setColor(Color.BLACK);
            og.fillRect((Largocuadrado)*i, alturadelcuadrado+52, 50, 2);
        }
        og.setColor(Color.BLACK);
        og.fillRect(Largocuadrado+50*numelementos, alturadelcuadrado, 2, 54);
        
        
        og.setFont(f1);
        og.drawString("Cola",Largocuadrado , alturadelcuadrado-50);
        int[] puntosX={68+50*(head),75+50*(head),82+50*(head)};
        int[] puntosY={170,180,170};
        og.fillPolygon(puntosX,puntosY,3);
        int[] puntosXTail={68+50*(tail),75+50*(tail),82+50*(tail)};
        int[] puntosYTail={280,270,280};
        og.fillPolygon(puntosXTail,puntosYTail,3);
        
        
        
        if(mensaje=="Cola vacia"){
            og.drawString("Cola Llena",50, alturadelcuadrado+150);
            og.setColor(Color.RED);
            og.drawString("Cola Vacia",200, alturadelcuadrado+150);
            og.setColor(Color.BLACK);
        }else if(mensaje=="Cola llena"){
            og.setColor(Color.RED);
            og.drawString("Cola Llena",50, alturadelcuadrado+150);
            og.setColor(Color.BLACK);
            og.drawString("Cola Vacia",200, alturadelcuadrado+150);
        }else if(mensaje==""){
            og.setColor(Color.BLACK);            
            og.drawString("Cola Llena",50, alturadelcuadrado+150);
            og.drawString("Cola Vacia",200, alturadelcuadrado+150);
        }
        mensaje="";
        for (int i = this.tail,j=0; j!=(numelementos-capacidad); i=(++i)%numelementos,j++) {
            og.drawString(datos[i].toString(),(Largocuadrado+13)+50*i, alturadelcuadrado+35);
        }

        
        g.drawImage(offscreen, 0, 0, null);
    }
    public void avisa(String mensaje){
        this.mensaje=mensaje;
        repaint();
    }
    public void representa(Object[] datos, int head,int tail,int numele){
        this.datos=datos;
        this.head=head;
        this.tail= tail;
        this.capacidad=numele;
        repaint();
    }
}
