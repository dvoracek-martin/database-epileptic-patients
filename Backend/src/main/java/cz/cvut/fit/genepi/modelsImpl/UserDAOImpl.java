package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.UserDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDAOImpl.
 */
public class UserDAOImpl extends GenericDAOImpl<UserDAO, Serializable>{
	
	/** The user. */
	public UserDAO user;

	/**
	 * Instantiates a new user dao impl.
	 */
	public UserDAOImpl() {
		user = new UserDAO();
	}

	/**
	 * Creates the user.
	 *
	 * @param id the id
	 * @param Username the username
	 * @param CreatedBy the created by
	 */
	public void createUser(int id, String Username, String CreatedBy) {
		user.setUserId(id);
		user.setUsername(Username);
		user.setCreatedBy(CreatedBy);
		user.setCreatedDate(new Date());
	}

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 */
	public void createUser(UserDAO user) {
		this.user = user;
	}
}
