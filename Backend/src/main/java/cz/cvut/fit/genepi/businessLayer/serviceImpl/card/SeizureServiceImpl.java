package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDetailDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeizureServiceImpl
        extends GenericCardServiceImpl<SeizureDetailDisplayVO,SeizureVO, SeizureEntity>
        implements SeizureService {

}
