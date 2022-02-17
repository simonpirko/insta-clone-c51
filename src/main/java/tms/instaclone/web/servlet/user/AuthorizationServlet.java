package tms.instaclone.web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static tms.instaclone.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_AUTHORIZATION_SERVLET, name = NAME_AUTHORIZATION_SERVLET)
public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
    }
}
