package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.ComplicationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.ComplicationVO;
import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import org.springframework.stereotype.Service;

@Service
public class ComplicationServiceImpl
        extends GenericCardServiceImpl<ComplicationDisplayVO, ComplicationVO, ComplicationEntity>
        implements ComplicationService {

}
