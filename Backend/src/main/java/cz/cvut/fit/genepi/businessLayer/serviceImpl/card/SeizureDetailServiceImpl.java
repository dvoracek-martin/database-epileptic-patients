package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;

@Service
public class SeizureDetailServiceImpl extends
		GenericServiceImpl<SeizureDetailEntity> implements
		SeizureDetailService {

	@Override
	@Transactional
	public void hide(SeizureDetailEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(SeizureDetailEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
