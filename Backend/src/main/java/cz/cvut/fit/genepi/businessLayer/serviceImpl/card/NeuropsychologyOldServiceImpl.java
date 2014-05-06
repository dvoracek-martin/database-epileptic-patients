package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyOldDisplayBO;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyOldService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.GenericCardDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NeuropsychologyOldServiceImpl implements NeuropsychologyOldService {

    @Autowired
    @Qualifier("genericDAOImpl")
    protected GenericDAO<NeuropsychologyOldEntity> genericDAO;

    @Autowired
    @Qualifier("genericCardDAOImpl")
    protected GenericCardDAO<NeuropsychologyOldEntity> genericCardDAO;

    @Autowired
    protected Mapper dozer;

    @Override
    @Transactional
    public void delete(int neuropsychologyOldId) {
        NeuropsychologyOldEntity entity = genericDAO.getById(neuropsychologyOldId, NeuropsychologyOldEntity.class);
        genericDAO.delete(entity);
    }

    @Override
    @Transactional
    public void hide(int neuropsychologyOldId) {
        NeuropsychologyOldEntity entity = genericDAO.getById(neuropsychologyOldId, NeuropsychologyOldEntity.class);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(int neuropsychologyOldId) {
        NeuropsychologyOldEntity entity = genericDAO.getById(neuropsychologyOldId, NeuropsychologyOldEntity.class);
        entity.setHidden(false);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public List<NeuropsychologyOldDisplayBO> getRecordsByPatientId(int patientId) {
        List<NeuropsychologyOldEntity> cardEntityList = genericCardDAO.getRecordsByPatientId(patientId, NeuropsychologyOldEntity.class);
        List<NeuropsychologyOldDisplayBO> cardDisplayVoList = new ArrayList<>();
        for (NeuropsychologyOldEntity entity : cardEntityList) {
            NeuropsychologyOldDisplayBO vo = dozer.map(entity, NeuropsychologyOldDisplayBO.class);
            cardDisplayVoList.add(vo);
        }
        return cardDisplayVoList;
    }
}
