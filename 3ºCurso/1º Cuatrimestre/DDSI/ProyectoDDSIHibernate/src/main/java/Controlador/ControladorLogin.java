/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.HibernateUtilMariaDB;
import Modelo.HibernateUtilOracle;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.hibernate.Session;

/**
 *
 * @author
 */
/*
/*
    Sirve para gestionar los errrores que se pueden producir al conectarse al servidor
*/
public class ControladorLogin implements ActionListener {

    private VistaLogin vLogin = null;
    private Session conexion = null;
    private VistaMensaje vMensaje = null;

    public ControladorLogin() {
        vLogin = new VistaLogin();
        vMensaje = new VistaMensaje();

        addListeners();

        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }

    /*
        En este metodo recogemos los datos de la vista Login para ver que BD 
        debemos elegir, devolvemos la variable que contiene la conexión
     */
    public Session conectar() {
        String sgbd = vLogin.jComboBox_Servidor.getSelectedItem().toString();
        if ("Oracle".equals(sgbd)) {
            conexion = HibernateUtilOracle.getSessionFactory().openSession();
        } else if ("MariaDB".equals(sgbd)) {
            conexion = HibernateUtilMariaDB.getSessionFactory().openSession();
        }
        
        return (conexion);
    }

    /*
        En este metodo lo usaremos para decir cuales son los componentes de los cuales queremos realizar un control de sus eventos
    */
    private void addListeners() {
        vLogin.Conectar.addActionListener(this);
        vLogin.Salir.addActionListener(this);
    }

    /*
        En este metodo realizamos el control de eventos de los componentes que usemos 
        teniendo en cuenta la variable de los componentes actionComand.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //Boton que sirve para conectarnos a la BD
            case "Conectar":
                conexion = conectar();
                if (conexion != null) {
                        vMensaje.Mensaje(null, "info", "Conectado correctamente al servidorcon Hibernate" ); //Mensage que mostramos al tener un conexión exitosa al servidor
                        vLogin.dispose(); //Cierra el Frame de VistaLogin 
                        ControladorPrincipal controladorP = new ControladorPrincipal(conexion,vLogin,vLogin.jComboBox_Servidor.getSelectedItem().toString()); // Llama al controladorPrincipal que gestiona todo el programa 
                }else
                    vMensaje.Mensaje(null, "ERROR", "Error en la conexión. No se ha podido crear una sesión\n");
            break;

            //Boton que sirve para salir del proyecto
            case "Salir":
                vLogin.dispose();
                System.exit(0);
                break;
        }
    }
}
