package tms.instaclone.dao.impl.inmemory;

import tms.instaclone.dao.UserDAO;
import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryUserDAO implements UserDAO {
    private static volatile InMemoryUserDAO instance;
    private final Map<Long, User> dataSource = new ConcurrentHashMap<>();

    private InMemoryUserDAO() {
    }

    public static InMemoryUserDAO getInstance(){
        if (instance == null) {
            synchronized (InMemoryUserDAO.class) {
                if (instance == null) {
                    instance = new InMemoryUserDAO();
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

    @Override
    public List<User> findAll() {
        return new ArrayList<>(dataSource.values());
    }

    @Override
    public Optional<User> getUserByEmail(String email){
        Optional<User> optional = dataSource.values().stream().filter(currentUser -> currentUser.getEmail().equals(email)).findAny();
        return optional;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> optional = dataSource.values().stream().filter(currentUser -> currentUser.getUsername().equals(username)).findAny();
        return optional;
    }

    @Override
    public Optional<User> getUserByMobilePhoneNumber(String login) {

        String onlynumber = login.replaceAll("[\\s\\-\\(\\)]+", "");
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("countrycallingcode.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Optional optional1 = properties.values()
                .stream()
                .filter(x->onlynumber.startsWith(x.toString()
                        .replaceAll(" ", ""))).findFirst();
        String countryCode = optional1.get().toString().replaceAll(" ","");
        String number = onlynumber.substring(countryCode.length(), onlynumber.length());
        MobilePhoneNumber mobilePhoneNumber = new MobilePhoneNumber(countryCode,number);
        Optional<User> optional = dataSource.values()
                .stream()
                .filter(currentUser -> currentUser.getMobilePhoneNumber().equals(mobilePhoneNumber)).findAny();
        return optional;
    }
}

