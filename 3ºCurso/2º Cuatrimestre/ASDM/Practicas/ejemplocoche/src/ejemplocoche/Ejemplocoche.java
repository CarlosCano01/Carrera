/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplocoche;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Ejemplocoche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int cantidad1;
        float cantidad;
        Adaptador cocheautomatico =new Adaptador();
        /*do{
            System.out.println("COCHE MANUAL");
            System.out.println("elija opcio:");
            System.out.println("1-Acelerar");
            System.out.println("2-Frenar");
            System.out.println("3-Bajar marcha");
            System.out.println("4-Subir marcha");
            System.out.println("5-Salir");
            opcion= sc.nextInt();
            switch (opcion) {
                case 1: 
                    System.out.println("Indique las revoluciones:");
                    cantidad=sc.nextFloat();
                    cochemanual.aceleraCoche(cantidad);
                break;
                case 2:
                    System.out.println("Indique las revoluciones:");
                    cantidad=sc.nextFloat();
                    cochemanual.frenar(cantidad);
                         
                break;
                case 3:
                   System.out.println("Indique cuantas marchas:");
                    cantidad1=sc.nextInt();
                    cochemanual.bajaMarcha(cantidad1);
                break;
                case 4:
                   System.out.println("Indique cuantas marchas:");
                   cantidad1=sc.nextInt();
                   cochemanual.subirMarcha(cantidad1);
                break;
                default:
                    System.out.println("Te has equivocado intentalo de nuevo");;
            }
           
        }while(opcion!=5);*/
        do{
            System.out.println("COCHE MANUAL");
            System.out.println("elija opcio:");
            System.out.println("1-Acelerar");
            System.out.println("2-Frenar");
            System.out.println("3-Bajar marcha");
            System.out.println("4-Subir marcha");
            System.out.println("5-Salir");
            opcion= sc.nextInt();
            switch (opcion) {
                case 1: 
                    System.out.println("Indique las revoluciones:");
                    cantidad=sc.nextFloat();
                    cocheautomatico.acelera(cantidad);
                break;
                case 2:
                    System.out.println("Indique las revoluciones:");
                    cantidad=sc.nextFloat();
                    cocheautomatico.frena(cantidad);
                         
                break;
                case 3:
                   System.out.println("Indique cuantas marchas:");
                break;
                default:
                    System.out.println("Elija una opcion correcta");
            }
            
        }while(opcion !=3);
        
    }
    
}
