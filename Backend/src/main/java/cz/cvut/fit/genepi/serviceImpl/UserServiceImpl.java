package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

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
public class UserServiceImpl implements UserService{
	
	/** The user dao. */
	@Autowired
	private UserDAO userDAO;

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.UserService#save(cz.cvut.fit.genepi.entity.UserEntity)
	 */
	@Override
	@Transactional
	public void save(UserEntity user) {
		userDAO.save(user);
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.UserService#findByID(int)
	 */
	@Override
	@Transactional
	public UserEntity findByID(int id) {
		return (userDAO.findByID(UserEntity.class, id));
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.UserService#findAll()
	 */
	@Override
	@Transactional
	public List<UserEntity> findAll() {
		return userDAO.findAll(UserEntity.class);
	}


	@Override
	@Transactional
	public UserEntity findUserByUsername(String username) {		
		return userDAO.findUserByUsername(username);
	}
}
