/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudokurmicliente;

import Estructuras.Esudokucliente;
import Estructuras.TipoDificultad;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class ListaSudokus {


    ArrayList<Esudokucliente> Sudokus=new ArrayList<>();
    
    public void añadiraLaRaid(String componente,TipoDificultad componente2) {
        Esudokucliente listaConcreo=new Esudokucliente();
        listaConcreo.Dificultad=componente2;
        listaConcreo.codigo=componente;
        Sudokus.add(listaConcreo);
    }
    public boolean eliminarLaRaid(String pCodJuego) {
        for (int i = 0; i < Sudokus.size();i++) {
            if(pCodJuego.equals(Sudokus.get(i).codigo)){
               Sudokus.remove(Sudokus.get(i));
               return true;
            }
        }
        return false;
    }
    public  String Correcta(String pCodJuego){
        for (int i = 0; i < Sudokus.size();i++) {
            if(pCodJuego.equals(Sudokus.get(i).codigo)){
               return Sudokus.get(i).codigo;
            }
        }
        return "";
    }
    public  String ListarSudokus(){
        String lista="";
        for (int i = 0; i < Sudokus.size(); i++) {
            lista+= i+"\t"+Sudokus.get(i).codigo+"\t"+Sudokus.get(i).Dificultad.toString()+"\n";
        }
        return lista;
    }   
}
