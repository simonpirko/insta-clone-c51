package tms.instaclone.web.servlet.user;

import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.Post;
import tms.instaclone.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static tms.instaclone.web.servlet.ServletConstants.*;

@WebServlet(urlPatterns = URL_AUTHORIZATION_SERVLET, name = NAME_AUTHORIZATION_SERVLET)
public class AuthorizationServlet extends HttpServlet {

    @Override
    public void init(){
        User user1 = new User("SashaGrey@gmail.com",new MobilePhoneNumber("+375", "294563345"),
                "Sasha", "Grey", "Grey1", "123457", LocalDate.now().minusYears(10L));

        User user2 = new User("Turner@gmail.com",new MobilePhoneNumber("+375", "294563675"),
                "Alex", "Turner", "Turner1", "1233423", LocalDate.now().minusYears(10L));

        User user3 = new User("Richard@gmail.com",new MobilePhoneNumber("+375", "334587671"),
                "Richard", "Hammond", "Hammond1", "1666663", LocalDate.now().minusYears(10L));

        User user4 = new User("Jeremy@gmail.com",new MobilePhoneNumber("+375", "339987688"),
                "Jeremy", "Clarkson", "Clarkson1", "1356763", LocalDate.now().minusYears(10L));

        User user5 = new User("James@gmail.com",new MobilePhoneNumber("+375", "333577688"),
                "James", "May", "May1", "999955", LocalDate.now().minusYears(10L));

        Post post1User1 = new Post(user1,"Post1", List.of("/user_data_storage/userid_1_imgid_1.jpg", "/user_data_storage/userid_1_imgid_2.jpg"),
                List.of(user1, user2, user3));

        Post post2User1 = new Post(user1,"Post2", List.of("/user_data_storage/userid_1_imgid_3.jpg", "/user_data_storage/userid_1_imgid_4.jpg"),
                List.of(user3, user4));
        Post post3User1 = new Post(user1,"Post3", List.of("/user_data_storage/userid_1_imgid_5.jpg", "/user_data_storage/userid_1_imgid_6.jpg"),
                List.of(user2, user4));
        Post post4User1 = new Post(user1,"Post4", List.of("/user_data_storage/userid_1_imgid_7.jpg", "/user_data_storage/userid_1_imgid_8.jpg"),
                List.of(user1, user3));
        Post post5User1 = new Post(user1,"Post5", List.of("/user_data_storage/userid_1_imgid_9.jpg", "/user_data_storage/userid_1_imgid_10.jpg"),
                List.of(user2, user4, user5));
        Post post6User1 = new Post(user1,"Post5", List.of("/user_data_storage/userid_1_videoid_1.mp4"), List.of( user1, user5));

        Post post1User2 = new Post(user2,"Post1", List.of("/user_data_storage/userid_2_imgid_11.jpg", "/user_data_storage/userid_2_imgid_12.jpg"),
                List.of(user2, user3, user4));
        Post post2User2 = new Post(user2,"Post2", List.of("/user_data_storage/userid_2_imgid_13.jpg", "/user_data_storage/userid_2_imgid_14.jpg"),
                List.of(user3, user5));
        Post post3User2 = new Post(user2,"Post3", List.of("/user_data_storage/userid_2_videoid_4.mp4", "/user_data_storage/userid_2_videoid_5.mp4" ),
                List.of(user1, user3));
        Post post4User2 = new Post(user2,"Post3", List.of("/user_data_storage/userid_2_imgid_15.jpg", "/user_data_storage/userid_2_imgid_16.jpg"),
                List.of(user1, user3));
        Post post5User2 = new Post(user2,"Post4", List.of("/user_data_storage/userid_2_imgid_17.jpg", "/user_data_storage/userid_2_imgid_18.jpg"),
                List.of(user2, user4, user5));
        Post post6User2 = new Post(user2,"Post5", List.of("/user_data_storage/userid_2_imgid_19.jpg", "/user_data_storage/userid_2_imgid_20.jpg"),
                List.of(user1, user3, user4));

        Post post1User3 = new Post(user3,"Post1", List.of("/user_data_storage/userid_3_videoid_6.mp4", "/user_data_storage/userid_3_imgid_22.jpg"),
                List.of(user3, user4));
        Post post2User3 = new Post(user3,"Post2", List.of("/user_data_storage/userid_3_imgid_21.jpg", "/user_data_storage/userid_3_videoid_7.mp4"),
                List.of(user2, user3, user5));
        Post post3User3 = new Post(user3,"Post3", List.of("/user_data_storage/userid_3_imgid_23.jpg", "/user_data_storage/userid_3_imgid_24.jpg"),
                List.of(user1, user5));
        Post post4User3 = new Post(user3,"Post4", List.of("/user_data_storage/userid_3_imgid_25.jpg", "/user_data_storage/userid_3_imgid_26.jpg"),
                List.of(user3, user4));
        Post post5User3 = new Post(user3,"Post5", List.of("/user_data_storage/userid_3_imgid_27.jpg", "/user_data_storage/userid_3_imgid_28.jpg"),
                List.of(user1, user2));

        Post post1User4 = new Post(user4,"Post1", List.of("/user_data_storage/userid_4_imgid_31.jpg", "/user_data_storage/userid_4_imgid_32.jpg"),
                List.of(user1, user3, user4));
        Post post2User4 = new Post(user4,"Post2", List.of("/user_data_storage/userid_4_videoid_8.mp4", "/user_data_storage/userid_4_imgid_33.jpg"),
                List.of(user1, user2,user4, user5));
        Post post3User4 = new Post(user4,"Post3", List.of("/user_data_storage/userid_4_videoid_9.mp4", "/user_data_storage/userid_4_imgid_35.jpg"),
                List.of(user1, user2, user5));
        Post post4User4 = new Post(user4,"Post4", List.of("/user_data_storage/userid_4_imgid_35.jpg", "/user_data_storage/userid_4_imgid_36.jpg","/user_data_storage/userid_4_imgid_37.jpg"),
                List.of(user3, user4, user5));
        Post post5User4 = new Post(user4,"Post5", List.of("/user_data_storage/userid_4_imgid_38.jpg", "/user_data_storage/userid_4_imgid_39.jpg", "/user_data_storage/userid_4_imgid_40.jpg"),
                List.of(user3,user4, user5));

        Post post1User5 = new Post(user5,"Post1", List.of("/user_data_storage/userid_5_imgid_41.jpg", "/user_data_storage/userid_5_imgid_42.jpg"),
                List.of(user2, user3, user5));
        Post post2User5 = new Post(user5,"Post2", List.of("/user_data_storage/userid_5_imgid_43.jpg", "/user_data_storage/userid_5_imgid_44.jpg"),
                List.of(user1, user2));
        Post post3User5 = new Post(user5,"Post3", List.of("/user_data_storage/userid_5_imgid_45.jpg", "/user_data_storage/userid_5_imgid_46.jpg"),
                List.of(user1, user2, user4, user5));
        Post post4User5 = new Post(user5,"Post4", List.of("/user_data_storage/userid_5_videoid_10.mp4", "/user_data_storage/userid_5_videoid_11.mp4","/user_data_storage/userid_5_imgid_47.jpg"),
                List.of(user2, user3));
        Post post5User5 = new Post(user5,"Post5", List.of("/user_data_storage/userid_5_imgid_48.jpg", "/user_data_storage/userid_5_videoid_12.mp4", "/user_data_storage/userid_5_imgid_49.jpg"),
                List.of(user2, user3));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher(PATH_AUTHORIZATION_JSP).forward(req, resp);
    }
}
