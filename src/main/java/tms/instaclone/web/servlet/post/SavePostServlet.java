// INST-24: card-block-save

package tms.instaclone.web.servlet.post;

import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;
import tms.instaclone.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static tms.instaclone.web.servlet.Constants.ERRORMESSAGE_SOMETHING_GONE_WRONG;


@WebServlet(urlPatterns = Constants.URL_SAVE_POST_SERVLET, name = Constants.NAME_SAVE_POST_SERVLET)
public class SavePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        req.getServletContext().getRequestDispatcher(Constants.PATH_USER_HOMEPAGE_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            IOException, NullPointerException, ServletException {
        UserService userService = UserService.getInstance();
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            if (req.getParameter("postId") != null) {
                long postId = Long.parseLong(req.getParameter("postId"));
                userService.savePostToUser(postId, user);
            }
        } else req.getSession().setAttribute("errormessage", ERRORMESSAGE_SOMETHING_GONE_WRONG);

        req.getServletContext().getRequestDispatcher(Constants.PATH_USER_HOMEPAGE_JSP).forward(req, resp);
    }
}
