package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.NeurologicalFindingBO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.NeurologicalFindingDAO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;

@Service
public class NeurologicalFindingServiceImpl extends
        GenericServiceImpl<NeurologicalFindingEntity> implements
        NeurologicalFindingService {

    @Autowired
    NeurologicalFindingDAO neurologicalFindingDAO;

    @Autowired
    Mapper dozer;

    @Override
    @Transactional
    public void hide(NeurologicalFindingEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(NeurologicalFindingEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public NeurologicalFindingBO getById() {
        NeurologicalFindingEntity nfe = neurologicalFindingDAO.findByID(NeurologicalFindingEntity.class, 1);
       /* Mapper mapper = new DozerBeanMapper();*/
        NeurologicalFindingBO destObject =
                dozer.map(nfe, NeurologicalFindingBO.class);
        return destObject;
    }
}
