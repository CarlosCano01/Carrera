using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ServiceModel;
namespace Servidor_sudoku
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***Host del Servicio de Sudoku de WCF*************");
            using (ServiceHost nuestrohost = new ServiceHost(typeof(ServicioWeb_Sudoku.Gestor_de_juegos))) 
            {
                nuestrohost.Open();
                Console.WriteLine("Servidor funcionando...");

                Console.WriteLine("Nombre: {0}", nuestrohost.Description.ConfigurationName);
                Console.WriteLine("Puerto: {0}", nuestrohost.BaseAddresses[0].Port);
                Console.WriteLine("Path: {0}", nuestrohost.BaseAddresses[0].LocalPath);
                Console.WriteLine("Protocolo: {0}", nuestrohost.BaseAddresses[0].Scheme);
                Console.WriteLine("Pulsa Enter para Salir..");
                Console.ReadLine();

                nuestrohost.Close();

            }
        }
    }
}
