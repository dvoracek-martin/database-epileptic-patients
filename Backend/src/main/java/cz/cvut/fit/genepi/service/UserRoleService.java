package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.UserRoleEntity;

public interface UserRoleService  {
	public List<UserRoleEntity> findAll();
	public List<UserRoleEntity> findAllUserRolesByUserID(int userID);
}
