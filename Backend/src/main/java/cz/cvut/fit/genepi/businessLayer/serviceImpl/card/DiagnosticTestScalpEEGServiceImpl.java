package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEEGService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestScalpEEGServiceImpl extends
        GenericServiceImpl<DiagnosticTestScalpEegEntity> implements
        DiagnosticTestScalpEEGService {

    @Override
    @Transactional
    public void hide(DiagnosticTestScalpEegEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(DiagnosticTestScalpEegEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}
