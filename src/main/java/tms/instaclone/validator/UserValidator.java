package tms.instaclone.validator;

import tms.instaclone.entity.User;
import tms.instaclone.service.UserService;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class UserValidator extends AbstractEntityValidator<User> {
    public static final String REGEX_EMAIL = ".+@.+\\..+";
    public static final String REGEX_MOBILE_PHONE =
            "^(\\+)?(\\(\\d{2,3}\\) ?\\d|\\d)(([ \\-]?\\d)|( ?\\(\\d{2,3}\\) ?)){5,12}\\d$";
    public static final String REGEX_USERNAME = "^[\\d\\w]*$";
    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MAX_PASSWORD_LENGTH = 30;
    public static final int MIN_USER_AGE = 18;
    public static final int MAX_USER_AGE = 130;

    public static final String USER_EXISTS = "userExists";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_MOBILE_PHONE = "mobilePhone";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_USERNAME = "username";
    private static final String FIELD_PASSWORD = "password";
    private static final String FIELD_BIRTHDAY = "birthday";

    private static final String MESSAGE_USER_EXISTS = "User with this phone number, mail or username already exists!";
    public static final String MESSAGE_INVALID_EMAIL_FIELD = "Email must be in format ____@___.__ !";
    private static final String MESSAGE_INVALID_MOBILE_PHONE_FIELD = "Invalid phone number format!";
    private static final String MESSAGE_INVALID_NAME_FIELD = "Invalid name!";
    private static final String MESSAGE_INVALID_USERNAME_FIELD = "Invalid username!";
    private static final String MESSAGE_INVALID_BIRTHDAY_FIELD = "Invalid birthday!";
    private static final String MESSAGE_INVALID_PASSWORD_FIELD = "Invalid password!";

    private UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(User user) {
        return user != null &&
                !exists(user) &&
                (isValidEmail(user.getEmail()) || isValidMobilePhone(user.getMobilePhone())) &&
                (isValidName(user.getFirstName()) || isValidName(user.getLastName())) &&
                isValidUsername(user.getUsername()) &&
                isValidPassword(user.getPassword()) &&
                isValidBirthday(user.getBirthday());
    }

    private boolean exists(User user) {
        if (userService.exists(user)) {
            return true;
        } else {
            getErrorMessages().put(USER_EXISTS, MESSAGE_USER_EXISTS);
            return false;
        }
    }

    private boolean isValidEmail(String email) {
        if (email != null && !email.isBlank() && Pattern.matches(REGEX_EMAIL, email)) {
            return true;
        } else {
            getErrorMessages().put(FIELD_EMAIL, MESSAGE_INVALID_EMAIL_FIELD);
            return false;
        }
    }

    private boolean isValidMobilePhone(String mobilePhone) {
        if (mobilePhone != null && !mobilePhone.isBlank() && Pattern.matches(REGEX_MOBILE_PHONE, mobilePhone)) {
            return true;
        } else {
            getErrorMessages().put(FIELD_MOBILE_PHONE, MESSAGE_INVALID_MOBILE_PHONE_FIELD);
            return false;
        }
    }

    private boolean isValidName(String name) {
        if (name != null && !name.isBlank() && Pattern.matches(REGEX_CONTAIN_ONLY_LATIN_CHARS_AND_NUMBERS, name)) {
            return true;
        } else {
            getErrorMessages().put(FIELD_NAME, MESSAGE_INVALID_NAME_FIELD);
            return false;
        }
    }

    private boolean isValidUsername(String username) {
        if (username != null && !username.isBlank() && Pattern.matches(REGEX_USERNAME, username)) {
            return true;
        } else {
            getErrorMessages().put(FIELD_USERNAME, MESSAGE_INVALID_USERNAME_FIELD);
            return false;
        }
    }

    private boolean isValidPassword(String password) {
        if (password != null && !password.isBlank() &&
                password.length() > MIN_PASSWORD_LENGTH && password.length() < MAX_PASSWORD_LENGTH) {
            return true;
        } else {
            getErrorMessages().put(FIELD_PASSWORD, MESSAGE_INVALID_PASSWORD_FIELD);
            return false;
        }
    }

    private boolean isValidBirthday(LocalDate birthday) {
        if (birthday != null) {
            int userAge = Period.between(birthday, LocalDate.now()).getYears();
            if (userAge > MIN_USER_AGE && userAge < MAX_USER_AGE) {
                return true;
            } else {
                getErrorMessages().put(FIELD_BIRTHDAY, MESSAGE_INVALID_BIRTHDAY_FIELD);
                return false;
            }
        } else {
            return false;
        }
    }
}
