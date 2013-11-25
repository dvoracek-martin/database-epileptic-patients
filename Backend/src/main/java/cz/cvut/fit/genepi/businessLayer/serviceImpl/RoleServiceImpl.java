package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Class RoleServiceImpl.
 */
@Service
public class RoleServiceImpl extends
		GenericServiceImpl<RoleEntity> implements RoleService {

	@Override
	@Transactional
	public List<UserEntity> getAllDoctors() {
		RoleEntity doctorRole = this.findByID(RoleEntity.class, 2);
		return doctorRole.getUsers();
	}

}
