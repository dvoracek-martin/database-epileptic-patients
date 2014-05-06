package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.InvasiveTestCorticalMappingDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.InvasiveTestCorticalMappingFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;
import org.springframework.stereotype.Service;

@Service
public class InvasiveTestCorticalMappingServiceImpl
        extends GenericCardServiceImpl<InvasiveTestCorticalMappingDisplayBO, InvasiveTestCorticalMappingFormBO, InvasiveTestCorticalMappingEntity>
        implements InvasiveTestCorticalMappingService {

}
