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
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author carlo
 */
public class ActividadDAO {

    Conexion conexion = null;
    PreparedStatement ps = null;
    CallableStatement stmt = null;
    String BaseDatos;

    public ActividadDAO(Conexion c){
        this.conexion = c;
    }
    public ArrayList<Actividad> listaActividades() throws SQLException{
        ArrayList listaActividades = new ArrayList();
        
        String consulta="SELECT * FROM ACTIVIDAD";
        ps= conexion.getConexion().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Actividad actividad = new Actividad(rs.getString(1),rs.getString(2),rs.getString(3),
                                            rs.getString(4));
            listaActividades.add(actividad);
        }
        
        return listaActividades;
    }
    public void pActividadesSocios(String actividad,VistaCuantosSociosEnActividad cSocios) throws SQLException {
        this.BaseDatos = conexion.informacionBD().getDatabaseProductName();
        ResultSet rs = null;
        if (BaseDatos == "Oracle") {
            String sql = "{ call pActividadesSocios(?, ?) }";
            CallableStatement llamadaP = conexion.getConexion().prepareCall(sql);
            llamadaP.setString(1, actividad);
            llamadaP.registerOutParameter(2, OracleTypes.CURSOR);
            llamadaP.execute();
            rs = (ResultSet) llamadaP.getObject(2);
            while (rs.next()) {
                cSocios.modeloTablaCuentaActividades.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        } else if (BaseDatos == "MariaDB") {
            String sql = "{ call pActividadesSocios(?) }";
            CallableStatement llamadaP= conexion.getConexion().prepareCall(sql);
            llamadaP.setString(1, actividad);
            llamadaP.execute();
            rs = llamadaP.getResultSet();
            while (rs.next()) {
                cSocios.modeloTablaCuentaActividades.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
            
        }
    }
     public void prueba(String actividad) throws SQLException {
        this.BaseDatos = conexion.informacionBD().getDatabaseProductName();
        ResultSet rs = null;
        if (BaseDatos == "MariaDB") {
            String sql = "{ call BusquedaDeNombres(?) }";
            CallableStatement llamadaP= conexion.getConexion().prepareCall(sql);
            llamadaP.setString(1, actividad);
            llamadaP.execute();
            rs = llamadaP.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }else if (BaseDatos == "Oracle") {
            String sql = "{ call BusquedaDeNombres(?, ?) }";
            CallableStatement llamadaP = conexion.getConexion().prepareCall(sql);
            llamadaP.setString(1, actividad);
            llamadaP.registerOutParameter(2, OracleTypes.CURSOR);
            llamadaP.execute();
            rs = (ResultSet) llamadaP.getObject(2);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }
     }
}
