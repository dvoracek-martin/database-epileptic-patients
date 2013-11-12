package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class NeurologicalFindingServiceImpl  extends
GenericServiceImpl<NeurologicalFindingEntity> implements
NeurologicalFindingService {
	
	@Override
	@Transactional
	public void hide(NeurologicalFindingEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(NeurologicalFindingEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
