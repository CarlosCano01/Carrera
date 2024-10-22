/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class EliminarMonitor {
    

    
    public int EliminarMoniotor(Component c,String mensaje){
    
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(c, mensaje,"Eliminar monitor",JOptionPane.YES_NO_OPTION);
        
        return respuesta;
    }
}
