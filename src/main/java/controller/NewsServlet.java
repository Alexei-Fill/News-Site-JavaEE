package controller;

import action.NewsService;
import action.PortalUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.ws.rs.HttpMethod.POST;

@WebServlet("/")
public class NewsServlet extends HttpServlet {

    @EJB
    NewsService newsService;

    @EJB
    PortalUserService portalUserService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (req.getUserPrincipal() != null)
            req.setAttribute("customPrincipal", req.getUserPrincipal());
        switch (uri){
            case ("/EjEx2/login") : {
                portalUserService.showLoginPage(req, resp);
                break;
            }
            case ("/EjEx2/logout") : {
                portalUserService.logOut(req, resp);
                break;
            }
            case ("/EjEx2/news") : {
                newsService.getNewsById(req, resp);
                break;
            }
            case ("/EjEx2/editNews"): {
                newsService.showAddEditNews(req, resp);
                break;
            }
            case ("/EjEx2/edit"): {
                if (req.getMethod() == POST){
                    newsService.updateNews(req, resp);
                }
                break;
            }
            case ("/EjEx2/add"): {
                if (req.getMethod() == POST){
                    newsService.addNews(req, resp);
                }
                break;
            }
            case ("/EjEx2/delete"): {
                if (req.getMethod() == POST){
                    newsService.deleteNews(req, resp);
                }
                break;
            }
            case ("/EjEx2/listNews"):
//            default:
                {
                newsService.listNews(req, resp);
                break;
            }
        }
    }
}


