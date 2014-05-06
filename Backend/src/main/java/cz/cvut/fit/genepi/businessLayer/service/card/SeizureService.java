package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDetailDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.SeizureFormBO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

import java.util.List;

public interface SeizureService extends GenericCardService<SeizureDetailDisplayBO, SeizureFormBO, SeizureEntity> {

    public int save(SeizureFormBO seizure);

    public List<SeizureDisplayBO> getRecordsByPatientId(int patientId);

    public SeizureDisplayBO getLatestRecordByPatientId(int patientId);
}
