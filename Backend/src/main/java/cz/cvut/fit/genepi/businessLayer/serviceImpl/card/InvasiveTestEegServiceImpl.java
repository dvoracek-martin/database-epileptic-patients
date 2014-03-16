package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.InvasiveTestEegDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEegVO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvasiveTestEegServiceImpl
        extends GenericCardServiceImpl<InvasiveTestEegDisplayVO,InvasiveTestEegVO, InvasiveTestEegEntity>
        implements InvasiveTestEegService {

}
