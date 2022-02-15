package tms.instaclone.dao.impl.inmemory;

import tms.instaclone.dao.UserDAO;
import tms.instaclone.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserDAO implements UserDAO {
    private Map<Long, User> dataSource;

    public InMemoryUserDAO(Map<Long, User> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean exists(User user) {
        if (user != null && dataSource != null && !dataSource.isEmpty()) {
            return dataSource.values()
                    .stream()
                    .anyMatch(currentUser -> {
                        if (currentUser.getEmail() != null) {
                            return currentUser.getEmail().equals(user.getEmail()) ||
                                    currentUser.getUsername().equals(user.getUsername());
                        } else {
                            return currentUser.getMobilePhone().equals(user.getMobilePhone()) ||
                                    currentUser.getUsername().equals(user.getUsername());
                        }
                    });
        } else {
            return false;
        }

    }

    @Override
    public boolean save(User user) {
        if (dataSource == null) {
            dataSource = new ConcurrentHashMap<>();
        }
        return user != null && dataSource.putIfAbsent(user.getId(), user) == null;
    }
}
