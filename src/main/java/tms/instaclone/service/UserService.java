package tms.instaclone.service;

import tms.instaclone.dao.DAO;
import tms.instaclone.entity.User;

public class UserService {
    private final DAO<User> userDAO;

    public UserService(DAO<User> userDAO) {
        this.userDAO = userDAO;
    }

    public boolean exists(User user) {
        return userDAO.exists(user);
    }

    public boolean save(User user) {
        if (!userDAO.exists(user)) {
            return userDAO.save(user);
        } else {
            return false;
        }
    }
}
