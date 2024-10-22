/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plnatillaadaptador;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class PlnatillaAdaptador {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Adaptado ap = new Adaptado("Inicial");
        String forma;
        /*System.out.println("¿Como queieres saca elnombre? MASYUSCULA/minuscula");
        forma = sc.nextLine();
        ap.mostrarNombre(forma);*/
        System.out.println("¿Como queieres saca elnombre? 1-MASYUSCULA/2-minuscula");
        forma =sc.nextLine(); 
        
    }
    
}
