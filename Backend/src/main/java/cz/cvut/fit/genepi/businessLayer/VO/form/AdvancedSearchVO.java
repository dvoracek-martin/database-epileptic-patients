package cz.cvut.fit.genepi.businessLayer.VO.form;


import javax.persistence.Column;
import javax.validation.constraints.Size;

public class AdvancedSearchVO {

    @Size(max=100)
    private String patientFirstname;

    private String patientLastname;

    private String patientNin;

    private String patientCity;

    private String patientCountry;

    /* General parameters */
    private int patientGender;

    private String patientAge;

    private String patientAgeFilter;

    private String patientAgeEpilepsy;

    private String patientAgeEpilepsyFilter;

    private int patientDoctor;


    public String getPatientAgeEpilepsy() {
        return patientAgeEpilepsy;
    }

    public String getPatientAgeEpilepsyFilter() {
        return patientAgeEpilepsyFilter;
    }

    public void setPatientAgeEpilepsyFilter(String patientAgeEpilepsyFilter) {
        this.patientAgeEpilepsyFilter = patientAgeEpilepsyFilter;
    }

    public int getPatientDoctor() {
        return patientDoctor;
    }

    public void setPatientDoctor(int patientDoctor) {
        this.patientDoctor = patientDoctor;
    }

    public void setPatientAgeEpilepsy(String patientAgeEpilepsy) {
        this.patientAgeEpilepsy = patientAgeEpilepsy;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public void setPatientLastname(String patientLastname) {
        this.patientLastname = patientLastname;
    }

    public String getPatientNin() {
        return patientNin;
    }

    public void setPatientNin(String patientNin) {
        this.patientNin = patientNin;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientCountry() {
        return patientCountry;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    public int getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(int patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAgeFilter() {
        return patientAgeFilter;
    }

    public void setPatientAgeFilter(String patientAgeFilter) {
        this.patientAgeFilter = patientAgeFilter;
    }

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }
}
