package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.UserRoleEntity;

public interface UserRoleDAO extends GenericDAO<UserRoleEntity, Serializable> { 
	List<UserRoleEntity> findAllUserRolesByUserID(int userID);
}
