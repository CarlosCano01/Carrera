/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "GestorJuegos.h"
#include <unistd.h>

int MenuDeJuego();
int MenuPrincipal();
int MenuDeElecionDificultad();

int
main (int argc, char *argv[])
{
	char *host;
	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	
	CLIENT *clnt;
	int opcionPrincipal,opcionJuego,opcionElecion,*result;
	int codigoactual=0;
	bool_t *resultadoBorrado;
	RCadena *resultCadena;
	TDificultad aux;
	
	
	
	clnt = clnt_create (host, GESTORJUEGOS, GESTORJUEGOS_VER, "tcp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
	
	printf("Cliente: Tengo Conexión con el servidor.... comenzamos\n\n");
	do
	{
	   system ("clear");
	   codigoactual=0;
	   resultCadena=getsudoku_1(&codigoactual,clnt);
	   printf("%s",resultCadena->Contenido);
	   opcionPrincipal=MenuPrincipal();

	   switch (opcionPrincipal)
	   {
	   	
		case 1: 
			
                system ("clear");
				printf("%d\n",codigoactual);
				resultCadena=getsudoku_1(&codigoactual,clnt);
	   			printf("%s",resultCadena->Contenido);
                opcionElecion= MenuDeElecionDificultad();
                switch (opcionElecion){
                	case 1:
						aux=MUY_FACIL;
                    	result = nuevo_1(&aux, clnt);
                    	break;
            		case 2:
						aux=FACIL;
                    	result = nuevo_1(&aux, clnt);
                    	break; 
					case 3:
						aux=MEDIA;
                    	result = nuevo_1(&aux, clnt);
                    	break;
					case 4:
						aux=DIFICIL;
                    	result = nuevo_1(&aux, clnt);
                    	break; 
					case 5:
						aux=MUY_DIFICIL;
                    	result = nuevo_1(&aux, clnt);
                    	break;

                    default:
                       	printf("Introduce un número correcto\n");
                }
			
			codigoactual=*result;
			if (result == (int *) NULL) 
                clnt_perror (clnt, "Cliente: Error en la llamada al procedimiento Dividir");
            do{
                system ("clear");
				resultCadena=getsudoku_1(&codigoactual,clnt);
	   			printf("%s",resultCadena->Contenido);
                opcionJuego=MenuDeJuego();
                switch (opcionJuego){
                	case 1:
                    	printf("Esta opcion no estan disponiblen todavia\n");
                    break;
                    case 2: 
					char opcion;
						printf("¿Desea eliminar el sudoku %d? s/n\n",codigoactual);
						scanf("%c",&opcion);
						if(opcion=='s'){
							resultadoBorrado=borrar_1(&codigoactual,clnt);
							if(*resultadoBorrado){
								opcionJuego=-1;
							}
							
						}
					case 3: 
					case 4: 
					case 5:
					case 6:
						opcionPrincipal=6;
					break;
                    default:
                       	printf("Introduce un número correcto\n");
                }
			}while(opcionPrincipal!=6 || opcionJuego!=-1);
	   
		break;
		case 2: 
		case 3: 
		case 4: 
		case 5:
			printf("Estas opciones no estan disponibles todavia\n");
		break;
		case 6:
			break;
  		default: 
  			printf("Introduce un número correcto\n");
	   }

	} while (opcionPrincipal!=6);
exit (0);
}

int MenuDeJuego()
{
  int opcion;
  do
  {
     printf("1.- --------------\n2.- Borrar Juego\n3.- Poner Valor\n4.- Borrar Valor\n5.- Ayuda\n6.- Salir\n\nElige opcion:");
     scanf("%d",&opcion);
  } while (opcion<1 || opcion>6);
  return opcion;
}
int MenuDeElecionDificultad()
{
  int opcion;
  do
  {
     printf("1.- Muy facil\n2.- Facil \n3.- Medio\n4.- Dificil\n5.- Muy dificil\n\nElige opcion:");
     scanf("%d",&opcion);
  } while (opcion<1 || opcion>5);
  return opcion;
}
int MenuPrincipal()
{
  int opcion;
  do
  {
     printf("1.- Juego Nuevo\n2.- --------------\n3.- --------------\n4.- --------------\n5.- --------------\n6.- Salir\n\nElige opcion:");
     scanf("%d",&opcion);
  } while (opcion<1 || opcion>6);
  return opcion;
}