/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Estructuras.DatosSudoku;
import Estructuras.TipoDificultad;
import static Estructuras.TipoDificultad.VACIO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Sudoku extends UnicastRemoteObject implements IGestorDeJuegos {

    //Cuanto mayor sea la dificultad el sudoku tendrá más casillas vacías.
    ArrayList<DatosSudoku> Lista_Sudokus=new ArrayList<>();
    int posicion = 0;
    DatosSudoku actual = null;

    public Sudoku() throws RemoteException {
        super();
        DatosSudoku vacio = new DatosSudoku(posicion);
        Lista_Sudokus.add(vacio);
        actual = vacio;
        Inicializar(VACIO);
    }
    public void Quesudoku(int pCodJuego){
        for (int i = 0; i < Lista_Sudokus.size(); i++) {
            if(Lista_Sudokus.get(i).codigo==pCodJuego){
               actual=Lista_Sudokus.get(i);
            }
        }
    }
    public void Inicializar(TipoDificultad pDifi) {
        actual.Dificultad = pDifi;
        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                actual.Tablero[f][c] = ' ';
            }
        }
    }
    
    @Override
    public synchronized int NuevoJuego(TipoDificultad pDifi) throws RemoteException {
        DatosSudoku nuevo = new DatosSudoku(++posicion);
        actual=nuevo;
        int f, c;
        char Valor;
        Inicializar(pDifi);

        char[] ValoresActuales = new char[81];

        for (int i = 0; i < 81; i++) {
            ValoresActuales[i] = ' ';
        }

        int Pos;
        for (char v = '1'; v <= '9'; v++) {
            Pos = (int) (Math.random() * 9);
            while (ValoresActuales[Pos] != ' ') {
                Pos++;
                if (Pos == 9) {
                    Pos = 0;
                }
            }
            ValoresActuales[Pos] = v;
            PonerValor(actual.codigo, 0, Pos, v);

        }

        Pos = 9;
        while (Pos < 81) {
            f = Pos / 9;
            c = Pos % 9;
            Valor = ValoresActuales[Pos] != ' ' ? ValoresActuales[Pos] : '0';

            boolean EsCorrecto = false;
            while (EsCorrecto == false && Valor < '9') {
                Valor++;
                PonerValor(actual.codigo, f, c, Valor);
                EsCorrecto = ComprobarValor(actual.codigo, f, c, Valor);
            }

            if (EsCorrecto == true) {
                ValoresActuales[Pos] = Valor;
                Pos++;
            } else {
                ValoresActuales[Pos] = ' ';
                PonerValor(actual.codigo, f, c, ' ');
                Pos--;
            }
        }

        int NHuecos = 0;
        switch (pDifi) {
            case MUY_FACIL:
                NHuecos = 10;
                break;
            case FACIL:
                NHuecos = 30;
                break;
            case DIFICIL:
                NHuecos = 60;
                break;
            case MUY_DIFICIL:
                NHuecos = 70;
                break;
            default:
                NHuecos = 40;
        }

        for (int i = 0; i < NHuecos; i++) {
            do {
                f = (int) (Math.random() * 9);
                c = (int) (Math.random() * 9);
            } while (ObtenerValor(actual.codigo, f, c) == ' ');
            PonerValor(actual.codigo, f, c, ' ');
        }
        Lista_Sudokus.add(actual);
        return posicion;
    }    
    
    
    @Override
    public synchronized boolean BorrarJuego(int pCodJuego) throws RemoteException {
        Quesudoku(pCodJuego);
        Inicializar(VACIO);
        return true;
    }

    @Override
    public synchronized boolean PonerValor(int pCodJuego, int pFila, int pColumna, char pValor) throws RemoteException {
        Quesudoku(pCodJuego);
        actual.Tablero[pFila][pColumna] = pValor;
        return true;
    }

    @Override
    public synchronized char ObtenerValor(int pCodJuego, int pFila, int pColumna) throws RemoteException {
        Quesudoku(pCodJuego);
        return actual.Tablero[pFila][pColumna];
    }

    @Override
    public synchronized boolean ComprobarValor(int pCodJuego, int pFila, int pColumna, char pValor) throws RemoteException {
        Quesudoku(pCodJuego);
        boolean Salida = true;
        if (BuscarPorFila(pFila, pValor) != 1 || BuscarPorColumna(pColumna, pValor) != 1 || BuscarPorBloque(pFila, pColumna, pValor) != 1) {
            Salida = false;
        }
        return Salida;
    }

    @Override
    public synchronized int NumeroHuecos(int pCodJuego) throws RemoteException {
        Quesudoku(pCodJuego);
        int Cuantos = 0;
        for (int f = 0; f < 9; f++) {
            for (int c = 0; c < 9; c++) {
                if (actual.Tablero[f][c] == ' ') {
                    Cuantos++;
                }
            }
        }
        return Cuantos;
    }

    @Override
    public synchronized String Ayuda(int pCodJuego, int pFila, int pColumna) throws RemoteException {
        Quesudoku(pCodJuego);
        char Valor;
        int Pos=0;
        String s="";
        char v = ObtenerValor(pCodJuego,pFila, pColumna);
        if (v == ' ')
        {
            Valor = '1';
            while (Valor <= '9')
            {
                PonerValor(pCodJuego,pFila, pColumna, Valor);
                if (ComprobarValor(pCodJuego,pFila, pColumna, Valor) == true)
                {
                    s+=Valor;
                    s+=' ';
                }
                Valor++;
            }
            PonerValor(pCodJuego,pFila, pColumna, ' ');
            s+='\0';
        }
            return s;
    }

    @Override
    public synchronized boolean Correcto(int pCodJuego) throws RemoteException {
        Quesudoku(pCodJuego);
        boolean Salida = true;
        char Valor = '1';
        int f, c;
        while (Valor <= '9' && Salida == true)
        {
            c = 0;
            while (c < 9 && Salida == true)
            {
                if (BuscarPorColumna(c, Valor) != 1)
                {
                    Salida = false;
                }
                c++;
            };
            f = 0;
            while (f < 9 && Salida == true)
            {
                if (BuscarPorFila(f, Valor) != 1)
                {
                    Salida = false;
                }
                f++;
            };

            for (f = 0; f < 9 && Salida == true; f += 3)
            {
                for (c = 0; c < 9 && Salida == true; c += 3)
                {
                    if (BuscarPorBloque(f, c, Valor) != 1)
                    {
                        Salida = false;
                    }
                }
            }
            Valor++;
        }
        return Salida;
    }

    @Override
    public synchronized String GetSudoku(int pCodJuego) throws RemoteException {
        Quesudoku(pCodJuego);
        String numero;
        String pSudo = "Dificultad: ";
        switch (actual.Dificultad) {
            case MUY_FACIL:
                pSudo += "Muy Fácil";
                break;
            case FACIL:
                pSudo +=  "Fácil";
                break;
            case MEDIO:
                pSudo +=  "Media";
                break;
            case DIFICIL:
                pSudo +=  "Difícil";
                break;
            case MUY_DIFICIL:
                pSudo += "Muy Difícil";
                break;
            default:
                pSudo += "** Sudoku vacoo **";
        }

        numero=Integer.toString(NumeroHuecos(actual.codigo));
        pSudo+="\tHuecos: ";
        pSudo += numero;
        pSudo += "\n  123 456 789\n";
        for (int f = 0; f < 9; f++) {

            if (f % 3 == 0) {
                pSudo += " +---+---+---+\n";
            }
            numero=Integer.toString(f+1);
           pSudo += numero;
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                     pSudo += "|";
                }
                if(f==actual.llamada){
                    if(ObtenerValor(actual.codigo,f, c)!= ' '){
                        pSudo += 'X';
                    }else{
                        numero = Character.toString(ObtenerValor(actual.codigo,f, c));
                        pSudo += numero;
                    }
                    
                }
                else{
                    numero = Character.toString(ObtenerValor(actual.codigo,f, c));
                    pSudo += numero;
                }
            }
            pSudo += "|\n";
        }
        actual.llamada++;
        if(actual.llamada>8){
            actual.llamada=0;
        }
        pSudo += " +---+---+---+\n";
        return pSudo;
    }

    int BuscarPorFila(int pFil, char pVal) {
        int Cuantos = 0;
        for (int c = 0; c < 9 && Cuantos < 2; c++) {
            if (actual.Tablero[pFil][c] == pVal) {
                Cuantos++;
            }
        }
        return Cuantos;
    }

    int BuscarPorColumna(int pCol, char pVal) {
        int Cuantos = 0;
        for (int f = 0; f < 9 && Cuantos < 2; f++) {
            if (actual.Tablero[f][pCol] == pVal) {
                Cuantos++;
            }
        }
        return Cuantos;
    }

    int BuscarPorBloque(int pFil, int pCol, char pVal) {
        int minF = (pFil / 3) * 3;
        int minC = (pCol / 3) * 3;
        int maxF = minF + 3;
        int maxC = minC + 3;

        int Cuantos = 0;
        for (int f = minF; f < maxF && Cuantos < 2; f++) {
            for (int c = minC; c < maxC && Cuantos < 2; c++) {
                if (actual.Tablero[f][c] == pVal) {
                    Cuantos++;
                }
            }
        }
        return Cuantos;
    }
}
