package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.DiagnosticTestScalpEegVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;

public interface DiagnosticTestScalpEegService extends GenericCardService<DiagnosticTestScalpEegVO, DiagnosticTestScalpEegEntity> {

    public void hide(int diagnosticTestScalpEegId);

    public void unhide(int diagnosticTestScalpEegId);
}
