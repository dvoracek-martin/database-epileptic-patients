package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.UserDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.RoleVO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;

import java.util.List;

/**
 * The Interface RoleService extends GenericService
 */
public interface RoleService extends GenericService<RoleVO, RoleEntity> {

    /**
     * Finds all users, that are doctors
     *
     * @return List of UserEntity
     */
    public List<UserDisplayVO> getAllDoctors();

    //TODO should return other VO then one for FORM but theres no form for roles so its maybe ok
    public List<RoleVO> getPossibleRoles(int userId);
}
