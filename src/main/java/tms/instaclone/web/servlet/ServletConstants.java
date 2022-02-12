package tms.instaclone.web.servlet;

public final class ServletConstants {
    public static final String NAME_REGISTRATION_SERVLET = "RegistrationServlet";


    public static final String URL_REGISTRATION_SERVLET = "/accounts/emailsignup";
    public static final String URL_LOGIN_SERVLET = "/login";

    /**
     * must add a registration jsp path
     */
    public static final String PATH_REGISTRATION_JSP = "/page/user/registration.jsp";


    public static final String PARAMETER_NAME_USER_MOBILE_PHONE_OR_EMAIL = "mobilePhoneOrEmail";
    public static final String PARAMETER_NAME_USER_FIRST_NAME_AND_LAST_NAME = "firstNameAndLastName";
    public static final String PARAMETER_NAME_USER_USERNAME = "username";
    public static final String PARAMETER_NAME_USER_PASSWORD = "password";
    public static final String PARAMETER_NAME_USER_BIRTHDAY = "birthday";


    private ServletConstants() {
    }
}
