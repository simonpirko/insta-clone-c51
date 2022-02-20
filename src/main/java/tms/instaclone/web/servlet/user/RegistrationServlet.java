package tms.instaclone.web.servlet.user;

import tms.instaclone.validator.MobilePhoneNumberValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static tms.instaclone.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_REGISTRATION_SERVLET, name = NAME_REGISTRATION_SERVLET)
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneOrEmail = req.getParameter("phoneOrEmail");
        String nameAndSurname = req.getParameter("nameAndSurname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

       // if(MobilePhoneNumberValidator.)

    }
}
