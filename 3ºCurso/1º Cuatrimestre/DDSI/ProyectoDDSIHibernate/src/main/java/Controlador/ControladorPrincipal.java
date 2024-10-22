/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Actividad;
import Modelo.ActividadDAO;
import Modelo.ActividadTablas;
import Modelo.CuotaMonitorTablas;
import Modelo.HibernateUtilMariaDB;
import Modelo.HibernateUtilOracle;
import Modelo.Monitor;
import Modelo.MonitorDAO;
import Modelo.MonitoresTablas;
import Modelo.Socio;
import Modelo.SocioDAO;
import Modelo.SociosTabla;
import Vista.ActualizaSocio;
import Vista.ActualizaciónDeMonitor;
import Vista.EliminarMonitorOSocio;
import Vista.NuevoMonitor;
import Vista.NuevoSocio;
import Vista.PanelVacio;
import Vista.VistaConsola;
import Vista.VistaCuantosSociosEnActividad;
import Vista.VistaCuotaMonitor;
import Vista.VistaDarDeAltaUnSocioEnUnaActicidad;
import Vista.VistaDarDeBajaUnSocioEnUnaActicidad;
import Vista.VistaGestionActividades;
import Vista.VistaLogin;
import Vista.VistaMensaje;
import Vista.VistaMonitor;
import Vista.VistaPrincipal;
import Vista.VistaSocios;
import java.awt.CardLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import org.hibernate.Session;

/**
 *
 * @author carlo
 */
/*
    Sirve para gestionar los errrores que se pueden producir al trabajar con el programa
*/
public class ControladorPrincipal implements ActionListener {

    private String sgbd;
    private Session conexion = null;
    private VistaConsola vConsola=null;
    private VistaPrincipal vPrincipal = null;
    private VistaMensaje vMensaje= null;
    private VistaMonitor vMonitor = null;
    private MonitoresTablas mTablas = null;
    private SociosTabla sTablas = null;
    private MonitorDAO monitorDAO = null;
    private SocioDAO socioDAO = null;
    private VistaLogin vLogin=null;
    private VistaSocios vSocios = null;
    private ActualizaciónDeMonitor AMonitor = null;
    private PanelVacio vPanel= null;
    private PanelVacio vPanelG= null;
    private NuevoMonitor nMonitor= null;
    private EliminarMonitorOSocio eMonitor=null;
    private ActualizaSocio ASocio=null;
    private NuevoSocio nSocio=null;
    private VistaGestionActividades vGestionA=null;
    private VistaCuantosSociosEnActividad cSocios=null;
    private ActividadTablas aTablas= null;
    private ActividadDAO actividadDAO=null;
    private VistaCuotaMonitor vCMonitor=null;
    private CuotaMonitorTablas cMTablas=null;
    private KeyListener L=null;
    private VistaDarDeAltaUnSocioEnUnaActicidad vDASA=null;
    private VistaDarDeBajaUnSocioEnUnaActicidad vDBSA=null;
    ArrayList<Actividad> lActividades;
    
    /*
        Este construztor inicializa todas las clases que vamos a necesitar
    */
    public ControladorPrincipal(Session conect,VistaLogin vLogin,String BD) {
        this.conexion= conect;
        this.vLogin=vLogin;
        this.sgbd=BD;
        
        vConsola= new VistaConsola();
        vPrincipal = new VistaPrincipal();
        vMensaje = new VistaMensaje();
        vPanel= new PanelVacio();
        vMonitor= new VistaMonitor();
        mTablas = new MonitoresTablas();
        monitorDAO =new MonitorDAO(conect);
        nMonitor= new NuevoMonitor();
        eMonitor=new EliminarMonitorOSocio();
        AMonitor= new ActualizaciónDeMonitor();
        vSocios= new VistaSocios();
        sTablas = new SociosTabla();
        socioDAO =new SocioDAO(conect);
        ASocio= new ActualizaSocio();
        nSocio=new NuevoSocio();
        cSocios= new VistaCuantosSociosEnActividad();
        aTablas= new ActividadTablas();
        actividadDAO=new ActividadDAO(conect);
        vGestionA=new VistaGestionActividades();
        vDASA=new VistaDarDeAltaUnSocioEnUnaActicidad();
        vDBSA=new VistaDarDeBajaUnSocioEnUnaActicidad();
        vPanelG= new PanelVacio();
        vCMonitor=new VistaCuotaMonitor();
        cMTablas= new CuotaMonitorTablas(conect);
        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vPanel);
        vPrincipal.add(vMonitor);
        vPrincipal.add(vSocios);
        vGestionA.getContentPane().setLayout(new CardLayout());
        vGestionA.add(vDASA);
        vGestionA.add(vDBSA);
        vGestionA.add(vPanelG);
        /*
            Este componente KeyListener sirve para que cuando dejemos de pulsar una tecla del teclado coloque en la tabla de vSocios los socios que empiezan por la letra selecionada
        */
        this.L=new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                    Buscador();
            }
        };
        
        muestraPanel(vPanel); //Inicializamos este panel al principio para que no se muestre nada
        
        addListeners();
        
        vPrincipal.setLocationRelativeTo(null); //Ponemos el Frame de VistaPrincipal en el centro de la pantalla
        vPrincipal.setVisible(true);    // Hacemos visible el Frame de VistaPrincipal
    }
    
    /*
        En este metodo lo usaremos para decir cuales son los componentes de los cuales queremos realizar un control de sus eventos
    */
    private void addListeners() {
        vPrincipal.jMenuItemSalir.addActionListener(this);
        vPrincipal.jMenuSalirLogin.addActionListener(this);
        vPrincipal.jMenuItemMonitores.addActionListener(this);
        vPrincipal.jMenuItemSocios.addActionListener(this);
        vPrincipal.jMenuItemCuantosSocios.addActionListener(this);
        vPrincipal.jMenuItemCuotaMonitor.addActionListener(this);
        vMonitor.jButtonActualización.addActionListener(this);
        vMonitor.jButtonAgregarMonitor.addActionListener(this);
        vMonitor.jButtonEliminarMonitor.addActionListener(this);
        AMonitor.jButtonActualizarMonitor.addActionListener(this);
        AMonitor.jButtonCancelarActualizarMonitor.addActionListener(this);
        nMonitor.jButtonAgregar.addActionListener(this);
        nMonitor.jButtonCancelarNuevoMonitor.addActionListener(this);
        vSocios.jButtonEliminaSocio.addActionListener(this);
        vSocios.jButtonActualizaSocios.addActionListener(this);
        vSocios.jButtonNuevoSocioGSocios.addActionListener(this);
        vSocios.jButtonGestionActividades.addActionListener(this);
        vSocios.jTextFieldBuscaSocio.addKeyListener(L); //Le metemos el componente KeyListener que hemos definido en e constructor
        vSocios.jTextFieldBuscaSocio.setFocusable(true);
        ASocio.jButtonActualizarSocio.addActionListener(this);
        ASocio.jButtonCancelarActualizarSocio.addActionListener(this);
        nSocio.jButtonCancelarNuevoSocio.addActionListener(this);
        nSocio.jButtonNuevoSocio.addActionListener(this);
        cSocios.jButtonSalirCuantosSocios.addActionListener(this);
        cSocios.jComboBoxCuantosActividad.addActionListener(this);
        cSocios.jButtonVaciarTablaCActividades.addActionListener(this);
        vGestionA.jMenuItemDarDeAltaUnSocioDeUnaActividad.addActionListener(this);
        vGestionA.jMenuItemDarDeBajaUnSocioDeUnaActividad.addActionListener(this);
        vGestionA.jMenuItemSalirGActividades.addActionListener(this);
        vDBSA.jButtonDarDeBaja.addActionListener(this);
        vDASA.jButtonInscribirSocioActividad.addActionListener(this);
        vCMonitor.jButtonVerCuota.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //Boton que termina la ejecución del progrma y cierra el Frame de VistaPrincipal
            case "Salir de la aplicación":
                vPrincipal.dispose();
                System.exit(0);
            break;
            //Boton que muestra cuota de monitor
            case"CuotadeMonitor":
                cMTablas.dibujarTablaSocios(vCMonitor);
                muestraCMonitor();
            break;
                //Boton que muestra la cuota 
                case"VerCuotaMonitorBoton":
                    try {
                        cMTablas.rellenarTablaCM(vCMonitor);
                    } catch (Exception ex) {
                        vMensaje.Mensaje(vCMonitor, "ERROR", ex.getMessage());
                    }
                break;

            //Boton que gestiona los monitores y muestra la tabla de monitores
            case "GestionMonitores":
                muestraPanel(vMonitor);
                mTablas.dibujarTablaMonitores(vMonitor);
                pideMonitores();
            break;
            
                //Boton que muestra la vista de actualizar monitor y lo rellena con el monitor selecionado
                case "Actualización de monitor":            
                    try {
                        mTablas.rellenaActualizarMonitor(AMonitor,vMonitor.jTableMonitores);
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
                            monitorDAO.ActualizaOIngresaMonitores(mTablas.ActualizaMonitor(AMonitor,conexion));
                            mTablas.dibujarTablaMonitores(vMonitor);
                            pideMonitores();
                            AMonitor.dispose();
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
                            monitorDAO.ActualizaOIngresaMonitores(mTablas.NuevoMonitor(nMonitor));
                            mTablas.dibujarTablaMonitores(vMonitor);
                            pideMonitores();
                            nMonitor.dispose();
                        } catch (Exception ex) {
                            vMensaje.Mensaje(nMonitor, "ERROR", ex.getMessage());
                        }
                    break;
                    
                //Boton que elimina el monitor selecionado
                case "Eliminar monitor":
                    try {
                        String codigo = mTablas.CodSelecionado(vMonitor.jTableMonitores);
                        int respuesta=eMonitor.EliminarMoniotorOSocio(vPrincipal, codigo,"Monitor");
                        if(respuesta==0){
                            monitorDAO.EliminarMonitores(codigo);
                            System.out.println("Eliminado");
                            mTablas.dibujarTablaMonitores(vMonitor);
                            pideMonitores();
                        }
                    } catch (Exception ex) {
                        vMensaje.Mensaje(vMonitor, "ERROR", ex.getMessage());
                    }                    
                break;    
            //Boton que gestiona los socios y muestra la tabla de socios    
            case "Gestión de Socios":
                muestraPanel(vSocios);
                sTablas.dibujarTablaSocios(vSocios);
                pideSocios();               
            break;
                //Boton que elimina socio
                case"EliminarSocio":
                    try{
                        String NumSoc = sTablas.NumSocSelecionado(vSocios.jTableSocios);
                        int respuesta=eMonitor.EliminarMoniotorOSocio(vPrincipal, NumSoc,"Socio");
                        if(respuesta==0){
                            socioDAO.EliminarSocio(NumSoc);
                            Buscador();
                        }
                    } catch (Exception ex) {
                        vMensaje.Mensaje(vSocios, "ERROR", ex.getMessage());
                    }
                    break;
                //Abre la ventana de Actualizar socios y lo rellena con el socio selecionado
                case"ActualizarSocioGSocios":
                    try {
                        sTablas.rellenaActualizarSocio(ASocio,vSocios.jTableSocios);                                                                      
                        muestraASocio();                                                                            
                    } catch (Exception ex) {
                        vMensaje.Mensaje(vMonitor, "ERROR", ex.getMessage());
                        Buscador();
                    }
                    break;
                    //Boton que cierra la vista de actualizar socio
                    case "CancelarActualizarSocio":
                        ASocio.dispose();
                    break;    
                    
                    //Boton que actualiza socio
                    case "ActualizarSocio":
                        try {
                            socioDAO.ActualizaOIngresaSocios(sTablas.ActualizaSocio(ASocio,conexion));
                            sTablas.dibujarTablaSocios(vSocios);
                            Buscador();
                            ASocio.dispose();
                        } catch (Exception ex) {
                            vMensaje.Mensaje(ASocio, "ERROR", ex.getMessage());
                        }
                    break;
                //Boton que muestra la vista de agregar socio    
                case "AgregarSocioGSocio":
                    pideSocios();
                    sTablas.SiguienteNumSoc(vSocios.jTableSocios, nSocio);
                    Buscador();
                    muestraNSocio();
                break;
                    //Boton que cierra la vista de agregar socio    
                    case "CancelarNuevoSocio":
                            nMonitor.dispose();
                    break;    
                    
                    //Boton que agrera un nuevo monitor
                    case "NuevoSocio":
                        try {
                            
                            socioDAO.ActualizaOIngresaSocios(sTablas.NuevoSocio(nSocio));
                            sTablas.dibujarTablaSocios(vSocios);
                            Buscador();
                            nSocio.dispose();
                        } catch (Exception ex) {
                            vMensaje.Mensaje(nSocio, "ERROR", ex.getMessage());
                        }
                    break;
                //Abre la ventana de Gestionar Acitidades y lo rellena con el socio selecionado
                case "GestionarAcitidades":
                    try {
                        sTablas.NumSocSelecionado(vSocios.jTableSocios);
                        muestraPanel(vPanelG);
                        muestraGSocioA();
                    } catch (Exception ex) {
                        vMensaje.Mensaje(nSocio, "ERROR", ex.getMessage());
                    }
                break;
                    // Botón que muestra el Panel DarDeAltaUnSocioDeUnaActividad
                    case "DarDeAltaUnSocioDeUnaActividad":
                        try {
                            aTablas.dibujarTablaAlta(vDASA);
                            aTablas.RellenalistaAlta(conexion, actividadDAO.pCodigosNoActividad(sTablas.NumSocSelecionado(vSocios.jTableSocios), sgbd), vDASA);
                            muestraPanel(vDASA);
                        } catch (Exception ex) {
                            vMensaje.Mensaje(nSocio, "ERROR", ex.getMessage());
                        }
                    break;
                    
                        case"InscribirSocioActividad":
                            try {
                                
                                actividadDAO.DarDeAlta(conexion,sTablas.NumSocSelecionado(vSocios.jTableSocios),aTablas.CodSelectAlta(vDASA.jTable1));
                                aTablas.RellenalistaAlta(conexion, actividadDAO.pCodigosNoActividad(sTablas.NumSocSelecionado(vSocios.jTableSocios), sgbd), vDASA);
                                
                            } catch (Exception ex) {
                                vMensaje.Mensaje(nSocio, "ERROR", ex.getMessage());
                            }
                        break;
                    //Botón que sirve para salir del Frame VistaGestiónActividades
                    case"SalirGActividades":
                        vGestionA.dispose();
                    break;
                    // Botón que muestra el Panel DarDeBajaUnSocioDeUnaActividad
                    case "DarDeBajaUnSocioDeUnaActividad":
                        try {
                            aTablas.dibujarTablaBaja(vDBSA);
                            aTablas.RellenalistaBaja(conexion, sTablas.NumSocSelecionado(vSocios.jTableSocios),vDBSA);
                            muestraPanel(vDBSA);
                        } catch (Exception ex) {
                            vMensaje.Mensaje(nSocio, "ERROR", ex.getMessage());
                        }
                    break;
                        case "DarDeBajaSocioActividad":
                            try {
                                
                                actividadDAO.DarDeBaja(conexion,sTablas.NumSocSelecionado(vSocios.jTableSocios),aTablas.CodSelectBaja(vDBSA.jTable1));
                                aTablas.RellenalistaBaja(conexion, sTablas.NumSocSelecionado(vSocios.jTableSocios),vDBSA);
                                
                            } catch (Exception ex) {
                                vMensaje.Mensaje(nSocio, "ERROR", ex.getMessage());
                            }
                        break;
            //Boton que inica y abre la ventana de Actividades
            case "CuantosSocios":
                try {
                    aTablas.inicializarCActividaes(cSocios);
                    this.lActividades=InicializaArrayCActividad();
                    aTablas.rellenarComboBox(cSocios, lActividades);
                    muestraCuantosSociosHay();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

            break;
                //Boton que sirve para salir de la ventana de Actividades
                case"SalirCuantosSocios":
                    cSocios.dispose();
                break;
                //Boton que vacia la tabla de actividades
                case "VaciarTablaCActividad":
                    vaciaCActividad();
                break;
                //Boton que muestra los socios hay inscritos segun la actividad que selecionemos
                case "CuantosActividad" :

                        aTablas.dibujarTablaCActividaes(cSocios);
                        vaciaCActividad();
                        String cod;
                    try {
                        cod = aTablas.devuelvCOd(lActividades, cSocios.jComboBoxCuantosActividad.getSelectedItem().toString());
                        aTablas.rellenarTablaSocios(actividadDAO.pActividadesSocios(cod,sgbd));
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
           //Botón que sale a la VistaLogin 
            
            case "SalirLogin":
                
                vPrincipal.dispose();
                vLogin.setLocationRelativeTo(null);
                vLogin.setVisible(true);
                break;
        }
    }
   
    //Metodo que muestra el panel que selecionemos
    private void muestraPanel(JPanel jP){
        vPanel.setVisible(false);
        vMonitor.setVisible(false);
        vSocios.setVisible(false);
        vDASA.setVisible(false);
        vDBSA.setVisible(false);
        vPanelG.setVisible(false);
        jP.setVisible(true);
    }
     private void pideMonitores(){
        ArrayList<Monitor> lMonitores = monitorDAO.listaMonitores();
        mTablas.vaciarTablaMonitores();
        mTablas.rellenarTablaMonitores(lMonitores);
    }
    private void pideSocios(){
        ArrayList<Socio> lSocio = socioDAO.listaSocios();
        sTablas.vaciarTablaSocios();
        sTablas.rellenarTablaSocios(lSocio);
    }
    private void muestraAMonitor(){
        AMonitor.setLocationRelativeTo(null);
        AMonitor.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        AMonitor.setVisible(true);
    }
    private void muestraASocio(){
        ASocio.setLocationRelativeTo(null);
        ASocio.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        ASocio.setVisible(true);
    }
    private void muestraNMonitor(){
        nMonitor.setLocationRelativeTo(null);
        nMonitor.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        nMonitor.setVisible(true);
    }
    private void muestraNSocio(){
        nSocio.setLocationRelativeTo(null);
        nSocio.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        nSocio.setVisible(true);
    }
    private void muestraCuantosSociosHay(){
        cSocios.setLocationRelativeTo(null);
        cSocios.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        cSocios.setVisible(true);
    }
    private void muestraGSocioA(){
        vGestionA.setLocationRelativeTo(null);
        vGestionA.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        vGestionA.setVisible(true);
    }
    private void muestraCMonitor(){
        vCMonitor.setLocationRelativeTo(null);
        vCMonitor.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        vCMonitor.setVisible(true);
    }
    
    private ArrayList<Actividad> InicializaArrayCActividad() throws SQLException{
        ArrayList<Actividad> lActividadesaux = actividadDAO.listaActividades();
        return lActividadesaux;
    }
    private void vaciaCActividad(){
        aTablas.vaciarTablaCActividaes();
    }
    private void Buscador(){
        if(!"".equals(vSocios.jTextFieldBuscaSocio.getText())){

            if(vSocios.jTextFieldBuscaSocio.getText().charAt(0)>= 'a' && vSocios.jTextFieldBuscaSocio.getText().charAt(0) <= 'z'){  // Sirve para poner la primera letra de que pongamos
                                                                                                                                              // en matuscula
                String ayuda=vSocios.jTextFieldBuscaSocio.getText().toUpperCase();
                vSocios.jTextFieldBuscaSocio.setText(ayuda);    
                }
                    try {
                        sTablas.buscaSocios(socioDAO.BuscarPorNombre(vSocios.jTextFieldBuscaSocio.getText()), conexion);
                    } catch (Exception ex) {
                        Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else
                    pideSocios();
    }
}
