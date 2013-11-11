package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleService.
 */
public interface RoleService extends GenericService<RoleEntity> {
	public List<UserEntity> getAllDoctors();
}
