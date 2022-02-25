package tms.instaclone.entitylisthandler;

public class EntityListHandlerException extends Exception {

    public EntityListHandlerException() {
        super();
    }

    public EntityListHandlerException(String message) {
        super(message);
    }

    public EntityListHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityListHandlerException(Throwable cause) {
        super(cause);
    }

    protected EntityListHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
