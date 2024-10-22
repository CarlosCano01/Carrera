/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Panel_Singleton;
import Modelo.Personal;
import Modelo.Vuelo;
import Vista.VistaAñadirVuelo;
import Vista.VistaMensajes;
import Vista.VistaModificarVuelo;
import Vista.VistaPanelAeropuerto;

import Vista.VistaPrincipal;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author carlo
 */
public class ControladorPanel implements ActionListener {

    private VistaPrincipal vPrincipal;
    private VistaPanelAeropuerto vPanelAeropuerto;
    private Panel_Singleton PanelAeropuerto;
    private VistaAñadirVuelo vAñadirVuelo;
    private VistaModificarVuelo vModificarVuelo;
    private VistaMensajes vMensajes;
    private Personal personal;

    public ControladorPanel() {
        vPrincipal = new VistaPrincipal();
        vPanelAeropuerto = new VistaPanelAeropuerto();
        vAñadirVuelo = new VistaAñadirVuelo();
        vModificarVuelo = new VistaModificarVuelo();
        vMensajes = new VistaMensajes();
        PanelAeropuerto = Panel_Singleton.getSingletonInstance();
        personal = new Personal(PanelAeropuerto, vPanelAeropuerto);
        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vPanelAeropuerto);

        addListeners();

        vPrincipal.setLocationRelativeTo(null); //Ponemos el Frame de VistaPrincipal en el centro de la pantalla
        vPrincipal.setVisible(true);    // Hacemos visible el Frame de VistaPrincipal
        personal.dibujarPanelAeropuerto();

        muestraPanel(vPanelAeropuerto); //Inicializamos este panel al principio para que no se muestre nada
    }

    private void addListeners() {
        vPanelAeropuerto.jButtonAñaidrVuelo.addActionListener(this);
        vPanelAeropuerto.jButtonEliminarVuelo.addActionListener(this);
        vPanelAeropuerto.jButtonModificarVuelo.addActionListener(this);
        vAñadirVuelo.jButtonVistaAñadirVueloCancelar.addActionListener(this);
        vAñadirVuelo.jButtonVistaAñadirVueloAgregar.addActionListener(this);
        vModificarVuelo.jButtonVistaModificarVueloAgregar.addActionListener(this);
        vModificarVuelo.jButtonVistaModificarVueloCancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "AñadirVuelo":
                muestraJDialog(vAñadirVuelo);
            break;
                case "AgregarNVuelo": 
                try {
                    
                    personal.AñadirVuelo(VueloRepetido( personal.vueloAañadir(vAñadirVuelo)));
                    personal.rellenarPanelAeropuerto();
                } catch (Exception ex) {
                    vMensajes.Mensaje(vAñadirVuelo, "ERROR", ex.getMessage());
                }
                break;
                case "CancelarNVuelo":
                    vAñadirVuelo.dispose();
                break;
                 case "EliminarVuelo":
                    try{
                        Vuelo v=personal.vueloSelecionado();
                        int respuesta=vMensajes.EliminarVuelo(vPrincipal,"Seguro que desea eliminar el vuelo "+(String)  vPanelAeropuerto.modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),2));
                        if(respuesta==0)
                            personal.EliminarVuelo(v);
                        personal.rellenarPanelAeropuerto();
                    } catch (Exception ex) {
                        vMensajes.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                    }
                    break;
            case "ModificarVuelo":
                try {

                    personal.RellenarActualizarVuelo(vModificarVuelo);
                    muestraJDialog(vModificarVuelo);
                } catch (Exception ex) {
                    vMensajes.Mensaje(vModificarVuelo, "ERROR", ex.getMessage());
                }
            break;
                case "VistaModificarVuelo":
                    try {
                        personal.actualizarVuelo(vModificarVuelo);
                        personal.rellenarPanelAeropuerto();
                    } catch (Exception ex) {
                        vMensajes.Mensaje(vModificarVuelo, "ERROR", ex.getMessage());
                        vModificarVuelo.dispose();
                    }

                break;
                case"CancelarModificarVuelo":
                    vModificarVuelo.dispose();
                break;
        }
    }

    private void muestraJDialog(JDialog aux) {
        aux.setLocationRelativeTo(null);
        aux.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        aux.setVisible(true);
    }

    private void muestraPanel(JPanel jP) {
        jP.setVisible(true);
    }
    
    private Vuelo VueloRepetido(Vuelo vueloAcomparar) throws Exception{
        if(!PanelAeropuerto.ListaVuelos().isEmpty()){
            System.out.println("entro"+PanelAeropuerto.ListaVuelos().size());
            for (int i = 0; i < PanelAeropuerto.ListaVuelos().size(); i++) {
                if(PanelAeropuerto.ListaVuelos().get(i).getNumerovuelo().equals(vueloAcomparar.getNumerovuelo())){
                    throw new Exception("Este numero de vuelo ya existe");
                }
            }
        }
        return vueloAcomparar;
    }
}
