package tms.instaclone.web.servlet.user;

import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;
import tms.instaclone.validator.AbstractEntityValidator;
import tms.instaclone.validator.UserValidator;
import tms.instaclone.web.listener.ApplicationContextListener;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import static tms.instaclone.web.servlet.ServletConstants.*;

@WebServlet(name = NAME_REGISTRATION_SERVLET, urlPatterns = URL_REGISTRATION_SERVLET)
public class RegistrationServlet extends HttpServlet {
    private static final String ATTRIBUTE_NAME_VALIDATION_ERRORS = "validationErrors";
    private UserService userService;
    private AtomicLong userRegistrationId;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext()
                .getAttribute(ApplicationContextListener.ATTRIBUTE_NAME_USER_SERVICE);
        userRegistrationId = (AtomicLong) config.getServletContext()
                .getAttribute(ApplicationContextListener.ATTRIBUTE_NAME_USER_REGISTRATION_ID);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = getUserFromRequestParameters(req);
        AbstractEntityValidator<User> userValidator = new UserValidator(userService);
        if (userValidator.isValid(user) && userService.save(user)) {
            userRegistrationId.addAndGet(1);
            resp.sendRedirect(URL_LOGIN_SERVLET);
        } else {
            req.setAttribute(ATTRIBUTE_NAME_VALIDATION_ERRORS, userValidator.getErrorMessages());
            req.getServletContext().getRequestDispatcher(PATH_REGISTRATION_JSP).forward(req, resp);
        }
    }

    private User getUserFromRequestParameters(HttpServletRequest req) {
        User user = new User();
        user.setId(userRegistrationId.get());

        String mobilePhoneOrEmailParameter = req.getParameter(PARAMETER_NAME_USER_MOBILE_PHONE_OR_EMAIL);
        setUserMobilePhoneOrEmailFromRequestParameter(user, mobilePhoneOrEmailParameter);

        String userFirstNameAndLastName = req.getParameter(PARAMETER_NAME_USER_FIRST_NAME_AND_LAST_NAME);
        setUserFirstNameAndLastNameFromRequestParameter(user, userFirstNameAndLastName);

        user.setUsername(req.getParameter(PARAMETER_NAME_USER_USERNAME));
        user.setPassword(req.getParameter(PARAMETER_NAME_USER_PASSWORD));

        if (!req.getParameter(PARAMETER_NAME_USER_BIRTHDAY).isBlank()) {
            user.setBirthday(LocalDate.parse(req.getParameter(PARAMETER_NAME_USER_BIRTHDAY)));
        }

        return user;
    }

    private void setUserFirstNameAndLastNameFromRequestParameter(User user, String userFirstNameAndLastName) {
        if (userFirstNameAndLastName != null && !userFirstNameAndLastName.isBlank()) {
            String[] names = userFirstNameAndLastName.split(" ");
            if (names.length > 1) {
                user.setFirstName(names[0]);
                user.setLastName(names[1]);
            } else {
                user.setFirstName(names[0]);
                user.setLastName(null);
            }
        }
    }

    private void setUserMobilePhoneOrEmailFromRequestParameter(User user, String mobilePhoneOrEmailParameter) {
        if (mobilePhoneOrEmailParameter.matches(UserValidator.REGEX_MOBILE_PHONE)) {
            user.setMobilePhone(mobilePhoneOrEmailParameter);
        } else if (mobilePhoneOrEmailParameter.matches(UserValidator.REGEX_EMAIL)) {
            user.setEmail(mobilePhoneOrEmailParameter);
        }
    }
}
