package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class NeuropsychologyServiceImpl  extends
GenericServiceImpl<NeuropsychologyEntity> implements
NeuropsychologyService {
	
	@Override
	@Transactional
	public void hide(NeuropsychologyEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(NeuropsychologyEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
