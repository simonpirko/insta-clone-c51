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
//        if (req.getMethod().equals("POST")) {
//        }
        chain.doFilter(req, resp);
    }
}
