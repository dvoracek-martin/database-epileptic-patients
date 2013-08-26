package cz.cvut.fit.genepi.service;

import java.io.Serializable;

import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService extends GenericService<UserEntity, Serializable> {
	
	public UserEntity findUserByUsername(String username);
}
