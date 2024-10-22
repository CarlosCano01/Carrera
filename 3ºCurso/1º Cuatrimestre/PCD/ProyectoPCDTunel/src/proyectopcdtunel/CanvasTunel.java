/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopcdtunel;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

/**
 *
 * @author usuario
 */
public class CanvasTunel extends Canvas{
    ArrayList<Integer> coches;
    ArrayList<Integer> furgos;
    ArrayList<String> tuneles;

    
    @Override
    public void update(Graphics g) {
        paint(g);
    }
    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics og = offscreen.getGraphics();
        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);
        og.setFont(f1);
        
        og.setColor(Color.BLUE);
        og.fillRect(300, 200, 400, 75);
        og.drawString("Coches", 300, 190);
        
        og.setColor(Color.BLUE);
        og.fillRect(300, 350, 400, 75);
        og.drawString("Furgonetas", 300, 340);
        
        
        
        // NO SE PORQUE NO PINTA
        g.drawImage(offscreen, 0, 0, null);
    }
    
    
}
