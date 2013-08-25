package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.RoleDAO;
import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.service.RoleService;

/**
 * The Class RoleServiceImpl.
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	@Transactional
	public List<RoleEntity> findAll() {
		return roleDAO.findAll(RoleEntity.class);
	}
	
	@Override
	@Transactional
	public RoleEntity findByID(int roleID) {
		return roleDAO.findByID(RoleEntity.class, roleID);
	}
}
