package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;

@Service
public class OperationServiceImpl  extends
GenericServiceImpl<OperationEntity> implements
OperationService {
	
	@Override
	@Transactional
	public void hide(OperationEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(OperationEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
