package cz.cvut.fit.genepi.businessLayer.service.card;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;


/**
 * The Interface AnamnesisService extends GenericCardService
 */
public interface AnamnesisService extends GenericCardService<AnamnesisEntity> {

	public List<AnamnesisEntity> findAllHidden();
}
