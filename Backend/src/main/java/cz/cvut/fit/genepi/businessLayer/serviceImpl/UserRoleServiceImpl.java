package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.UserRoleService;
import cz.cvut.fit.genepi.dataLayer.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Class UserRoleServiceImpl.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    /**
     * The user role dao.
     */
    @Autowired
    private UserRoleDAO userRoleDAO;

    @Override
    @Transactional
    public List<UserRoleEntity> findAllUserRolesByUserID(int userID) {
        return userRoleDAO.findAllUserRolesByUserID(userID);
    }
}
