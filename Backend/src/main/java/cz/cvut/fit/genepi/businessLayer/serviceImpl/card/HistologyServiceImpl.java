package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.HistologyDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.HistologyVO;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import org.springframework.stereotype.Service;

@Service
public class HistologyServiceImpl
        extends GenericCardServiceImpl<HistologyDisplayVO, HistologyVO, HistologyEntity>
        implements HistologyService {

}
