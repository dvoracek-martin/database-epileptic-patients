package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;

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
