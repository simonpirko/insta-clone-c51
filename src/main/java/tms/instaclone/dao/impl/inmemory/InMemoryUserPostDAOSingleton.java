package tms.instaclone.dao.impl.inmemory;

import tms.instaclone.dao.UserPostDAO;
import tms.instaclone.entity.UserPost;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public final class InMemoryUserPostDAOSingleton implements UserPostDAO {
    private static volatile InMemoryUserPostDAOSingleton instance;
    private final Map<Long, UserPost> dataSource = new ConcurrentHashMap<>();

    private InMemoryUserPostDAOSingleton() {
    }

    public static InMemoryUserPostDAOSingleton getInstance() {
        if (instance == null) {
            synchronized (InMemoryUserPostDAOSingleton.class) {
                if (instance == null) {
                    instance = new InMemoryUserPostDAOSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean exists(UserPost userPost) {
        if (!userPost.equals(null) && !dataSource.isEmpty()) {
            return dataSource.values()
                    .stream()
                    .anyMatch(currentUserPost -> {
                                if (!currentUserPost.getName().equals(null)) {
                                    return currentUserPost.getName().equals(userPost.getName());
                                } else {
                                    return false;
                                }
                            });
        } else {
            return false;
        }
    }

    @Override
    public boolean save(UserPost userPost) {
        return userPost != null && dataSource.putIfAbsent(userPost.getId(), userPost) == null;
    }

    @Override
    public List<UserPost> getUserPostByUsername(String username) {
        List<UserPost> optional = dataSource.values().stream().filter(currentUserPost -> currentUserPost.getUserName().equals(username)).collect(Collectors.toList());
        return optional;
    }
}
