package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.DAO.card.GenericCardDAO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenericCardServiceImpl<CardDisplayVo, CardFormVo, CardEntity>
        extends GenericServiceImpl<CardFormVo, CardEntity>
        implements GenericCardService<CardDisplayVo, CardFormVo, CardEntity> {

    @Autowired
    @Qualifier("genericCardDAOImpl")
    protected GenericCardDAO<CardEntity> genericCardDAO;

    @Autowired
    protected Mapper dozer;


    @Override
    @Transactional
    public void hide(int id, Class<CardEntity> entityClass) {
        genericCardDAO.hide(id, entityClass);
    }

    @Override
    @Transactional
    public void unhide(int id, Class<CardEntity> entityClass) {
        genericCardDAO.unhide(id, entityClass);
    }

    @Override
    @Transactional
    public void makeHistory(int id, Class<CardEntity> entityClass) {
        genericCardDAO.makeHistory(id, entityClass);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<CardDisplayVo> getRecordsByPatientId(int patientId, Class<CardDisplayVo> voClass, Class<CardEntity> entityClass) {
        List<CardEntity> cardEntityList = genericCardDAO.getRecordsByPatientId(patientId, entityClass);
        List<CardDisplayVo> cardDisplayVoList = new ArrayList<>();
        for (CardEntity entity : cardEntityList) {
            CardDisplayVo vo = dozer.map(entity, voClass);
            cardDisplayVoList.add(vo);
        }
        return cardDisplayVoList;
    }
}
