package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.DiagnosticTestMriDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestMriVO;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMriService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestMriServiceImpl
        extends GenericCardServiceImpl<DiagnosticTestMriDisplayVO,DiagnosticTestMriVO, DiagnosticTestMriEntity>
        implements DiagnosticTestMriService {

}
