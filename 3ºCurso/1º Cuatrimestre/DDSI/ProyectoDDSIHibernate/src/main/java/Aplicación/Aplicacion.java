
package Aplicación;

import Controlador.ControladorLogin;
import Vista.VistaMensaje;
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Aplicacion {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf()); // Ponemos que el la interfaz se vea segun el Modelo que le ponemos
        } catch(UnsupportedLookAndFeelException ex) {
            VistaMensaje vMensaje=new VistaMensaje();
            vMensaje.Mensaje(null, "ERROR", "Ha ocurrido un error al inicial el progrma"); // Lanza un error si si falla el modelo que queremos poner en nuestra interfaz
        }
        ControladorLogin CL = new ControladorLogin();      // Iniciamos la aplicación
    }
}
