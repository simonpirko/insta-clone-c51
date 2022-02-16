package tms.instaclone.service;

import tms.instaclone.dao.DAO;
import tms.instaclone.entity.User;
import tms.instaclone.validator.AbstractEntityValidator;

public class UserService {
    private final DAO<User> userDAO;
    private final AbstractEntityValidator<User> userValidator;

    public UserService(DAO<User> userDAO, AbstractEntityValidator<User> userValidator) {
        this.userDAO = userDAO;
        this.userValidator = userValidator;
    }

    public boolean exists(User user) {
        return userDAO.exists(user);
    }

    public boolean save(User user) {
        return userValidator.isValid(user) && !userDAO.exists(user) && userDAO.save(user);
    }
}
