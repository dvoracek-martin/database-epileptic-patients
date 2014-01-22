package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.SeizureDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeizureServiceImpl /* extends GenericServiceImpl<SeizureEntity> */ implements SeizureService {

    @Autowired
    SeizureDAO seizureDAO;

    @Autowired
    @Qualifier("genericDAOImpl")
    GenericDAO<SeizureEntity> genericDAO;

    @Autowired
    Mapper dozer;


    @Override
    @Transactional
    public SeizureVO getById(int sId) {
        SeizureEntity se = seizureDAO.findByID(SeizureEntity.class, sId);
        SeizureVO destObject =
                dozer.map(se, SeizureVO.class);
        return destObject;
    }

    @Override
    @Transactional
    public void hide(int seizureId) {
        SeizureEntity entity = genericDAO.findByID(SeizureEntity.class, seizureId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(int seizureId) {
        SeizureEntity entity = genericDAO.findByID(SeizureEntity.class, seizureId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void save(SeizureVO seizureVO) {
        genericDAO.save(dozer.map(seizureVO, SeizureEntity.class));
    }
}
