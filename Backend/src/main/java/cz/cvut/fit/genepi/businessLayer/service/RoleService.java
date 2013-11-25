package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleService.
 */
public interface RoleService extends GenericService<RoleEntity> {
	//TODO:unused method
	public List<UserEntity> getAllDoctors();
}
