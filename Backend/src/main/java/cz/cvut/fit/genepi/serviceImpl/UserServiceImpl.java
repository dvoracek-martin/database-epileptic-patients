package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.UserDAO;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.UserService;
// TODO: Auto-generated Javadoc

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl  extends GenericServiceImpl<UserEntity, Serializable> implements UserService{
	
	/** The user dao. */
	@Autowired
	private UserDAO userDAO;

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.UserService#findUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional
	public UserEntity findUserByUsername(String username) {		
		return userDAO.findUserByUsername(username);
	}
}
