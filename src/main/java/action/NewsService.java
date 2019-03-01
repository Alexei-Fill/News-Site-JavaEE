package action;

import DAO.NewsDAO;
import entity.News;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Singleton
public class NewsService {

    @EJB
    NewsDAO newsDAO;

    public void showAddEditNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  idSt = req.getParameter("id");
        if (idSt != null && idSt != ""){
            Long id = Long.parseLong(idSt);
            req.setAttribute("news", newsDAO.getNewsById(id));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/editNews.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void addNews(News news) {

    }

    public void updateNews(News news){

    }

    public void listNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listNews", newsDAO.listNews());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/newsList.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void getNewsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("news", newsDAO.getNewsById(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/news.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void deleteNews(long Id){

    }
}
