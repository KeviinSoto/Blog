package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-02T00:52:50")
@StaticMetamodel(Resumen.class)
public class Resumen_ { 

    public static volatile SingularAttribute<Resumen, Integer> id;
    public static volatile SingularAttribute<Resumen, String> titulo;
    public static volatile SingularAttribute<Resumen, Date> fecha;
    public static volatile SingularAttribute<Resumen, String> descripcion;

}