package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.UserRoleEntity;

public interface UserRoleService  {
	public List<UserRoleEntity> findAll();
	public UserRoleEntity findByID(int userRoleID);
	public List<UserRoleEntity> findAllUserRolesByUserID(int userID);
	public List<UserRoleEntity> findAllUserRolesByRoleID(int roleID);
}
