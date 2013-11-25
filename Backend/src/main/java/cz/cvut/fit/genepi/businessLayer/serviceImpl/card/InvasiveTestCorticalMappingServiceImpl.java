package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;

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
