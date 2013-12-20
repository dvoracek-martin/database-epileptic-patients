package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.DAO.card.AnamnesisDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisServiceImpl.
 */
@Service
public class AnamnesisServiceImpl extends GenericServiceImpl<AnamnesisEntity>
		implements AnamnesisService {

	@Autowired
	AnamnesisDAO anamnesisDAO;
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
	
	@Override
	@Transactional
	public List<AnamnesisEntity> findAllHidden(){
		return anamnesisDAO.findAllHidden();
	}
}
