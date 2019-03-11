package DAO;

import entity.News;
import entity.News_;
import org.hibernate.query.NativeQuery;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Stateless
@LocalBean
@Local(NewsDAO.class)
public class NewsDAOImpl implements NewsDAO {

    private final String ID_NEWS = "id";

    @PersistenceContext(unitName = "myUnit")
    private EntityManager entityManager;

    //SQL
    @Override
    public List<News> listNews(){
        final String SQLQuery = "select * from NEWS";
        Query query = entityManager.createNativeQuery(SQLQuery);
        List<News> listNews = new ArrayList<>();
        List<Object[]> list = ((NativeQuery) query).list();
        for (Object[] obj : list) {
            News news = new News();
            news.setId(Integer.parseInt(obj[0].toString()));
            news.setTitle(obj[1].toString());
            news.setDate(LocalDate.parse(obj[2].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
//            news.setDate(LocalDate.parse(obj[2].toString()));
            if (obj[3] != null) {
                news.setBrief(obj[3].toString());
            }
            news.setContent(obj[4].toString());
            listNews.add(news);
        }
        Collections.sort(listNews, Comparator.comparing(News::getDate).thenComparing(News::getTitle));
        return listNews;
    }

    //Named Query
    @Override
    public void addNews(News news){
        Query query = entityManager.createNamedQuery("@INSERT_INTO_NEWS");
        query.setParameter("brief", news.getBrief());
        query.setParameter("content", news.getContent());
        query.setParameter("date_news", news.getDate());
        query.setParameter("title", news.getTitle());
        query.executeUpdate();
    }

    //Criteria
    @Override
    public void updateNews(News news) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<News> criteriaQuery = criteriaBuilder.createCriteriaUpdate(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        criteriaQuery.set(News_.title, news.getTitle());
        criteriaQuery.set(News_.brief, news.getBrief());
        criteriaQuery.set(News_.content, news.getContent());
        criteriaQuery.set(News_.date, news.getDate());
        criteriaQuery.where(criteriaBuilder.equal(root.get(News_.id), news.getId()));
        entityManager.createQuery(criteriaQuery).executeUpdate();
    }

    //JPQL
    @Override
    public News getNewsById(long id) {
        final String JPQLQuery = "SELECT n FROM News n WHERE n.id = :id";
        Query query = entityManager.createQuery(JPQLQuery, News.class);
        query.setParameter(ID_NEWS, id);
        try {
         return (News) query.getSingleResult();
        }
        catch (NoResultException nre){
          return null;
        }
    }

    //HQL
    @Override
    public void deleteNews(long id) {
        final String checkNews = "from News n where n.id = :id";
        final String deleteNews = "delete from News n where n.id = :id";
        Query checkNewsQuery = entityManager.createQuery(checkNews);
        checkNewsQuery.setParameter(ID_NEWS, id);
        News news = null;
        try {
            news = (News) checkNewsQuery.getSingleResult();
        }
        catch (NoResultException nre){
            System.out.println("News not found");
        }
        if (news != null) {
            Query deleteNewsQuery = entityManager.createQuery(deleteNews);
            deleteNewsQuery.setParameter(ID_NEWS, id);
            deleteNewsQuery.executeUpdate();
        }
    }
}
