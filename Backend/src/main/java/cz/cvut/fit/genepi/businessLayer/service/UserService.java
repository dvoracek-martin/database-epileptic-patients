package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.UserDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.UserVO;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.util.List;
import java.util.Locale;

/**
 * The Interface UserService extends GenericService
 */
public interface UserService extends GenericService<UserVO, UserEntity> {

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user entity
     */
    public UserEntity getUserByUsername(String username);

    public UserEntity getUserByEmail(String email);

    /**
     * creates new user with his locale
     *
     * @param user   as UserEntity
     * @param locale as Locale
     */
    public int create(UserVO user, Locale locale);

    public boolean isUniqueUsername(String username);

    public boolean isUniqueEmail(String email);

    public boolean isMineOrUniqueUsername(int userId, String username);

    public boolean isMineOrUniqueEmail(int userId, String email);

    public List<UserDisplayVO> findAllNonHidden();

    public void changePassword(UserVO user);

    public void hide(int userId);

    public void revokeRoles(int userId);

   // public UserDisplayVO getDisplayById(int userId);

    //public List<UserEntity> findAllUsersWithPagination(int maxResults, int pageNumber);

}
