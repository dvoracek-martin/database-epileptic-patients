package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.UserRoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
        List<UserRoleEntity> roles = userRoleService.findAllUserRolesByUserID((userService.getUserByUsername(name)).getId());
        boolean isAuthorized = false;
        for (UserRoleEntity r : roles) {
            if (r.getRoleId() == (1)) {
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

    public boolean onlyResearcher() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        List<RoleEntity> roles = (userService.getUserByUsername(name)).getRoles();

        return (roles.size() == 2) && ((roles.get(0).getId() == 1 && roles.get(1).getId() == 2) || ((roles.get(0).getId() == 2 && roles.get(1).getId() == 1)));
    }

    @Override
    @Transactional
    public boolean isAdmin() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        List<RoleEntity> roles = (userService.getUserByUsername(name)).getRoles();

        for (RoleEntity role : roles) {
            if (role.getId() == 5) {
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean isUserFromUrl(int userId) {
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        UserEntity user = userService.getUserByUsername(name);

        return user.getId() == userId;
    }

    @Override
    @Transactional
    public boolean isSuperDoctor() {
        String name = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        List<RoleEntity> roles = (userService.getUserByUsername(name)).getRoles();

        for (RoleEntity role : roles) {
            if (role.getId() == 4) {
                return true;
            }
        }
        return false;
    }
}
