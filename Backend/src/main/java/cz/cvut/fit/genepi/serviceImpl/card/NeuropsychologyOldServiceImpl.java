package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.NeuropsychologyOldEntity;
import cz.cvut.fit.genepi.service.card.NeuropsychologyOldService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class NeuropsychologyOldServiceImpl  extends
GenericServiceImpl<NeuropsychologyOldEntity> implements
NeuropsychologyOldService {
	
	@Override
	@Transactional
	public void hide(NeuropsychologyOldEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(NeuropsychologyOldEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
