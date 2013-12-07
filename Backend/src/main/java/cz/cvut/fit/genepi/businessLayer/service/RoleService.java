package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Interface RoleService extends GenericService
 */
public interface RoleService extends GenericService<RoleEntity> {

	/**
	 * Finds all users, that are doctors
	 * @return List of UserEntity
	 */
	public List<UserEntity> getAllDoctors();
}
