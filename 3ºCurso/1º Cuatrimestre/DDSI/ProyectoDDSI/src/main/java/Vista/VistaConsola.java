/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author carlos
 */
public class VistaConsola {

    public void mensajeConsola(String texto) {
        System.out.println(texto);
    }

    public void mensajeConsola(String texto, String error) {
        System.out.println(texto);
        System.out.println(error);

    }

    public void mensajeMetadatos(DatabaseMetaData dbmd) throws SQLException {
        // Versión del driver
        String Driver = dbmd.getDriverName();
        //Nombre de la base de datos 
        String nombre = dbmd.getDatabaseProductName();
        //Versión de la base de datos
         String BD = dbmd.getDatabaseProductVersion();
        //URL de la conexión
         String URL = dbmd.getURL();
        // Versión del driver
         String VDriver = dbmd.getDriverVersion();
        // Nombre del usuario con el que se ha conectado
         String NUsuario = dbmd.getUserName();
        // Lista de términos SQL que tiene la base de datos que no pertenecen al SQL estándar
        //String SQL = dbmd.gets();
        System.out.println("************************************************************");
        System.out.println("Nombre del usuario: "+NUsuario);
        System.out.println("Nombre de la base de datos: "+nombre);
        System.out.println("Verión de la base de datos: "+BD);
        System.out.println("Nombre del driver: "+Driver);
        System.out.println("Version del driver: "+VDriver);
        System.out.println("Nombre de la URL: "+URL);
        //System.out.println("Lista de terminos: "+SQL);
        System.out.println("************************************************************");
    }
}
