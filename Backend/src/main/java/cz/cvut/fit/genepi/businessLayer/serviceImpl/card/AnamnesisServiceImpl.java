package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.AnamnesisVO;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc

/**
 * The Class AnamnesisServiceImpl.
 */
@Service
public class AnamnesisServiceImpl
        extends GenericCardServiceImpl<AnamnesisVO, AnamnesisEntity>
        implements AnamnesisService {

    @Override
    @Transactional
    public void hide(int anamnesisId) {
        AnamnesisEntity entity = genericDAO.findByID(AnamnesisEntity.class, anamnesisId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int anamnesisId) {
        AnamnesisEntity entity = genericDAO.findByID(AnamnesisEntity.class, anamnesisId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }

   /* @Override
    @Transactional
    public List<AnamnesisEntity> findAllHidden() {
        return anamnesisDAO.findAllHidden();
    }*/
}
