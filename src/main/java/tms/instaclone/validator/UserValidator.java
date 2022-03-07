package tms.instaclone.validator;

import tms.instaclone.entity.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserValidator {
    public static final String REGEX_CONTAIN_ONLY_LATIN_CHARS_AND_NUMBERS = "^[a-zA-Z0-9]*$";
    public static final String REGEX_EMAIL = "([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+)";
    public static final String REGEX_USERNAME = "^[\\d\\w]*$";


    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MAX_PASSWORD_LENGTH = 30;
    public static final int MIN_USER_AGE = 18;
    public static final int MAX_USER_AGE = 130;


    public static boolean isValid(User user) {
        return user != null &&
                (isValidEmail(user.getEmail()) || MobilePhoneNumberValidator.isValid(user.getMobilePhoneNumber())) &&
                (isValidName(user.getFirstName()) || isValidName(user.getLastName())) &&
                isValidUsername(user.getUsername()) &&
                isValidPassword(user.getPassword()) &&
                isValidBirthday(user.getBirthday());
    }

    public static boolean isValidEmail(String email) {
        return email != null && !email.isBlank() && Pattern.matches(REGEX_EMAIL, email);
    }

    public static boolean isValidName(String name) {
        return name != null && !name.isBlank() && Pattern.matches(REGEX_CONTAIN_ONLY_LATIN_CHARS_AND_NUMBERS, name);
    }

    public static boolean isValidUsername(String username) {
        return username != null && !username.isBlank() && Pattern.matches(REGEX_USERNAME, username);
    }

    public static boolean isValidPassword(String password) {
        return password != null && !password.isBlank() &&
                password.length() > MIN_PASSWORD_LENGTH && password.length() < MAX_PASSWORD_LENGTH;
    }

    public static boolean isValidBirthday(LocalDate birthday) {
        if (birthday != null) {
            int userAge = Period.between(birthday, LocalDate.now()).getYears();
            return userAge >= MIN_USER_AGE && userAge < MAX_USER_AGE;
        } else {
            return false;
        }
    }
}
