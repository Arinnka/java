package Model;

import Model.Review;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T02:52:37")
@StaticMetamodel(ZUsers.class)
public class ZUsers_ { 

    public static volatile SingularAttribute<ZUsers, String> idUser;
    public static volatile ListAttribute<ZUsers, Review> reviewList;
    public static volatile SingularAttribute<ZUsers, String> password;

}