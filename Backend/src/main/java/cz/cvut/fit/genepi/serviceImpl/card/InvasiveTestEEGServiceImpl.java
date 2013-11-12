package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.service.card.InvasiveTestEEGService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class InvasiveTestEEGServiceImpl  extends
GenericServiceImpl<InvasiveTestEEGEntity> implements
InvasiveTestEEGService {
	
	@Override
	@Transactional
	public void hide(InvasiveTestEEGEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(InvasiveTestEEGEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
