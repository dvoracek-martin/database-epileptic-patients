package cz.cvut.fit.genepi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.UserDAO;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.LoggingService;
import cz.cvut.fit.genepi.service.MailService;
import cz.cvut.fit.genepi.service.RoleService;
import cz.cvut.fit.genepi.service.UserService;

// TODO: Auto-generated Javadoc

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl extends
		GenericServiceImpl<UserEntity> implements UserService {

	private LoggingService logger = new LoggingService();

	@Autowired
	RoleService roleService;

	@Autowired
	MailService mailService;

	/** The user dao. */
	@Autowired
	private UserDAO userDAO;

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
	public void create(UserEntity user, Locale locale) {
		String password = RandomStringUtils.randomAlphanumeric(10);
		//FIXME: bad logger
		if (logger.getLogger() == null)
			logger.setLogger(UserServiceImpl.class);
		logger.logInfo("New password " + password + " for new user id "
				+ user.getId() + " generated.");
		user.setPassword(DigestUtils.sha256Hex(password + "{"
				+ user.getUsername() + "}"));

		/* assigning roles to user */
		ArrayList<RoleEntity> roles = new ArrayList<RoleEntity>();
		roles.add(roleService.findByID(RoleEntity.class, 1));
		user.setRoles(roles);
		this.save(user);

		/* sending email to user about account creation */
		try {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("subject", "creationOfANewUser");
			map.put("user", user);
			map.put("password", password);
			mailService.sendMail("test", map, locale);
			logger.logInfo("Email to new user sent");

		} catch (Exception e) {
			logger.logError(
					"Error when trying to send email after creating new user.",
					e);
		}
	}
}
