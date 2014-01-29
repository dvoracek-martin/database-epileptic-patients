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

    //hotfix, is there a better way?
    CardEntity cardEntity;

    @Override
    @Transactional
    public CardVO getById(Class<CardVO> cardVoClass, int recordId) {

        CardEntity entity = genericDAO.findByID((Class<CardEntity>) cardEntity.getClass(), recordId);
        CardVO destObject = dozer.map(entity, cardVoClass);
        return destObject;
    }

    @Override
    @Transactional
    public void save(CardVO cardVO) {

        //System.out.println(this.getClass().getGenericInterfaces());
        // System.out.println(this.getClass().getGenericSuperclass());
        /*java.lang.reflect.TypeVariable<? extends Class<? extends GenericCardServiceImpl>>[] var = this.getClass().getTypeParameters();
        System.out.println("start");
        for (java.lang.reflect.TypeVariable item : var) {
            System.out.println(item);
        }
        System.out.println("end");*/
        //System.out.println(this.getClass().getTypeParameters());

        genericDAO.save(dozer.map(cardVO, (Class<CardEntity>) cardEntity.getClass()));
    }

    @Override
    @Transactional
    public void delete(int recordId) {
        //better delete by ID
        CardEntity entity = genericDAO.findByID((Class<CardEntity>) cardEntity.getClass(), recordId);
        genericDAO.delete(entity);
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
