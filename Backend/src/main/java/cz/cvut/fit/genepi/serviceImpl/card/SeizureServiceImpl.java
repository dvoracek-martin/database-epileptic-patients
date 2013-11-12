package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.service.card.SeizureService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class SeizureServiceImpl  extends
GenericServiceImpl<SeizureEntity> implements
SeizureService {
	
	@Override
	@Transactional
	public void hide(SeizureEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(SeizureEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
