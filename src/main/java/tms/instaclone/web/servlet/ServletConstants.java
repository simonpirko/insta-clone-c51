package tms.instaclone.web.servlet;

public final class ServletConstants {
    public static final String PATH_REGISTRATION_JSP = "/page/user/registration.jsp";
    public static final String PATH_AUTHORIZATION_JSP = "/page/user/authorization.jsp";
    public static final String PATH_PASSWORD_RESET_PAGE_JSP = "/page/user/passwordResetPage.jsp";
    public static final String PATH_AUTHORIZATION_NO_IMAGE_JSP = "/page/user/authorizationNoImage.jsp";


    public static final String NAME_REGISTRATION_SERVLET = "RegistrationServlet";
    public static final String NAME_AUTHORIZATION_SERVLET = "AuthorizationServlet";
    public static final String NAME_PASSWORD_RESET_SERVLET = "PasswordResetServlet";
    public static final String NAME_AUTHORIZATION_NO_IMAGE_SERVLET = "AuthorizationNoImageServlet";


    public static final String URL_REGISTRATION_SERVLET = "/accounts/emailsignup/";
    public static final String URL_AUTHORIZATION_SERVLET = "/";
    public static final String URL_PASSWORD_RESET_SERVLET = "/accounts/password/reset/";
    public static final String URL_AUTHORIZATION_NO_IMAGE_SERVLET = "/accounts/login/";

    private ServletConstants() {
    }
}
