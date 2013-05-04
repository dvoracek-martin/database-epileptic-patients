package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.UserDAO;

public class UserDAOImpl extends GenericDAOImpl<UserDAO, Serializable>{
	
	public UserDAO user;

	public UserDAOImpl() {
		user = new UserDAO();
	}

	public void createUser(int id, String Username, String CreatedBy) {
		user.setUserId(id);
		user.setUsername(Username);
		user.setCreatedBy(CreatedBy);
		user.setCreatedDate(new Date());
	}

	public void createUser(UserDAO user) {
		this.user = user;
	}
}
