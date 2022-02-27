package tms.instaclone.web.filter;

import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = "AuthorizationServletNoImage")
public class AuthorizationNoImageFilter extends AuthorizationFilter {


}
