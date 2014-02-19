package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestScalpEegServiceImpl
        extends GenericCardServiceImpl<DiagnosticTestScalpEegVO, DiagnosticTestScalpEegEntity>
        implements DiagnosticTestScalpEegService {

    @Override
    @Transactional
    public void hide(int diagnosticTestScalpEegId) {
        DiagnosticTestScalpEegEntity entity = genericDAO.findByID(DiagnosticTestScalpEegEntity.class, diagnosticTestScalpEegId);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int diagnosticTestScalpEegId) {
        DiagnosticTestScalpEegEntity entity = genericDAO.findByID(DiagnosticTestScalpEegEntity.class, diagnosticTestScalpEegId);
        entity.setHidden(false);
        genericDAO.save(entity);
    }
}
