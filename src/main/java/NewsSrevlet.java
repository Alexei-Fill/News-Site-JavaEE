import DAO.NewsDAOImpl;
import action.NewsService;
import entity.News;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class NewsSrevlet extends HttpServlet {

    @EJB
    NewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println(uri);
        switch (uri){
            case ("/EjEx2/news"): {
                newsService.getNewsById(req, resp);
                break;
            }
            case ("/EjEx2/edit"): {
                newsService.showAddEditNews(req, resp);
                break;
            }
            case ("/EjEx2/listNews"):
                default: {
                newsService.listNews(req, resp);
                break;
            }
        }

    }
}


