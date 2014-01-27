package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.DiagnosticTestMriVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;

public interface DiagnosticTestMriService extends GenericCardService<DiagnosticTestMriVO, DiagnosticTestMriEntity> {

    public void hide(int diagnosticTestMriId);

    public void unhide(int diagnosticTestMriId);
}
