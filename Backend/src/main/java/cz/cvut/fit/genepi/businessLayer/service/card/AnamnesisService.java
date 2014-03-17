package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.AnamnesisDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.AnamnesisVO;
import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;

import java.util.List;


public interface AnamnesisService extends GenericService<AnamnesisVO, AnamnesisEntity> {

    public AnamnesisDisplayVO getRecordsByPatientId(int patientId);
}
