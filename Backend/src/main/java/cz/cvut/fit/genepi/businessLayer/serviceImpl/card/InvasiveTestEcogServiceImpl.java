package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestEcogDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.InvasiveTestEcogFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEcogService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import org.springframework.stereotype.Service;

@Service
public class InvasiveTestEcogServiceImpl
        extends GenericCardServiceImpl<InvasiveTestEcogDisplayBO, InvasiveTestEcogFormBO, InvasiveTestEcogEntity>
        implements InvasiveTestEcogService {

}
