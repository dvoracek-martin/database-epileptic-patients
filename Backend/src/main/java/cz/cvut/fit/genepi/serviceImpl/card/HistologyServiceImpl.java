package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.service.card.HistologyService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class HistologyServiceImpl  extends
GenericServiceImpl<HistologyEntity> implements
HistologyService {
	
	@Override
	@Transactional
	public void hide(HistologyEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(HistologyEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
