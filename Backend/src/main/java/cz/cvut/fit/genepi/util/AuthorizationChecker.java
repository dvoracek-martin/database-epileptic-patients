package cz.cvut.fit.genepi.util;

import cz.cvut.fit.genepi.businessLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Martin on 27.2.14.
 */
public class AuthorizationChecker {

    public static boolean checkAuthoritaion(HttpServletRequest request){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        List<GrantedAuthority> roles = (List<GrantedAuthority>) auth.getAuthorities();
        boolean isAuthorized = false;
        for (GrantedAuthority r : roles) {
            if (r.getAuthority().equals("ROLE_USER")) {
                isAuthorized = true;
                break;
            }
        }
        if (!isAuthorized){
            SecurityContextHolder.getContext().setAuthentication(null);
            CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
            SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }
        return isAuthorized;
    }
}
