package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diagnostic_test_scalp_eeg")
public class DiagnosticTestScalpEegEntity implements
        Comparable<DiagnosticTestScalpEegEntity> {

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

    @Column(name = "status", nullable = false)
    private int status;

	/* Other fields */

    /**
     * The date.
     */
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "done")
    private boolean done;

    @Column(name = "basic_eeg_activity")
    private int basicEegActivity;

    @Column(name = "eeg_slow")
    private int eegSlow;

    @Column(name = "interictal_eeg_spikes")
    private int interictalEegSpikes;

    @Column(name = "localization_interictal_eeg_spikes", length = 800)
    private String localizationInterictalEEGSpikes;

    @Column(name = "eeg_status_epilepticus")
    private boolean eegStatusEpilepticus;

    @Column(name = "secondary_sided_synchrony")
    private boolean secondarySidedSynchrony;

    @Column(name = "ictal_eeg_patterns")
    private int ictalEegPatterns;

    @Column(name = "localization_ictal_eeg_pattern", length = 800)
    private String localizationIctalEegPattern;

    @Column(name = "description_video_eeg", length = 800)
    private String descriptionVideoEeg;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(DiagnosticTestScalpEegEntity o) {
        int comparison = this.date.compareTo(o.getDate());
        if (comparison > 0) {
            return -1;
        } else if (comparison == 0) {
            return 0;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getBasicEegActivity() {
        return basicEegActivity;
    }

    public void setBasicEegActivity(int basicEegActivity) {
        this.basicEegActivity = basicEegActivity;
    }

    public int getEegSlow() {
        return eegSlow;
    }

    public void setEegSlow(int eegSlow) {
        this.eegSlow = eegSlow;
    }

    public int getInterictalEegSpikes() {
        return interictalEegSpikes;
    }

    public void setInterictalEegSpikes(int interictalEegSpikes) {
        this.interictalEegSpikes = interictalEegSpikes;
    }

    public String getLocalizationInterictalEEGSpikes() {
        return localizationInterictalEEGSpikes;
    }

    public void setLocalizationInterictalEEGSpikes(
            String localizationInterictalEEGSpikes) {
        this.localizationInterictalEEGSpikes = localizationInterictalEEGSpikes;
    }

    public boolean isEegStatusEpilepticus() {
        return eegStatusEpilepticus;
    }

    public void setEegStatusEpilepticus(boolean eegStatusEpilepticus) {
        this.eegStatusEpilepticus = eegStatusEpilepticus;
    }

    public boolean isSecondarySidedSynchrony() {
        return secondarySidedSynchrony;
    }

    public void setSecondarySidedSynchrony(boolean secondarySidedSynchrony) {
        this.secondarySidedSynchrony = secondarySidedSynchrony;
    }

    public int getIctalEegPatterns() {
        return ictalEegPatterns;
    }

    public void setIctalEegPatterns(int ictalEegPatterns) {
        this.ictalEegPatterns = ictalEegPatterns;
    }

    public String getLocalizationIctalEegPattern() {
        return localizationIctalEegPattern;
    }

    public void setLocalizationIctalEegPattern(
            String localizationIctalEegPattern) {
        this.localizationIctalEegPattern = localizationIctalEegPattern;
    }

    public String getDescriptionVideoEeg() {
        return descriptionVideoEeg;
    }

    public void setDescriptionVideoEeg(String descriptionVideoEeg) {
        this.descriptionVideoEeg = descriptionVideoEeg;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
