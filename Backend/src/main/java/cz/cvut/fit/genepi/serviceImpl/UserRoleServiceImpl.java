package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.entity.UserRoleEntity;
import cz.cvut.fit.genepi.service.UserRoleService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRoleServiceImpl.
 */
@Service
public class UserRoleServiceImpl extends GenericServiceImpl<UserRoleEntity> implements UserRoleService {

	/** The user role dao. */
	@Autowired
	private UserRoleDAO userRoleDAO;
	
		
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.UserRoleService#findAllUserRolesByUserID(int)
	 */
	@Override
	@Transactional
	public List<UserRoleEntity> findAllUserRolesByUserID(int userID) {		
		return userRoleDAO.findAllUserRolesByUserID(userID);
	}
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.UserRoleService#findAllUserRolesByRoleID(int)
	 */
	@Override
	@Transactional
	public List<UserRoleEntity> findAllUserRolesByRoleID(int roleID) {		
		return userRoleDAO.findAllUserRolesByRoleID(roleID);
	}
}
