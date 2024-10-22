/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

import Estructuras.TipoDificultad;

/**
 *
 * @author carlo
 */
public class DatosSudoku {
    
    public int codigo;
    public char[][] Tablero=new char[9][9];
    public TipoDificultad Dificultad;
    public int llamada=0;
    public DatosSudoku(int cod) {
        this.codigo=cod;
    }
    
}
