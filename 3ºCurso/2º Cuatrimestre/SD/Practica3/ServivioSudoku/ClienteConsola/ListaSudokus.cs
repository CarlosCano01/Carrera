using ServicioSudoku;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteConsola
{
    struct Esudokucliente
    {
        public String codigo;
        public TipoDificultad Dificultad;
    }
    class ListaSudokus
    {


        public ArrayList Sudokus = new ArrayList();

        public void añadiraLaRaid(String componente, TipoDificultad componente2)
        {
            Esudokucliente listaConcreo;
            listaConcreo.Dificultad = componente2;
            listaConcreo.codigo = componente;
            Sudokus.Add(listaConcreo);
        }
        public bool eliminarLaRaid(String pCodJuego)
        {
            for (int i = 0; i < Sudokus.Count; i++)
            {
                Esudokucliente listaConcreto = (Esudokucliente) Sudokus[i];
                if (pCodJuego.Equals(listaConcreto.codigo))
                {
                    Sudokus.Remove(Sudokus[i]);
                    return true;
                }
            }
            return false;
        }
        public String Correcta(String pCodJuego)
        {
            for (int i = 0; i < Sudokus.Count; i++)
            {
                Esudokucliente listaConcreto = (Esudokucliente)Sudokus[i];
                if (pCodJuego.Equals(listaConcreto.codigo))
                {
                    return listaConcreto.codigo;
                }
            }
            return "";
        }
        public String ListarSudokus()
        {
            String lista = "";
            for (int i = 0; i < Sudokus.Count; i++)
            {
                Esudokucliente listaConcreto = (Esudokucliente)Sudokus[i];
                lista += i + "\t" + listaConcreto.codigo + "\t" + listaConcreto.Dificultad.ToString() + "\n";
            }
            return lista;
        }
    }
}
