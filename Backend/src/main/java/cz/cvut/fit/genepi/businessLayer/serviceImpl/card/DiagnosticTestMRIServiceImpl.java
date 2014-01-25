package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMRIService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestMRIServiceImpl extends
        GenericServiceImpl<DiagnosticTestMriEntity> implements
        DiagnosticTestMRIService {

    @Override
    @Transactional
    public void hide(DiagnosticTestMriEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(DiagnosticTestMriEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}
