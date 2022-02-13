package tms.instaclone.web.filter.user;

import tms.instaclone.web.servlet.user.PasswordResetConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = PasswordResetConstants.PASSWORD_RESET_NAME_SERVLET)
public class PasswordResetFilter extends HttpFilter {

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
//            if (name == null || userName == null || password == null) {
//                req.setAttribute("messageErrorRegistration", Constants.MSG_ERROR_NAME_USERNAME_PASSWORD_NULL);
//                req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_LINK_JSP).forward(req, resp);
//            } else if (name.isEmpty() || userName.isEmpty() || password.isEmpty()) {
//                req.setAttribute("messageErrorRegistration", Constants.MSG_ERROR_NAME_USERNAME_PASSWORD_EMPTY);
//                req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_LINK_JSP).forward(req, resp);
//            } else if (userService.checkByUserLogin(userName)) {
//                req.setAttribute("messageErrorRegistration", Constants.MSG_ERROR_USER_HAS_FOUND);
//                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
//            }
        }
        chain.doFilter(req, resp);
    }
}
