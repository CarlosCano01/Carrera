package Persistencia;

import Persistencia.Cometarios;
import Persistencia.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-09T16:14:32")
@StaticMetamodel(Articulos.class)
public class Articulos_ { 

    public static volatile SingularAttribute<Articulos, String> precio;
    public static volatile CollectionAttribute<Articulos, Cometarios> cometariosCollection;
    public static volatile SingularAttribute<Articulos, Usuarios> usuario;
    public static volatile SingularAttribute<Articulos, Integer> id;
    public static volatile SingularAttribute<Articulos, String> nombre;

}