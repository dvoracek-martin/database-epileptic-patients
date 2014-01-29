package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Class RoleServiceImpl.
 */
@Service
public class RoleServiceImpl extends
        GenericServiceImpl<RoleEntity> implements RoleService {

    @Override
    @Transactional
    public List<UserEntity> getAllDoctors() {
        //TODO move to DAO
        RoleEntity doctorRole = this.findByID(RoleEntity.class, 3);
        return doctorRole.getUsers();
    }

}
