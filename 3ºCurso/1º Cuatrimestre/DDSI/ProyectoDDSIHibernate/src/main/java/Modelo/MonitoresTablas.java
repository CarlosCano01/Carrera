/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.ActualizaciónDeMonitor;
import Vista.NuevoMonitor;
import Vista.VistaMonitor;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class MonitoresTablas {

    DefaultTableModel modeloTablaMonitores = null;
    Monitor m = new Monitor();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Comparaciones cmp=new Comparaciones();
    public void inicializarTablaMonitores(VistaMonitor vMonitor) {
        this.modeloTablaMonitores = vMonitor.modeloTablaMonitores;
    }

    //Metodo que dibuja en la VistaMonitor un jTable la tabla
    public void dibujarTablaMonitores(VistaMonitor vMonitor) {
        String[] columnaTabla = {"Código", "Nombre", "DNI", "Teléfono",
            "Correo", "Fecha Incorporación", "Nick"};
        inicializarTablaMonitores(vMonitor);
        modeloTablaMonitores.setColumnIdentifiers(columnaTabla);

        vMonitor.jTableMonitores.getTableHeader().setResizingAllowed(false);
        vMonitor.jTableMonitores.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vMonitor.jTableMonitores.getColumnModel().getColumn(0).setPreferredWidth(40);
        vMonitor.jTableMonitores.getColumnModel().getColumn(1).setPreferredWidth(240);
        vMonitor.jTableMonitores.getColumnModel().getColumn(2).setPreferredWidth(70);
        vMonitor.jTableMonitores.getColumnModel().getColumn(3).setPreferredWidth(70);
        vMonitor.jTableMonitores.getColumnModel().getColumn(4).setPreferredWidth(200);
        vMonitor.jTableMonitores.getColumnModel().getColumn(5).setPreferredWidth(150);
        vMonitor.jTableMonitores.getColumnModel().getColumn(6).setPreferredWidth(60);
    }

    //Metodo que rellena el jtable de la VistaMonitor mediante una ArrayList de monitores
    public void rellenarTablaMonitores(ArrayList<Monitor> monitores) {
        Object[] fila = new Object[7];
        System.out.println("estoy funcionando");
        int numRegistros = monitores.size();
        for (int i = 0; i < numRegistros; i++) {
            fila[0] = monitores.get(i).getCodmonitor();
            fila[1] = monitores.get(i).getNombre();
            fila[2] = monitores.get(i).getDni();
            fila[3] = monitores.get(i).getTelefono();
            fila[4] = monitores.get(i).getCorreo();
            fila[5] = monitores.get(i).getFechaentrada();
            fila[6] = monitores.get(i).getNick();
            modeloTablaMonitores.addRow(fila);
        }
    }

    // Metodo que borra toda la informacion del jTable de la VistaMonitor
    public void vaciarTablaMonitores() {
        while (modeloTablaMonitores.getRowCount() > 0) {
            modeloTablaMonitores.removeRow(0);
        }
    }

    //Metodo que rellena toda la información que tengamos de un monitor en ActualizacionDeMonitor
    public void rellenaActualizarMonitor(ActualizaciónDeMonitor aMonitor, JTable tablaM) throws Exception {

        aMonitor.jTextFieldCodigo.setEnabled(false);
        aMonitor.jTextFieldCodigo.setText(CodSelecionado(tablaM));
        aMonitor.jTextFieldCorreo.setText(m.getCorreo());
        aMonitor.jTextFieldTelefono.setText(m.getTelefono());
        Date fechaChooser = formatoFecha.parse(m.getFechaentrada());
        aMonitor.jDateChooserFechaEntradaAMonitor.setDate(fechaChooser);
        aMonitor.jTextFieldDNI.setText(m.getDni());
        aMonitor.jTextFieldNick.setText(m.getNick());
        aMonitor.jTextFieldNombre.setText(m.getNombre());
    }

    //Metodo que devuelve la informacion de un Monitor selecionado
    public String CodSelecionado(JTable tablaM) throws Exception {
        String codigo = null;
        if (tablaM.getSelectedRow() != -1) {
            codigo = (String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 0);
            m.setCodmonitor(codigo);
            m.setCorreo((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 4));
            m.setDni((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 2));
            m.setFechaentrada((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 5));
            m.setNick((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 6));
            m.setNombre((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 1));
            m.setTelefono((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 3));
            System.out.println(codigo);
        } else {
            throw new Exception("No ha selecionado ningun monitor");
        }
        return codigo;
    }

    //Metodo que devuelve el suiguiente codigo de un Monitor
    public void SiguienteCod(JTable tablaM, NuevoMonitor nMonitor) {
        String codigo = null;
        int ultimo = tablaM.getRowCount() - 1;
        codigo = (String) modeloTablaMonitores.getValueAt(ultimo, 0);
        String Numero = codigo.substring(1, 4);
        int numEntero = Integer.parseInt(Numero);
        numEntero++;
        String numeroS = String.format("%03d", numEntero);
        String codSiguiente = "M" + numeroS;
        nMonitor.jTextFieldCodigo.setText(codSiguiente);
        nMonitor.jTextFieldCodigo.setEnabled(false);
    }

    //Metodo que introduce y controla los datos que hemos intrducido en la aplicación en un objeto de tipo Monitor y lo devuelve
    public Monitor NuevoMonitor(NuevoMonitor nMonitor) throws Exception {
        m.setCodmonitor(nMonitor.jTextFieldCodigo.getText());
        m.setCorreo(nMonitor.jTextFieldCorreo.getText());
        if (!cmp.ComparaCorreo(nMonitor.jTextFieldCorreo.getText())) {
            throw new Exception("No existe este correo.\nDebe tener la siguiente forma: nombre@dominio");
        }
        m.setDni(nMonitor.jTextFieldDNI.getText());
        if(!cmp.DNICorecto(nMonitor.jTextFieldDNI.getText())){
            throw new Exception("No existe este DNI.");
        }
        Date fechaChooser = nMonitor.jDateChooserFechaEntradaNMonitor.getDate();
            if (fechaChooser != null) {
                String fechaString = formatoFecha.format(fechaChooser);
                if(cmp.FechaAdecuada(fechaChooser))
                    throw new Exception("Seleciona ua fecha adecuada");
                m.setFechaentrada(fechaString);
            } else {
                throw new Exception("No ha selecionado ninguna fecha");
            }
        m.setNick(nMonitor.jTextFieldNick.getText());
        m.setNombre(nMonitor.jTextFieldNombre.getText());
        m.setTelefono(nMonitor.jTextFieldTelefono.getText());
        if(!cmp.NumeroTelefonoCorrecto(nMonitor.jTextFieldTelefono.getText())){
            throw new Exception("No existe este Numero.\nRecuerda que el número debe de tener 9 digitos");
        }
        return m;
    }

    // En este actualizamos el Monitor q
    public Monitor ActualizaMonitor(ActualizaciónDeMonitor aMonitor, Session s) throws Exception {
        String codMonitor = aMonitor.jTextFieldCodigo.getText();
        m = s.get(Monitor.class, codMonitor);
        m.setCorreo(aMonitor.jTextFieldCorreo.getText());
        if (!cmp.ComparaCorreo(aMonitor.jTextFieldCorreo.getText())) {
            throw new Exception("No existe este correo.\nDebe tener la siguiente forma: nombre@dominio");
        }
        m.setDni(aMonitor.jTextFieldDNI.getText());
        if(!cmp.DNICorecto(aMonitor.jTextFieldDNI.getText())){
            throw new Exception("No existe este DNI.");
        }
        
        Date fechaChooser = aMonitor.jDateChooserFechaEntradaAMonitor.getDate();
            if (fechaChooser != null) {
                String fechaString = formatoFecha.format(fechaChooser);
                if(cmp.FechaAdecuada(fechaChooser))
                    throw new Exception("Seleciona ua fecha adecuada");
                m.setFechaentrada(fechaString);
            } else {
                throw new Exception("No ha selecionado ninguna fecha");
            }
        m.setNick(aMonitor.jTextFieldNick.getText());
        m.setNombre(aMonitor.jTextFieldNombre.getText());
        m.setTelefono(aMonitor.jTextFieldTelefono.getText());
        if(!cmp.NumeroTelefonoCorrecto(aMonitor.jTextFieldTelefono.getText())){
            throw new Exception("No existe este Numero.\nRecuerda que el número debe de tener 9 digitos");
        }
        return m;
    }
    
}
