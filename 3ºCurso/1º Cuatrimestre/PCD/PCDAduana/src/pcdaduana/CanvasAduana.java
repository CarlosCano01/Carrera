/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pcdaduana;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author usuario
 */
public class CanvasAduana extends Canvas{
    
    private ArrayList<Integer> cola_pasajero_mano;
    private ArrayList<Integer> cola_pasajero_maleta;
    private ArrayList<Integer> pasajero_mano;
    private ArrayList<Integer> pasajero_maleta;
    private int[] contador_rayoMaleta = {0,0};
    private int contador_manoRayo = 0;
    private int[] perros = {0,0};
    private int cuidador = 0;
    private Image Perro;
    private Image Galleta;   
    public CanvasAduana(){
        this.cola_pasajero_maleta = new ArrayList<>();
        this.cola_pasajero_mano = new ArrayList<>();
        this.pasajero_maleta = new ArrayList<>();
        this.pasajero_mano = new ArrayList<>();
        this.Perro = new ImageIcon("Perro.png").getImage();
        this.Galleta = new ImageIcon("Galletita.png").getImage();
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    @Override
    public void paint(Graphics g){
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();
        

        og.drawImage(this.Perro, 20, 120, 80, 80, null);
        og.drawImage(this.Perro, 20, 320, 80, 80, null);
        
        
        og.drawString("Rayo mano", 200, 340);

        og.drawLine(180, 350, 280, 350);
        og.drawLine(280, 350, 280, 450);
        og.drawLine(180, 350, 180, 450);
        
        og.drawString("Rayo Maleta", 200, 40);

        og.drawLine(180, 150, 280, 150);
        og.drawLine(280, 150, 280, 230);
        og.drawLine(180, 150, 180, 230);
        
        og.drawString("Rayo Maleta", 200, 140);

        og.drawLine(180, 50, 280, 50);
        og.drawLine(280, 50, 280, 130);
        og.drawLine(180, 50, 180, 130);
        
        
        
        og.setColor(Color.RED);
        og.drawString("Maletas", 300, 140);
        og.drawLine(300, 150, 300, 250);
        og.drawLine(300, 150, 800, 150);
        og.drawLine(300, 250, 800, 250);    
        
        
        og.setColor(Color.ORANGE);
        og.drawString("Maletas de mano", 300, 340);
        og.drawLine(300, 350, 300, 450);
        og.drawLine(300, 350, 800, 350);
        og.drawLine(300, 450, 800, 450);    

        //COLAS
        og.setColor(Color.ORANGE);
        for (int i = 0; i < cola_pasajero_mano.size(); i++) {
            og.drawOval(310+(50*i), 380, 30, 30);
            og.drawString(cola_pasajero_mano.get(i).toString(), 310+(50*i), 370);
        }
        og.setColor(Color.RED);
        for (int i = 0; i < cola_pasajero_maleta.size(); i++) {
            og.drawOval(310+(50*i), 180, 30, 30);
            og.drawString(cola_pasajero_maleta.get(i).toString(), 310+(50*i), 170);
        }
        
        //RAYOS
        og.setColor(Color.BLUE);
        
        if(contador_manoRayo!=0){
            //og.drawOval(215, 380, 30, 30);
            pintaViajero(og, 215, 380, contador_manoRayo);
            og.drawString(Integer.toString(contador_manoRayo), 215, 370);
        }
        
        if(contador_rayoMaleta[0]!=0){
            pintaViajero(og, 215, 80, contador_rayoMaleta[0]);
            og.drawString(Integer.toString(contador_rayoMaleta[0]), 215, 70);
        }
        if(contador_rayoMaleta[1]!=0){
            pintaViajero(og, 215, 180, contador_rayoMaleta[1]);
            og.drawString(Integer.toString(contador_rayoMaleta[1]), 215, 170);
        }
        
        //PERROS
        
        if(perros[0]!=0){
            pintaViajero(og, 120, 140, perros[0]);
            og.drawString(Integer.toString(perros[0]), 120, 130);
        }
        if(perros[1]!=0){
            pintaViajero(og, 120, 340, perros[1]);
            og.drawString(Integer.toString(perros[1]), 120, 330);
        }
        if(perros[0]==0 && cuidador==1){
            og.drawImage(this.Galleta, 20, 120, 80, 80, null);
        }else if(perros[1]==0 && cuidador==1){
            og.drawImage(this.Galleta, 20, 320, 80, 80, null);
        }
        og.drawImage(offscreen, 0, 0, null);        
        g.drawImage(offscreen, 0, 0, null);
    }
    
    public synchronized void colaMano(int id){
        cola_pasajero_mano.add(id);
        pasajero_mano.add(id);
        repaint();
    }
    public synchronized void colaMaleta(int id){
        cola_pasajero_maleta.add(id);
        pasajero_maleta.add(id);
        repaint();
    }
    public synchronized void contador_maletaRayo(int id){
        this.cola_pasajero_maleta.remove((Object)id);
        if (this.contador_rayoMaleta[0] == 0){
            this.contador_rayoMaleta[0] = id;
        }else{
            this.contador_rayoMaleta[1] = id;
        }
        repaint();
    } 
    public synchronized void contador_manoRayo(int id){
       this.cola_pasajero_mano.remove((Object)id);
       contador_manoRayo = id;
       repaint();
    }
    public synchronized void perroMaleta(int id){
        if (this.contador_rayoMaleta[0] == id){
            this.contador_rayoMaleta[0] = 0;
        }else {
            this.contador_rayoMaleta[1] = 0;
        }
        
        if (this.perros[0] == 0){ 
            this.perros[0] = id;
        }else
            this.perros[1] = id;
        repaint();
    }
    public synchronized void perroMano(){
        int aux = this.contador_manoRayo;
        this.contador_manoRayo = 0;
        if (this.perros[0] == 0) 
            this.perros[0] = aux;
        else
            this.perros[1] = aux;
    }
    public synchronized void perroSale(int id){
        if(this.perros[1] == id){
            this.perros[1] = 0;
        }
        else this.perros[0] = 0;
        repaint();
    }
    public synchronized void cuidadorEntra(){
        cuidador++;
        repaint();
    }
    public synchronized void cuidadorSale(){
        cuidador--;
        repaint();
    }
    public synchronized void pintaViajero(Graphics og, int x, int y ,int id){

        for (int j = 0; j < pasajero_mano.size(); j++) {
            if(pasajero_mano.get(j)==id){
                og.setColor(Color.GREEN);
            }
        }
        for (int j = 0; j < pasajero_maleta.size(); j++) {
            if(pasajero_maleta.get(j)==id){
                og.setColor(Color.RED);
            }
        }
        og.drawOval(x, y, 30, 30);
         og.setColor(Color.BLUE);
    }
}
