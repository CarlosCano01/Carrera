using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using Cliente;
using System.Collections;

namespace ServicioSudoku
{
    class Cliente
    {
        static void Main(string[] args)
        {

            

                ArrayList Sudokus = new ArrayList();
                ListaSudokus listaSudokusCliente = new ListaSudokus();
                int error = 0;
                Menus menu = new Menus();
                int menuS, menuG, menuM, menuE, codActual = 0;
                int fila, columna, valor;
                String codigoArevisar;
                ChannelServices.RegisterChannel(new TcpChannel(), false);
                ServicioSudoku Sudoku = new ServicioSudoku();
                RemotingServices.Marshal(Sudoku, "ServicioSudoku");
            do
                {
                    Console.WriteLine(Sudoku.GetSudoku(codActual));
                    menuS = menu.menuServidor_de_juegos(error);
                    error = 0;
                    switch (menuS)
                    {
                        case 0:
                            break;
                        case 1:
                            do
                            {
                                Console.WriteLine(Sudoku.GetSudoku(codActual));
                                menuG = menu.menuGestion_de_juegos(error);
                                error = 0;
                                switch (menuG)
                                {
                                    case 0:
                                        break;
                                    case 1:
                                        do
                                        {
                                            menuE = menu.menuEligen_la_dificultad(error);
                                            error = 0;
                                            float porcentS;
                                            switch (menuE)
                                            {                
                                                case 0:
                                                    break;
                                                case 1:

                                                    codActual = Sudoku.NuevoJuego(TipoDificultad.MUY_FACIL);                                                  
                                                    porcentS = Sudoku.Completo(codActual);
                                                    listaSudokusCliente.añadiraLaRaid(codActual.ToString(), TipoDificultad.MUY_FACIL, porcentS);
                                                    error = 2;
                                                    break;
                                                case 2:
                                                    codActual = Sudoku.NuevoJuego(TipoDificultad.FACIL);
                                                    porcentS = Sudoku.Completo(codActual);
                                                    listaSudokusCliente.añadiraLaRaid(codActual.ToString(), TipoDificultad.FACIL, porcentS);
                                                    error = 2;
                                                    break;
                                                case 3:
                                                    codActual = Sudoku.NuevoJuego(TipoDificultad.MEDIA);
                                                    porcentS = Sudoku.Completo(codActual);
                                                    listaSudokusCliente.añadiraLaRaid(codActual.ToString(), TipoDificultad.MEDIA, porcentS);
                                                    error = 2;
                                                    break;
                                                case 4:
                                                    codActual = Sudoku.NuevoJuego(TipoDificultad.DIFICIL);
                                                    porcentS = Sudoku.Completo(codActual);
                                                    listaSudokusCliente.añadiraLaRaid(codActual.ToString(), TipoDificultad.DIFICIL, porcentS);
                                                    error = 2;
                                                    break;
                                                case 5:
                                                    codActual= Sudoku.NuevoJuego(TipoDificultad.MUY_DIFICIL);
                                                    porcentS = Sudoku.Completo(codActual);
                                                    listaSudokusCliente.añadiraLaRaid(codActual.ToString(), TipoDificultad.MUY_DIFICIL, porcentS);
                                                    error = 2;
                                                    break;
                                                default:
                                                    error = 1;
                                                    break;
                                            }
                                        } while (menuE < 0 || menuE > 6);
                                        break;
                                    case 2:
                                        String respuesta;
                                        bool mostrarlista = true;
                                        if (codActual!= 0)
                                        {
                                            Console.WriteLine("¿Desea elmininar el sudoku con codigo " + (codActual).ToString() + "?s/n");
                                            respuesta = Console.ReadLine();
                                            if ("s".Equals(respuesta))
                                            {
                                                listaSudokusCliente.eliminarLaRaid(codActual.ToString());
                                                Sudoku.BorrarJuego(codActual);
                                                codActual= 0;
                                                mostrarlista = false;
                                            }
                                        }
                                        if (mostrarlista)
                                        {
                                            codigoArevisar = listaSudokusCliente.Correcta(menu.menuEligen_el_sudoku(listaSudokusCliente.ListarSudokusSP(), 2));
                                            if (!"".Equals(codigoArevisar))
                                            {
                                                codActual = 0;
                                                listaSudokusCliente.eliminarLaRaid(codigoArevisar);
                                                Sudoku.BorrarJuego(Convert.ToInt32(codigoArevisar));
                                            }
                                            else
                                            {
                                                error = 3;
                                            }
                                        }
                                        break;
                                    case 3:
                                        codigoArevisar = listaSudokusCliente.Correcta(menu.menuEligen_el_sudoku(listaSudokusCliente.ListarSudokus(), 1));
                                        if (!"".Equals(codigoArevisar))
                                        {
                                            codActual= Convert.ToInt32(codigoArevisar);
                                        }
                                        else
                                        {
                                            error = 3;
                                        }
                                        break;
                                    default:
                                        error = 1;
                                        break;
                                }
                            } while (menuG != 0);
                            break;
                        case 2:
                            String Posibles_numeros = "0";
                            do
                            {
                                Console.WriteLine(Sudoku.GetSudoku(codActual));
                                if (codActual == 0)
                                {
                                    error = 2;
                                    break;
                                }
                                menuM = menu.menuMenu_de_juegos(error, Posibles_numeros);
                                error = 0;

                                switch (menuM)
                                {
                                    case 1:
                                        do
                                        {
                                            Console.WriteLine("Seleciona fila: ");
                                            fila = Convert.ToInt32(Console.ReadLine()) - 1;
                                        } while (fila < 0 || fila > 9);
                                        do
                                        {
                                            Console.WriteLine("Seleciona columna: ");
                                            columna = Convert.ToInt32(Console.ReadLine())- 1;
                                        } while (columna < 0 || columna > 9);
                                        do
                                        {
                                            Console.WriteLine("Seleciona valor: ");
                                            valor = Convert.ToInt32(Console.ReadLine()) + 48;
                                        } while (valor < 48 || valor > 57);
                                        if (!Sudoku.ComprobarValor(codActual, fila, columna, (char)valor))
                                        {
                                            Sudoku.PonerValor(codActual, fila, columna, (char)valor);
                                        }
                                        else
                                        {
                                            error = 2;
                                        }
                                        listaSudokusCliente.actualizarPor(codActual.ToString(),Sudoku.Completo(codActual));
                                        break;
                                    case 2:
                                        do
                                        {
                                            Console.WriteLine("Seleciona fila: ");
                                            fila = Convert.ToInt32(Console.ReadLine()) - 1;
                                        } while (fila < 0 || fila > 9);
                                        do
                                        {
                                            Console.WriteLine("Seleciona columna: ");
                                            columna = Convert.ToInt32(Console.ReadLine()) - 1;
                                        } while (columna < 0 || columna > 9);


                                        Sudoku.PonerValor(codActual, fila, columna, (char)32);
                                        listaSudokusCliente.actualizarPor(codActual.ToString(), Sudoku.Completo(codActual));

                                    break;
                                    case 3:
                                        do
                                        {
                                            Console.WriteLine("Seleciona fila: ");
                                            fila = Convert.ToInt32(Console.ReadLine()) - 1;
                                        } while (fila < 0 || fila > 9);
                                        do
                                        {
                                            Console.WriteLine("Seleciona columna: ");
                                            columna = Convert.ToInt32(Console.ReadLine()) - 1;
                                        } while (columna < 0 || columna > 9);
                                        Posibles_numeros = Sudoku.Ayuda(codActual, fila, columna);
                                        error = 3;
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        error = 1;
                                        break;
                                }
                            } while (menuM != 0);
                            break;
                        default:
                            error = 1;
                            break;
                    }
            } while (menuS != 0);

        }
    }
}
