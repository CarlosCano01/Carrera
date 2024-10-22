using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteSW_Sudoki
{
    class Menus
    {
        public int menuServidor_de_juegos(int Mensaje)
        {


            switch (Mensaje)
            {
                case 1:
                    Console.WriteLine("***Introduce un valor correcto");
                    break;
                case 2:
                    Console.WriteLine("***Seleciona o crea un sudoku***");
                    break;
                default:
                    Console.WriteLine("\n");
                    break;
            }
            int opcion;
            Console.WriteLine("---- Servidor de Juegos ----\n");
            Console.WriteLine("1.-Gestion de juegos");
            Console.WriteLine("2.-Jugar");
            Console.WriteLine("0.-Salir\n");
            Console.WriteLine("Elige opcion: ");
            opcion = Convert.ToInt32(Console.ReadLine());
            return opcion;

        }
        public int menuMenu_de_juegos(int Mensaje, String Posibles_numeros)
        {

            switch (Mensaje)
            {
                case 1:
                    Console.WriteLine("***Introduce un valor correcto***");
                    break;
                case 2:
                    Console.WriteLine("***Ese valor es incorrecto***");
                    break;
                case 3:
                    Console.WriteLine("***Los posibles valores para ese espacio son: " + Posibles_numeros + " ***");
                    break;
                default:
                    Console.WriteLine("\n");
                    break;
            }
            int opcion;
            Console.WriteLine("---- Menu de Juegos ----\n");
            Console.WriteLine("1.-Poner Valor");
            Console.WriteLine("2.-Borrar Valor");
            Console.WriteLine("3.-Ayuda");
            Console.WriteLine("0.-Salir\n");
            Console.WriteLine("Elige opcion: ");
            opcion = Convert.ToInt32(Console.ReadLine());
            return opcion;

        }

        public int menuGestion_de_juegos(int Mensaje)
        {

            switch (Mensaje)
            {
                case 1:
                    Console.WriteLine("***Introduce un valor correcto***");
                    break;
                case 2:
                    Console.WriteLine("***Se ha creado un nuevo juego***");
                    break;
                case 3:
                    Console.WriteLine("***Introduce un codigo de un sudoku correcto***");
                    break;
                default:
                    Console.WriteLine("\n");
                    break;
            }

            int opcion;

            Console.WriteLine("---- Gestion de Juegos ----\n");
            Console.WriteLine("1.-Crear Juego");
            Console.WriteLine("2.-Borrar Juego");
            Console.WriteLine("3.-Selecionar Juego");
            Console.WriteLine("0.-Salir\n");
            Console.WriteLine("Elige opcion: ");
            opcion = Convert.ToInt32(Console.ReadLine());
            return opcion;

        }

        public int menuEligen_la_dificultad(int Mensaje)
        {

            switch (Mensaje)
            {
                case 1:
                    Console.WriteLine("***Introduce un valor correcto ***");
                    break;
                case 2:
                    Console.WriteLine("***Se ha creado un juego nuevo ***");
                    break;
                default:
                    Console.WriteLine("\n");
                    break;
            }

            int opcion;
            Console.WriteLine("---- Eligen la dificultad ----\n");
            Console.WriteLine("1.-Muy Facil");
            Console.WriteLine("2.-Facil");
            Console.WriteLine("3.-Medio");
            Console.WriteLine("4.-Dificil");
            Console.WriteLine("5.-Muy Dificil");
            Console.WriteLine("0.-Salir\n");
            Console.WriteLine("Elige opcion: ");
            opcion = Convert.ToInt32(Console.ReadLine());
            return opcion;

        }
        public String menuEligen_el_sudoku(String lista_sudokus, int tipo)
        {
            String opcion;

            Console.WriteLine("Lista de Juegos Almacenados\nPosicion\tCodigo\tDificulatad\n------------------------------------\n");

            Console.WriteLine(lista_sudokus);
            switch (tipo)
            {
                case 1:
                    Console.WriteLine("---- Eligen el codigo del sudoku que quieres elegir----\n");
                    break;
                case 2:
                    Console.WriteLine("---- Eligen el codigo del sudoku que quieres eliminar----\n");
                    break;
            }

            opcion = Console.ReadLine();

            return opcion;

        }
    }
}
