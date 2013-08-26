package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.RoleEntity;
import cz.cvut.fit.genepi.service.RoleService;

/**
 * The Class RoleServiceImpl.
 */
@Service
public class RoleServiceImpl extends
		GenericServiceImpl<RoleEntity, Serializable> implements RoleService {

}
