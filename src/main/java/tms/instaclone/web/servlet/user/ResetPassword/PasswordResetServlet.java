package tms.instaclone.web.servlet.user.ResetPassword;

import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;
import tms.instaclone.validator.MobilePhoneNumberValidator;
import tms.instaclone.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

import static tms.instaclone.web.servlet.Constants.*;

@WebServlet(urlPatterns = URL_PASSWORD_RESET_SERVLET, name = NAME_PASSWORD_RESET_SERVLET)
public class PasswordResetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_PASSWORD_RESET_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneOrEmailOrUserName = req.getParameter("phoneOrEmailOrUserName").trim();

        boolean isUserName = false;
        boolean isPhoneNumber = false;
        boolean isEmail = false;

        isUserName = UserService.getInstance().getUserByUsername(phoneOrEmailOrUserName).isPresent();
        isPhoneNumber = MobilePhoneNumberValidator.isValidPhoneNumber(phoneOrEmailOrUserName);
        isEmail = UserService.getInstance().getUserByEmail(phoneOrEmailOrUserName).isPresent();


        if (isUserName) {
            HttpSession session = req.getSession();
            User user = UserService.getInstance().getUserByUsername(phoneOrEmailOrUserName).get();

            Random random = new Random(100000000);
            int secretWorld = random.nextInt();

            session.setAttribute("user", user);
            session.setAttribute("secretWorld", secretWorld);

            req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
        } else if (isPhoneNumber) {
            HttpSession session = req.getSession();


            Random random = new Random(100000000);
            int secretWorld = random.nextInt();
            session.setAttribute("secretWorld", secretWorld);

            req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
        } else if (isEmail) {
            HttpSession session = req.getSession();
            User user = UserService.getInstance().getUserByEmail(phoneOrEmailOrUserName).get();

            Random random = new Random(100000000);
            int secretWorld = random.nextInt();

            session.setAttribute("user", user);
            session.setAttribute("secretWorld", secretWorld);

            req.getServletContext().getRequestDispatcher(PATH_PASSWORD_UPDATE_JSP).forward(req, resp);
        } else {
            req.setAttribute("msgError", Constants.ERRORMESSAGE_RESET_USER_PHONE_EMAIL);
            req.getServletContext().getRequestDispatcher(Constants.PATH_PASSWORD_RESET_JSP).forward(req, resp);
        }
    }
}
