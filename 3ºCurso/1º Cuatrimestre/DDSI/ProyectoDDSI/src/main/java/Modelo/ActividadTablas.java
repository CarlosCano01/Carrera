/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaCuantosSociosEnActividad;
import Vista.VistaMonitor;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */

public class ActividadTablas {
    
    private DefaultTableModel modeloTablaCActividades=null;
    public void rellenarComboBox(VistaCuantosSociosEnActividad cSA,ArrayList<Actividad> actividades){
        int numRegistros = actividades.size();
        for (int i = 0; i < numRegistros; i++) {
            cSA.jComboBoxCuantosActividad.addItem(actividades.get(i).getNombre());
        }
    }
    public String devuelvCOd(ArrayList<Actividad> actividad,String nombre) throws Exception{
        boolean encontrado=false;
        String cod;
        int i=0;
        while(!encontrado){
            if(nombre.equals(actividad.get(i).getNombre())){
                cod=actividad.get(i).getIdActividad();
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
    
}
