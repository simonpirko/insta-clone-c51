package tms.instaclone.web.servlet;

public final class Constants {
    public static final String PATH_REGISTRATION_JSP = "/page/user/registration.jsp";
    public static final String PATH_AUTHORIZATION_JSP = "/page/user/authorization.jsp";
    public static final String PATH_AUTHORIZATION_NO_IMAGE_JSP = "/page/user/authorizationNoImage.jsp";
    public static final String PATH_USER_PROFILE_JSP = "/page/user/userProfile.jsp";
    public static final String PATH_USER_HOMEPAGE_JSP = "/page/user/homePage/userPage.jsp";
    public static final String PATH_PASSWORD_RESET_JSP = "/page/user/passwordReset/passwordResetPage.jsp";
    public static final String PATH_PASSWORD_UPDATE_JSP = "/page/user/passwordReset/passwordUpdatePage.jsp";

    public static final String NAME_REGISTRATION_SERVLET = "RegistrationServlet";
    public static final String NAME_AUTHORIZATION_SERVLET = "AuthorizationServlet";
    public static final String NAME_PASSWORD_RESET_SERVLET = "PasswordResetServlet";
    public static final String NAME_PASSWORD_UPDATE_SERVLET = "PasswordUpdateServlet";
    public static final String NAME_AUTHORIZATION_NO_IMAGE_SERVLET = "AuthorizationNoImageServlet";
    public static final String NAME_USER_PROFILE_SERVLET = "UserProfileServlet";
    public static final String NAME_SAVE_POST_SERVLET = "SavePostServlet";

    public static final String URL_REGISTRATION_SERVLET = "/accounts/emailsignup/";
    public static final String URL_AUTHORIZATION_SERVLET = "/";
    public static final String URL_PASSWORD_RESET_SERVLET = "/accounts/password/reset/";
    public static final String URL_PASSWORD_UPDATE_SERVLET = "/accounts/password/update/";
    public static final String URL_AUTHORIZATION_NO_IMAGE_SERVLET = "/accounts/login/";
    public static final String URL_USER_PROFILE_SERVLET = "/accounts/profile";
    public static final String URL_SAVE_POST_SERVLET = "/account/savePost/";

    public static final String ERRORMESSAGE_INCORRECT_DATE = "Такой даты не существует в нашем архиве";
    public static final String ERRORMESSAGE_INCORRECT_NUMBER = "Не правильный номер телефона";
    public static final String ERRORMESSAGE_EXIST_USERNAME = "Этот никнейм уже используется";
    public static final String ERRORMESSAGE_EXIST_NUMBER = "Этот номер телефона уже используется пользователем";
    public static final String ERRORMESSAGE_EXIST_MAIL = "Этот имэйл уже используется пользователем";
    public static final String ERRORMESSAGE_INCORRECT_ENTER_NUMBER = "К сожалению, вы ввели неправильный пароль. Проверьте свой пароль еще раз.";
    public static final String ERRORMESSAGE_INCORRECT_ENTER_USERNAME = "Введенное вами имя пользователя не принадлежит аккаунту. Проверьте свое имя пользователя и повторите попытку.";
    public static final String ERRORMESSAGE_ADD_USER = "Мы не можем добавить такого пользователя, пожалуйста, проверьте правильность данных";
    public static final String ERRORMESSAGE_UPDATE_USER_PASSWORD = "Мы не можем обновить пароль. Попробуйте еще раз";
    public static final String ERRORMESSAGE_RESET_USER_PHONE_EMAIL = "Нет такого пользователя";
    public static final String ERRORMESSAGE_INVALID_SECRET_WORD = "Секретная фраза введена неверно";

    private Constants() {
    }
}
