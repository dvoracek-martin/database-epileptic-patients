package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestScalpEEGService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEEGEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestScalpEEGServiceImpl extends
        GenericServiceImpl<DiagnosticTestScalpEEGEntity> implements
        DiagnosticTestScalpEEGService {

    @Override
    @Transactional
    public void hide(DiagnosticTestScalpEEGEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(DiagnosticTestScalpEEGEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}
