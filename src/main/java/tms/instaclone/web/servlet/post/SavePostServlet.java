// INST-24: card-block-save

package tms.instaclone.web.servlet.post;

import tms.instaclone.entity.Publication;
import tms.instaclone.entity.User;
import tms.instaclone.service.PostService;
import tms.instaclone.service.UserService;
import tms.instaclone.validator.UserValidator;
import tms.instaclone.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = Constants.URL_SAVE_POST_SERVLET, name = Constants.NAME_SAVE_POST_SERVLET)
public class SavePostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        UserService userService = UserService.getInstance();
        HttpSession session = req.getSession();
        User user = (User)req.getSession().getAttribute("user");
        long postId = Long.parseLong(req.getParameter("postId"));
        userService.savePostToUser(postId, user);
        req.getServletContext().getRequestDispatcher(Constants.URL_AUTHORIZATION_NO_IMAGE_SERVLET).forward(req, resp);
    }
}
