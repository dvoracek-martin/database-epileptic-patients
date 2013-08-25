package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.entity.UserRoleEntity;
import cz.cvut.fit.genepi.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@Override
	@Transactional
	public List<UserRoleEntity> findAll() {
		return userRoleDAO.findAll(UserRoleEntity.class);
	}

		
	@Override
	@Transactional
	public List<UserRoleEntity> findAllUserRolesByUserID(int userID) {		
		return userRoleDAO.findAllUserRolesByUserID(userID);
	}
}
