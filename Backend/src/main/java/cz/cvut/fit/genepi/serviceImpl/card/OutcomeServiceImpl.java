package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.service.card.OutcomeService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class OutcomeServiceImpl  extends
GenericServiceImpl<OutcomeEntity> implements
OutcomeService {
	
	@Override
	@Transactional
	public void hide(OutcomeEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(OutcomeEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
