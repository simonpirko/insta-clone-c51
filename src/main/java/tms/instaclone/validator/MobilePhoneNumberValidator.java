package tms.instaclone.validator;

import tms.instaclone.entity.MobilePhoneNumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class MobilePhoneNumberValidator {
    public static final String PATH_COUNTRY_CALLING_CODE_PROPERTIES = "src/main/resources/countrycallingcode.properties";
    public static final String REGEX_PHONE_NUMBER = "(^(\\+)?((\\d{2,3}) ?\\d|\\d)(([ -]?\\d)|( ?(\\d{2,3}) ?)){5,12}\\d$)";

    public static boolean isValid(MobilePhoneNumber mobilePhoneNumber) {
        return mobilePhoneNumber != null && isValidCountryCallingCode(mobilePhoneNumber.getCountryCallingCode()) &&
                isValidPhoneNumber(mobilePhoneNumber.getPhoneNumber());
    }

    public static boolean isValidCountryCallingCode(String countryCallingCode) {
        if (countryCallingCode != null && !countryCallingCode.isBlank()) {
            Properties country = new Properties();
            try {
                country.load(new FileInputStream(PATH_COUNTRY_CALLING_CODE_PROPERTIES));
                return country.values()
                        .stream()
                        .flatMap(callingCode -> Arrays.stream(String.valueOf(callingCode).replaceAll(" ", "").split(",")))
                        .anyMatch(Predicate.isEqual(countryCallingCode));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
           return false;
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return Pattern.matches(REGEX_PHONE_NUMBER, phoneNumber);
    }
}
