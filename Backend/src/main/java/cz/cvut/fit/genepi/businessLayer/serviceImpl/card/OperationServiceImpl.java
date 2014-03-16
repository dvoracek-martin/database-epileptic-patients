package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OperationVO;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationServiceImpl
        extends GenericCardServiceImpl<OperationDisplayVO,OperationVO, OperationEntity>
        implements OperationService {

}
