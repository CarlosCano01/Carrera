/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaPanelAeropuerto;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author carlo
 */
public class Panel_Singleton {
    
    private ArrayList<Vuelo> vuelos;
    private static Panel_Singleton panel;
    
    
    private Panel_Singleton() {
        vuelos=new ArrayList<>();
    }
    
    public static Panel_Singleton getSingletonInstance() {
        if (panel == null){
            panel = new Panel_Singleton();
        }
        else{
            System.out.println("No se puede crear el objeto porque ya existe un objeto de la clase Panel_Singleton ");
        }
        return panel;
    }
    public boolean InsertarVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
        return true;
    }
    public boolean ModificarVuelo(int pos ,Vuelo vue){
        vuelos.set(pos, vue);
        return vuelos.get(pos)==vue;
    }
    public boolean BorrarVuelo(Vuelo vuelo){
        return vuelos.remove(vuelo);
    }
    public ArrayList<Vuelo> ListaVuelos(){
        return vuelos;
    }
    
}
