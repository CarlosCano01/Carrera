﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ClienteSW_Sudoki.ServicioSudoku {
    using System.Runtime.Serialization;
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="TipoDificultad", Namespace="http://schemas.datacontract.org/2004/07/ServicioWeb_Sudoku")]
    public enum TipoDificultad : int {
        
        [System.Runtime.Serialization.EnumMemberAttribute()]
        VACIO = 0,
        
        [System.Runtime.Serialization.EnumMemberAttribute()]
        MUY_FACIL = 1,
        
        [System.Runtime.Serialization.EnumMemberAttribute()]
        FACIL = 2,
        
        [System.Runtime.Serialization.EnumMemberAttribute()]
        MEDIA = 3,
        
        [System.Runtime.Serialization.EnumMemberAttribute()]
        DIFICIL = 4,
        
        [System.Runtime.Serialization.EnumMemberAttribute()]
        MUY_DIFICIL = 5,
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioSudoku.IGestor_de_juegos")]
    public interface IGestor_de_juegos {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/NuevoJuego", ReplyAction="http://tempuri.org/IGestor_de_juegos/NuevoJuegoResponse")]
        int NuevoJuego(ClienteSW_Sudoki.ServicioSudoku.TipoDificultad pDifi);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/NuevoJuego", ReplyAction="http://tempuri.org/IGestor_de_juegos/NuevoJuegoResponse")]
        System.Threading.Tasks.Task<int> NuevoJuegoAsync(ClienteSW_Sudoki.ServicioSudoku.TipoDificultad pDifi);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/BorrarJuego", ReplyAction="http://tempuri.org/IGestor_de_juegos/BorrarJuegoResponse")]
        bool BorrarJuego(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/BorrarJuego", ReplyAction="http://tempuri.org/IGestor_de_juegos/BorrarJuegoResponse")]
        System.Threading.Tasks.Task<bool> BorrarJuegoAsync(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/PonerValor", ReplyAction="http://tempuri.org/IGestor_de_juegos/PonerValorResponse")]
        bool PonerValor(int pCodJuego, int pFila, int pColumna, char pValor);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/PonerValor", ReplyAction="http://tempuri.org/IGestor_de_juegos/PonerValorResponse")]
        System.Threading.Tasks.Task<bool> PonerValorAsync(int pCodJuego, int pFila, int pColumna, char pValor);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/ObtenerValor", ReplyAction="http://tempuri.org/IGestor_de_juegos/ObtenerValorResponse")]
        char ObtenerValor(int pCodJuego, int pFila, int pColumna);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/ObtenerValor", ReplyAction="http://tempuri.org/IGestor_de_juegos/ObtenerValorResponse")]
        System.Threading.Tasks.Task<char> ObtenerValorAsync(int pCodJuego, int pFila, int pColumna);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/ComprobarValor", ReplyAction="http://tempuri.org/IGestor_de_juegos/ComprobarValorResponse")]
        bool ComprobarValor(int pCodJuego, int pFila, int pColumna, char pValor);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/ComprobarValor", ReplyAction="http://tempuri.org/IGestor_de_juegos/ComprobarValorResponse")]
        System.Threading.Tasks.Task<bool> ComprobarValorAsync(int pCodJuego, int pFila, int pColumna, char pValor);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/NumeroHuecos", ReplyAction="http://tempuri.org/IGestor_de_juegos/NumeroHuecosResponse")]
        int NumeroHuecos(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/NumeroHuecos", ReplyAction="http://tempuri.org/IGestor_de_juegos/NumeroHuecosResponse")]
        System.Threading.Tasks.Task<int> NumeroHuecosAsync(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/Ayuda", ReplyAction="http://tempuri.org/IGestor_de_juegos/AyudaResponse")]
        string Ayuda(int pCodJuego, int pFila, int pColumna);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/Ayuda", ReplyAction="http://tempuri.org/IGestor_de_juegos/AyudaResponse")]
        System.Threading.Tasks.Task<string> AyudaAsync(int pCodJuego, int pFila, int pColumna);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/Correcto", ReplyAction="http://tempuri.org/IGestor_de_juegos/CorrectoResponse")]
        bool Correcto(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/Correcto", ReplyAction="http://tempuri.org/IGestor_de_juegos/CorrectoResponse")]
        System.Threading.Tasks.Task<bool> CorrectoAsync(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/GetSudoku", ReplyAction="http://tempuri.org/IGestor_de_juegos/GetSudokuResponse")]
        string GetSudoku(int pCodJuego);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IGestor_de_juegos/GetSudoku", ReplyAction="http://tempuri.org/IGestor_de_juegos/GetSudokuResponse")]
        System.Threading.Tasks.Task<string> GetSudokuAsync(int pCodJuego);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IGestor_de_juegosChannel : ClienteSW_Sudoki.ServicioSudoku.IGestor_de_juegos, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class Gestor_de_juegosClient : System.ServiceModel.ClientBase<ClienteSW_Sudoki.ServicioSudoku.IGestor_de_juegos>, ClienteSW_Sudoki.ServicioSudoku.IGestor_de_juegos {
        
        public Gestor_de_juegosClient() {
        }
        
        public Gestor_de_juegosClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public Gestor_de_juegosClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public Gestor_de_juegosClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public Gestor_de_juegosClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public int NuevoJuego(ClienteSW_Sudoki.ServicioSudoku.TipoDificultad pDifi) {
            return base.Channel.NuevoJuego(pDifi);
        }
        
        public System.Threading.Tasks.Task<int> NuevoJuegoAsync(ClienteSW_Sudoki.ServicioSudoku.TipoDificultad pDifi) {
            return base.Channel.NuevoJuegoAsync(pDifi);
        }
        
        public bool BorrarJuego(int pCodJuego) {
            return base.Channel.BorrarJuego(pCodJuego);
        }
        
        public System.Threading.Tasks.Task<bool> BorrarJuegoAsync(int pCodJuego) {
            return base.Channel.BorrarJuegoAsync(pCodJuego);
        }
        
        public bool PonerValor(int pCodJuego, int pFila, int pColumna, char pValor) {
            return base.Channel.PonerValor(pCodJuego, pFila, pColumna, pValor);
        }
        
        public System.Threading.Tasks.Task<bool> PonerValorAsync(int pCodJuego, int pFila, int pColumna, char pValor) {
            return base.Channel.PonerValorAsync(pCodJuego, pFila, pColumna, pValor);
        }
        
        public char ObtenerValor(int pCodJuego, int pFila, int pColumna) {
            return base.Channel.ObtenerValor(pCodJuego, pFila, pColumna);
        }
        
        public System.Threading.Tasks.Task<char> ObtenerValorAsync(int pCodJuego, int pFila, int pColumna) {
            return base.Channel.ObtenerValorAsync(pCodJuego, pFila, pColumna);
        }
        
        public bool ComprobarValor(int pCodJuego, int pFila, int pColumna, char pValor) {
            return base.Channel.ComprobarValor(pCodJuego, pFila, pColumna, pValor);
        }
        
        public System.Threading.Tasks.Task<bool> ComprobarValorAsync(int pCodJuego, int pFila, int pColumna, char pValor) {
            return base.Channel.ComprobarValorAsync(pCodJuego, pFila, pColumna, pValor);
        }
        
        public int NumeroHuecos(int pCodJuego) {
            return base.Channel.NumeroHuecos(pCodJuego);
        }
        
        public System.Threading.Tasks.Task<int> NumeroHuecosAsync(int pCodJuego) {
            return base.Channel.NumeroHuecosAsync(pCodJuego);
        }
        
        public string Ayuda(int pCodJuego, int pFila, int pColumna) {
            return base.Channel.Ayuda(pCodJuego, pFila, pColumna);
        }
        
        public System.Threading.Tasks.Task<string> AyudaAsync(int pCodJuego, int pFila, int pColumna) {
            return base.Channel.AyudaAsync(pCodJuego, pFila, pColumna);
        }
        
        public bool Correcto(int pCodJuego) {
            return base.Channel.Correcto(pCodJuego);
        }
        
        public System.Threading.Tasks.Task<bool> CorrectoAsync(int pCodJuego) {
            return base.Channel.CorrectoAsync(pCodJuego);
        }
        
        public string GetSudoku(int pCodJuego) {
            return base.Channel.GetSudoku(pCodJuego);
        }
        
        public System.Threading.Tasks.Task<string> GetSudokuAsync(int pCodJuego) {
            return base.Channel.GetSudokuAsync(pCodJuego);
        }
    }
}
