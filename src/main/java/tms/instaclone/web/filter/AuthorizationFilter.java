package tms.instaclone.web.filter;

import tms.instaclone.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if(user==null){
            chain.doFilter(req, res);
        }else{
//                  req.getServletContext().getRequestDispatcher(
//                          "здесь вставить страницу пользователя после успешной авторизации и удалить ошибку ниже"
//                  ).forward(req, res);

            res.getWriter().println("You are logged in!");
        }
    }
}
