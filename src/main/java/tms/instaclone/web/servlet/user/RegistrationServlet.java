package tms.instaclone.web.servlet.user;

import tms.instaclone.dao.impl.inmemory.InMemoryUserDAOSingleton;
import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.User;
import tms.instaclone.service.UserServiceSingleton;
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
        req.getSession().setAttribute("errormessage",null);
        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneOrEmail = req.getParameter("phoneOrEmail");
        String nameAndSurname = req.getParameter("nameAndSurname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] names = nameAndSurname.split("\\s+");
        String firstName = names[0];
        String secondName=null;
        if (names.length>1){
            secondName=names[1];
        }
        if(UserServiceSingleton.getInstance().getUserByUsername(username).isPresent()){
            setAttribute(req);
            req.getSession().setAttribute("errormessage", "Этот никнейм уже используется");
            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        }else {
            if(MobilePhoneNumberValidator.isValidPhoneNumber(phoneOrEmail)){
                if(MobilePhoneNumber.getMobilePhoneNumberByLongNumber(phoneOrEmail).isPresent()){
                    MobilePhoneNumber mobilePhoneNumber = MobilePhoneNumber.getMobilePhoneNumberByLongNumber(phoneOrEmail).get();
                    if(UserServiceSingleton.getInstance().getUserByMobilePhoneNumber(mobilePhoneNumber).isPresent()){
                        setAttribute(req);
                        req.getSession().setAttribute("errormessage", "Этот номер телефона уже используется пользователем");
                        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
                    }else{
                        InMemoryUserDAOSingleton.getInstance().save(new User(null,mobilePhoneNumber,
                                firstName,secondName, username,
                                password, null));
                        req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
                    }
                }else {
                    setAttribute(req);
                    req.getSession().setAttribute("errormessage", "Не правильный номер телефона.");
                    req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
                }
            }else if(UserServiceSingleton.getInstance().getUserByEmail(phoneOrEmail).isPresent()){
                setAttribute(req);
                req.getSession().setAttribute("errormessage", "Этот имэйл уже используется пользователем");
                req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
            }else {
                InMemoryUserDAOSingleton.getInstance().save(new User(phoneOrEmail,null,
                        firstName,secondName, username,
                        password, null));
                req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
            }
        }

    }
    private void setAttribute(HttpServletRequest req){
        req.getSession().setAttribute("phoneOrEmail", req.getParameter("phoneOrEmail"));
        req.getSession().setAttribute("nameAndSurname", req.getParameter("nameAndSurname"));
        req.getSession().setAttribute("username", req.getParameter("username"));
        req.getSession().setAttribute("password", req.getParameter("password"));
    }
}
