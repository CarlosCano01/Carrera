/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vista.VistaSocios;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class SociosTabla {
    VistaSocios vSocios= new VistaSocios();
    DefaultTableModel modeloTablaSocios = null;
    
    public void inicializarTablaSocios(VistaSocios vSocios){
        this.modeloTablaSocios=vSocios.modeloTablaSocios;
    }
    public void dibujarTablaSocios(VistaSocios vSocios){
        String[] columnaTabla={"Código","Nombre","DNI","Teléfono",
                                "Correo","Fecha Incorporación","Categoria","Fecha Nacimiento"};
        inicializarTablaSocios(vSocios);
        modeloTablaSocios.setColumnIdentifiers(columnaTabla);

        vSocios.jTableSocios.getTableHeader().setResizingAllowed(false);
        vSocios.jTableSocios.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vSocios.jTableSocios.getColumnModel().getColumn(0).setPreferredWidth(60);
        vSocios.jTableSocios.getColumnModel().getColumn(1).setPreferredWidth(220);
        vSocios.jTableSocios.getColumnModel().getColumn(2).setPreferredWidth(80);
        vSocios.jTableSocios.getColumnModel().getColumn(3).setPreferredWidth(80);
        vSocios.jTableSocios.getColumnModel().getColumn(4).setPreferredWidth(200);
        vSocios.jTableSocios.getColumnModel().getColumn(5).setPreferredWidth(150);
        vSocios.jTableSocios.getColumnModel().getColumn(6).setPreferredWidth(70);
        vSocios.jTableSocios.getColumnModel().getColumn(7).setPreferredWidth(150);
    }
    public void rellenarTablaSocios(ArrayList<Socio> socios){
        Object[] fila = new Object[8];
        int numRegistros = socios.size();
        for (int i = 0; i < numRegistros; i++) {
            fila[0]=socios.get(i).getNumSocio();
            fila[1]=socios.get(i).getNombre();
            fila[2]=socios.get(i).getDni();
            fila[3]=socios.get(i).getTelefono();
            fila[4]=socios.get(i).getCorreo();
            fila[5]=socios.get(i).getFechaEntrada();
            fila[6]=socios.get(i).getCategoria();
            fila[7]=socios.get(i).getFechaNacimiento();
            modeloTablaSocios.addRow(fila);
        }
    }
    public void vaciarTablaSocios(){
        while(modeloTablaSocios.getRowCount()>0){
            modeloTablaSocios.removeRow(0);
        }
    }
}
