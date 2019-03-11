package action;

import DAO.NewsDAO;
import util.CustomLoggingInterceptor;
import entity.News;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Stateless
public class NewsService {

    @EJB
    NewsDAO newsDAO;

    @RolesAllowed("USER")
    public void showAddEditNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  idSt = req.getParameter("id");
        if (idSt != null && idSt != ""){
            Long id = Long.parseLong(idSt);
            req.setAttribute("news", newsDAO.getNewsById(id));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/editNews.jsp");
        requestDispatcher.forward(req, resp);
    }

    @RolesAllowed("USER")
    @Interceptors(CustomLoggingInterceptor.class)
    public void addNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        fillNews(req, news);
        newsDAO.addNews(news);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/EjEx2/listNews");
        requestDispatcher.forward(req, resp);
    }

    @RolesAllowed("USER")
    @Interceptors(CustomLoggingInterceptor.class)
    public void updateNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        news.setId(Long.parseLong(req.getParameter("newsId")));
        fillNews(req, news);
        newsDAO.updateNews(news);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/EjEx2/listNews");
        requestDispatcher.forward(req, resp);
    }

    @PermitAll
    public void listNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listNews", newsDAO.listNews());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/newsList.jsp");
        requestDispatcher.forward(req, resp);
    }

    @PermitAll
    public void getNewsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("news", newsDAO.getNewsById(id));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/news.jsp");
        requestDispatcher.forward(req, resp);
    }

    @RolesAllowed("USER")
    @Interceptors(CustomLoggingInterceptor.class)
    public void deleteNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] idString = req.getParameterValues("deleteNews");
        if (idString != null) {
            for (String s : idString) {
               newsDAO.deleteNews(Long.parseLong(s.trim()));
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/EjEx2/listNews");
        requestDispatcher.forward(req, resp);
    }

    private void fillNews(HttpServletRequest req, News news){
        news.setTitle(req.getParameter("newsTitle"));
        news.setContent(req.getParameter("newsContent"));
        news.setBrief(req.getParameter("newsBrief"));
        news.setDate(LocalDate.parse(req.getParameter("newsDate")));
    }
}
