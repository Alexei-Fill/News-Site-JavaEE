package action;

import DAO.PortalUserDAO;
import entity.PortalUser;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Stateless
public class PortalUserService {

    @EJB
    PortalUserDAO portalUserDAO;

    public void showLoginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("/EjEx2/listNews");
    }

    public PortalUser loadUserById(String username) {
        return portalUserDAO.loadUserByUsername(username);
    }

    public void updateToken(String username, String authToken) {
        portalUserDAO.updateToken(username, authToken);
    }

    public PortalUser loadUserByToken(String authToken) {
        return portalUserDAO.loadUserByToken(authToken);
    }

    public void remove(String authToken) {
        PortalUser portalUser = portalUserDAO.loadUserByToken(authToken);
        System.out.println("SERVICE");
        portalUserDAO.updateToken(portalUser.getLogin(), "");
    }
}
