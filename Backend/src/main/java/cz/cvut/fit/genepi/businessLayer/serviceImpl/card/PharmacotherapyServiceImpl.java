package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.PharmacotherapyVO;
import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PharmacotherapyServiceImpl
        extends GenServiceImpl<PharmacotherapyVO, PharmacotherapyEntity>
        implements PharmacotherapyService {

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
}
