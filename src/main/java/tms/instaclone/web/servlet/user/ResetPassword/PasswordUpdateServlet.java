package tms.instaclone.web.servlet.user.ResetPassword;

import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;
import tms.instaclone.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static tms.instaclone.web.servlet.Constants.*;

@WebServlet(urlPatterns = Constants.URL_PASSWORD_UPDATE_SERVLET, name = Constants.NAME_PASSWORD_UPDATE_SERVLET)
public class PasswordUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String secretWord = String.valueOf(session.getAttribute("secretWord"));
        User user = (User) session.getAttribute("user");
        String inputSecretWord = req.getParameter("inputSecretWord");
        String updatePassword = req.getParameter("updatePassword");

        if (!secretWord.equals(inputSecretWord)) {
            req.setAttribute("msgError", ERRORMESSAGE_INVALID_SECRET_WORD);
            req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
        } else {
            user.setPassword(updatePassword);

            if (!UserService.getInstance().update(user)) {
                req.getSession().setAttribute("msgErrorUpdatePassword", ERRORMESSAGE_UPDATE_USER_PASSWORD);
                req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
            }

            session.invalidate();
            resp.sendRedirect(URL_AUTHORIZATION_SERVLET);
        }

    }
}
