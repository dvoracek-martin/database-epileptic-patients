package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.DiagnosticTestMriDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.DiagnosticTestMriFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMriService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticTestMriServiceImpl
        extends GenericCardServiceImpl<DiagnosticTestMriDisplayBO, DiagnosticTestMriFormBO, DiagnosticTestMriEntity>
        implements DiagnosticTestMriService {

}
