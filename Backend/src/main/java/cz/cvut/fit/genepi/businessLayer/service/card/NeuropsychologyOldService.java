package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyOldDisplayBO;

import java.util.List;

public interface NeuropsychologyOldService {

    public void delete(int neuropsychologyOldId);

    public void hide(int neuropsychologyOldId);

    public void unhide(int neuropsychologyOldId);

    public List<NeuropsychologyOldDisplayBO> getRecordsByPatientId(int patientId);
}
