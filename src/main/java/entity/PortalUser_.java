package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PortalUser.class)
public abstract class PortalUser_ {

	public static volatile SingularAttribute<PortalUser, String> password;
	public static volatile SingularAttribute<PortalUser, Integer> id;
	public static volatile SingularAttribute<PortalUser, String> login;
	public static volatile SingularAttribute<PortalUser, String> token;

	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String LOGIN = "login";
	public static final String TOKEN = "token";

}

