package cz.cvut.fit.genepi.modelsImpl;

import java.util.Date;

import org.hibernate.classic.Session;

import cz.cvut.fit.genepi.models.UserDAO;
import cz.cvut.fit.genepi.utils.HibernateUtil;

public class UserDAOImpl {
	UserDAO user;

	public UserDAOImpl() {
		user = new UserDAO();
	}

	public void createUser(int id, String Username, String CreatedBy) {
		user.setUserId(id);
		user.setUsername(Username);
		user.setCreatedBy(CreatedBy);
		user.setCreatedDate(new Date());
	}

	// not implemented yet
	public void deleteUser() {
		throw new UnsupportedOperationException();
	}


	/*
	 * =============================================== 
	 * THIS BLOCK DEMONSTRATES THE WORK WITH HIBERNATE
	 * ===============================================
	 */
	
	// save user to dtb
	public void saveUser() {
		// create new session via HibernateUtil class
		// this class seeks for the hibernate.cfg.xml file and maps the entities
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();		
		session.save(this);
		// save the data to the database
		session.getTransaction().commit();
		// close the connection
		session.disconnect();
	}

	// not implemented yet
	public void modifyUser() {
		throw new UnsupportedOperationException();
	}

	// not implemented yet
	public void findUser() {
		throw new UnsupportedOperationException();
	}
}
