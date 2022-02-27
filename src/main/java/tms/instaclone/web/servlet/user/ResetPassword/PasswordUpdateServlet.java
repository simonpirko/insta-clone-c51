package tms.instaclone.web.servlet.user.ResetPassword;

import tms.instaclone.entity.User;
import tms.instaclone.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static tms.instaclone.web.servlet.Constants.PATH_PASSWORD_UPDATE_JSP;

@WebServlet(urlPatterns = Constants.URL_PASSWORD_UPDATE_SERVLET, name = Constants.NAME_PASSWORD_UPDATE_SERVLET)
public class PasswordUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String secretWorld = (String) session.getAttribute("secretWorld");
        User user = (User) session.getAttribute("user");
        String inputSecretWord = req.getParameter("inputSecretWord");
        String updatePassword = req.getParameter("updatePassword");

        if (!secretWorld.equals(inputSecretWord)) {
            req.setAttribute("msgError", "ds");
            req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
        }

    }
}
