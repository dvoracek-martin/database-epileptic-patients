package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.NeurologicalFindingVO;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.NeurologicalFindingDAO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;

@Service
public class NeurologicalFindingServiceImpl /* extends
        GenericServiceImpl<NeurologicalFindingEntity>*/ implements
        NeurologicalFindingService {

    @Autowired
    NeurologicalFindingDAO neurologicalFindingDAO;

    @Autowired
    @Qualifier("genericDAOImpl")
    GenericDAO<NeurologicalFindingEntity> genericDAO;

    @Autowired
    Mapper dozer;


    @Transactional
    public void hide(NeurologicalFindingEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(NeurologicalFindingEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public NeurologicalFindingVO getById(int nfId) {
        NeurologicalFindingEntity nfe = neurologicalFindingDAO.findByID(NeurologicalFindingEntity.class, nfId);
        NeurologicalFindingVO destObject =
                dozer.map(nfe, NeurologicalFindingVO.class);
        return destObject;
    }

    @Override
    @Transactional
    public void save(NeurologicalFindingVO neurologicalFindingVO) {
        genericDAO.save(dozer.map(neurologicalFindingVO, NeurologicalFindingEntity.class));
    }
}
