/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaCuotaMonitor;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class CuotaMonitorTablas {
    DefaultTableModel modeloTablaCMonitor = null;
    Session sesion=null;
    public CuotaMonitorTablas(Session s) {
        this.sesion=s;
    }
    
    public void inicializarTablaCMonitor(VistaCuotaMonitor vCMonitor){
        this.modeloTablaCMonitor=vCMonitor.modeloTablaCMonitor;
    }
    public void dibujarTablaSocios(VistaCuotaMonitor vCMonitor){
        String[] columnaTabla={"Nombre","Precio","Socios"};
        inicializarTablaCMonitor(vCMonitor);
        modeloTablaCMonitor.setColumnIdentifiers(columnaTabla);

        vCMonitor.jTableCuotaMonitor.getTableHeader().setResizingAllowed(false);
        vCMonitor.jTableCuotaMonitor.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vCMonitor.jTableCuotaMonitor.getColumnModel().getColumn(0).setPreferredWidth(100);
        vCMonitor.jTableCuotaMonitor.getColumnModel().getColumn(1).setPreferredWidth(40);
        vCMonitor.jTableCuotaMonitor.getColumnModel().getColumn(2).setPreferredWidth(40);
    }
    public void rellenarTablaCM(VistaCuotaMonitor vCMonitor) throws Exception{
        Monitor m=new Monitor();
        Actividad a=new Actividad();
        int suma=0;
        int cuota=0;
        vaciarTablaCMonitores();
        m=sesion.get(Monitor.class, vCMonitor.jTextFieldCodigoM.getText());
        if(m!=null){
            vCMonitor.jLabelNombreM.setText(m.getNombre());
            vCMonitor.jLabelNActividades.setText(String.valueOf(m.getActividadSet().size()));
            ArrayList<Actividad> A=new ArrayList();
            A.addAll(m.getActividadSet());
            for (int i = 0; i < m.getActividadSet().size(); i++) {
                a=sesion.get(Actividad.class, A.get(i).getIdactividad());
                suma=suma+a.getSocioSet().size();
                cuota=cuota+(a.getPreciobasemes()*a.getSocioSet().size());
            }
            rellenarTablaSocios(A);
            vCMonitor.jLabelCuota.setText(String.valueOf(cuota));
            vCMonitor.jLabelSociosIns.setText(String.valueOf(suma));
        }else{
            throw new Exception("No existe este codigo de monitor");
        }
            
    }
    public void rellenarTablaSocios(ArrayList<Actividad> Actividad){
        if(Actividad!=null){
            Object[] fila = new Object[3];
            int numRegistros = Actividad.size();
            for (int i = 0; i < numRegistros; i++) {
                fila[0]=Actividad.get(i).getNombre();
                fila[1]=Actividad.get(i).getPreciobasemes();
                fila[2]=Actividad.get(i).getSocioSet().size();
                modeloTablaCMonitor.addRow(fila);
            }
        }
    }
    public void vaciarTablaCMonitores() {
        while (modeloTablaCMonitor.getRowCount() > 0) {
            modeloTablaCMonitor.removeRow(0);
        }
    }

}
