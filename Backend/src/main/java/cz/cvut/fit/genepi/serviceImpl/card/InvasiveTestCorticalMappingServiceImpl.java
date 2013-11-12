package cz.cvut.fit.genepi.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.card.InvasiveTestCorticalMappingEntity;
import cz.cvut.fit.genepi.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class InvasiveTestCorticalMappingServiceImpl extends
		GenericServiceImpl<InvasiveTestCorticalMappingEntity>
		implements InvasiveTestCorticalMappingService {
	
	@Override
	@Transactional
	public void hide(InvasiveTestCorticalMappingEntity entity) {
		entity.setStatus(1);
		genericDAO.save(entity);
	}

	@Override
	@Transactional
	public void unhide(InvasiveTestCorticalMappingEntity entity) {
		entity.setStatus(0);
		genericDAO.save(entity);
	}

}
