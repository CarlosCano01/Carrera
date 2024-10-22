/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class Conexion {

    private Connection conectar = null;

    public Conexion(String sgbd, String ip, String servicio_bd, String usuario, String password) throws SQLException, ClassNotFoundException {
        String cadena = null;
        if ("MariaDB"==sgbd) {
            cadena = "jdbc:mariadb://" + ip + ":3306/" + servicio_bd;
        } else if ("Oracle"==sgbd) {
            cadena = cadena = "jdbc:oracle:thin:@" + ip + ":1521:" + servicio_bd;
        }
        conectar = DriverManager.getConnection(cadena, usuario, password);
    }

    public void desconexion() throws SQLException {
        conectar.close();
    }

    public DatabaseMetaData informacionBD() throws SQLException {

        return conectar.getMetaData();
    }
    public Connection getConexion(){
        return conectar;
    }
}
