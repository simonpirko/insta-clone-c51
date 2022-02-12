package tms.instaclone.web.listener;

import tms.instaclone.dao.DAO;
import tms.instaclone.dao.impl.inmemory.InMemoryUserDAO;
import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@WebListener
public class ApplicationContextListener implements ServletContextListener {
    public static final String ATTRIBUTE_NAME_USER_SERVICE = "userService";
    public static final String ATTRIBUTE_NAME_USER_REGISTRATION_ID = "userRegistrationId";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AtomicLong userIdForRegistration = new AtomicLong(1);

        DAO<User> userDAO = new InMemoryUserDAO(new ConcurrentHashMap<>());
        UserService userService = new UserService(userDAO);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute(ATTRIBUTE_NAME_USER_SERVICE, userService);
        servletContext.setAttribute(ATTRIBUTE_NAME_USER_REGISTRATION_ID, userIdForRegistration);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
