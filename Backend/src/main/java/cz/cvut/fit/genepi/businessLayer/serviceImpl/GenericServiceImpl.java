package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenericServiceImpl<VO, Entity> implements GenericService<VO, Entity> {

    /**
     * The generic dao.
     */
    @Autowired
    @Qualifier("genericDAOImpl")
    protected GenericDAO<Entity> genericDAO;

    @Autowired
    protected Mapper dozer;


    @Override
    @Transactional
    public int save(VO vo, Class<Entity> entityClass) {
        Entity entity = dozer.map(vo, entityClass);
        return genericDAO.save(entity);
    }

    @Override
    @Transactional
    public VO getById(int id, Class<VO> voClass, Class<Entity> entityClass) {
        Entity entity = genericDAO.getById(id, entityClass);
        return dozer.map(entity, voClass);
    }

    @Override
    @Transactional
    public void update(VO vo, Class<Entity> entityClass) {
        Entity entity = dozer.map(vo, entityClass);
        genericDAO.update(entity);
    }

    @Override
    @Transactional
    public void delete(int id, Class<Entity> entityClass) {
        Entity entity = genericDAO.getById(id, entityClass);
        genericDAO.delete(entity);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<VO> getAll(Class<VO> voClass, Class<Entity> entityClass) {
        List<Entity> entityList = genericDAO.findAll(entityClass);
        List<VO> voList = new ArrayList<>();
        for (Entity entity : entityList) {
            VO vo = dozer.map(entity, voClass);
            voList.add(vo);
        }
        return voList;
    }

}
