package Model;

import Model.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T02:52:37")
@StaticMetamodel(Stuff.class)
public class Stuff_ { 

    public static volatile SingularAttribute<Stuff, String> stuffname;
    public static volatile SingularAttribute<Stuff, Integer> idstuff;
    public static volatile ListAttribute<Stuff, Request> requestList;
    public static volatile SingularAttribute<Stuff, Integer> price;
    public static volatile SingularAttribute<Stuff, String> stufftype;

}