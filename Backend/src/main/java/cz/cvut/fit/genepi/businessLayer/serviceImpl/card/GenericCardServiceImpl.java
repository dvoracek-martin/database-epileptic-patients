package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenericCardServiceImpl<CardVO, CardEntity> implements GenericCardService<CardVO, CardEntity> {

    @Autowired
    @Qualifier("genericDAOImpl")
    protected GenericDAO<CardEntity> genericDAO;

    @Autowired
    protected Mapper dozer;

    @Override
    @Transactional
    public CardVO getById(Class<CardVO> cardVoClass, Class<CardEntity> cardEntityClass, int recordId) {
        CardEntity entity = genericDAO.findByID(cardEntityClass, recordId);
        CardVO destObject = dozer.map(entity, cardVoClass);
        return destObject;
    }

    @Override
    @Transactional
    public void save(Class<CardEntity> cardEntityClass, CardVO cardVO) {
        genericDAO.save(dozer.map(cardVO, cardEntityClass));
    }

    @Override
    @Transactional
    public void delete(Class<CardEntity> cardEntityClass, int recordId) {
        genericDAO.delete(genericDAO.findByID(cardEntityClass, recordId));
    }

    /*
        @Override
        @Transactional
        public void hide(Class<T> myClass, int id) {
            T entity = genericDAO.findByID(myClass, id);
            entity.setStatus(1);
            genericDAO.save(entity);
        }

        @Transactional
        public void unhide(int pharmacotherapyId) {
            PharmacotherapyEntity entity = genericDAO.findByID(PharmacotherapyEntity.class, pharmacotherapyId);
            entity.setStatus(0);
            genericDAO.save(entity);
        }
    */
}
