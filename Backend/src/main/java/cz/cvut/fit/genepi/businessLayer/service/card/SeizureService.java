package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDetailDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

import java.util.List;

public interface SeizureService extends GenericCardService<SeizureDetailDisplayVO,SeizureVO, SeizureEntity> {

    public int save(SeizureVO seizure);

    public List<SeizureDisplayVO> getRecordsByPatientId(int patientId);

    public SeizureDisplayVO getLatestRecordByPatientId(int patientId);
}
