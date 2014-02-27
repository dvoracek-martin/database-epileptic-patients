package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.UserRoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Martin on 27.2.14.
 */
@Service
public class AuthorizationCheckerImpl implements AuthorizationChecker {
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    public boolean checkAuthoritaion(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();
        List<UserRoleEntity> roles = userRoleService.findAllUserRolesByUserID((userService.findUserByUsername(name)).getId());
        boolean isAuthorized = false;
        for (UserRoleEntity r : roles) {
            if (r.getRole_id()==(1)) {
                isAuthorized = true;
                break;
            }
        }
        if (!isAuthorized) {
           // SecurityContextHolder.getContext().setAuthentication(null);
               HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        }
        return isAuthorized;
    }
}
