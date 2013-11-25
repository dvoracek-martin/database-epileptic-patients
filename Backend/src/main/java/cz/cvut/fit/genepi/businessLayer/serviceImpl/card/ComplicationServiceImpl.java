package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;

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
