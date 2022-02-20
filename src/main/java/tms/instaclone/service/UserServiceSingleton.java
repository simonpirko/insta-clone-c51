package tms.instaclone.service;

import tms.instaclone.dao.DataAccessObject;
import tms.instaclone.dao.UserDAO;
import tms.instaclone.dao.impl.inmemory.InMemoryUserDAOSingleton;
import tms.instaclone.entity.User;
import tms.instaclone.validator.UserValidator;

import java.util.Optional;

public final class UserServiceSingleton {
    private static volatile UserServiceSingleton instance;
    private final UserDAO userDAO = InMemoryUserDAOSingleton.getInstance();

    private UserServiceSingleton() {
    }

    public static UserServiceSingleton getInstance(){
        if (instance == null) {
            synchronized (UserServiceSingleton.class) {
                if (instance == null) {
                    instance = new UserServiceSingleton();
                }
            }
        }
        return instance;
    }

    public boolean save(User user) {
        return UserValidator.isValid(user) && !userDAO.exists(user) && userDAO.save(user);
    }

    public Optional<User> getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    public Optional<User> getUserByUsername(String username){
        return userDAO.getUserByUsername(username);
    }

    public Optional<User> getUserByMobilePhoneNumber(String mobilePhoneNumber){
        return userDAO.getUserByMobilePhoneNumber(mobilePhoneNumber);
    }

}
