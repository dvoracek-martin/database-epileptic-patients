package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "diagnostic_test_mri")
public class DiagnosticTestMriEntity implements
        Comparable<DiagnosticTestMriEntity> {

	/* Autofilled fields */

    /**
     * The id.
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private int id;

    /**
     * The add user id.
     */
    @NotNull
    @Column(name = "add_user_id", nullable = false)
    private int addUserId;

    /**
     * The added.
     */
    @Column(name = "added", nullable = false, insertable = false)
    private Date added;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private PatientEntity patient;

    @Column(name = "patient_id", nullable = false)
    private int patientId;

    @Column(name = "history", nullable = false)
    private boolean history;

    @Column(name = "hidden", nullable = false)
    private boolean hidden;

	/* Other fields */

    /**
     * The date.
     */
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "done")
    private int done;

    @Column(name = "mri_finding")
    private int mriFinding;

    @Column(name = "mri_description", length = 800)
    private String mriDescription;

    @Column(name = "fdg_pet")
    private int fdgPet;

    @Column(name = "description_pet_hypometabolism", length = 800)
    private String descriptionPetHypometabolism;

    @Column(name = "interictal_spect")
    private int interictalSpect;

    @Column(name = "description_spect_hypoperfuse", length = 800)
    private String descriptionSpectHypoperfuse;

    @Column(name = "ictal_spect")
    private int ictalSpect;

    @Column(name = "description_spect_hyperperfuse", length = 800)
    private String descriptionSpectHyperperfuse;

    @Column(name = "siscom")
    private boolean siscom;

    @Column(name = "mrs_protocol")
    private int mrsProtocol;

    @Column(name = "mrs_finding")
    private int mrsFinding;

    @Column(name = "description_mrs_abnormality", length = 800)
    private String descriptionMrsAbnormality;

    @Column(name = "fmri")
    private boolean fmri;

    @Column(name = "details_fmri", length = 800)
    private String detailsFmri;

    @Column(name = "dti")
    private boolean dti;

    @Size(max = 800)
    @Column(name = "details_dti_study", length = 800)
    private String detailsDtiStudy;

    @Column(name = "wada")
    private boolean wada;

    @Column(name = "details_wada", length = 800)
    private String detailsWada;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(DiagnosticTestMriEntity o) {
        int dateComparison = this.date.compareTo(o.getDate());
        int idComparison = this.id - o.getId();
        if (dateComparison > 0) {
            return -1;
        } else if (dateComparison == 0) {
            if (idComparison < 0) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 1;
        }
    }

	/* Getters and Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(int addUserId) {
        this.addUserId = addUserId;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean status) {
        this.hidden = status;
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

    public void setDescriptionPetHypometabolism(
            String descriptionPetHypometabolism) {
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

    public void setDescriptionSpectHypoperfuse(
            String descriptionSpectHypoperfuse) {
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

    public void setDescriptionSpectHyperperfuse(
            String descriptionSpectHyperperfuse) {
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
