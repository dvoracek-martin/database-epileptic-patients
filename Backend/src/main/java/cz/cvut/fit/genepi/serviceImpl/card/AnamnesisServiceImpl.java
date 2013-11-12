package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.card.AnamnesisService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisServiceImpl.
 */
@Service
public class AnamnesisServiceImpl extends GenericServiceImpl<AnamnesisEntity>
		implements AnamnesisService {

	@Override
	@Transactional
	public void hide(AnamnesisEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(AnamnesisEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}
}
