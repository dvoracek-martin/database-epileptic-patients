package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureDetailVO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.SeizureDetailDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeizureDetailServiceImpl /*extends GenericServiceImpl<SeizureDetailEntity>*/ implements SeizureDetailService {

    @Autowired
    SeizureDetailDAO seizureDetailDAO;

    @Autowired
    @Qualifier("genericDAOImpl")
    GenericDAO<SeizureDetailEntity> genericDAO;

    @Autowired
    Mapper dozer;


    @Override
    @Transactional
    public SeizureDetailVO getById(int sdId) {
        SeizureDetailEntity sde = seizureDetailDAO.findByID(SeizureDetailEntity.class, sdId);
        SeizureDetailVO destObject =
                dozer.map(sde, SeizureDetailVO.class);
        return destObject;
    }

    @Override
    @Transactional
    public void hide(int seizureDetailId) {
        SeizureDetailEntity entity = genericDAO.findByID(SeizureDetailEntity.class, seizureDetailId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(int seizureDetailId) {
        SeizureDetailEntity entity = genericDAO.findByID(SeizureDetailEntity.class, seizureDetailId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void save(SeizureDetailVO seizureDetailVO) {
        genericDAO.save(dozer.map(seizureDetailVO, SeizureDetailEntity.class));
    }
}
