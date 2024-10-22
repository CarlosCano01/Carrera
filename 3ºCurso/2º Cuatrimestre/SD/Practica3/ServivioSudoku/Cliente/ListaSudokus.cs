using ServicioSudoku;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cliente
{
    struct Esudokucliente
    {
        public String codigo;
        public TipoDificultad Dificultad;
        public float por;
    }
    class ListaSudokus
    {
        public ArrayList Sudokus = new ArrayList();

        public void actualizarPor(String pCodJuego, float por)
        {
            for (int i = 0; i < Sudokus.Count; i++)
            {
                Esudokucliente listaConcreto = (Esudokucliente)Sudokus[i];
                if (pCodJuego.Equals(listaConcreto.codigo))
                {
                    listaConcreto.por = por;
                    int index= Sudokus.IndexOf(Sudokus[i]);
                    Sudokus.Remove(Sudokus[i]);
                    Sudokus.Insert(index, listaConcreto);
                }
            }
        }
        public void añadiraLaRaid(String componente, TipoDificultad componente2,float por)
        {
            Esudokucliente listaConcreo= new Esudokucliente();
            listaConcreo.Dificultad = componente2;
            listaConcreo.codigo = componente;
            listaConcreo.por = por;
            Sudokus.Add(listaConcreo);
        }
        public bool eliminarLaRaid(String pCodJuego)
        {
            for (int i = 0; i < Sudokus.Count; i++)
            {
                Esudokucliente listaConcreto = (Esudokucliente)Sudokus[i];
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
            float media=0;
            for (int i = 0; i < Sudokus.Count; i++)
            {
                Esudokucliente listaConcreto = (Esudokucliente)Sudokus[i];
                media += listaConcreto.por;
                lista += i + "\t" + listaConcreto.codigo + "\t" + listaConcreto.Dificultad.ToString() + "\t"+listaConcreto.por.ToString() + "\n";
            }
            media = (media / Sudokus.Count);
            lista += "\n" + "La media de completitud es: " + media+ "\n";
            return lista;
        }
        public String ListarSudokusSP()
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
