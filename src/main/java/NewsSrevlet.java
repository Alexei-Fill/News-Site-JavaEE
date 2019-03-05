import action.NewsService;
import action.PortalUserService;

import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.ws.rs.HttpMethod.POST;

@BasicAuthenticationMechanismDefinition()
@ServletSecurity(@HttpConstraint())
@WebServlet("/")
public class  NewsSrevlet extends HttpServlet {

    @EJB
    NewsService newsService;

    @EJB
    PortalUserService portalUserService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println(uri);
        switch (uri){
            case ("/EjEx2/login") : {
                portalUserService.showLoginPage(req, resp);
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
            default: {
                newsService.listNews(req, resp);
                break;
            }
        }
    }
}


