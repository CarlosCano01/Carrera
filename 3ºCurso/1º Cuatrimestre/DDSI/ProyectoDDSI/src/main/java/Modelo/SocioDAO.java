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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author carlo
 */
public class SocioDAO {
    Conexion conexion = null;
    PreparedStatement ps = null;
    String BaseDatos=null;
    
    public SocioDAO (Conexion c){
        this.conexion = c;
    }
    
    public ArrayList<Socio> listaSocios() throws SQLException{
        ArrayList listaSocio = new ArrayList();
        
        String consulta="SELECT * FROM SOCIO";
        ps= conexion.getConexion().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Socio socio = new Socio(rs.getString(1),rs.getString(2),rs.getString(3),
                                            rs.getString(4),rs.getString(5),rs.getString(6),
                                            rs.getString(7),rs.getString(8));
            listaSocio.add(socio);
        }
        
        return listaSocio;
    }
    public void BuscarPorNombre(String actividad) throws SQLException {
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
