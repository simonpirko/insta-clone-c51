package tms.instaclone.service;

import tms.instaclone.dao.UserDAO;
import tms.instaclone.dao.impl.inmemory.InMemoryUserDAO;
import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.Post;
import tms.instaclone.entity.User;
import tms.instaclone.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class UserService {
    private static volatile UserService instance;
    private final UserDAO userDAO = InMemoryUserDAO.getInstance();

    private UserService() {
    }

    public static UserService getInstance(){
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    public boolean save(User user) {
        return UserValidator.isValid(user) && !userDAO.exists(user) && userDAO.save(user);
    }

    public boolean update(User user) {
        return UserValidator.isValid(user) && userDAO.save(user);
    }

    public Optional<User> getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    public Optional<User> getUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }

    public Optional<User> getUserByMobilePhoneNumber(MobilePhoneNumber mobilePhoneNumber){
        return userDAO.getUserByMobilePhoneNumber(mobilePhoneNumber);
    }

    public void savePostToUser(long postId, User user){              //INST-24: card-block-save
        List publications = new ArrayList(user.getPublications());
        PostService postService = PostService.getInstance();
        Optional<Post> post = postService.getPostById(postId);
        publications.add(post);
        user.setPublications(publications);
        update(user);
    }
}
