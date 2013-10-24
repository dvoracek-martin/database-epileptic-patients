package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.RoleService;

/**
 * The Class RoleServiceImpl.
 */
@Service
public class RoleServiceImpl extends
		GenericServiceImpl<RoleEntity, Serializable> implements RoleService {

	@Override
	@Transactional
	public List<UserEntity> getAllDoctors() {
		RoleEntity doctorRole = this.findByID(RoleEntity.class, 2);
		return doctorRole.getUsers();
	}

}
