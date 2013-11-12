package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.DiagnosticTestScalpEEGEntity;
import cz.cvut.fit.genepi.service.card.DiagnosticTestScalpEEGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class DiagnosticTestScalpEEGServiceImpl  extends
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
