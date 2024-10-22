/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "GestorJuegos.h"
#include <stdbool.h>
#include <unistd.h>

typedef struct 
{
	int Codigo; //Código del juego
	char Tablero[9][9]; //Tablero de juego
	TDificultad Dificultad; //Dificultad
} TJuego;
TJuego *Sudokus = NULL; //Vector dinámico de Juegos
int NSudokus=0; //Número de juegos almacenados en el vector Sudokus
int contadorCod=0;
int  posActual=0;
char ObtenerValorAux(int f,int c);
void QueSudoku(int cod);
void Inicializar(TDificultad pDifi);
int NumeroHuecosAux();
bool PonerValorAux(int f,int c,char v);
bool ComprobarValorAux(int f,int c,char v);
int BuscarPorFila(int pFil, char pVal);
int BuscarPorColumna(int pCol, char pVal);
int BuscarPorBloque(int pFil, int pCol, char pVal);



int *
nuevo_1_svc(TDificultad *argp, struct svc_req *rqstp)
{
	static int  result;

	int f, c;
    char Valor;
	contadorCod++;
	posActual=NSudokus++;
	Sudokus=(TJuego *)realloc(Sudokus,sizeof(TJuego)*NSudokus);

	

    Inicializar(*argp);

    char ValoresActuales[81];
    srand(getpid());

    for (int i = 0; i < 81; i++)
        ValoresActuales[i] = ' ';

    int Pos;
    for (char v = '1'; v <= '9'; v++)
    {
        Pos = rand()%9;
        while (ValoresActuales[Pos] != ' ')
        {
            Pos++;
            if (Pos == 9)
                Pos = 0;
        };
        ValoresActuales[Pos] = v;
        PonerValorAux(0, Pos, v);
    };

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
            PonerValorAux(f, c, Valor);
            EsCorrecto = ComprobarValorAux(f, c, Valor);
        };

        if (EsCorrecto == true)
        {
            ValoresActuales[Pos] = Valor;
            Pos++;
        }
        else
        {
            ValoresActuales[Pos] = ' ';
            PonerValorAux(f, c, ' ');
            Pos--;
        }
    }

    int NHuecos = 0;
    switch (*argp)
    {
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
    };

    for (int i = 0; i < NHuecos; i++)
    {
        do
        {
            f = rand()%9;
            c = rand()%9;
        }
        while (ObtenerValorAux(f, c) == ' ');
        PonerValorAux(f, c, ' ');
    }
	Sudokus[posActual].Codigo=contadorCod;
	result=contadorCod;
	return &result;
}

bool_t *
borrar_1_svc(int *argp, struct svc_req *rqstp)
{
	static bool_t  result;
	if(QueSudoku(*argp)){
		Inicializar(VACIO)
		NSudokus--;
		result=true;
	}else{
		result=false;
	}


	return &result;
}

bool_t *
ponervalor_1_svc(TFCV *argp, struct svc_req *rqstp)
{
	static bool_t  result;

	/*
	 * insert server code here
	 */

	return &result;
}

char *
obtenervalor_1_svc(TFC *argp, struct svc_req *rqstp)
{
	static char  result;

	result=ObtenerValorAux(argp->pFil,argp->pCol);

	return &result;
}

bool_t *
comprobarvalor_1_svc(TFCV *argp, struct svc_req *rqstp)
{
	static bool_t  result;

	/*
	 * insert server code here
	 */

	return &result;
}

int *
numerohuecos_1_svc(int *argp, struct svc_req *rqstp)
{
	static int  result;

	result=NumeroHuecosAux();

	return &result;
}

bool_t *
correcto_1_svc(int *argp, struct svc_req *rqstp)
{
	static bool_t  result;

	/*
	 * insert server code here
	 */

	return &result;
}

RCadena *
ayuda_1_svc(TFC *argp, struct svc_req *rqstp)
{
	static RCadena  result;

	/*
	 * insert server code here
	 */

	return &result;
}

RCadena *
getsudoku_1_svc(int *argp, struct svc_req *rqstp)
{
	static RCadena result;

	RCadena aux;

	QueSudoku(*argp);

	Cadena Numero;
	Cadena pSudo;
    strcpy(pSudo,"Dificultad: ");
    switch (Sudokus[posActual].Dificultad)
    {
    case MUY_FACIL:
        strcat(pSudo,"Muy Fácil");
        break;
    case FACIL:
        strcat(pSudo,"Fácil");
        break;
    case MEDIA:
        strcat(pSudo,"Media");
        break;
    case DIFICIL:
        strcat(pSudo,"Difícil");
        break;
    case MUY_DIFICIL:
        strcat(pSudo,"Muy Difícil");
        break;
    default:
        strcat(pSudo,"** Sudoku vacío **");
    }

    sprintf(Numero,"%d",NumeroHuecosAux());
    strcat(pSudo, "\tHuecos: ");
    strcat(pSudo,Numero);
    strcat(pSudo,"\n  123 456 789\n");
    for (int f = 0; f < 9; f++)
    {
        if (f % 3 == 0)
            strcat(pSudo," +---+---+---+\n");

        sprintf(Numero,"%d",f+1);
        strcat(pSudo,Numero);
        for (int c = 0; c < 9; c++)
        {
            if (c % 3 == 0)
                strcat(pSudo,"|");
            sprintf(Numero,"%c",ObtenerValorAux(f, c));
            strcat(pSudo,Numero);
        };
        strcat(pSudo,"|\n");
    };
    strcat(pSudo," +---+---+---+\n");
	strcpy(aux.Contenido,pSudo);
	aux.Salida=true;
	result=aux;
	return &result;
}


bool_t QueSudoku(int cod){
	if(NSudokus!=0){
		for(int i=0;i<NSudokus;i++){
			if(cod==Sudokus[i].Codigo){
				posActual=i;
				return true;
			}else{
				posActual=0;
			}
		}
		return false;
	}else{
		Sudokus=(TJuego *)malloc(sizeof(TJuego));
		NSudokus++;
		Inicializar(VACIO);
		return true;
	}
}
void Inicializar(TDificultad pDifi)
{

    Sudokus[posActual].Dificultad=pDifi;
    for (int f = 0; f < 9; f++)
        for (int c = 0; c < 9; c++)
            Sudokus[posActual].Tablero[f][c] = (char) 32;


}

int NumeroHuecosAux(){
	int Cuantos = 0;
    for (int f = 0; f < 9; f++)
        for (int c = 0; c < 9; c++)
            if (Sudokus[posActual].Tablero[f][c] == (char) 32)
                Cuantos++;
    return Cuantos;
}

char ObtenerValorAux(int f,int c){
	return Sudokus[posActual].Tablero[f][c];
}
bool PonerValorAux(int f,int c,char v){
	
	Sudokus[posActual].Tablero[f][c] = v;
	return true;
}
bool ComprobarValorAux(int f,int c,char v){
	bool Salida = true;
    if (BuscarPorFila(f, v) != 1 || BuscarPorColumna(c, v) != 1 || BuscarPorBloque(f, c, v) != 1)
        Salida = false;
    return Salida;
}
int BuscarPorFila(int pFil, char pVal)
{
    int Cuantos = 0;
    for (int c = 0; c < 9 && Cuantos < 2; c++)
        if (Sudokus[posActual].Tablero[pFil][c] == pVal)
            Cuantos++;
    return Cuantos;
}

int BuscarPorColumna(int pCol, char pVal)
{
    int Cuantos = 0;
    for (int f = 0; f < 9 && Cuantos < 2; f++)
        if (Sudokus[posActual].Tablero[f][pCol] == pVal)
            Cuantos++;
    return Cuantos;
}

int BuscarPorBloque(int pFil, int pCol, char pVal)
{
    int minF = (pFil / 3) * 3;
    int minC = (pCol / 3) * 3;
    int maxF = minF + 3;
    int maxC = minC + 3;

    int Cuantos = 0;
    for (int f = minF; f < maxF && Cuantos < 2; f++)
        for (int c = minC; c < maxC && Cuantos < 2; c++)
            if (Sudokus[posActual].Tablero[f][c] == pVal)
                Cuantos++;
    return Cuantos;
}