package action;

import DAO.PortalUserDAO;

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
    PortalUserDAO userDAO;

    public void showLoginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }
}
