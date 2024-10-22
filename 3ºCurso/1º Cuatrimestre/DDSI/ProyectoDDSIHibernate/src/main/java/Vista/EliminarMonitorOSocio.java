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
public class EliminarMonitorOSocio {
    

    
    public int EliminarMoniotorOSocio(Component c,String mensaje,String tipo){
    
        int respuesta;
        switch (tipo) {
            case "Monitor":
                    respuesta=JOptionPane.showConfirmDialog(c, mensaje,"Eliminar monitor",JOptionPane.YES_NO_OPTION);
                break;
            case "Socio":
                    respuesta=JOptionPane.showConfirmDialog(c, mensaje,"Eliminar socio",JOptionPane.YES_NO_OPTION);
                break;
            default:
                throw new AssertionError();
        }
        
        
        return respuesta;
    }
}
