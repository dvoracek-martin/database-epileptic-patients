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
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int diagnosticTestScalpEegId) {
        DiagnosticTestScalpEegEntity entity = genericDAO.findByID(DiagnosticTestScalpEegEntity.class, diagnosticTestScalpEegId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}
