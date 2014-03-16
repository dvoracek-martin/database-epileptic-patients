package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeuropsychologyDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeuropsychologyOldDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeuropsychologyVO;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NeuropsychologyServiceImpl
        extends GenericCardServiceImpl<NeuropsychologyDisplayVO,NeuropsychologyVO, NeuropsychologyEntity>
        implements NeuropsychologyService {

}
