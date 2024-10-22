using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;

namespace ServicioSudoku
{
    class Cliente
    {
        static void Main(string[] args)
        {
            ChannelServices.RegisterChannel(new TcpChannel(), false);
            ServicioSudoku Calculadora = (ServicioSudoku)Activator.GetObject(typeof(ServicioSudoku), "tcp://localhost:12345/ServicioSudoku");
        }
    }
}
