package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-02T00:52:50")
@StaticMetamodel(Noticia.class)
public class Noticia_ { 

    public static volatile SingularAttribute<Noticia, Integer> id;
    public static volatile SingularAttribute<Noticia, String> titulo;
    public static volatile SingularAttribute<Noticia, Date> fecha;
    public static volatile SingularAttribute<Noticia, String> descripcion;

}