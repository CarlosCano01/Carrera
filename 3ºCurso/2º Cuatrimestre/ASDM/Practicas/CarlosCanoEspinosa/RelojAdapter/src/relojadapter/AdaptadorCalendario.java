/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relojadapter;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author carlo
 */
public class AdaptadorCalendario extends Calendario implements ICalendario{
    int forma;
    public AdaptadorCalendario(int formato){
        super();
        forma=formato;
        Calendar c = Calendar.getInstance();
        switch (forma) {
            case 1:
                dia=Integer.toString(c.get(Calendar.DATE));
                mes=Integer.toString(c.get(Calendar.MONTH)+1);
                año=Integer.toString(c.get(Calendar.YEAR));
                break;
            case 2:
                dia=Integer.toString(c.get(Calendar.DATE));
                mes=LocalDate.now().getMonth().toString();
                año=Integer.toString(c.get(Calendar.YEAR));
                break;
            case 3:
                dia=c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US)+","+Integer.toString(c.get(Calendar.DATE));
                mes=LocalDate.now().getMonth().toString().toLowerCase();
                año=Integer.toString(c.get(Calendar.YEAR));
                break;
        }
    }
    @Override
    public void mostrar(){
        switch (forma) {
            case 1:
                System.out.println(dia+"/"+mes+"/"+año+"\n");
                break;
            case 2:
                System.out.println(dia+"-"+mes+"-"+año+"\n");
                break;
            case 3:
                System.out.println(dia+" de "+mes+" de "+año+"\n");
                break;
        }
    }
}
