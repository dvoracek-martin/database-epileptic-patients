package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;

public class NeuropsychologyServiceImpl extends GenericServiceImpl<NeuropsychologyEntity>
implements NeuropsychologyService{

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
