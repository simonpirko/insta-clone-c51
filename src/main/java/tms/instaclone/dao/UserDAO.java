package tms.instaclone.dao;

import tms.instaclone.entity.MobilePhoneNumber;
import tms.instaclone.entity.User;

import java.util.Optional;

public interface UserDAO extends DataAccessObject<User> {

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByMobilePhoneNumber(MobilePhoneNumber mobilePhoneNumber);
}