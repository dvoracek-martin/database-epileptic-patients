package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDetailDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.SeizureDetailFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import org.springframework.stereotype.Service;

@Service
public class SeizureDetailServiceImpl
        extends GenericCardServiceImpl<SeizureDetailDisplayBO, SeizureDetailFormBO, SeizureDetailEntity>
        implements SeizureDetailService {

}
