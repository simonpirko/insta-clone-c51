package tms.instaclone.validator;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEntityValidator<T> {
    public static final String REGEX_CONTAIN_ONLY_LATIN_CHARS_AND_NUMBERS = "^[a-zA-Z0-9]*$";
    private Map<String, String> errorMessages;

    public AbstractEntityValidator() {
        errorMessages = new HashMap<>();
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
