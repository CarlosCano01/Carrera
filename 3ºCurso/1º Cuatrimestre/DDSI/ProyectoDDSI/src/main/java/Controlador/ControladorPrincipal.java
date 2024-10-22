/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Actividad;
import Modelo.ActividadDAO;
import Modelo.ActividadTablas;
import Modelo.Conexion;
import Modelo.Monitor;
import Modelo.MonitorDAO;
import Modelo.MonitoresTablas;
import Modelo.Socio;
import Modelo.SocioDAO;
import Modelo.SociosTabla;
import Vista.ActualizaciónDeMonitor;
import Vista.EliminarMonitor;
import Vista.NuevoMonitor;
import Vista.PanelVacio;
import Vista.VistaConsola;
import Vista.VistaCuantosSociosEnActividad;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import Vista.VistaMonitor;
import Vista.VistaPrincipal;
import Vista.VistaSocios;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author carlo
 */
public class ControladorPrincipal implements ActionListener {

    private Conexion conexion = null;
    private VistaConsola vConsola=null;
    private VistaPrincipal vPrincipal = null;
    private VistaMensaje vMensaje= null;
    private VistaMonitor vMonitor = null;
    private MonitoresTablas mTablas = null;
    private SociosTabla mSocios = null;
    private MonitorDAO monitorDAO = null;
    private SocioDAO socioDAO = null;
    private VistaSocios vSocios = null;
    private ActualizaciónDeMonitor AMonitor = null;
    private PanelVacio vPanel= null;
    private NuevoMonitor nMonitor= null;
    private EliminarMonitor eMonitor=null;
    private VistaCuantosSociosEnActividad cSocios=null;
    private ActividadTablas aTablas= null;
    private ActividadDAO actividadDAO=null;
    ArrayList<Actividad> lActividades;
    
    public ControladorPrincipal(Conexion conect) {
        this.conexion= conect;
        
        vConsola= new VistaConsola();
        vPrincipal = new VistaPrincipal();
        vMensaje = new VistaMensaje();
        vMonitor= new VistaMonitor();
        vSocios= new VistaSocios();
        mTablas = new MonitoresTablas();
        mSocios = new SociosTabla();
        cSocios= new VistaCuantosSociosEnActividad();
        monitorDAO =new MonitorDAO(conect);
        socioDAO =new SocioDAO(conect);
        AMonitor= new ActualizaciónDeMonitor();
        vPanel= new PanelVacio();
        nMonitor= new NuevoMonitor();
        eMonitor=new EliminarMonitor();
        aTablas= new ActividadTablas();
        actividadDAO=new ActividadDAO(conect);
        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vSocios);
        vPrincipal.add(vMonitor);
        vPrincipal.add(vPanel);
        
        muestraPanel(vPanel);
        
        addListeners();
        
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
        
        mostrarInfo();
    }

    private void addListeners() {
        vPrincipal.jRadioButtonMenuItemSalir.addActionListener(this);
        vPrincipal.jMenuItemMonitores.addActionListener(this);
        vPrincipal.jMenuItemSocios.addActionListener(this);
        vPrincipal.jMenuItemCuantosSocios.addActionListener(this);
        vMonitor.jButtonActualización.addActionListener(this);
        vMonitor.jButtonAgregarMonitor.addActionListener(this);
        vMonitor.jButtonEliminarMonitor.addActionListener(this);
        AMonitor.jButtonActualizarMonitor.addActionListener(this);
        AMonitor.jButtonCancelarActualizarMonitor.addActionListener(this);
        nMonitor.jButtonAgregar.addActionListener(this);
        nMonitor.jButtonCancelarNuevoMonitor.addActionListener(this);
        cSocios.jButtonSalirCuantosSocios.addActionListener(this);
        cSocios.jComboBoxCuantosActividad.addActionListener(this);
        cSocios.jButtonVaciarTablaCActividades.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            
            case "Salir de la aplicación":
                vPrincipal.dispose();
                System.exit(0);
            break;
            
            //Boton que gestiona los monitores
            case "GestionMonitores":
                muestraPanel(vMonitor);
                mTablas.dibujarTablaMonitores(vMonitor);
                try {
                    actividadDAO.prueba("A");
                    pideMonitores();
                } catch (SQLException ex){
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            
                //Boton que muestra la vista de actualizar monitor
                case "Actualización de monitor":            
                    try {
                        mTablas.actualizarmonitor(AMonitor,vMonitor.jTableMonitores);
                        muestraAMonitor();
                    } catch (Exception ex) {
                        vMensaje.Mensaje(vMonitor, "ERROR", ex.getMessage());
                    }            
                break;
                    
                    //Boton que cierra la vista de actualizar monitor
                    case "CancelarActualizarMonitor":
                        AMonitor.dispose();
                    break;    
                    
                    //Boton que actualiza monitores
                    case "ActualizarMonitor":
                        try {
                            monitorDAO.ActualizaMonitores(mTablas.ActualizaMonitor(AMonitor));
                            mTablas.dibujarTablaMonitores(vMonitor);
                            pideMonitores();
                            AMonitor.dispose();
                        } catch (SQLException ex) {
                            vMensaje.Mensaje(nMonitor, "ERROR", ex.getMessage());
                        } catch (Exception ex) {
                            vMensaje.Mensaje(nMonitor, "ERROR", ex.getMessage());
                        }
                    break;    
    
                //Boton que muestra la vista de agregar monitor
                case "Agregar monitor":
                    mTablas.SiguienteCod(vMonitor.jTableMonitores, nMonitor);
                    muestraNMonitor();
                break;    
                
                    //Boton que cierra la vista de agregar monitor    
                    case "CancelarNuevoMonitor":
                            nMonitor.dispose();
                    break;    
                    
                    //Boton que agrera un nuevo monitor
                    case "AgregarNMonitor":
                        try {
                            monitorDAO.NuevoMonitores(mTablas.NuevoMonitor(nMonitor));
                            mTablas.dibujarTablaMonitores(vMonitor);
                            pideMonitores();
                            nMonitor.dispose();
                        } catch (SQLException ex) {
                            vMensaje.Mensaje(nMonitor, "ERROR", ex.getMessage());
                        } catch (Exception ex) {
                            vMensaje.Mensaje(nMonitor, "ERROR", ex.getMessage());
                        }
                    break;
                    
                //Boton que elimina el monitor selecionado
                case "Eliminar monitor":
                    String codigo;
                    try {
                        codigo = mTablas.CodSelecionado(vMonitor.jTableMonitores);
                        int respuesta=eMonitor.EliminarMoniotor(vPrincipal, codigo);
                        if(respuesta==0){
                            mTablas.eliminarmonitor(vMonitor.jTableMonitores,conexion);
                            System.out.println("Eliminado");
                            mTablas.dibujarTablaMonitores(vMonitor);
                            pideMonitores();
                        }
                    } catch (SQLException ex) {
                        vMensaje.Mensaje(vMonitor, "ERROR", ex.getMessage());
                    } catch (Exception ex) {
                        vMensaje.Mensaje(vMonitor, "ERROR", ex.getMessage());
                    }                    
                break;    
                
            case "Gestión de Socios":
                muestraPanel(vSocios);
                mSocios.dibujarTablaSocios(vSocios);
                try {
                    pideSocios();
                } catch (SQLException ex) {
                    vMensaje.Mensaje(vSocios, "ERROR", ex.getMessage());
                }
            break;
            
            case "CuantosSocios":
                try {
                    aTablas.inicializarCActividaes(cSocios);
                    this.lActividades=InicializaArrayCActividad();
                    aTablas.rellenarComboBox(cSocios, lActividades);
                    vaciaCActividad();
                    muestraCuantosSociosHay();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            break;

                case"SalirCuantosSocios":
                    cSocios.dispose();
                break;
                
                case "VaciarTablaCActividad":
                    vaciaCActividad();
                break;

                
                case "CuantosActividad" :
                    try {
                        aTablas.dibujarTablaCActividaes(cSocios);
                        vaciaCActividad();
                        String cod=aTablas.devuelvCOd(lActividades, cSocios.jComboBoxCuantosActividad.getSelectedItem().toString());
                        actividadDAO.pActividadesSocios(cod,cSocios);
                    } catch (SQLException ex) {
                        vMensaje.Mensaje(cSocios, "ERROR", ex.getMessage());
                    } catch (Exception ex) {
                        vMensaje.Mensaje(cSocios, "ERROR", ex.getMessage());
                    }
                break;
        }
    }
    private void pideMonitores() throws SQLException{
        ArrayList<Monitor> lMonitores = monitorDAO.listaMonitores();
        mTablas.vaciarTablaMonitores();
        mTablas.rellenarTablaMonitores(lMonitores);
    }
    private void muestraPanel(JPanel jP){
        vPanel.setVisible(false);
        vMonitor.setVisible(false);
        vSocios.setVisible(false);
        jP.setVisible(true);
    }
    private void pideSocios() throws SQLException{
        ArrayList<Socio> lSocio = socioDAO.listaSocios();
        mSocios.vaciarTablaSocios();
        mSocios.rellenarTablaSocios(lSocio);
    }
    private void muestraAMonitor(){
        AMonitor.setLocationRelativeTo(null);
        AMonitor.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        AMonitor.setVisible(true);
    }
    private void muestraNMonitor(){
        nMonitor.setLocationRelativeTo(null);
        nMonitor.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        nMonitor.setVisible(true);
    }
    private void muestraCuantosSociosHay(){
        cSocios.setLocationRelativeTo(null);
        cSocios.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        cSocios.setVisible(true);
    }
    private ArrayList<Actividad> InicializaArrayCActividad() throws SQLException{
        ArrayList<Actividad> lActividadesaux = actividadDAO.listaActividades();
        return lActividadesaux;
    }
    private void vaciaCActividad(){
        aTablas.vaciarTablaCActividaes();
    }
    private void mostrarInfo(){
        try {
            DatabaseMetaData dbmd= conexion.informacionBD();
            vConsola.mensajeMetadatos(dbmd);
        } catch (SQLException ex) {
             vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
        }
    }
}
