package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.OutcomeDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OutcomeVO;
import cz.cvut.fit.genepi.businessLayer.service.card.OutcomeService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import org.springframework.stereotype.Service;

@Service
public class OutcomeServiceImpl
        extends GenericCardServiceImpl<OutcomeDisplayVO,OutcomeVO, OutcomeEntity>
        implements OutcomeService {
}
