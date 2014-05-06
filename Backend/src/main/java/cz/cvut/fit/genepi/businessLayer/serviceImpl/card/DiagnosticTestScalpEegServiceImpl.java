package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.DiagnosticTestScalpEegDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.DiagnosticTestScalpEegFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticTestScalpEegServiceImpl
        extends GenericCardServiceImpl<DiagnosticTestScalpEegDisplayBO, DiagnosticTestScalpEegFormBO, DiagnosticTestScalpEegEntity>
        implements DiagnosticTestScalpEegService {

}
