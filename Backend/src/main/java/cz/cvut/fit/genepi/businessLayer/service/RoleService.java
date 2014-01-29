package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.util.List;

/**
 * The Interface RoleService extends GenericService
 */
public interface RoleService extends GenericService<RoleEntity> {

    /**
     * Finds all users, that are doctors
     *
     * @return List of UserEntity
     */
    public List<UserEntity> getAllDoctors();
}
