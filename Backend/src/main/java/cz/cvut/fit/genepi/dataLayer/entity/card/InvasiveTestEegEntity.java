package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invasive_test_eeg")
public class InvasiveTestEegEntity implements Comparable<InvasiveTestEegEntity> {

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
    private int done;

    @Column(name = "intracranial_electrodes")
    private int intracranialElectrodes;

    @Column(name = "localization_intracranial_electrodes")
    private String localizationIntracranialElectrodes;

    @Column(name = "invasive_eeg_slow")
    private int invasiveEegSlow;

    @Column(name = "invasive_eeg_interictal_spikes")
    private int invasiveEegInterictalSpikes;

    @Column(name = "localization_invasive_eeg_interictal_spikes")
    private String localizationInvasiveEegInterictalSpikes;

    @Column(name = "invasive_eeg_status_epilepticus")
    private boolean invasiveEegStatusEpilepticus;

    @Column(name = "invasive_ictal_eeg_patterns")
    private int invasiveIctalEegPatterns;

    @Column(name = "localization_invasive_ictal_eeg_patterns")
    private int localizationInvasiveIctalEegPatterns;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(InvasiveTestEegEntity o) {
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

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getIntracranialElectrodes() {
        return intracranialElectrodes;
    }

    public void setIntracranialElectrodes(int intracranialElectrodes) {
        this.intracranialElectrodes = intracranialElectrodes;
    }

    public String getLocalizationIntracranialElectrodes() {
        return localizationIntracranialElectrodes;
    }

    public void setLocalizationIntracranialElectrodes(
            String localizationIntracranialElectrodes) {
        this.localizationIntracranialElectrodes = localizationIntracranialElectrodes;
    }

    public int getInvasiveEegSlow() {
        return invasiveEegSlow;
    }

    public void setInvasiveEegSlow(int invasiveEegSlow) {
        this.invasiveEegSlow = invasiveEegSlow;
    }

    public int getInvasiveEegInterictalSpikes() {
        return invasiveEegInterictalSpikes;
    }

    public void setInvasiveEegInterictalSpikes(int invasiveEegInterictalSpikes) {
        this.invasiveEegInterictalSpikes = invasiveEegInterictalSpikes;
    }

    public String getLocalizationInvasiveEegInterictalSpikes() {
        return localizationInvasiveEegInterictalSpikes;
    }

    public void setLocalizationInvasiveEegInterictalSpikes(
            String localizationInvasiveEegInterictalSpikes) {
        this.localizationInvasiveEegInterictalSpikes = localizationInvasiveEegInterictalSpikes;
    }

    public boolean isInvasiveEegStatusEpilepticus() {
        return invasiveEegStatusEpilepticus;
    }

    public void setInvasiveEegStatusEpilepticus(
            boolean invasiveEegStatusEpilepticus) {
        this.invasiveEegStatusEpilepticus = invasiveEegStatusEpilepticus;
    }

    public int getInvasiveIctalEegPatterns() {
        return invasiveIctalEegPatterns;
    }

    public void setInvasiveIctalEegPatterns(int invasiveIctalEegPatterns) {
        this.invasiveIctalEegPatterns = invasiveIctalEegPatterns;
    }

    public int getLocalizationInvasiveIctalEegPatterns() {
        return localizationInvasiveIctalEegPatterns;
    }

    public void setLocalizationInvasiveIctalEegPatterns(
            int localizationInvasiveIctalEegPatterns) {
        this.localizationInvasiveIctalEegPatterns = localizationInvasiveIctalEegPatterns;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
