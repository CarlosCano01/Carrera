/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author carlo
 */
public class Comparaciones {
    
    //Comprueba si el correo introducio es correcto
    public boolean ComparaCorreo(String correo) {
        int contadorarroba = 0;
        int haypalabraDespues = 0;
        int haypalabraAntes = 0;
        for (int i = 0; i < correo.length(); i++) {
            String Arroba = correo.substring(i, i + 1);
            if (contadorarroba == 0) {
                haypalabraAntes++;
            }
            if (contadorarroba == 1 && !".".equals(Arroba)) {
                haypalabraDespues++;
            }
            if ("@".equals(Arroba)) {
                contadorarroba++;
            }
        }
        return contadorarroba == 1 && haypalabraAntes > 0 && haypalabraDespues > 0;
    }

    //Comprueba si el dni introducido es correcto
    public boolean DNICorecto(String DNI) {

        String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String[] Numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String numero;
        String miDNI = "";
        if (DNI.length() != 9 || Character.isLetter(DNI.charAt(8)) == false) {
            return false;
        }
        String letraMayuscula = (DNI.substring(8)).toUpperCase();

        for (int i = 0; i < DNI.length() - 1; i++) {
            numero = DNI.substring(i, i + 1);

            for (String Numero : Numeros) {
                if (numero.equals(Numero)) {
                    miDNI += Numero;
                }
            }
        }
        int nDNI = Integer.parseInt(miDNI);
        int resto = nDNI % 23;
        if (asignacionLetra[resto].equals(letraMayuscula)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean NumeroTelefonoCorrecto(String Telefono) {
        
        String[] Numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String telefono = "";
        if (Telefono.length() != 9 ) {
            return false;
        }

        for (int i = 0; i < Telefono.length(); i++) {
            String numero = Telefono.substring(i, i + 1);

            for (String Numero : Numeros) {
                if (numero.equals(Numero)) {
                    telefono += Numero;
                }
            }
        }
        return telefono.length() == 9;

    }
    public boolean FechaAdecuada(Date fecha) {
      
        Date fechaHoy= new Date();
        return fechaHoy.before(fecha);

    }

}
