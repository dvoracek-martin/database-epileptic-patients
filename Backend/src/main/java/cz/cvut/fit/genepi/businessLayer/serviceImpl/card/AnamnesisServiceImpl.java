package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.AnamnesisDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.AnamnesisVO;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.DAO.card.AnamnesisDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class AnamnesisServiceImpl.
 */
@Service
public class AnamnesisServiceImpl
        extends GenericCardServiceImpl<AnamnesisDisplayVO,AnamnesisVO, AnamnesisEntity>
        implements AnamnesisService {

}
