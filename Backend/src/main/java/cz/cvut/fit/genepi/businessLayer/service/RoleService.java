package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.display.UserDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.RoleFormBO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;

import java.util.List;

/**
 * The Interface RoleService extends GenericService
 */
public interface RoleService extends GenericService<RoleFormBO, RoleEntity> {

    /**
     * Finds all users, that are doctors
     *
     * @return List of UserEntity
     */
    public List<UserDisplayBO> getAllDoctors();

    //TODO should return other BO then one for FORM but theres no form for roles so its maybe ok
    public List<RoleFormBO> getPossibleRoles(int userId);
}
