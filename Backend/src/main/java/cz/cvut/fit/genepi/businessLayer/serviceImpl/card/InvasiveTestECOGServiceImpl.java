package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestECOGService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestECOGEntity;

@Service
public class InvasiveTestECOGServiceImpl  extends
GenericServiceImpl<InvasiveTestECOGEntity> implements
InvasiveTestECOGService {
	
	@Override
	@Transactional
	public void hide(InvasiveTestECOGEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(InvasiveTestECOGEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
