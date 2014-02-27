package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.DiagnosticTestMriVO;
import cz.cvut.fit.genepi.businessLayer.service.card.DiagnosticTestMriService;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiagnosticTestMriServiceImpl
        extends GenericCardServiceImpl<DiagnosticTestMriVO, DiagnosticTestMriEntity>
        implements DiagnosticTestMriService {

    @Override
    @Transactional
    public void hide(int diagnosticTestMriId) {
        DiagnosticTestMriEntity entity = genericDAO.findByID(DiagnosticTestMriEntity.class, diagnosticTestMriId);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int diagnosticTestMriId) {
        DiagnosticTestMriEntity entity = genericDAO.findByID(DiagnosticTestMriEntity.class, diagnosticTestMriId);
        entity.setHidden(false);
        genericDAO.save(entity);
    }
}
