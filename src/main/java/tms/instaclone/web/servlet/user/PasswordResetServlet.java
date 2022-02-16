package tms.instaclone.web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = PasswordResetConstants.PASSWORD_RESET_LINK, name = PasswordResetConstants.PASSWORD_RESET_NAME_SERVLET)
public class PasswordResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PasswordResetConstants.PASSWORD_RESET_PAGE_TEMPLATE_LINK_JSP).forward(req, resp);
    }
}
