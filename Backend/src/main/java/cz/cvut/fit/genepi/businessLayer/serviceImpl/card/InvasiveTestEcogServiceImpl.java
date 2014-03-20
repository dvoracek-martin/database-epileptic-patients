package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.InvasiveTestEcogDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEcogVO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEcogService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import org.springframework.stereotype.Service;

@Service
public class InvasiveTestEcogServiceImpl
        extends GenericCardServiceImpl<InvasiveTestEcogDisplayVO, InvasiveTestEcogVO, InvasiveTestEcogEntity>
        implements InvasiveTestEcogService {

}
