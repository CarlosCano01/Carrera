/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import oracle.jdbc.OracleTypes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author carlo
 */
public class SocioDAO {
    Session conexion = null;

    public SocioDAO (Session c){
        this.conexion = c;
    }
    
    public ArrayList<Socio> listaSocios(){
        Transaction transaction = conexion.beginTransaction();
        Query consulta = conexion.createNativeQuery("SELECT * FROM SOCIO S ORDER BY S.numeroSocio", Socio.class);
        ArrayList<Socio> listaSocio = (ArrayList<Socio>) consulta.list();
        transaction.commit();
        
        return listaSocio;
    }
    public ArrayList<Socio> BuscarPorNombre(String letra) throws Exception {
        Transaction transaction = conexion.beginTransaction();
        letra = letra + "%";
        Query consulta = conexion.createNativeQuery("SELECT * FROM SOCIO S "
                + "WHERE nombre LIKE :letra", Socio.class).setParameter("letra", letra);
        ArrayList<Socio> socios = (ArrayList<Socio>) consulta.list();
        transaction.commit();
        return socios;
    }
   
    public void EliminarSocio(String NumSoc){
        Transaction transaction = conexion.beginTransaction();
        Socio socio = conexion.get(Socio.class, NumSoc);
        conexion.delete(socio);
        transaction.commit();
    }
    public void ActualizaOIngresaSocios(Socio s) throws Exception{
        Transaction transaction = conexion.beginTransaction();
        conexion.save(s);
        transaction.commit();
    }
    
}
