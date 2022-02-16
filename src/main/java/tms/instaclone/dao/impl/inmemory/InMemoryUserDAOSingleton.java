package tms.instaclone.dao.impl.inmemory;

import tms.instaclone.dao.UserDAO;
import tms.instaclone.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryUserDAOSingleton implements UserDAO {
    private static volatile InMemoryUserDAOSingleton instance;
    private final Map<Long, User> dataSource = new ConcurrentHashMap<>();

    private InMemoryUserDAOSingleton() {
    }

    public static InMemoryUserDAOSingleton getInstance(){
        if (instance == null) {
            synchronized (InMemoryUserDAOSingleton.class) {
                if (instance == null) {
                    instance = new InMemoryUserDAOSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean exists(User user) {
        if (user != null && !dataSource.isEmpty()) {
            return dataSource.values()
                    .stream()
                    .anyMatch(currentUser -> {
                        if (currentUser.getEmail() != null) {
                            return currentUser.getEmail().equals(user.getEmail()) ||
                                    currentUser.getUsername().equals(user.getUsername());
                        } else {
                            return currentUser.getMobilePhoneNumber().equals(user.getMobilePhoneNumber()) ||
                                    currentUser.getUsername().equals(user.getUsername());
                        }
                    });
        } else {
            return false;
        }

    }

    @Override
    public boolean save(User user) {
        return user != null && dataSource.putIfAbsent(user.getId(), user) == null;
    }
}
