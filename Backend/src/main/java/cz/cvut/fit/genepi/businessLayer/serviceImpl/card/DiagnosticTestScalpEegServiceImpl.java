package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.DiagnosticTestScalpEegDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticTestScalpEegServiceImpl
        extends GenericCardServiceImpl<DiagnosticTestScalpEegDisplayVO, DiagnosticTestScalpEegVO, DiagnosticTestScalpEegEntity>
        implements DiagnosticTestScalpEegService {

}
