package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.UserDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.RoleVO;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.dataLayer.DAO.UserDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class RoleServiceImpl.
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<RoleVO, RoleEntity> implements RoleService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<UserDisplayVO> getAllDoctors() {
        RoleEntity doctorRole = genericDAO.getById(3, RoleEntity.class);
        List<UserEntity> doctorEntityList = doctorRole.getUsers();
        List<UserDisplayVO> doctorVoList = new ArrayList<>();
        for (UserEntity doctorEntity : doctorEntityList) {
            UserDisplayVO doctorVo = dozer.map(doctorEntity, UserDisplayVO.class);
            doctorVoList.add(doctorVo);
        }
        return doctorVoList;
    }

    @Override
    @Transactional
    public List<RoleVO> getPossibleRoles(int userId) {
        UserEntity user = userDAO.getById(userId, UserEntity.class);


        List<RoleVO> possibleRoles = getAll(RoleVO.class, RoleEntity.class);
        Iterator<RoleVO> i = possibleRoles.iterator();
        while (i.hasNext()) {
            RoleVO role = i.next();
            for (RoleEntity roleEnt : user.getRoles()) {
                if (roleEnt.getId() == role.getId()) {
                    i.remove();
                }
            }
        }

        //Collections.sort(possibleRoles);
        return possibleRoles;
    }
}
