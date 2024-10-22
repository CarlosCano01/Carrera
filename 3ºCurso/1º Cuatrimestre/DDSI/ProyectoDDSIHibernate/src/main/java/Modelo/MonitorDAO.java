/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author carlo
 */
public class MonitorDAO {

    Session conexion = null;
    public MonitorDAO(Session c) {
        this.conexion = c;
    }

    //Metodo que recoge de la base de datos todos las tuplas de la tabla MONITOR y los devuelve en una array
    public ArrayList<Monitor> listaMonitores(){
        Transaction transaction = conexion.beginTransaction();
        Query consulta = conexion.createNativeQuery("SELECT * FROM MONITOR M ORDER BY M.codMonitor", Monitor.class);
        ArrayList<Monitor> monitores = (ArrayList<Monitor>) consulta.list();
        transaction.commit();
        
        return monitores;
    }

    //Metodo que introduce una nueva tupla en la tabla MONITOR
    public void ActualizaOIngresaMonitores(Monitor m) throws Exception{
        Transaction transaction = conexion.beginTransaction();
        conexion.save(m);
        transaction.commit();
    }
    
    //Metodo que elimina un monitor de la tabla MONITOR
    public void EliminarMonitores(String codMonitor){
        Transaction transaction = conexion.beginTransaction();
        Monitor monitor = conexion.get(Monitor.class, codMonitor);
        conexion.delete(monitor);
        transaction.commit();
    }

}
