package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.AnamnesisDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.AnamnesisFormBO;
import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;


public interface AnamnesisService extends GenericService<AnamnesisFormBO, AnamnesisEntity> {

    public AnamnesisDisplayBO getRecordsByPatientId(int patientId);
}
