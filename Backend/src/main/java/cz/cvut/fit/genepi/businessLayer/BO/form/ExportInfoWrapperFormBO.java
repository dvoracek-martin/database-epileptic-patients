package cz.cvut.fit.genepi.businessLayer.BO.form;

import java.util.ArrayList;
import java.util.List;

public class ExportInfoWrapperFormBO {

    private List<Integer> patientIds;

    private String source;

    public ExportInfoWrapperFormBO() {
        this.patientIds = new ArrayList<>();
    }

    public void addPatientId(int patientId) {
        this.patientIds.add(patientId);
    }

    public List<Integer> getPatientIds() {
        return patientIds;
    }

    public void setPatientIds(List<Integer> patientIds) {
        this.patientIds = patientIds;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
