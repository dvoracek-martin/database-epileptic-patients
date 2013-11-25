package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;

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
