package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.service.card.PharmacotherapyService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

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
