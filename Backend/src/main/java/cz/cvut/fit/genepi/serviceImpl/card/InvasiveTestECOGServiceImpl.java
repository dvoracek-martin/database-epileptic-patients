package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.service.card.InvasiveTestECOGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

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
