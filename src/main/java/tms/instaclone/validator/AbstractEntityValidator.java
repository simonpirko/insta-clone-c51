package tms.instaclone.validator;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntityValidator<T> {
    public static final String REGEX_NAME = "^[a-zA-Z0-9]*$";
    public static final String REGEX_USERNAME = "^[\\d\\w]*$";
    private Map<String, String> errorMessages = new HashMap<>();

    public AbstractEntityValidator() {
    }

    public AbstractEntityValidator(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public Map<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(Map<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public abstract boolean isValid(T entity);
}
