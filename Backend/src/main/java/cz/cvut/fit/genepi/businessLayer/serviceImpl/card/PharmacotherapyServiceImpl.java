package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;

@Service
public class PharmacotherapyServiceImpl  extends
GenericServiceImpl<PharmacotherapyEntity> implements
PharmacotherapyService {
	
	@Override
	@Transactional
	public void hide(PharmacotherapyEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(PharmacotherapyEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
