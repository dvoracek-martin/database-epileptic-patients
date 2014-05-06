package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.BO.display.UserDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.UserFormBO;
import cz.cvut.fit.genepi.businessLayer.service.MailService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.DAO.RoleDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.UserDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<UserFormBO, UserEntity> implements UserService {

    private RoleDAO roleDAO;

    private MailService mailService;

    private UserDAO userDAO;

    private Mapper dozer;

    @Autowired
    public UserServiceImpl(RoleDAO roleDAO,
                           MailService mailService,
                           UserDAO userDAO,
                           Mapper dozer) {

        this.roleDAO = roleDAO;
        this.mailService = mailService;
        this.userDAO = userDAO;
        this.dozer = dozer;
    }

    @Override
    @Transactional
    public UserEntity getUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    @Transactional
    public UserEntity getUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    @Transactional
    public int create(UserFormBO user, Locale locale) {

        String password = RandomStringUtils.randomAlphanumeric(10);
        user.setPassword(DigestUtils.sha256Hex(password + "{" + user.getUsername() + "}"));

        UserEntity userEntity = dozer.map(user, UserEntity.class);
        /* assigning roles to user */
        ArrayList<RoleEntity> roles = new ArrayList<>();
        roles.add(roleDAO.getById(1, RoleEntity.class));
        userEntity.setRoles(roles);
        int userId = userDAO.saveUser(userEntity);

		/* sending email to user about account creation */
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("subject", "creationOfANewUser");
            map.put("user", user);
            map.put("password", password);
            mailService.sendMail(user.getContact().getEmail(), map, locale);

        } catch (Exception e) {
//
        }
        return userId;
    }

    @Override
    @Transactional
    public boolean isUniqueUsername(String username) {
        return this.getUserByUsername(username) == null;
    }

    @Override
    @Transactional
    public boolean isUniqueEmail(String email) {
        return this.getUserByEmail(email) == null;
    }

    @Override
    @Transactional
    public boolean isMineOrUniqueUsername(int userId, String username) {
        UserFormBO user = getById(userId, UserFormBO.class, UserEntity.class);
        return user.getUsername().equals(username) || this.isUniqueUsername(username);
    }

    @Override
    @Transactional
    public boolean isMineOrUniqueEmail(int userId, String email) {
        UserFormBO user = getById(userId, UserFormBO.class, UserEntity.class);
        return user.getContact().getEmail().equals(email) || this.isUniqueEmail(email);
    }

    @Override
    @Transactional
    public List<UserDisplayBO> findAllNonHidden() {

        List<UserEntity> userEntityList = userDAO.findAllNonHidden();
        List<UserDisplayBO> userDisplayBOList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            userDisplayBOList.add(dozer.map(userEntity, UserDisplayBO.class));
        }

        return userDisplayBOList;
    }

    @Override
    @Transactional
    public void changePassword(UserFormBO user) {

        user.setPassword(DigestUtils.sha256Hex(user.getPassword()
                + "{" + user.getUsername() + "}"));
        UserEntity userEntity = dozer.map(user, UserEntity.class);
        genericDAO.update(userEntity);
    }

    @Override
    @Transactional
    public void hide(int userId) {
        userDAO.hide(userId);
    }

    @Override
    @Transactional
    public void revokeRoles(int userId) {
        UserEntity user = genericDAO.getById(userId, UserEntity.class);
        user.setRoles(new ArrayList<RoleEntity>());
        genericDAO.update(user);
    }

    @Override
    @Transactional
    public int getLoggedUserId() {

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();

        UserEntity user = this.getUserByUsername(name);
        return user.getId();
    }
}
