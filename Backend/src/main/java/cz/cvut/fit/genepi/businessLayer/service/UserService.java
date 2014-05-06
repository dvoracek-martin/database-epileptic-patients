package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.display.UserDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.UserFormBO;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.util.List;
import java.util.Locale;

/**
 * The Interface UserService extends GenericService
 */
public interface UserService extends GenericService<UserFormBO, UserEntity> {

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user entity
     */
    //TODO should return some VO
    public UserEntity getUserByUsername(String username);

    //TODO should return some VO
    public UserEntity getUserByEmail(String email);

    /**
     * creates new user with his locale
     *
     * @param user   as UserEntity
     * @param locale as Locale
     */
    public int create(UserFormBO user, Locale locale);

    public boolean isUniqueUsername(String username);

    public boolean isUniqueEmail(String email);

    public boolean isMineOrUniqueUsername(int userId, String username);

    public boolean isMineOrUniqueEmail(int userId, String email);

    public List<UserDisplayBO> findAllNonHidden();

    public void changePassword(UserFormBO user);

    public void hide(int userId);

    public void revokeRoles(int userId);

    public int getLoggedUserId();

}
