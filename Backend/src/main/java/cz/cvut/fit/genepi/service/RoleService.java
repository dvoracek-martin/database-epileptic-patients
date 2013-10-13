package cz.cvut.fit.genepi.service;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleService.
 */
public interface RoleService extends GenericService<RoleEntity, Serializable> {
	public List<UserEntity> getAllDoctors();
}
