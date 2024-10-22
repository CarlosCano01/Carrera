/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relojadapter;

import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class RelojAdapter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int elecion,elecion2;
        Scanner sc=new Scanner(System.in);
        AdaptadorCalendario AC;
        AdaptadorReloj AR;
        do{
            System.out.println("¿Que desea ver?");
            System.out.println("1.Calendario");
            System.out.println("2.Reloj");
            System.out.println("0.Salir\n");
            System.out.println("Selecion: ");
            elecion = sc.nextInt();
            switch (elecion) {
                case 1:
                    do{
                        System.out.println("¿En que formato desea verla?");
                        System.out.println("1.Corto");
                        System.out.println("2.Madio");
                        System.out.println("3.Largo");
                        System.out.println("0.Salir al menu principal\n");
                        System.out.println("Selecion: ");
                        elecion2 = sc.nextInt();
                        switch (elecion2) {
                            case 1:
                                AC=new AdaptadorCalendario(1);
                                AC.mostrar();
                                break;
                            case 2:
                                AC=new AdaptadorCalendario(2);
                                AC.mostrar();
                                break;
                            case 3:
                                AC=new AdaptadorCalendario(3);
                                AC.mostrar();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Selecione una opción correcta");
                        }
                    }while(elecion2!=0);
                    break;
                case 2:
                    do{
                        System.out.println("¿En que formato desea verla?\n");
                        System.out.println("1.Corto");
                        System.out.println("2.Madio");
                        System.out.println("3.Largo");
                        System.out.println("0.Salir al menu principal\n");
                        System.out.println("Selecion: ");
                        elecion2 = sc.nextInt();
                        switch (elecion2) {
                            case 1:
                                AR = new AdaptadorReloj(1);
                                AR.mostrar();
                                break;
                            case 2:
                                AR = new AdaptadorReloj(2);
                                AR.mostrar();
                                break;
                            case 3:
                                AR = new AdaptadorReloj(3);
                                AR.mostrar();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Selecione una opción correcta");
                        }
                    }while(elecion2!=0);
                    break;    
                case 0:
                    break;
                default:
                    System.out.println("Selecione una opción correcta");
            }
        }while(elecion!=0);
    }

}
