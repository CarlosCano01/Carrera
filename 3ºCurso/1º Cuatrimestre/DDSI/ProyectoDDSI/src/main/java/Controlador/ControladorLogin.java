/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Vista.VistaConsola;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class ControladorLogin implements ActionListener {

    private VistaLogin vLogin = null;
    private Conexion conect = null;
    private VistaMensaje vMensaje = null;

    public ControladorLogin() {
        vLogin = new VistaLogin();
        vMensaje = new VistaMensaje();

        addListeners();

        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }

    public Conexion conectar() {
        try {
            //String usuario = "DDSI_018";
            //String password = "DDSI_018";
            //String ip = "172.18.1.241";
            //String servicio_bd = "DDSI_018";
            String sgbd = vLogin.jComboBox_Servidor.getSelectedItem().toString();
            String servicio_bd = vLogin.jTextField_Servicio.getText();
            String ip = vLogin.jTextField_Ip.getText();
            String usuario = vLogin.jTextField_Usuario.getText();
            //String password = vLogin.jPasswordField_Contraseña.getSelectedText();
            String password ="DDSI_018";
            conect = new Conexion(sgbd, ip, servicio_bd, usuario, password);
        } catch (SQLException sqle) {
            // Mensaje de error
            vMensaje.Mensaje(null,"ERROR", sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            // Mensaje de error
            vMensaje.Mensaje(null,"ERROR", ex.getMessage());
        }
        return (conect);
    }

    public void desconectar() {
        try {
            conect.desconexion();
            System.out.println("Desconectado");
        } catch (SQLException sqle) {
            // Mensaje de error
            vMensaje.Mensaje(null,"ERROR", sqle.getMessage());
        }
    }

    private void addListeners() {
        vLogin.Conectar.addActionListener(this);
        vLogin.Salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Conectar":
                conect = conectar();
                if (conect != null) {
                    try{
                    vLogin.dispose();
                    vMensaje.Mensaje(null,"info", "Conectado correctamente al servidor" + conect.informacionBD().getDatabaseProductName());
                    ControladorPrincipal controladorP= new ControladorPrincipal(conect);
                    }catch(SQLException sqle){
                    vMensaje.Mensaje(null,"ERROR", sqle.getMessage());
                    }
                }
                break;
            case "Salir":
                vLogin.dispose();
                System.exit(0);
                break;
        }
    }
    /*public void metadatos(){
    try{
        DatabaseMetaData Meta= conect.informacionBD();
        VC.mensajeMetadatos(Meta);
    }catch(SQLException sqle) {
            // Mensaje de error
            VC.mensajeConsola("ERROR", sqle.getMessage());
        }
    }*/
}
