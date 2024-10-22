/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.ActualizaciónDeMonitor;
import Vista.EliminarMonitor;
import Vista.NuevoMonitor;
import Vista.VistaMonitor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author carlo
 */
public class MonitorDAO {
    Conexion conexion = null;
    PreparedStatement ps = null;
    
    
    public MonitorDAO (Conexion c){
        this.conexion = c;
    }
    public ArrayList<Monitor> listaMonitores() throws SQLException{
        ArrayList listaMonitores = new ArrayList();
        
        String consulta="SELECT * FROM MONITOR";
        ps= conexion.getConexion().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Monitor monitor = new Monitor(rs.getString(1),rs.getString(2),rs.getString(3),
                                            rs.getString(4),rs.getString(5),rs.getString(6),
                                            rs.getString(7));
            listaMonitores.add(monitor);
        }

        return listaMonitores;
    }
    public void NuevoMonitores(Monitor m) throws SQLException{
        String consulta="INSERT INTO MONITOR VALUES (?,?,?,?,?,?,?)";
        ps= conexion.getConexion().prepareStatement(consulta);
        ps.setString(1, m.getCdMonitor());
        ps.setString(2, m.getNombre());
        ps.setString(3, m.getDni());
        ps.setString(4, m.getTelefono());
        ps.setString(5, m.getCorreo());
        ps.setString(6, m.getFechaEntrada());
        ps.setString(7, m.getNick());
        ps.executeUpdate();
    }
    public void ActualizaMonitores(Monitor m) throws SQLException{
        String consulta="UPDATE MONITOR SET  nombre = ? , dni = ? , telefono = ? , correo = ? , fechaEntrada = ? , nick = ?  WHERE codMonitor=?";
        ps= conexion.getConexion().prepareStatement(consulta);
        ps.setString(7, m.getCdMonitor());
        ps.setString(1, m.getNombre());
        ps.setString(2, m.getDni());
        ps.setString(3, m.getTelefono());
        ps.setString(4, m.getCorreo());
        ps.setString(5, m.getFechaEntrada());
        ps.setString(6, m.getNick());
        ps.executeUpdate();
    }
    public void EliminarMonitores(String CodMonitor) throws SQLException{
        String consulta="DELETE FROM MONITOR WHERE codMonitor=?";
        ps= conexion.getConexion().prepareStatement(consulta);
        ps.setString(1,CodMonitor);
        ps.executeUpdate();
    }

}
