package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestEegDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.InvasiveTestEegFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import org.springframework.stereotype.Service;

@Service
public class InvasiveTestEegServiceImpl
        extends GenericCardServiceImpl<InvasiveTestEegDisplayBO, InvasiveTestEegFormBO, InvasiveTestEegEntity>
        implements InvasiveTestEegService {

}
