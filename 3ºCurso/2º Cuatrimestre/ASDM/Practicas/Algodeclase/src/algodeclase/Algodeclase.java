/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algodeclase;

import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Algodeclase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Scanner sc1= new Scanner(System.in);
        int opcion,posX,posY,tam;
        String n;
        Figura figura;
        Creador miFabrica = new Creador_Concreto();
        do {            
            System.out.println("que quieres crear : \n1-Circulo\n2-Clon circulo\n3-Cuadrado\n4-Clon nCuadrado\n5-Salir");
            opcion=sc.nextInt();
            while(opcion<1 || opcion>5){
                System.err.println("Las opciones deben estar entre 1 y 5 , intentelo de nuevo");
                opcion=sc.nextInt();
            }
            switch (opcion) {
                case 1:
                    
                break;
                case 2:
                    
                break;
                case 3:
                    figura=miFabrica.Factory_method(opcion);
                    System.out.println("que nombre quiere:");
                    n=sc1.nextLine();
                    figura.setNombre(n);
                    System.out.println("codenada x:");
                    posX=sc.nextInt();
                    figura.setposX();
                   System.out.println("codenada y:");
                    posY=sc.nextInt();
                    figura.set(posY);
                    System.out.println("Tamaño");
                    tam=sc.nextInt();
                    figura.set(tam);
                break;
                case 4:
                    
                break;
            }
        } while (opcion!=5);
    }
    
}
