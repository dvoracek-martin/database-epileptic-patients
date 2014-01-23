package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMRIService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMRIEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestMRIServiceImpl extends
        GenericServiceImpl<DiagnosticTestMRIEntity> implements
        DiagnosticTestMRIService {

    @Override
    @Transactional
    public void hide(DiagnosticTestMRIEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(DiagnosticTestMRIEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}
