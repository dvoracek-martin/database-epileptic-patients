package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.form.UserVO;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.util.List;
import java.util.Locale;

/**
 * The Interface UserService extends GenericService
 */
public interface UserService extends GenericService<UserEntity> {

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user entity
     */
    public UserEntity findUserByUsername(String username);

    /**
     * Gets the doctors.
     *
     * @return the doctors
     */
    public List<UserEntity> getDoctors();

    /**
     * creates new user with his locale
     *
     * @param user   as UserEntity
     * @param locale as Locale
     */
    public int create(UserVO user, Locale locale);


    public UserEntity findUserByEmail(String email);

    public List<UserEntity> findAllUsersWithPagination(int maxResults, int pageNumber);

    public boolean isUniqueUsername(String username);

    public boolean isUniqueEmail(String email);

    public void hide(Integer userId);
}
