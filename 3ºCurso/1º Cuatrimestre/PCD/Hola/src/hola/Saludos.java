/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hola;

import java.util.Random;

/**
 * Esta cales no sirve para nada
 * 
 * @author usuario
 * 
 */
public class Saludos implements Isaludos {

    private int tipo;
    Random r = new Random();

    Saludos(int tipo) {
        this.tipo = tipo;
        r.setSeed(System.currentTimeMillis());
    }
    /**
     * Este metodo saluda
     * @param mensaje que es el saludo
     * @return siempre un 0 porque esto no sirve 
     * @throws Exception cuando el objeto invalido
     */
    @Override
    public int saludar(String mensaje) throws Exception {
        if (tipo == 0) {
            System.out.println("Hola mundo");
        } else if (tipo == 1) {
            System.out.println(mensaje);
        } else {
            throw new Exception("Tipo del objeto invalido");
        }
        return 0;
    }

    public void parimpar() {
        int ale = r.nextInt(10);
        if (ale % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }
    }
}
