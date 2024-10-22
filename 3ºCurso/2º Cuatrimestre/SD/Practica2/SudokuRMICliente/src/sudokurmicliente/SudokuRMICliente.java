/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokurmicliente;


import Estructuras.TipoDificultad;
import Interfaz.IGestorDeJuegos;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class SudokuRMICliente {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    try {
            Scanner sc=new Scanner(System.in);
            ArrayList<Integer> Sudokus=new ArrayList<>();
            ListaSudokus listaSudokusCliente=new ListaSudokus();
            int error=0;
            Menus menu=new Menus();
            int menuS,menuG,menuM,menuE,codActual=0;
            int fila,columna,valor;
            String codigoArevisar;
            Registry Registro = LocateRegistry.getRegistry("localhost", 2015);
            IGestorDeJuegos sudokuStub = (IGestorDeJuegos) Naming.lookup("rmi://localhost:2015/Sudoku");
            do{
                System.out.println(sudokuStub.GetSudoku(codActual));
                menuS=menu.menuServidor_de_juegos(error);
                error=0;
                switch (menuS) {
                case 0:
                    break;
                case 1:
                    do{
                        System.out.println(sudokuStub.GetSudoku(codActual));
                        menuG=menu.menuGestion_de_juegos(error);
                        error=0;
                        switch (menuG) {
                        case 0:
                            break;
                        case 1:
                            do{  
                                menuE=menu.menuEligen_la_dificultad(error);
                                error=0;
                                switch (menuE) {
                                case 0:
                                    break;
                                case 1:
                                    
                                    codActual=sudokuStub.NuevoJuego(TipoDificultad.MUY_FACIL);
                                    listaSudokusCliente.añadiraLaRaid(Integer.toString(codActual), TipoDificultad.MUY_FACIL);
                                    error=2;
                                    break;
                                case 2:
                                    codActual=sudokuStub.NuevoJuego(TipoDificultad.FACIL);
                                    listaSudokusCliente.añadiraLaRaid(Integer.toString(codActual), TipoDificultad.FACIL);
                                    error=2;
                                    break;
                                case 3:
                                    codActual=sudokuStub.NuevoJuego(TipoDificultad.MEDIO);
                                    listaSudokusCliente.añadiraLaRaid(Integer.toString(codActual), TipoDificultad.MEDIO);
                                    error=2;
                                    break;
                                case 4:
                                    codActual=sudokuStub.NuevoJuego(TipoDificultad.DIFICIL);
                                    listaSudokusCliente.añadiraLaRaid(Integer.toString(codActual), TipoDificultad.DIFICIL);
                                    error=2;
                                    break;
                                case 5:
                                    codActual=sudokuStub.NuevoJuego(TipoDificultad.MUY_DIFICIL);
                                    listaSudokusCliente.añadiraLaRaid(Integer.toString(codActual), TipoDificultad.MUY_DIFICIL);
                                    error=2;
                                    break;
                                default:
                                    error=1;
                                }
                            }while(menuE<0||menuE>6);
                            break;
                        case 2:
                            String respuesta;
                            boolean mostrarlista=true;
                            if(codActual!=0){
                                    System.out.println("¿Desea elmininar el sudoku con codigo " +codActual+"?s/n");
                                    respuesta=sc.nextLine();
                                    if("s".equals(respuesta)){
                                        listaSudokusCliente.eliminarLaRaid(Integer.toString(codActual));
                                        sudokuStub.BorrarJuego(Integer.parseInt(Integer.toString(codActual)));
                                        codActual=0;
                                        mostrarlista=false;
                                    }
                            }
                            if(mostrarlista){
                                codigoArevisar=listaSudokusCliente.Correcta(menu.menuEligen_el_sudoku(listaSudokusCliente.ListarSudokus(),2));
                                if(!"".equals(codigoArevisar)){
                                    codActual=0;
                                    listaSudokusCliente.eliminarLaRaid(codigoArevisar);
                                    sudokuStub.BorrarJuego(Integer.parseInt(codigoArevisar));
                                }else{
                                    error=3;
                                }
                            }
                            break;
                        case 3:
                            codigoArevisar=listaSudokusCliente.Correcta(menu.menuEligen_el_sudoku(listaSudokusCliente.ListarSudokus(),1));
                            if(!"".equals(codigoArevisar)){
                                codActual= Integer.parseInt(codigoArevisar);
                            }else{
                                error=3;
                            }
                            break;
                        default:
                            error=1;
                        }
                    }while(menuG!=0);
                    break;
                case 2:
                    String Posibles_numeros="0";
                    do{
                        System.out.println(sudokuStub.GetSudoku(codActual));
                        if(codActual==0){
                            error=2;
                            break;
                        }
                        menuM=menu.menuMenu_de_juegos(error,Posibles_numeros);
                        error=0;
                        
                        switch (menuM) {
                        case 1:
                            do{
                                System.out.println("Seleciona fila: ");
                                fila= sc.nextInt()-1;
                            }while(fila<0||fila>9);
                            do{
                                System.out.println("Seleciona columna: ");
                                columna= sc.nextInt()-1;
                            }while(columna<0||columna>9);
                            do{
                                System.out.println("Seleciona valor: ");
                                valor= sc.nextInt()+48;
                            }while(valor<48||valor>57);
                            if(!sudokuStub.ComprobarValor(codActual, fila, columna, (char)valor)){
                                sudokuStub.PonerValor(codActual,fila,columna,(char)valor);
                            }else{
                                error=2;
                            }
                                
                            break;
                        case 2:
                            do{
                                System.out.println("Seleciona fila: ");
                                fila= sc.nextInt()-1;
                            }while(fila<0||fila>9);
                            do{
                                System.out.println("Seleciona columna: ");
                                columna= sc.nextInt()-1;
                            }while(columna<0||columna>9);


                            sudokuStub.PonerValor(codActual,fila,columna,(char)32);
                                
                            
                            break;
                        case 3:
                            do{
                                System.out.println("Seleciona fila: ");
                                fila= sc.nextInt()-1;
                            }while(fila<0||fila>9);
                            do{
                                System.out.println("Seleciona columna: ");
                                columna= sc.nextInt()-1;
                            }while(columna<0||columna>9);
                            Posibles_numeros=sudokuStub.Ayuda(codActual, fila, columna);
                            error=3;
                            break;
                        case 0:
                            break;
                        default:
                            error=1;
                        }
                    }while(menuM!=0);
                    break;
                default:
                    error=1;
                }
            }while(menuS!=0);
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(SudokuRMICliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
