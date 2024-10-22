/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vista.VistaAñadirVuelo;
import Vista.VistaModificarVuelo;
import Vista.VistaPanelAeropuerto;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class Personal {
    private ArrayList<Vuelo> vuelos;
    private Panel_Singleton panel;
    private DefaultTableModel modeloPanelAeropuerto=null;
    private VistaPanelAeropuerto vPanelAeropuerto;
    
    public Personal(Panel_Singleton p,VistaPanelAeropuerto vPanelaeropuerto){
        this.panel=p;
        this.vPanelAeropuerto=vPanelaeropuerto;
        modeloPanelAeropuerto=vPanelaeropuerto.modeloPanelAeropuerto;
    }
    public void ArrayVuelos(){
        vuelos=panel.ListaVuelos();
    }
  
    public void actualizarVuelo(VistaModificarVuelo vModificarVuelo) throws Exception{
        ArrayVuelos();
        boolean encontrado=false;
        int pos=0;
        while(!encontrado){
            if(vuelos.get(pos).getNumerovuelo().equals(vueloSelecionado().getNumerovuelo()))
                encontrado=true;
            else{
                pos++;
            }
        }
        System.out.println(pos);
        Vuelo vue=new Vuelo();
        vue.setCompañia(vModificarVuelo.jTextFielCompañia.getText());
        vue.setDestino(vModificarVuelo.jTextFieldDestino.getText());
        vue.setNumerovuelo(vModificarVuelo.jTextFieldNumeroVuelo.getText());
        vue.setPuertaembarque(vModificarVuelo.jTextFieldPuertaEmbarque.getText());
        vue.setEstado(vModificarVuelo.jTextFieldEstado.getText());
        vue.setHorasalida(vModificarVuelo.jTextFieldHoraSalida.getText());
        vue.setHoraLlegada(vModificarVuelo.jTextFieldHoraLLegada.getText());
        if(panel.ModificarVuelo(pos,vue)){
            System.out.println("El vuelo ha sido modificado");
        }else 
            throw new Exception("No se ha podido modificar el vuelo");
    }
    public Vuelo vueloAañadir(VistaAñadirVuelo vAñadirVuelo){
        Vuelo vuelo=new Vuelo();
        vuelo.setCompañia(vAñadirVuelo.jTextFielCompañia.getText());
        vuelo.setDestino(vAñadirVuelo.jTextFieldDestino.getText());
        vuelo.setNumerovuelo(vAñadirVuelo.jTextFieldNumeroVuelo.getText());
        vuelo.setPuertaembarque(vAñadirVuelo.jTextFieldPuertaEmbarque.getText());
        vuelo.setEstado(vAñadirVuelo.jTextFieldEstado.getText());
        vuelo.setHorasalida(vAñadirVuelo.jTextFieldHoraSalida.getText());
        vuelo.setHoraLlegada(vAñadirVuelo.jTextFieldHoraLLegada.getText());
        vAñadirVuelo.jTextFielCompañia.setText("");
        vAñadirVuelo.jTextFieldDestino.setText("");
        vAñadirVuelo.jTextFieldNumeroVuelo.setText("");
        vAñadirVuelo.jTextFieldPuertaEmbarque.setText("");
        vAñadirVuelo.jTextFieldEstado.setText("");
        vAñadirVuelo.jTextFieldHoraSalida.setText("");
        vAñadirVuelo.jTextFieldHoraLLegada.setText("");
        return vuelo;
    }
    public void AñadirVuelo(Vuelo vue) throws Exception{
        if(panel.InsertarVuelo(vue)){
            System.out.println("El vuelo ha sido añadido");
        }else 
            throw new Exception("No se ha podido insertar el nuevo vuelo");

    }
    public void RellenarActualizarVuelo(VistaModificarVuelo vModificarVuelo) throws Exception  {
            Vuelo v=vueloSelecionado();
            vModificarVuelo.jTextFielCompañia.setText(v.getCompañia());
            vModificarVuelo.jTextFieldDestino.setText(v.getDestino());
            vModificarVuelo.jTextFieldNumeroVuelo.setText(v.getNumerovuelo());
            vModificarVuelo.jTextFieldPuertaEmbarque.setText(v.getPuertaembarque());
            vModificarVuelo.jTextFieldEstado.setText(v.getEstado());
            vModificarVuelo.jTextFieldHoraSalida.setText(v.getHorasalida());
            vModificarVuelo.jTextFieldHoraLLegada.setText(v.getHoraLlegada());
    }
    public Vuelo vueloSelecionado() throws Exception{
        Vuelo vueloSelecionado=new Vuelo();
         if (vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow() != -1) {
            vueloSelecionado.setCompañia((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),0));
            vueloSelecionado.setDestino((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),1));
            vueloSelecionado.setNumerovuelo((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),2));
            vueloSelecionado.setPuertaembarque((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),3));
            vueloSelecionado.setEstado((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),4));
            vueloSelecionado.setHorasalida((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),5));
            vueloSelecionado.setHoraLlegada((String) modeloPanelAeropuerto.getValueAt(vPanelAeropuerto.jTablePanelAeropuerto.getSelectedRow(),6));
         }else {
            throw new Exception("No ha selecionado ningun vuelo");
        }
         return vueloSelecionado;
    }
    public void dibujarPanelAeropuerto() {
        String[] columnaTabla = {"Compañia", "Destino", "Numero vuelo", "Puerta de embarque",
            "Estado", "Horade salida", "Horade llegada"};

        modeloPanelAeropuerto.setColumnIdentifiers(columnaTabla);

        vPanelAeropuerto.jTablePanelAeropuerto.getTableHeader().setResizingAllowed(false);
        vPanelAeropuerto.jTablePanelAeropuerto.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(0).setPreferredWidth(110);
        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(1).setPreferredWidth(100);
        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(2).setPreferredWidth(150);
        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(3).setPreferredWidth(200);
        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(4).setPreferredWidth(100);
        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(5).setPreferredWidth(100);
        vPanelAeropuerto.jTablePanelAeropuerto.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    public void vaciarPanel() {
        while (modeloPanelAeropuerto.getRowCount() > 0) {
            modeloPanelAeropuerto.removeRow(0);
        }
    }
    public void rellenarPanelAeropuerto() {
        vaciarPanel();
        ArrayVuelos();
        Object[] fila = new Object[7];
        int numRegistros = vuelos.size();
        for (int i = 0; i < numRegistros; i++) {
            fila[0] = vuelos.get(i).getCompañia();
            fila[1] = vuelos.get(i).getDestino();
            fila[2] = vuelos.get(i).getNumerovuelo();
            fila[3] = vuelos.get(i).getPuertaembarque();
            fila[4] = vuelos.get(i).getEstado();
            fila[5] = vuelos.get(i).getHorasalida();
            fila[6] = vuelos.get(i).getHoraLlegada();
            modeloPanelAeropuerto.addRow(fila);
        }
    }
    public void EliminarVuelo(Vuelo vue) throws Exception{
        boolean encontrado=false;
        int pos=0;
        while(!encontrado){
            if(vuelos.get(pos).getNumerovuelo()==vueloSelecionado().getNumerovuelo())
                encontrado=true;
            else{
                pos++;
            }
        }
        panel.BorrarVuelo(vuelos.get(pos));
    }
}
