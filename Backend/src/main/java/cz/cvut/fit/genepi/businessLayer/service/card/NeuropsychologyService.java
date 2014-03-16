package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeurologicalFindingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeuropsychologyDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeuropsychologyVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;

public interface NeuropsychologyService extends GenericCardService<NeuropsychologyDisplayVO,NeuropsychologyVO, NeuropsychologyEntity> {

}
