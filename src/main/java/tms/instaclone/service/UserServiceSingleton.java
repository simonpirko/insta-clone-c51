package tms.instaclone.service;

import tms.instaclone.dao.DataAccessObject;
import tms.instaclone.dao.impl.inmemory.InMemoryUserDAOSingleton;
import tms.instaclone.entity.User;
import tms.instaclone.validator.UserValidator;

public final class UserServiceSingleton {
    private static volatile UserServiceSingleton instance;
    private final DataAccessObject<User> userDAO = InMemoryUserDAOSingleton.getInstance();

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
}
