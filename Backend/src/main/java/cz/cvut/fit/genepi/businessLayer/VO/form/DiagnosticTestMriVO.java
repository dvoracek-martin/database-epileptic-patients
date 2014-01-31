package cz.cvut.fit.genepi.businessLayer.VO.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class DiagnosticTestMriVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int done;

    private int mriFinding;

    @Size(max = 800)
    private String mriDescription;

    private int fdgPet;

    @Size(max = 800)
    private String descriptionPetHypometabolism;

    private int interictalSpect;

    @Size(max = 800)
    private String descriptionSpectHypoperfuse;

    private int ictalSpect;

    @Size(max = 800)
    private String descriptionSpectHyperperfuse;

    private boolean siscom;

    private int mrsProtocol;

    private int mrsFinding;

    @Size(max = 800)
    private String descriptionMrsAbnormality;

    private boolean fmri;

    @Size(max = 800)
    private String detailsFmri;

    private boolean dti;

    @Size(max = 800)
    private String detailsDtiStudy;

    private boolean wada;

    @Size(max = 800)
    private String detailsWada;

    @Size(max = 800)
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getMriFinding() {
        return mriFinding;
    }

    public void setMriFinding(int mriFinding) {
        this.mriFinding = mriFinding;
    }

    public String getMriDescription() {
        return mriDescription;
    }

    public void setMriDescription(String mriDescription) {
        this.mriDescription = mriDescription;
    }

    public int getFdgPet() {
        return fdgPet;
    }

    public void setFdgPet(int fdgPet) {
        this.fdgPet = fdgPet;
    }

    public String getDescriptionPetHypometabolism() {
        return descriptionPetHypometabolism;
    }

    public void setDescriptionPetHypometabolism(String descriptionPetHypometabolism) {
        this.descriptionPetHypometabolism = descriptionPetHypometabolism;
    }

    public int getInterictalSpect() {
        return interictalSpect;
    }

    public void setInterictalSpect(int interictalSpect) {
        this.interictalSpect = interictalSpect;
    }

    public String getDescriptionSpectHypoperfuse() {
        return descriptionSpectHypoperfuse;
    }

    public void setDescriptionSpectHypoperfuse(String descriptionSpectHypoperfuse) {
        this.descriptionSpectHypoperfuse = descriptionSpectHypoperfuse;
    }

    public int getIctalSpect() {
        return ictalSpect;
    }

    public void setIctalSpect(int ictalSpect) {
        this.ictalSpect = ictalSpect;
    }

    public String getDescriptionSpectHyperperfuse() {
        return descriptionSpectHyperperfuse;
    }

    public void setDescriptionSpectHyperperfuse(String descriptionSpectHyperperfuse) {
        this.descriptionSpectHyperperfuse = descriptionSpectHyperperfuse;
    }

    public boolean isSiscom() {
        return siscom;
    }

    public void setSiscom(boolean siscom) {
        this.siscom = siscom;
    }

    public int getMrsProtocol() {
        return mrsProtocol;
    }

    public void setMrsProtocol(int mrsProtocol) {
        this.mrsProtocol = mrsProtocol;
    }

    public int getMrsFinding() {
        return mrsFinding;
    }

    public void setMrsFinding(int mrsFinding) {
        this.mrsFinding = mrsFinding;
    }

    public String getDescriptionMrsAbnormality() {
        return descriptionMrsAbnormality;
    }

    public void setDescriptionMrsAbnormality(String descriptionMrsAbnormality) {
        this.descriptionMrsAbnormality = descriptionMrsAbnormality;
    }

    public boolean isFmri() {
        return fmri;
    }

    public void setFmri(boolean fmri) {
        this.fmri = fmri;
    }

    public String getDetailsFmri() {
        return detailsFmri;
    }

    public void setDetailsFmri(String detailsFmri) {
        this.detailsFmri = detailsFmri;
    }

    public boolean isDti() {
        return dti;
    }

    public void setDti(boolean dti) {
        this.dti = dti;
    }

    public String getDetailsDtiStudy() {
        return detailsDtiStudy;
    }

    public void setDetailsDtiStudy(String detailsDtiStudy) {
        this.detailsDtiStudy = detailsDtiStudy;
    }

    public boolean isWada() {
        return wada;
    }

    public void setWada(boolean wada) {
        this.wada = wada;
    }

    public String getDetailsWada() {
        return detailsWada;
    }

    public void setDetailsWada(String detailsWada) {
        this.detailsWada = detailsWada;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
