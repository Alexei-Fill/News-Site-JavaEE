package entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(News.class)
public abstract class News_ {

	public static volatile SingularAttribute<News, Long> id;
	public static volatile SingularAttribute<News, String> content;
	public static volatile SingularAttribute<News, String> title;
	public static volatile SingularAttribute<News, LocalDate> date;
	public static volatile SingularAttribute<News, String> brief;

	public static final String NEWS_ID = "newsId";
	public static final String NEWS_CONTENT = "newsContent";
	public static final String NEWS_TITLE = "newsTitle";
	public static final String NEWS_DATE = "newsDate";
	public static final String NEWS_BRIEF = "newsBrief";

}

