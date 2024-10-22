package Persistencia;

import Persistencia.Articulos;
import Persistencia.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-09T16:14:32")
@StaticMetamodel(Cometarios.class)
public class Cometarios_ { 

    public static volatile SingularAttribute<Cometarios, String> texto;
    public static volatile SingularAttribute<Cometarios, Usuarios> usuario;
    public static volatile SingularAttribute<Cometarios, Integer> id;
    public static volatile SingularAttribute<Cometarios, Articulos> articulo;
    public static volatile SingularAttribute<Cometarios, String> privacidad;

}