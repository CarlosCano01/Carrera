/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokurmicliente;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Menus {
    
    Scanner sc=new Scanner(System.in);
    Scanner sp=new Scanner(System.in);
    
    
    public int menuServidor_de_juegos(int Mensaje){
        
        
        switch (Mensaje) {
            case 1:
                System.out.println("***Introduce un valor correcto");
                break;
            case 2:
                System.out.println("***Seleciona o crea un sudoku***");
                break;
            default:
                System.out.println("\n");
        }
        int opcion;
        System.out.println("---- Servidor de Juegos ----\n");
        System.out.println("1.-Gestion de juegos");
        System.out.println("2.-Jugar");
        System.out.println("0.-Salir\n");
        System.out.println("Elige opcion: ");
        opcion= sc.nextInt();
        return opcion;
        
    }
    public int menuMenu_de_juegos(int Mensaje,String Posibles_numeros){
        
        switch (Mensaje) {
            case 1:
                System.out.println("***Introduce un valor correcto***");
                break;
            case 2:
                System.out.println("***Ese valor es incorrecto***");
                break;
            case 3:
                System.out.println("***Los posibles valores para ese espacio son: "+Posibles_numeros+" ***");
                break;
            default:
                System.out.println("\n");
        }
        int opcion;
        System.out.println("---- Menu de Juegos ----\n");
        System.out.println("1.-Poner Valor");
        System.out.println("2.-Borrar Valor");
        System.out.println("3.-Ayuda");
        System.out.println("0.-Salir\n");
        System.out.println("Elige opcion: ");
        opcion= sc.nextInt();
        return opcion;
        
    }
    
    public int menuGestion_de_juegos(int Mensaje){
        
        switch (Mensaje) {
            case 1:
                System.out.println("***Introduce un valor correcto***");
                break;
            case 2:
                System.out.println("***Se ha creado un nuevo juego***");
                break;
            case 3:
                System.out.println("***Introduce un codigo de un sudoku correcto***");
                break;
            default:
                System.out.println("\n");
        }
        
        int opcion;
        System.out.println("---- Gestion de Juegos ----\n");
        System.out.println("1.-Crear Juego");
        System.out.println("2.-Borrar Juego");
        System.out.println("3.-Selecionar Juego");
        System.out.println("0.-Salir\n");
        System.out.println("Elige opcion: ");
        opcion= sc.nextInt();
        return opcion;
        
    }
    
    public int menuEligen_la_dificultad(int Mensaje){
        
        switch (Mensaje) {
            case 1:
                System.out.println("***Introduce un valor correcto ***");
                break;
             case 2:
                System.out.println("***Se ha creado un juego nuevo ***");
                break;
            default:
                System.out.println("\n");
        }
        
        int opcion;
        System.out.println("---- Eligen la dificultad ----\n");
        System.out.println("1.-Muy Facil");
        System.out.println("2.-Facil");
        System.out.println("3.-Medio");
        System.out.println("4.-Dificil");
        System.out.println("5.-Muy Dificil");
        System.out.println("0.-Salir\n");
        System.out.println("Elige opcion: ");
        opcion= sc.nextInt();
        return opcion;
        
    }
    public String menuEligen_el_sudoku(String lista_sudokus,int tipo){
        String opcion;

        System.out.println("Lista de Juegos Almacenados\nPosicion\tCodigo\tDificulatad\n------------------------------------\n");
        
        System.out.println(lista_sudokus);
        switch (tipo) {
            case 1:
                System.out.println("---- Eligen el codigo del sudoku que quieres elegir----\n");
                break;
            case 2:
                System.out.println("---- Eligen el codigo del sudoku que quieres eliminar----\n");
                break;
        }
        
        opcion= sp.nextLine();

        return opcion;
        
    }
    
}
