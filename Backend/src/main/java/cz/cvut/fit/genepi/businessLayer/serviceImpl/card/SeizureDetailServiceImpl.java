package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDetailDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureDetailVO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeizureDetailServiceImpl
        extends GenericCardServiceImpl<SeizureDetailDisplayVO,SeizureDetailVO, SeizureDetailEntity>
        implements SeizureDetailService {

}
