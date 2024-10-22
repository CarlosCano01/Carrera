/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relojadapter;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author carlo
 */
public class AdaptadorReloj extends Reloj implements IReloj{
    int forma;
    public AdaptadorReloj(int formato){
        super();
        forma=formato;
        Calendar c = Calendar.getInstance();
        switch (forma) {
            case 1:
                hora=Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                minuto=Integer.toString(c.get(Calendar.MINUTE));
                segundo=Integer.toString(c.get(Calendar.SECOND));
                break;
            case 2:
                hora=Integer.toString(c.get(Calendar.HOUR));
                minuto=Integer.toString(c.get(Calendar.MINUTE));
                segundo=Integer.toString(c.get(Calendar.SECOND));
                break;
            case 3:
                hora=Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                minuto=Integer.toString(c.get(Calendar.MINUTE));
                segundo=Integer.toString(c.get(Calendar.SECOND));
                break;
        }
    }
    @Override
    public void mostrar(){
        switch (forma) {
            case 1:
                System.out.println(hora+":"+minuto+"\n");
                break;
            case 2:
                System.out.println(hora+":"+minuto+"\n");
                break;
            case 3:
                System.out.println(hora+":"+minuto+":"+segundo+"\n");
                break;
        }
    }
}
