package tms.instaclone.web.servlet.user;

import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;
import tms.instaclone.validator.MobilePhoneNumberValidator;
import tms.instaclone.validator.UserValidator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static tms.instaclone.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_AUTHORIZATION_NO_IMAGE_SERVLET, name = NAME_AUTHORIZATION_NO_IMAGE_SERVLET)
public class AuthorizationNoImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_NO_IMAGE_JSP).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<User> optional =Optional.empty();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(UserValidator.isValidEmail(login)){
            optional = UserService.getInstance().getUserByEmail(login);
        }else if(MobilePhoneNumberValidator.isValidPhoneNumber(login)){
            Optional<MobilePhoneNumber> mobilePhoneNumber =MobilePhoneNumber.getMobilePhoneNumberByLongNumber(login);
            if(mobilePhoneNumber.isPresent()){
                optional = UserService.getInstance().getUserByMobilePhoneNumber(mobilePhoneNumber.get());
            }
        }else if(UserValidator.isValidUsername(login)){
            optional = UserService.getInstance().getUserByUsername(login);
        }
        if(optional.isPresent()){
            User user = optional.get();
            if(user.getPassword().equals(password)){
                req.getSession().setAttribute("user", user);
                req.getServletContext().getRequestDispatcher(PATH_USER_HOMEPAGE_JSP).forward(req, resp);

            }else {
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("errormessage", "К сожалению, вы ввели неправильный пароль. Проверьте свой пароль еще раз.");
                req.getServletContext().getRequestDispatcher("/page/user/authorizationNoImage.jsp").forward(req, resp);
            }
        }else {
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("errormessage", "Введенное вами имя пользователя не принадлежит аккаунту. Проверьте свое имя пользователя и повторите попытку.");
            req.getServletContext().getRequestDispatcher("/page/user/authorizationNoImage.jsp").forward(req, resp);
        }
    }
}
