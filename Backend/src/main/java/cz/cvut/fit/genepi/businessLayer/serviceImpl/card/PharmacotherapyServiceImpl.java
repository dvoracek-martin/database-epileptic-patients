package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.PharmacotherapyVO;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.PharmacotherapyDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PharmacotherapyServiceImpl/*  extends
GenericServiceImpl<PharmacotherapyEntity>*/ implements
        PharmacotherapyService {

    @Autowired
    PharmacotherapyDAO pharmacotherapyDAO;

    @Autowired
    @Qualifier("genericDAOImpl")
    GenericDAO<PharmacotherapyEntity> genericDAO;

    @Autowired
    Mapper dozer;

    @Override
    @Transactional
    public void hide(int pharmacotherapyId) {
        PharmacotherapyEntity entity = genericDAO.findByID(PharmacotherapyEntity.class, pharmacotherapyId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int pharmacotherapyId) {
        PharmacotherapyEntity entity = genericDAO.findByID(PharmacotherapyEntity.class, pharmacotherapyId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public PharmacotherapyVO getById(int pId) {
        PharmacotherapyEntity nfe = pharmacotherapyDAO.findByID(PharmacotherapyEntity.class, pId);
        PharmacotherapyVO destObject =
                dozer.map(pId, PharmacotherapyVO.class);
        return destObject;
    }

    @Override
    @Transactional
    public void save(PharmacotherapyVO pharmacotherapyVO) {
        genericDAO.save(dozer.map(pharmacotherapyVO, PharmacotherapyEntity.class));
    }
}
