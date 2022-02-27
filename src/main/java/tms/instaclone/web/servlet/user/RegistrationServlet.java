package tms.instaclone.web.servlet.user;


import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;

import tms.instaclone.validator.MobilePhoneNumberValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


import static tms.instaclone.web.servlet.Constants.*;

@WebServlet(urlPatterns = URL_REGISTRATION_SERVLET, name = NAME_REGISTRATION_SERVLET)
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("errormessage", null);
        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneOrEmail = req.getParameter("phoneOrEmail");
        String nameAndSurname = req.getParameter("nameAndSurname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int day = Integer.parseInt(req.getParameter("day"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year = Integer.parseInt(req.getParameter("year"));
        LocalDate localDate = null;
        try {
            localDate = LocalDate.of(year, month, day);
        } catch (Exception e) {
            setAttribute(req);
            req.getSession().setAttribute("errormessage", ERRORMESSAGE_INCORRECT_DATE);
            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        }
        String[] names = nameAndSurname.split("\\s+");
        String firstName = names[0];
        String secondName = null;
        if (names.length > 1) {
            secondName = names[1];
        }
        if (UserService.getInstance().getUserByUsername(username).isPresent()) {
            setAttribute(req);
            req.getSession().setAttribute("errormessage", ERRORMESSAGE_EXIST_USERNAME);
            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        } else {
            if (MobilePhoneNumberValidator.isValidPhoneNumber(phoneOrEmail)) {
                if (MobilePhoneNumber.getMobilePhoneNumberByLongNumber(phoneOrEmail).isPresent()) {
                    MobilePhoneNumber mobilePhoneNumber = MobilePhoneNumber.getMobilePhoneNumberByLongNumber(phoneOrEmail).get();
                    if (UserService.getInstance().getUserByMobilePhoneNumber(mobilePhoneNumber).isPresent()) {
                        setAttribute(req);
                        req.getSession().setAttribute("errormessage", ERRORMESSAGE_EXIST_NUMBER);
                        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
                    } else {
                        if (!UserService.getInstance().save(new User(null, mobilePhoneNumber,
                                firstName, secondName, username,
                                password, localDate))) {
                            setAttribute(req);
                            req.getSession().setAttribute("errormessage", ERRORMESSAGE_ADD_USER);
                            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
                        }
                        req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
                    }
                } else {
                    setAttribute(req);
                    req.getSession().setAttribute("errormessage", ERRORMESSAGE_INCORRECT_NUMBER);
                    req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
                }
            } else if (UserService.getInstance().getUserByEmail(phoneOrEmail).isPresent()) {
                setAttribute(req);
                req.getSession().setAttribute("errormessage", ERRORMESSAGE_EXIST_MAIL);
                req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
            } else {
                if (!UserService.getInstance().save(new User(phoneOrEmail, null,
                        firstName, secondName, username,
                        password, localDate))) {
                    setAttribute(req);
                    req.getSession().setAttribute("errormessage", ERRORMESSAGE_ADD_USER);
                    req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
                }
                req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
            }
        }
    }

    private void setAttribute(HttpServletRequest req) {
        req.getSession().setAttribute("phoneOrEmail", req.getParameter("phoneOrEmail"));
        req.getSession().setAttribute("nameAndSurname", req.getParameter("nameAndSurname"));
        req.getSession().setAttribute("username", req.getParameter("username"));
        req.getSession().setAttribute("password", req.getParameter("password"));
        req.getSession().setAttribute("day", req.getParameter("day"));
        req.getSession().setAttribute("month", req.getParameter("month"));
        req.getSession().setAttribute("year", req.getParameter("year"));
    }
}
