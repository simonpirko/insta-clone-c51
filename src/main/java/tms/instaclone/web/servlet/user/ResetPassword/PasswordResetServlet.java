package tms.instaclone.web.servlet.user.ResetPassword;

import tms.instaclone.service.UserService;
import tms.instaclone.validator.MobilePhoneNumberValidator;
import tms.instaclone.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static tms.instaclone.web.servlet.Constants.*;

@WebServlet(urlPatterns = URL_PASSWORD_RESET_SERVLET, name = NAME_PASSWORD_RESET_SERVLET)
public class PasswordResetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_PASSWORD_RESET_PAGE_JSP).forward(req, resp);
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

        } else if (isPhoneNumber) {

        } else if (isEmail) {

        } else {
            req.setAttribute("msgError", Constants.ERRORMESSAGE_RESET_USER_PHONE_EMAIL);
            req.getServletContext().getRequestDispatcher(Constants.PATH_RESET_PASSWORD_JSP).forward(req, resp);
        }

//        if (UserService.getInstance().getUserByUsername(username).isPresent()) {
//            setAttribute(req);
//            req.getSession().setAttribute("errormessage", ERRORMESSAGE_EXIST_USERNAME);
//            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
//        } else {
//            if (MobilePhoneNumberValidator.isValidPhoneNumber(phoneOrEmail)) {
//                if (MobilePhoneNumber.getMobilePhoneNumberByLongNumber(phoneOrEmail).isPresent()) {
//                    MobilePhoneNumber mobilePhoneNumber = MobilePhoneNumber.getMobilePhoneNumberByLongNumber(phoneOrEmail).get();
//                    if (UserService.getInstance().getUserByMobilePhoneNumber(mobilePhoneNumber).isPresent()) {
//                        setAttribute(req);
//                        req.getSession().setAttribute("errormessage", ERRORMESSAGE_EXIST_NUMBER);
//                        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
//                    } else {
//                        if (!UserService.getInstance().save(new User(null, mobilePhoneNumber,
//                                firstName, secondName, username,
//                                password, localDate))) {
//                            setAttribute(req);
//                            req.getSession().setAttribute("errormessage", ERRORMESSAGE_ADD_USER);
//                            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
//                        }
//                        req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
//                    }
//                } else {
//                    setAttribute(req);
//                    req.getSession().setAttribute("errormessage", ERRORMESSAGE_INCORRECT_NUMBER);
//                    req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
//                }
//            } else if (UserService.getInstance().getUserByEmail(phoneOrEmail).isPresent()) {
//                setAttribute(req);
//                req.getSession().setAttribute("errormessage", ERRORMESSAGE_EXIST_MAIL);
//                req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
//            } else {
//                if (!UserService.getInstance().save(new User(phoneOrEmail, null,
//                        firstName, secondName, username,
//                        password, localDate))) {
//                    setAttribute(req);
//                    req.getSession().setAttribute("errormessage", ERRORMESSAGE_ADD_USER);
//                    req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
//                }
//                req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
//            }
//        }
    }
}
