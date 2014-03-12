package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.UserDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.UserVO;
import cz.cvut.fit.genepi.businessLayer.service.MailService;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.DAO.UserDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends GenericServiceImpl<UserEntity> implements UserService {

    private LoggingService logger = new LoggingService();

    private RoleService roleService;

    private MailService mailService;

    private UserDAO userDAO;

    private Mapper dozer;

    @Autowired
    public UserServiceImpl(RoleService roleService,
                           MailService mailService,
                           UserDAO userDAO,
                           Mapper dozer) {
        this.roleService = roleService;
        this.mailService = mailService;
        this.userDAO = userDAO;
        this.dozer = dozer;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * cz.cvut.fit.genepi.service.UserService#findUserByUsername(java.lang.String
     * )
     */
    @Override
    @Transactional
    public UserEntity findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.service.UserService#getDoctors()
     */
    @Override
    @Transactional
    public List<UserEntity> getDoctors() {
        return userDAO.getDoctors();
    }

    @Override
    @Transactional
    public List<UserEntity> findAllUsersWithPagination(int maxResults, int pageNumber) {
        return userDAO.findAllUsersWithPagination(maxResults, pageNumber);
    }

    @Override
    @Transactional
    public int create(UserVO user, Locale locale) {

        String password = RandomStringUtils.randomAlphanumeric(10);
        user.setPassword(DigestUtils.sha256Hex(password + "{" + user.getUsername() + "}"));

        //FIXME: bad logger
         /*if (logger.getLogger() == null)
            logger.setLogger(UserServiceImpl.class);
        logger.logInfo("New password " + password + " for new user id "
                + user.getId() + " generated.");*/


        UserEntity userEntity = dozer.map(user, UserEntity.class);
        /* assigning roles to user */
        ArrayList<RoleEntity> roles = new ArrayList<>();
        roles.add(roleService.findByID(RoleEntity.class, 1));
        userEntity.setRoles(roles);
        int userId = userDAO.saveUser(userEntity);

		/* sending email to user about account creation */
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("subject", "creationOfANewUser");
            map.put("user", user);
            map.put("password", password);
            mailService.sendMail(user.getContact().getEmail(), map, locale);

            //logger.logInfo("Email to new user sent");

        } catch (Exception e) {
          /*  logger.logError(
                    "Error when trying to send email after creating new user.",
                    e);*/
        }
        return userId;
    }

    @Override
    @Transactional
    public UserEntity findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    @Transactional
    public boolean isUniqueUsername(String username) {
        return this.findUserByUsername(username) == null;
    }

    @Override
    @Transactional
    public boolean isUniqueEmail(String email) {
        return this.findUserByEmail(email) == null;
    }

    @Override
    @Transactional
    public void hide(Integer userId) {

        UserEntity user = this.findByID(UserEntity.class, userId);
        user.setRoles(null);
        user.setHidden(true);
        this.save(user);
    }

    @Override
    @Transactional
    public List<UserDisplayVO> findAllNonHidden() {

        List<UserEntity> userEntityList = userDAO.findAllNonHidden();
        List<UserDisplayVO> userDisplayVOList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            userDisplayVOList.add(dozer.map(userEntity, UserDisplayVO.class));
        }

        return userDisplayVOList;
    }
}