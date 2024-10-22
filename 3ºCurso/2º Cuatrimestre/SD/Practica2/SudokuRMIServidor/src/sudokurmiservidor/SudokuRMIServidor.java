/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudokurmiservidor;

import Interfaz.IGestorDeJuegos;
import Interfaz.Sudoku;
import java.io.IOException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author carlo
 */
public class SudokuRMIServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
                
            IGestorDeJuegos sudokuStub = new Sudoku();
            Registry registro = LocateRegistry.createRegistry(2015);
            registro.rebind("Sudoku", sudokuStub);
            
            
            System.out.println("Servidor Funcionando ....");
            System.out.println("pulsa enter para finalizar");



            System.in.read();

            System.out.println("Saliendo del servidor ...");
            System.exit(0);


        } catch (IOException ex) {
            Logger.getLogger(SudokuRMIServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
   
