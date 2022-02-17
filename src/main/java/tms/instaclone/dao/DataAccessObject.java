package tms.instaclone.dao;

import tms.instaclone.entity.Entity;
import tms.instaclone.entity.User;

import java.util.Optional;

public interface DataAccessObject<T extends Entity> {

    boolean exists(T entity);

    boolean save(T entity);

    Optional<T> getUserByEmail(String email);

    Optional<T> getUserByUsername(String username);

    Optional<T> getUserByMobilePhoneNumber(String mobilePhoneNumber);

}
