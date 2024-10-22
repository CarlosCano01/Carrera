/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaCuantosSociosEnActividad;
import Vista.VistaDarDeAltaUnSocioEnUnaActicidad;
import Vista.VistaDarDeBajaUnSocioEnUnaActicidad;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;


/**
 *
 * @author carlo
 */

public class ActividadTablas {
    
    private DefaultTableModel modeloTablaCActividades=null;
    private DefaultTableModel modeloTablaAlta=null;
    private DefaultTableModel modeloTablaBaja=null;
    
    public void rellenarComboBox(VistaCuantosSociosEnActividad cSA,ArrayList<Actividad> actividades){
        int numRegistros = actividades.size();
        for (int i = 0; i < numRegistros; i++) {
            cSA.jComboBoxCuantosActividad.addItem(actividades.get(i).getNombre());
        }
    }
    public void rellenarTablaSocios(ArrayList<Socio> socios){
        if(socios!=null){
            Object[] fila = new Object[8];
            int numRegistros = socios.size();
            for (int i = 0; i < numRegistros; i++) {
                fila[0]=socios.get(i).getNombre();
                fila[1]=socios.get(i).getCorreo();
                modeloTablaCActividades.addRow(fila);
            }
        }
    }
    public String devuelvCOd(ArrayList<Actividad> actividad,String nombre) throws Exception{
        boolean encontrado=false;
        String cod;
        int i=0;
        while(!encontrado){
            if(nombre.equals(actividad.get(i).getNombre())){
                cod=actividad.get(i).getIdactividad();
                return cod;
            }
            i++;
        }   
        throw new Exception("No se ha encontrado ningun codigo");
    }
   
    public void inicializarCActividaes(VistaCuantosSociosEnActividad cSA){
        
        this.modeloTablaCActividades=cSA.modeloTablaCuentaActividades;
        
    }
    
    public void dibujarTablaCActividaes(VistaCuantosSociosEnActividad cSocios){
        String[] columnaTabla={"Nombre","Correo"};
        inicializarCActividaes(cSocios);
        modeloTablaCActividades.setColumnIdentifiers(columnaTabla);

        cSocios.jTable1.getTableHeader().setResizingAllowed(false);
        cSocios.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        cSocios.jTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
        cSocios.jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);

    }
    
    public void vaciarTablaCActividaes(){
        
        while(modeloTablaCActividades.getRowCount()>0){
            modeloTablaCActividades.removeRow(0);
        }
        
    }
    public void buscaSociosActividades(ArrayList<String> sociosEncontrados,Session sesion){
        ArrayList<Socio> socio=new ArrayList<>();
        int numRegistros = sociosEncontrados.size();
        int i=0;
        while( i < numRegistros){
            String objeto=sociosEncontrados.get(i);
            Socio s=sesion.get(Socio.class, objeto);
            socio.add(s);
            i++;
        }
        vaciarTablaCActividaes();
        rellenarTablaSocios(socio);
    }
    public void inicializarmodeloTablaAlta (VistaDarDeAltaUnSocioEnUnaActicidad vDA){
        this.modeloTablaAlta=vDA.modeloTablaAgregarSA;
    }
     public void dibujarTablaAlta (VistaDarDeAltaUnSocioEnUnaActicidad vDA){
        String[] columnaTabla={"Código","Nombre"};
        inicializarmodeloTablaAlta(vDA);
        modeloTablaAlta.setColumnIdentifiers(columnaTabla);

        vDA.jTable1.getTableHeader().setResizingAllowed(false);
        vDA.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vDA.jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        vDA.jTable1.getColumnModel().getColumn(1).setPreferredWidth(220);
    }
    public void vaciarTablaAlta(){
        while(modeloTablaAlta.getRowCount()>0){
            modeloTablaAlta.removeRow(0);
        }
    }
    public void RellenalistaAlta(Session sesion,ArrayList<String> resultado,VistaDarDeAltaUnSocioEnUnaActicidad vDB){
        vaciarTablaAlta();
        for (int i = 0; i < resultado.size(); i++) {
            Actividad Act=sesion.get(Actividad.class, resultado.get(i));
                Object[] fila = new Object[2];
                fila[0]=Act.getIdactividad();
                fila[1]=Act.getNombre();
                modeloTablaAlta.addRow(fila);
        } 
     }
    public String CodSelectAlta(JTable tablaM) throws Exception{
        String CodSelect=null;
        if (tablaM.getSelectedRow() != -1) {
            CodSelect = (String) modeloTablaAlta.getValueAt(tablaM.getSelectedRow(), 0);
        } else {
            throw new Exception("No ha selecionado ninguna actividad");
        }
       return CodSelect;
    }
    public void inicializarmodeloTablaBaja (VistaDarDeBajaUnSocioEnUnaActicidad vDB){
        this.modeloTablaBaja=vDB.modeloTablaEliminarSA;
    }
    public void dibujarTablaBaja (VistaDarDeBajaUnSocioEnUnaActicidad vDB){
        String[] columnaTabla={"Código","Nombre"};
        inicializarmodeloTablaBaja(vDB);
        modeloTablaBaja.setColumnIdentifiers(columnaTabla);

        vDB.jTable1.getTableHeader().setResizingAllowed(false);
        vDB.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vDB.jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        vDB.jTable1.getColumnModel().getColumn(1).setPreferredWidth(220);
    }
    public void vaciarTablaBaja(){
        while(modeloTablaBaja.getRowCount()>0){
            modeloTablaBaja.removeRow(0);
        }
    }
    public void RellenalistaBaja(Session sesion,String numsoc,VistaDarDeBajaUnSocioEnUnaActicidad vDB){
        vaciarTablaBaja();
        Socio socio=sesion.get(Socio.class, numsoc);
        Set<Actividad> actividades = socio.getActividades();
        for (Actividad actividad : actividades ){
            Object[] fila = new Object[2];
                fila[0]=actividad.getIdactividad();
                fila[1]=actividad.getNombre();
                modeloTablaBaja.addRow(fila);
            } 
     }
    public String CodSelectBaja(JTable tablaM) throws Exception{
        String CodSelect=null;
        if (tablaM.getSelectedRow() != -1) {
            CodSelect = (String) modeloTablaBaja.getValueAt(tablaM.getSelectedRow(), 0);
        } else {
            throw new Exception("No ha selecionado ninguna actividad");
        }
       return CodSelect;
    }
}
