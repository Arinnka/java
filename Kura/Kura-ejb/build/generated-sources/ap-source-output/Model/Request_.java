package Model;

import Model.Place;
import Model.Review;
import Model.Stuff;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T02:52:37")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile ListAttribute<Request, Review> reviewList;
    public static volatile SingularAttribute<Request, Integer> idrequest;
    public static volatile SingularAttribute<Request, Integer> amount;
    public static volatile SingularAttribute<Request, Place> idplace;
    public static volatile SingularAttribute<Request, Stuff> idstuff;

}