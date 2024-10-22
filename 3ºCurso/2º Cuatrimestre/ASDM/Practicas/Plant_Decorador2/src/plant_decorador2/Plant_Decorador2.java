
package plant_decorador2;

public class Plant_Decorador2 {

    public static void main(String[] args) {
        ComponenteConcreto basico = new ComponenteConcreto();
        
        DecoradorConcretoA añadido2= new DecoradorConcretoA(basico);
        
        System.out.println(añadido2.getDescripcion());
        System.out.println("El precio es: "+añadido2.getPrecio());
        System.out.println(basico.getDescripcion());
        System.out.println(basico.getPrecio());
    }
    
}
