package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.service.card.DiagnosticTestMRIService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class DiagnosticTestMRIServiceImpl  extends
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
