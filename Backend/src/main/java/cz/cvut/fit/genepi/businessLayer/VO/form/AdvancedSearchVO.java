package cz.cvut.fit.genepi.businessLayer.VO.form;


import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class AdvancedSearchVO {

    @Size(max=100)
    private String patientFirstname;

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }
}
