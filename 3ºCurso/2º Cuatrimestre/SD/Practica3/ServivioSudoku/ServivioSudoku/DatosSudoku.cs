using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServicioSudoku
{
    class DatosSudoku
    {
        public int codigo;
        public char[,] Tablero = new char[9,9];
        public TipoDificultad Dificultad;
        public int llamada = 0;
        public DatosSudoku(int cod)
        {
            this.codigo = cod;
        }
    }
}
