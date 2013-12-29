package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.BO.NeurologicalFindingBO;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;

/**
 * The Interface NeurologicalFindingService extends GenericCardService
 */
public interface NeurologicalFindingService extends GenericCardService<NeurologicalFindingEntity>  {

   public NeurologicalFindingBO getById();

}
