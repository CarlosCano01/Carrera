/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import Vista.ActualizaSocio;
import Vista.ActualizaciónDeMonitor;
import Vista.NuevoSocio;
import Vista.VistaSocios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author carlo
 */
public class SociosTabla {
    Socio s=new Socio();
    DefaultTableModel modeloTablaSocios = null;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    Comparaciones cmp=new Comparaciones();
    
    public void inicializarTablaSocios(VistaSocios vSocios){
        this.modeloTablaSocios=vSocios.modeloTablaSocios;
    }
    public void dibujarTablaSocios(VistaSocios vSocios){
        String[] columnaTabla={"Código","Nombre","DNI","Teléfono",
                                "Correo","Fecha Incorporación","Categoria","Fecha Nacimiento"};
        inicializarTablaSocios(vSocios);
        modeloTablaSocios.setColumnIdentifiers(columnaTabla);

        vSocios.jTableSocios.getTableHeader().setResizingAllowed(false);
        vSocios.jTableSocios.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        vSocios.jTableSocios.getColumnModel().getColumn(0).setPreferredWidth(60);
        vSocios.jTableSocios.getColumnModel().getColumn(1).setPreferredWidth(220);
        vSocios.jTableSocios.getColumnModel().getColumn(2).setPreferredWidth(80);
        vSocios.jTableSocios.getColumnModel().getColumn(3).setPreferredWidth(80);
        vSocios.jTableSocios.getColumnModel().getColumn(4).setPreferredWidth(200);
        vSocios.jTableSocios.getColumnModel().getColumn(5).setPreferredWidth(150);
        vSocios.jTableSocios.getColumnModel().getColumn(6).setPreferredWidth(70);
        vSocios.jTableSocios.getColumnModel().getColumn(7).setPreferredWidth(150);
    }
    public void rellenarTablaSocios(ArrayList<Socio> socios){
        if(socios!=null){
            Object[] fila = new Object[8];
            int numRegistros = socios.size();
            for (int i = 0; i < numRegistros; i++) {
                fila[0]=socios.get(i).getNumerosocio();
                fila[1]=socios.get(i).getNombre();
                fila[2]=socios.get(i).getDni();
                fila[3]=socios.get(i).getTelefono();
                fila[4]=socios.get(i).getCorreo();
                fila[5]=socios.get(i).getFechaentrada();
                fila[6]=socios.get(i).getCategoria();
                fila[7]=socios.get(i).getFechanacimiento();
                modeloTablaSocios.addRow(fila);
            }
        }
    }
    public void vaciarTablaSocios(){
        while(modeloTablaSocios.getRowCount()>0){
            modeloTablaSocios.removeRow(0);
        }
    }
    //Metodo que devuelve la informacion de un Socio selecionado
    public String NumSocSelecionado(JTable tablaM) throws Exception{
        String NumSoc=null;
        System.out.println(tablaM.getSelectedRow());
        if (tablaM.getSelectedRow() != -1) {
            System.out.println("Funcionaaaa");
            NumSoc = (String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 0);
            s.setNumerosocio(NumSoc);
            s.setNombre((String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 1));
            s.setDni((String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 2));
            s.setTelefono((String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 3));
            s.setCorreo((String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 4));
            s.setFechaentrada((String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 5));
            s.setCategoria((Character) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 6));
            s.setFechanacimiento((String) modeloTablaSocios.getValueAt(tablaM.getSelectedRow(), 7));
        } else {
            throw new Exception("No ha selecionado ningun socio");
        }
       return NumSoc;
    }
    
    public void rellenaActualizarSocio(ActualizaSocio aSocio,JTable tablaM) throws Exception{
        
        aSocio.jTextFieldCodigo.setEnabled(false);
        aSocio.jTextFieldCodigo.setText(NumSocSelecionado(tablaM));
        aSocio.jTextFieldCorreo.setText(s.getCorreo());
        aSocio.jTextFieldDni.setText(s.getDni());
        Date fechaChooser = formatoFecha.parse(s.getFechaentrada());
        aSocio.jDateChooserFechaEntradaAMonitor.setDate(fechaChooser);
        Date fechaChoose = formatoFecha.parse(s.getFechanacimiento());
        aSocio.jDateChooserFechaNac.setDate(fechaChoose);
        System.out.println("Funcionaaaa");
        aSocio.jComboBoxCategoria.setSelectedItem(s.getCategoria().toString());
        System.out.println("Funcionaaaa2");
        aSocio.jTextFieldNombre.setText(s.getNombre());
        aSocio.jTextFieldTelefono.setText(s.getTelefono());
    }
    public Socio ActualizaSocio(ActualizaSocio aSocio,Session sesion) throws Exception{
        String NumSoc=aSocio.jTextFieldCodigo.getText();
        s=sesion.get(Socio.class, NumSoc);
        s.setCorreo(aSocio.jTextFieldCorreo.getText());
        if (!cmp.ComparaCorreo(aSocio.jTextFieldCorreo.getText())) {
            throw new Exception("No existe este correo.\nDebe tener la siguiente forma: nombre@dominio");
        }
        s.setDni(aSocio.jTextFieldDni.getText());
        if(!cmp.DNICorecto(aSocio.jTextFieldDni.getText())){
            throw new Exception("No existe este DNI.");
        }
        Date fechaChooser = aSocio.jDateChooserFechaEntradaAMonitor.getDate();
        if (fechaChooser != null) {
            String fechaString = formatoFecha.format(fechaChooser);
            if(cmp.FechaAdecuada(fechaChooser))
                    throw new Exception("Seleciona ua fecha adecuada");
            s.setFechaentrada(fechaString);
        }else{
            throw new Exception("No ha selecionado ninguna fecha");
        }
        Date fechaChoose = aSocio.jDateChooserFechaNac.getDate();
        if (fechaChoose != null) {
            String fechaString = formatoFecha.format(fechaChoose);
            if(cmp.FechaAdecuada(fechaChoose))
                    throw new Exception("Seleciona ua fecha adecuada");
            s.setFechaentrada(fechaString);
        }else{
            throw new Exception("No ha selecionado ninguna fecha");
        }
        s.setCategoria(aSocio.jComboBoxCategoria.getSelectedItem().toString().charAt(0));
        s.setNombre(aSocio.jTextFieldNombre.getText());
        s.setTelefono(aSocio.jTextFieldTelefono.getText());
        if(!cmp.NumeroTelefonoCorrecto(aSocio.jTextFieldTelefono.getText())){
            throw new Exception("No existe este Numero.\nRecuerda que el número debe de tener 9 digitos");
        }
        return s;
    }
    public void SiguienteNumSoc (JTable tablaM,NuevoSocio nSocio){
        String codigo=null;
        int ultimo=tablaM.getRowCount()-1;
        codigo = (String) modeloTablaSocios.getValueAt(ultimo, 0);
        String Numero= codigo.substring(1, 4);
        int numEntero = Integer.parseInt(Numero);
        numEntero++;
        String numeroS = String.format("%03d", numEntero);
        String codSiguiente="S"+numeroS;
        nSocio.jTextFieldCodigo.setText(codSiguiente);
        nSocio.jTextFieldCodigo.setEnabled(false);
    }
     public Socio NuevoSocio(NuevoSocio nSocio) throws Exception{
        s.setNumerosocio(nSocio.jTextFieldCodigo.getText());
        s.setCorreo(nSocio.jTextFieldCorreo.getText());
        if (!cmp.ComparaCorreo(nSocio.jTextFieldCorreo.getText())) {
            throw new Exception("No existe este correo.\nDebe tener la siguiente forma: nombre@dominio");
        }
        s.setDni(nSocio.jTextFieldDni.getText());
        if(!cmp.DNICorecto(nSocio.jTextFieldDni.getText())){
            throw new Exception("No existe este DNI.");
        }
        Date fechaChooser = nSocio.jDateChooserFechaEntradaAMonitor.getDate();
        if (fechaChooser != null) {
            String fechaString = formatoFecha.format(fechaChooser);
            if(cmp.FechaAdecuada(fechaChooser))
                    throw new Exception("Seleciona una fecha adecuada");
            s.setFechaentrada(fechaString);
        }else{
            throw new Exception("No ha selecionado ninguna fecha");
        }
        Date fechaChoose = nSocio.jDateChooserFechaNac.getDate();
        if (fechaChoose != null) {
            String fechaString = formatoFecha.format(fechaChoose);
            if(cmp.FechaAdecuada(fechaChoose))
                    throw new Exception("Seleciona una fecha adecuada");
            s.setFechaentrada(fechaString);
        }else{
            throw new Exception("No ha selecionado ninguna fecha");
        }
        s.setCategoria(nSocio.jComboBoxCategoria.getSelectedItem().toString().charAt(0));
        s.setNombre(nSocio.jTextFieldNombre.getText());
        s.setTelefono(nSocio.jTextFieldTelefono.getText());
        if(!cmp.NumeroTelefonoCorrecto(nSocio.jTextFieldTelefono.getText())){
            throw new Exception("No existe este Numero.\nRecuerda que el número debe de tener 9 digitos");
        }
        return s;
    }
    public void buscaSocios(ArrayList<Socio> sociosEncontrados,Session sesion){
        ArrayList<Socio> socio=new ArrayList<>();
        int i=0;
        while( i < sociosEncontrados.size()){
            String objeto=sociosEncontrados.get(i).getNumerosocio();
            s=sesion.get(Socio.class, objeto);
            socio.add(s);
            i++;
        }
        vaciarTablaSocios();
        rellenarTablaSocios(socio);
    }
    
}
