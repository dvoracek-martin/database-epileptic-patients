package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.UserDAO;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void save(UserEntity user) {
		userDAO.save(user);
	}

	@Override
	@Transactional
	public UserEntity findByID(int id) {
		return (userDAO.findByID(UserEntity.class, id));
	}

	@Override
	@Transactional
	public List<UserEntity> findAll() {
		return userDAO.findAll(UserEntity.class);
	}

	@Override
	@Transactional
	public UserEntity findUserByID(Integer userID) {
		return userDAO.findUserByID(userID);
	}
}
