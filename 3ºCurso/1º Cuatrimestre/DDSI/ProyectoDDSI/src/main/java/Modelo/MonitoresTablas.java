/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vista.ActualizaciónDeMonitor;
import Vista.NuevoMonitor;
import Vista.VistaMonitor;
import com.toedter.calendar.IDateEditor;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlo
 */
public class MonitoresTablas {
    DefaultTableModel modeloTablaMonitores = null;
    MonitorDAO mDao=null;
    Monitor m=new Monitor();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    
    public void inicializarTablaMonitores(VistaMonitor vMonitor){
        this.modeloTablaMonitores=vMonitor.modeloTablaMonitores;
    }
    public void dibujarTablaMonitores(VistaMonitor vMonitor){
        String[] columnaTabla={"Código","Nombre","DNI","Teléfono",
                                "Correo","Fecha Incorporación","Nick"};
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
    public void rellenarTablaMonitores(ArrayList<Monitor> monitores){
        Object[] fila = new Object[7];
        int numRegistros = monitores.size();
        for (int i = 0; i < numRegistros; i++) {
            fila[0]=monitores.get(i).getCdMonitor();
            fila[1]=monitores.get(i).getNombre();
            fila[2]=monitores.get(i).getDni();
            fila[3]=monitores.get(i).getTelefono();
            fila[4]=monitores.get(i).getCorreo();
            fila[5]=monitores.get(i).getFechaEntrada();
            fila[6]=monitores.get(i).getNick();
            modeloTablaMonitores.addRow(fila);
        }
    }
    public void vaciarTablaMonitores(){
        while(modeloTablaMonitores.getRowCount()>0){
            modeloTablaMonitores.removeRow(0);
        }
    }
    public void actualizarmonitor(ActualizaciónDeMonitor aMonitor,JTable tablaM) throws Exception{
        
        aMonitor.jTextFieldCodigo.setEnabled(false);
        aMonitor.jTextFieldCodigo.setText(CodSelecionado(tablaM));
        aMonitor.jTextFieldCorreo.setText(m.getCorreo());
        aMonitor.jTextFieldDNI.setText(m.getDni());
        Date fechaChooser = formatoFecha.parse(m.getFechaEntrada());
        aMonitor.jDateChooserFechaEntradaAMonitor.setDate(fechaChooser);
        aMonitor.jTextFieldNick.setText(m.getNick());
        aMonitor.jTextFieldNombre.setText(m.getNombre());
        aMonitor.jTextFieldTelefono.setText(m.getTelefono());
    }
    public void eliminarmonitor(JTable tablaM,Conexion c) throws SQLException, Exception{
        mDao=new MonitorDAO(c);
        mDao.EliminarMonitores(CodSelecionado(tablaM));
            
    }
    public String CodSelecionado(JTable tablaM) throws Exception{
        String codigo=null;
        if (tablaM.getSelectedRow() != -1) {
            codigo = (String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 0);
            m.setCdMonitor(codigo);
            m.setCorreo((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 4));
            m.setDni((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 2));
            m.setFechaEntrada((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 5));
            m.setNick((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 6));
            m.setNombre((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 1));
            m.setTelefono((String) modeloTablaMonitores.getValueAt(tablaM.getSelectedRow(), 3));
            System.out.println(codigo);
        } else {
            throw new Exception("No ha selecionado ningun monitor");
        }
       return codigo;
    }
    
    public void SiguienteCod(JTable tablaM,NuevoMonitor nMonitor){
        String codigo=null;
        int ultimo=tablaM.getRowCount()-1;
        codigo = (String) modeloTablaMonitores.getValueAt(ultimo, 0);
        String Numero= codigo.substring(1, 4);
        int numEntero = Integer.parseInt(Numero);
        numEntero++;
        String numeroS = String.format("%03d", numEntero);
        String codSiguiente="M"+numeroS;
        nMonitor.jTextFieldCodigo.setText(codSiguiente);
        nMonitor.jTextFieldCodigo.setEnabled(false);
    }
    public Monitor NuevoMonitor(NuevoMonitor nMonitor) throws Exception{
        m.setCdMonitor(nMonitor.jTextFieldCodigo.getText());
        m.setCorreo(nMonitor.jTextFieldCorreo.getText());
        if(!ComparaCorreo(nMonitor.jTextFieldCorreo.getText())){
            throw new Exception("No existe este correo");
        }
        m.setDni(nMonitor.jTextFieldDNI.getText());
        Date fechaChooser = nMonitor.jDateChooserFechaEntradaNMonitor.getDate();
        if (fechaChooser != null) {
            String fechaString = formatoFecha.format(fechaChooser);
            m.setFechaEntrada(fechaString);
        }else{
            throw new Exception("No ha selecionado ninguna fecha");
        }       
        m.setNick(nMonitor.jTextFieldNick.getText());
        m.setNombre(nMonitor.jTextFieldNombre.getText());
        m.setTelefono(nMonitor.jTextFieldTelefono.getText());
        return m;
    }
    public Monitor ActualizaMonitor(ActualizaciónDeMonitor aMonitor) throws Exception{
        m.setCdMonitor(aMonitor.jTextFieldCodigo.getText());
        m.setCorreo(aMonitor.jTextFieldCorreo.getText());
        if(!ComparaCorreo(aMonitor.jTextFieldCorreo.getText())){
            throw new Exception("No existe este correo");
        }
        m.setDni(aMonitor.jTextFieldDNI.getText());
        Date fechaChooser = aMonitor.jDateChooserFechaEntradaAMonitor.getDate();
        if (fechaChooser != null) {
            String fechaString = formatoFecha.format(fechaChooser);
            m.setFechaEntrada(fechaString);
        }else{
            throw new Exception("No ha selecionado ninguna fecha");
        }       
        m.setNick(aMonitor.jTextFieldNick.getText());
        m.setNombre(aMonitor.jTextFieldNombre.getText());
        m.setTelefono(aMonitor.jTextFieldTelefono.getText());
        return m;
    }
    public boolean ComparaCorreo(String correo){
        int contadorarroba=0;
        int punto=0;
        int haypalabraDespues=0;
        int haypalabraAntes=0;
        boolean haypalabraDespuesDeP=false;
        for(int i=0;i<correo.length();i++ ){
            String Arroba=correo.substring(i,i+1);
            if(contadorarroba == 1 && ".".equals(Arroba)){
                punto++;
                haypalabraDespuesDeP=false;
            }else{
                haypalabraDespuesDeP=true;
            }
            if(contadorarroba == 0){
                haypalabraAntes++;
            }
            if(contadorarroba == 1 && !".".equals(Arroba)){
                haypalabraDespues++;
            }
            if("@".equals(Arroba)){
                contadorarroba++;
            }
        }
        return contadorarroba == 1 && punto > 0 && haypalabraAntes > 0 && haypalabraDespues > 0 && haypalabraDespuesDeP;
    }
}
