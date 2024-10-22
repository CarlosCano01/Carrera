using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace ServicioWeb_Sudoku
{


    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código y en el archivo de configuración a la vez.
    
    [ServiceBehavior(ConcurrencyMode =ConcurrencyMode.Multiple,InstanceContextMode = InstanceContextMode.Single)]
    public class Gestor_de_juegos : IGestor_de_juegos
    {
        private Random random = new Random();
        private ArrayList Lista_Sudokus = new ArrayList();
        private int posicion = 0;
        DatosSudoku actual = null;
        public Gestor_de_juegos()
        {
            DatosSudoku vacio = new DatosSudoku(posicion);
            Lista_Sudokus.Add(vacio);
            actual = vacio;
            Inicializar(TipoDificultad.VACIO);
        }
        private void Quesudoku(int pCodJuego)
        {

            for (int i = 0; i < Lista_Sudokus.Count; i++)
            {
                DatosSudoku aux = (DatosSudoku)Lista_Sudokus[i];
                if (aux.codigo == pCodJuego)
                {
                    actual = (DatosSudoku)Lista_Sudokus[i];
                    break;
                }
            }
        }
        void Inicializar(TipoDificultad pDifi)
        {
            actual.Dificultad = pDifi;
            for (int f = 0; f < 9; f++)
            {
                for (int c = 0; c < 9; c++)
                {
                    actual.Tablero[f, c] = ' ';
                }
            }
        }

        public int NuevoJuego(TipoDificultad pDifi)
        {
            posicion += 1;
            DatosSudoku nuevo = new DatosSudoku(posicion);
            actual = nuevo;
            int f, c;
            char Valor;
            Inicializar(pDifi);

            char[] ValoresActuales = new char[81];

            for (int i = 0; i < 81; i++)
            {
                ValoresActuales[i] = ' ';
            }

            int Pos;
            for (char v = '1'; v <= '9'; v++)
            {
                Pos = (int)random.Next(0, 9);
                while (ValoresActuales[Pos] != ' ')
                {
                    Pos++;
                    if (Pos == 9)
                    {
                        Pos = 0;
                    }
                }
                ValoresActuales[Pos] = v;
                PonerValorAux(actual.codigo, 0, Pos, v);

            }

            Pos = 9;
            while (Pos < 81)
            {
                f = Pos / 9;
                c = Pos % 9;
                Valor = ValoresActuales[Pos] != ' ' ? ValoresActuales[Pos] : '0';

                bool EsCorrecto = false;
                while (EsCorrecto == false && Valor < '9')
                {
                    Valor++;
                    PonerValorAux(actual.codigo, f, c, Valor);
                    EsCorrecto = ComprobarValorAux(actual.codigo, f, c, Valor);
                }

                if (EsCorrecto == true)
                {
                    ValoresActuales[Pos] = Valor;
                    Pos++;
                }
                else
                {
                    ValoresActuales[Pos] = ' ';
                    PonerValorAux(actual.codigo, f, c, ' ');
                    Pos--;
                }
            }

            int NHuecos = 0;
            switch (pDifi)
            {
                case TipoDificultad.MUY_FACIL:
                    NHuecos = 10;
                    break;
                case TipoDificultad.FACIL:
                    NHuecos = 30;
                    break;
                case TipoDificultad.DIFICIL:
                    NHuecos = 60;
                    break;
                case TipoDificultad.MUY_DIFICIL:          //Esto no me gusta
                    NHuecos = 70;
                    break;
                default:
                    NHuecos = 40;
                    break;
            }

            for (int i = 0; i < NHuecos; i++)
            {
                do
                {
                    f = (int)(int)random.Next(0, 9);
                    c = (int)(int)random.Next(0, 9);
                } while (ObtenerValorAux(actual.codigo, f, c) == ' ');
                PonerValorAux(actual.codigo, f, c, ' ');
            }

            Lista_Sudokus.Add(actual);
            return posicion;
        }

        //Dado un código de sudoku lo elimina. Devuelve true si se ha realizado, false si el
        //juego no existe.
        public bool BorrarJuego(int pCodJuego)
        {
            Quesudoku(pCodJuego);
            Inicializar(TipoDificultad.VACIO);
            return true;
        }

        //Actualiza la posición pFila, pColumna con el valor pValor en el tablero del sudoku cuyo
        //código es pasado por parámetro. Devuelve true si se ha podido actualizar, false si el
        //juego no existe.
        public bool PonerValor(int pCodJuego, int pFila, int pColumna, char pValor)
        {
            return PonerValorAux(pCodJuego, pFila, pColumna, pValor);
        }

        //Devuelve el valor de la posición pFila, PColumna del tablero del sudoku cuyo código es
        //pasado por parámetro. Si la posición no existe en el tablero devuelve ‘-‘.
        public char ObtenerValor(int pCodJuego, int pFila, int pColumna)
        {
            return ObtenerValorAux(pCodJuego, pFila, pColumna);
        }

        //Comprueba si la posición pFila, pColumna del tablero del sudoku cuyo código es pasado
        //por parámetro, si puede o no actualizarse. Devuelve true si la posición indicada 
        //verifica las reglas del sudoku, false si no las verifica o bien si el juego no existe.
        public bool ComprobarValor(int pCodJuego, int pFila, int pColumna, char pValor)
        {
            return ComprobarValorAux(pCodJuego, pFila, pColumna, pValor);
        }

        //Devuelve el número de posiciones del tablero que están vacías en el sudoku cuyo código
        //es pasado por parámetro. Si no existe el sudoku devuelve -1.
        public int NumeroHuecos(int pCodJuego)
        {
            return NumeroHuecosAux(pCodJuego);
        }

        //Devuelve una cadena con todos los posibles valores que pueden ponerse en la posición
        //pFila, pColumna. Devolverá un string vacío si el juego no existe o bien si la posición
        //indicada no se puede poner ningún valor.
        public string Ayuda(int pCodJuego, int pFila, int pColumna)
        {
            Quesudoku(pCodJuego);
            char Valor;
            int Pos = 0;
            String s = "";
            char v = ObtenerValorAux(pCodJuego, pFila, pColumna);
            if (v == ' ')
            {
                Valor = '1';
                while (Valor <= '9')
                {
                    PonerValorAux(pCodJuego, pFila, pColumna, Valor);
                    if (ComprobarValorAux(pCodJuego, pFila, pColumna, Valor) == true)
                    {
                        s += Valor;
                        s += ' ';
                    }
                    Valor++;
                }
                PonerValorAux(pCodJuego, pFila, pColumna, ' ');
                s += '\0';
            }
            return s;
        }

        //Verifica que el sudoku cuyo código es pasado por parámetro, no tiene posiciones que 
        //incumplen las reglas del sudoku. Devuelve true si el tablero es correcto, false si no
        //lo es o bien si el juego no existe.
        public bool Correcto(int pCodJuego)
        {
            Quesudoku(pCodJuego);
            bool Salida = true;
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

        //Devuelve una copia formateada del sudoku cuyo código es pasado por parámetro, 
        //incluyendo la información del sudoku y el contenido del tablero. Si juego no existe
        //en la información indicará “**Sudoku Vacío **”.
        public string GetSudoku(int pCodJuego)
        {
            Quesudoku(pCodJuego);
            String numero;
            String pSudo = "Dificultad: ";
            switch (actual.Dificultad)
            {
                case TipoDificultad.MUY_FACIL:
                    pSudo += "Muy Fácil";
                    break;
                case TipoDificultad.FACIL:
                    pSudo += "Fácil";
                    break;
                case TipoDificultad.MEDIA:
                    pSudo += "Media";
                    break;
                case TipoDificultad.DIFICIL:
                    pSudo += "Difícil";
                    break;
                case TipoDificultad.MUY_DIFICIL:
                    pSudo += "Muy Difícil";
                    break;
                default:
                    pSudo += "** Sudoku vacio **";
                    break;
            }

            numero = (NumeroHuecosAux(actual.codigo).ToString());
            pSudo += "\tHuecos: ";
            pSudo += numero;
            pSudo += "\n  123 456 789\n";
            for (int f = 0; f < 9; f++)
            {

                if (f % 3 == 0)
                {
                    pSudo += " +---+---+---+\n";
                }
                numero = (f + 1).ToString();
                pSudo += numero;
                for (int c = 0; c < 9; c++)
                {
                    if (c % 3 == 0)
                    {
                        pSudo += "|";
                    }
                    if (f == actual.llamada)
                    {
                        if (ObtenerValorAux(actual.codigo, f, c) != ' ')
                        {
                            pSudo += 'X';
                        }
                        else
                        {
                            numero = (ObtenerValorAux(actual.codigo, f, c)).ToString();
                            pSudo += numero;
                        }

                    }
                    else
                    {
                        numero = (ObtenerValorAux(actual.codigo, f, c)).ToString();
                        pSudo += numero;
                    }
                }
                pSudo += "|\n";
            }
            actual.llamada++;
            if (actual.llamada > 8)
            {
                actual.llamada = 0;
            }
            pSudo += " +---+---+---+\n";
            return pSudo;
        }
        private int BuscarPorFila(int pFil, char pVal)
        {
            int Cuantos = 0;
            for (int c = 0; c < 9 && Cuantos < 2; c++)
            {
                if (actual.Tablero[pFil, c] == pVal)
                {
                    Cuantos++;
                }
            }
            return Cuantos;
        }

        private int BuscarPorColumna(int pCol, char pVal)
        {
            int Cuantos = 0;
            for (int f = 0; f < 9 && Cuantos < 2; f++)
            {
                if (actual.Tablero[f, pCol] == pVal)
                {
                    Cuantos++;
                }
            }
            return Cuantos;
        }

        private int BuscarPorBloque(int pFil, int pCol, char pVal)
        {
            int minF = (pFil / 3) * 3;
            int minC = (pCol / 3) * 3;
            int maxF = minF + 3;
            int maxC = minC + 3;

            int Cuantos = 0;
            for (int f = minF; f < maxF && Cuantos < 2; f++)
            {
                for (int c = minC; c < maxC && Cuantos < 2; c++)
                {
                    if (actual.Tablero[f, c] == pVal)
                    {
                        Cuantos++;
                    }
                }
            }
            return Cuantos;
        }
        private bool PonerValorAux(int pCodJuego, int pFila, int pColumna, char pValor)
        {
            Quesudoku(pCodJuego);
            actual.Tablero[pFila, pColumna] = pValor;
            return true;
        }
        char ObtenerValorAux(int pCodJuego, int pFila, int pColumna)
        {
            Quesudoku(pCodJuego);
            return actual.Tablero[pFila, pColumna];
        }
        private bool ComprobarValorAux(int pCodJuego, int pFila, int pColumna, char pValor)
        {
            Quesudoku(pCodJuego);
            bool Salida = true;
            if (BuscarPorFila(pFila, pValor) != 1 || BuscarPorColumna(pColumna, pValor) != 1 || BuscarPorBloque(pFila, pColumna, pValor) != 1)
            {
                Salida = false;
            }
            return Salida;
        }
        private int NumeroHuecosAux(int pCodJuego)
        {
            Quesudoku(pCodJuego);
            int Cuantos = 0;
            for (int f = 0; f < 9; f++)
            {
                for (int c = 0; c < 9; c++)
                {
                    if (actual.Tablero[f, c] == ' ')
                    {
                        Cuantos++;
                    }
                }
            }
            return Cuantos;
        }
    }
}
