
package plantilladecorador1;

import java.util.concurrent.ConcurrentHashMap;

class PlantillaDecorador1 {

    public static void main(String[] args) {
        ComponenteConcreto basico=new ComponenteConcreto();
        DecoradorConcretroA añadido1=new DecoradorConcretroA(basico);
        DecoradorConcretoB añadido2= new DecoradorConcretoB(basico);
        añadido2.visualiza();
        
    }
    
}
