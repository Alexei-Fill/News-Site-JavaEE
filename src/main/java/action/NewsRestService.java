package action;

import DAO.NewsDAO;
import entity.News;
import util.CustomLoggingInterceptor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class NewsRestService {

    @EJB
    NewsDAO newsDAO;

    @Interceptors(CustomLoggingInterceptor.class)
    public void addNews(News news) {
        newsDAO.addNews(news);
    }

    @Interceptors(CustomLoggingInterceptor.class)
    public void updateNews(News news) {
        newsDAO.updateNews(news);
    }

    public List<News> listNews() {
        return newsDAO.listNews();
     }

    public News getNewsById(long id) {
        return newsDAO.getNewsById(id);
    }

    @Interceptors(CustomLoggingInterceptor.class)
    public void deleteNews(List<Long> deletedNews){
        for (long l: deletedNews)
            newsDAO.deleteNews(l);
    }

}
