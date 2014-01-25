package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyOldService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NeuropsychologyOldServiceImpl implements NeuropsychologyOldService {

    @Autowired
    @Qualifier("genericDAOImpl")
    protected GenericDAO<NeuropsychologyOldEntity> genericDAO;

    @Override
    @Transactional
    public void hide(int neuropsychologyOldId) {
        NeuropsychologyOldEntity entity = genericDAO.findByID(NeuropsychologyOldEntity.class, neuropsychologyOldId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int neuropsychologyOldId) {
        NeuropsychologyOldEntity entity = genericDAO.findByID(NeuropsychologyOldEntity.class, neuropsychologyOldId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}
