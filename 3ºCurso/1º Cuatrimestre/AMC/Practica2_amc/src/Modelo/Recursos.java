/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.VistaAñadirTransición;
import Vistas.VistaComprobar;
import Vistas.Vista_Crearfichero;
import java.awt.Dialog;

/**
 *
 * @author carlo
 */
public class Recursos {

    private Vista_Crearfichero vCrear;
    private VistaAñadirTransición vAt;
    private VistaComprobar vComprobar;

    /**
     * Constructor de la clase `Recursos`.
     *
     * @param vCrear Vista para la creación de archivos y definición de
     * autómatas.
     * @param vATransicion Vista para añadir transiciones a un autómata.
     * @param vComprobar Vista para la comprobación de cadenas en un autómata.
     */
    public Recursos(Vista_Crearfichero vCrear, VistaAñadirTransición vATransicion, VistaComprobar vComprobar) {
        this.vCrear = vCrear;
        this.vAt = vATransicion;
        this.vComprobar = vComprobar;
    }

    /**
     * Crea y devuelve un autómata según la información ingresada en la vista de
     * creación.
     *
     * @return Una instancia de {@code IProceso} que representa el autómata
     * creado.
     * @throws Exception Si ocurre un error durante la creación o validación del
     * autómata.
     */
    public IProceso crearautomata() throws Exception {
        String variable;
        String[] array;
        IProceso b = null;
        if (vCrear.jComboBox1.getSelectedItem().equals("AFD")) {
            AFD a = new AFD();
            //inicial
            variable = vCrear.jTextFieldEstadoInicial.getText();

            a.setInicial(variable);
            //todos los estados
            variable = vCrear.jTextFieldEstados.getText();
            array = variable.split(" ");
            a.addEstados(array);
            //estados finales
            variable = vCrear.jTextFieldEstadosFinales.getText();
            array = variable.split(" ");
            a.addfinales(array);
            //transiciones
            while (vCrear.modeloTablaTransiciones.getRowCount() > 0) {
                a.addTransicion(vCrear.modeloTablaTransiciones.getValueAt(0, 0).toString(), vCrear.modeloTablaTransiciones.getValueAt(0, 1).toString().charAt(0), vCrear.modeloTablaTransiciones.getValueAt(0, 2).toString());
                vCrear.modeloTablaTransiciones.removeRow(0);
            }
            a.validar();
            b = a;

        } else {
            AFND a = new AFND();
            //inicial
            variable = vCrear.jTextFieldEstadoInicial.getText();

            a.setInicial(variable);
            //todos los estados
            variable = vCrear.jTextFieldEstados.getText();
            array = variable.split(" ");
            a.addEstados(array);
            //estados finales
            variable = vCrear.jTextFieldEstadosFinales.getText();
            array = variable.split(" ");
            a.addfinales(array);
            //transiciones
            while (vCrear.modeloTablaTransiciones.getRowCount() > 0) {
                if(!vCrear.modeloTablaTransiciones.getValueAt(0, 1).toString().equals("")){
                    a.addTransicion(vCrear.modeloTablaTransiciones.getValueAt(0, 0).toString(), vCrear.modeloTablaTransiciones.getValueAt(0, 1).toString().charAt(0), vCrear.modeloTablaTransiciones.getValueAt(0, 2).toString());
                }else{
                    a.addtransicionesEpsilon(vCrear.modeloTablaTransiciones.getValueAt(0, 0).toString(), vCrear.modeloTablaTransiciones.getValueAt(0, 2).toString());
                }
                    
                vCrear.modeloTablaTransiciones.removeRow(0);
            }
            a.validar();
            System.out.println(a.toString());
            b = a;
        }

        return b;

    }

    /**
     * Añade una transición a la tabla de transiciones en la vista de creación.
     */
    public void añadirTransición() {
        Object[] fila = new Object[3];
        fila[0] = vAt.jTextFieldInicial.getText();
        fila[1] = vAt.jTextFieldCaract.getText();
        fila[2] = vAt.jTextFieldFinal.getText();
        vCrear.modeloTablaTransiciones.addRow(fila);
    }

    /**
     * Muestra la vista para añadir una nueva transición.
     */
    public void muestraNTransacion() {
        vAt.setLocationRelativeTo(null);
        vAt.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        vAt.setVisible(true);
    }

    /**
     * Comprueba una cadena en el autómata proporcionado y devuelve el
     * resultado.
     *
     * @param Automata El autómata sobre el cual se realiza la comprobación.
     * @return {@code true} si la cadena es aceptada, {@code false} si no lo es.
     * @throws Exception Si ocurre un error durante la comprobación.
     */
    public boolean ComprobarP(IProceso Automata) throws Exception {
        String cadena = vComprobar.jTextField1.getText();
        if (Automata.reconocer(cadena)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Muestra el nombre del archivo cargado en la vista de comprobación.
     *
     * @param archivo El nombre del archivo cargado.
     */
    public void mostrarArchivo(String archivo) {
        vComprobar.jLabelarchivo.setText(archivo);
        vComprobar.setResultadoLabelText(" ");
    }

    /**
     * Muestra el proceso paso a paso del reconocimiento de una cadena en la
     * vista de comprobación.
     *
     * @param Automata El autómata sobre el cual se realiza la comprobación.
     * @return La representación en cadena del proceso paso a paso.
     */
    public String mostrarPasoaPaso(IProceso Automata) {
        vComprobar.jTextAreaMostrarProceso.setText("");
        return Automata.PasoaPaso();
    }

    /**
     * Muestra el resultado de la comprobación y el proceso paso a paso en la
     * vista de comprobación.
     *
     * @param AutomataCargado El autómata sobre el cual se realiza la
     * comprobación.
     * @throws Exception Si ocurre un error durante la comprobación.
     */
    public void mostrarComprobación(IProceso AutomataCargado) throws Exception {
        if (ComprobarP(AutomataCargado)) {
            vComprobar.jTextAreaMostrarProceso.setText("");
            vComprobar.setResultadoLabelText("La cadena pertenece al automata");
            vComprobar.jTextAreaMostrarProceso.setText(mostrarPasoaPaso(AutomataCargado));
        } else {
            vComprobar.jTextAreaMostrarProceso.setText("");
            vComprobar.jTextAreaMostrarProceso.setText(mostrarPasoaPaso(AutomataCargado));
            vComprobar.setResultadoLabelText("La cadena no pertenece al automata");
        }
    }
}
