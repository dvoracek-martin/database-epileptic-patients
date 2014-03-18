package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeuropsychologyOldDisplayVO;

import java.util.List;

public interface NeuropsychologyOldService {

    public void delete(int neuropsychologyOldId);

    public void hide(int neuropsychologyOldId);

    public void unhide(int neuropsychologyOldId);

    public List<NeuropsychologyOldDisplayVO> getRecordsByPatientId(int patientId);
}
