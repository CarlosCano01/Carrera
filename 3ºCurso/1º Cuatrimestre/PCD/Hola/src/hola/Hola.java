/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hola;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Hola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Saludos s=new Saludos(2);
        
        try {
            s.saludar("Bienvenidos a PCD");
        } catch (Exception ex) {
            System.out.println("ERROR: "+ex.getMessage());
            System.exit(0);
        }
        System.out.println("FIN");
    }
    
}
