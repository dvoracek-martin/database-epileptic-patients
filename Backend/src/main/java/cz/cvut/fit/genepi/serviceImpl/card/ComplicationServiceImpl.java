package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.service.card.ComplicationService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class ComplicationServiceImpl  extends
GenericServiceImpl<ComplicationEntity> implements
ComplicationService {
	
	@Override
	@Transactional
	public void hide(ComplicationEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(ComplicationEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
