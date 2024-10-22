/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import java.util.ArrayList;
import practica1_amc.Punto;
import practica1_amc.Resultado;


public class AlgoritmoExhaustivo {

    
    public static Resultado BusquedaExhauxtiva(ArrayList<Punto> p){
        Punto p1=null;
        Punto p2=null;
        double distanciaMin = Double.MAX_VALUE;
        for(int i=0;i<p.size()-1;i++){
            for(int j=i+1;j<p.size();j++){
                double distancia=p.get(i).distancia(p.get(j));
                if(distancia<distanciaMin){
                    distanciaMin=distancia;
                    p1=p.get(i);
                    p2=p.get(j);
                }
            }
        }
        Resultado resultado=new Resultado(p1,p2,distanciaMin);
        return resultado;
    }
    
    public static Resultado BusquedaExhauxtivaPoda(ArrayList<Punto> p){
        ArrayList<Punto> clonP=p;
        AlgoritmoOrdenacion.OrdenaQuickSortX(clonP);
        
        double distanciaMin = Double.MAX_VALUE;
        Punto p1=null;
        Punto p2=null;
        for (int i = 0; i < clonP.size()-2;i++) {
            int j = i + 1;
            while (j < clonP.size()) {
                if ((clonP.get(j).getX() - clonP.get(i).getX()) >= distanciaMin) {
                    j = p.size(); 
                } else {
                    double distancia = clonP.get(i).distancia(clonP.get(j));
                    if (distancia < distanciaMin) {
                        distanciaMin = distancia;
                        p1 = clonP.get(i);
                        p2 = clonP.get(j);
                    }
                    j++;
                }
            }
        }
        Resultado resultado=new Resultado(p1,p2,distanciaMin);
        return resultado;
    }
    
}
