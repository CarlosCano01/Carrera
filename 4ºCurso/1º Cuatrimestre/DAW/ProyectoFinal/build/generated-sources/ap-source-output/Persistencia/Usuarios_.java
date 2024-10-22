package Persistencia;

import Persistencia.Articulos;
import Persistencia.Cometarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-09T16:14:32")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile CollectionAttribute<Usuarios, Cometarios> cometariosCollection;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile CollectionAttribute<Usuarios, Articulos> articulosCollection;
    public static volatile SingularAttribute<Usuarios, String> email;

}