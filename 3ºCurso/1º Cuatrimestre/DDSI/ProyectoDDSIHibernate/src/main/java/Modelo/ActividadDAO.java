          /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.VistaCuantosSociosEnActividad;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author carlo
 */
public class ActividadDAO {

    Session conexion = null;
    PreparedStatement ps = null;
    CallableStatement stmt = null;
    String BaseDatos;

    public ActividadDAO(Session c){
        this.conexion = c;
    }
    public ArrayList<Actividad> listaActividades() {
        Transaction transaction = conexion.beginTransaction();
        Query consulta = conexion.createNativeQuery("SELECT * FROM ACTIVIDAD A ORDER BY A.idActividad", Actividad.class);
        ArrayList<Actividad> listaActividad = (ArrayList<Actividad>) consulta.list();
        transaction.commit();
        
        return listaActividad;
    }
     public ArrayList<Socio> pActividadesSocios(String idActividad,String BaseDatos) {
        ArrayList<Socio> Socios =new ArrayList<>();
        if (BaseDatos == "Oracle") {
            Transaction transaction = conexion.beginTransaction();
            StoredProcedureQuery llamada = conexion.createStoredProcedureCall("pActividadesSocios")
            .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
            .registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR)
            .setParameter(1, idActividad);
            llamada.execute();
            ArrayList<String> resultado = (ArrayList<String>) llamada.getResultList();
            int i=0;
            while( i < resultado.size()){
                String res=resultado.get(i);
                Socios.add(conexion.get(Socio.class, res));
                i++;
            }
            transaction.commit();
        } else if (BaseDatos == "MariaDB") {
            Transaction transaction = conexion.beginTransaction();
            StoredProcedureQuery llamada = conexion.createStoredProcedureCall("pActividadesSocios")
            .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
            .setParameter(1, idActividad);
            llamada.execute();
            ArrayList<String> resultado = (ArrayList<String>) llamada.getResultList();
            transaction.commit();
            int i=0;
            while( i < resultado.size()){
                String res=resultado.get(i);
                Socios.add(conexion.get(Socio.class, res));
                i++;
            }
        }
        return Socios;
    }
     public ArrayList<String> pCodigosNoActividad(String idActividad,String BaseDatos) {
        ArrayList<String> resultado =new ArrayList<>();
        if (BaseDatos == "Oracle") {
            Transaction transaction = conexion.beginTransaction();
            StoredProcedureQuery llamada = conexion.createStoredProcedureCall("NOACTIVIDADESSOCIOS")
            .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
            .registerStoredProcedureParameter(2, Class.class, ParameterMode.REF_CURSOR)
            .setParameter(1, idActividad);
            llamada.execute();
            resultado = (ArrayList<String>) llamada.getResultList();
            transaction.commit();
        } else if (BaseDatos == "MariaDB") {
            Transaction transaction = conexion.beginTransaction();
            StoredProcedureQuery llamada = conexion.createStoredProcedureCall("NOACTIVIDADESSOCIOS")
            .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
            .setParameter(1, idActividad);
            llamada.execute();
            resultado = (ArrayList<String>) llamada.getResultList();
            transaction.commit();
           
        }
        return resultado;
    }
     public void DarDeBaja(Session sesion,String numsoc,String idactividad){
        
        Transaction transaction = sesion.beginTransaction();
        Socio socio = sesion.get(Socio.class, numsoc);
        Actividad actividad = sesion.get(Actividad.class, idactividad);
        actividad.eliminaSocio(socio);
        sesion.save(actividad);
        transaction.commit();
        
     }
     public void DarDeAlta(Session sesion,String numsoc,String idactividad){
        
        Transaction transaction = sesion.beginTransaction();
        Socio socio = sesion.get(Socio.class, numsoc);
        Actividad actividad = sesion.get(Actividad.class, idactividad);
        actividad.addSocio(socio);
        sesion.save(actividad); // también podríamos haber usado sesion.save(socio)
        transaction.commit();
        
     }
}
