package cz.cvut.fit.genepi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "GIAGNOSTICTESTMRI")
public class DiagnosticTestMRIEntity {
	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The date. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "DATE", nullable = false)
	private Date date;

	/** The doctor id. */
	@Column(name = "DOCTOR_ID", length = 6, nullable = true)
	private int doctorId;

	/** The added. */
	@Column(name = "ADDED", nullable = false, insertable = false)
	private Date added;
	
	@Column(name="mri_protocol_idcom")
	private int mriProtocolIdcom;
	
	@Column(name="mri_finding_idcom")
	private int mriFindingIdcom;
	
	@Column(name="fdg_pet_idcom")
	private int fdgPetIdcom;
	
	@Column(name="interictal_spect_idcom")
	private int interictalSpectIdcom;
	
	@Column(name="ictali_spect_idcom")
	private int ictaliSpectIdcom;
	
	@Column(name="siscom")
	private Boolean siscom;
	
	@Column(name="time_aplication_rn")
	private int timeAplicationRn;
	
	@Column(name="timingi_aplication_rn_idcom")
	private int timingiAplicationRnIdcom;
	
	@Column(name="mrs_protocol_idcom")
	private int mrsProtocolIdcom;
		
	@Column(name="mrs_finfing_idcom")
	private int mrsFinfingIdcom;
		
	@Column(name="dti")
	private Boolean dti;
		
	@Column(name="details_dti_studie")
	private String detailsDtiStudie;
		
	@Column(name="fmri")
	private Boolean fmri;
		
	@Column(name="details_fmri")
	private String detailsFmri;
	
	
	@Column(name="wada")
	private Boolean wada;
	
	@Column(name="details_wada")
	private String detailsWada;
		
	@Column(name="mri_describe")
	private String mriDescribe;
		
	@Column(name="localization_spect_hypoperfuse")
	private String localizationSpectHypoperfuse;	
	
	@Column(name="localization_mrs_abnormality")
	private String localizationMrsAbnormality;
	
	@Column(name="localization_pet_hypometabolismu")
	private String localizationPetHypometabolismu;
	
	@Column(name="localization_spect_hyperperfuse")
	private String localizationSpectHyperperfuse;
	
	@Column(name="fmri_protocols")
	private String fmriProtocols;	
	
	/** The comment. */
	@Size(max = 400)
	@Column(name = "COMMENT", length = 400, nullable = true)
	private String comment;

	/** The deleted. */
	@Column(name = "DELETED", precision = 1, scale = 0, nullable = true)
	private Boolean deleted;

	/** The add user id. */
	@NotNull
	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = false)
	private int addUserId;

	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public int getMriProtocolIdcom() {
		return mriProtocolIdcom;
	}

	public void setMriProtocolIdcom(int mriProtocolIdcom) {
		this.mriProtocolIdcom = mriProtocolIdcom;
	}

	public int getMriFindingIdcom() {
		return mriFindingIdcom;
	}

	public void setMriFindingIdcom(int mriFindingIdcom) {
		this.mriFindingIdcom = mriFindingIdcom;
	}

	public int getFdgPetIdcom() {
		return fdgPetIdcom;
	}

	public void setFdgPetIdcom(int fdgPetIdcom) {
		this.fdgPetIdcom = fdgPetIdcom;
	}

	public int getInterictalSpectIdcom() {
		return interictalSpectIdcom;
	}

	public void setInterictalSpectIdcom(int interictalSpectIdcom) {
		this.interictalSpectIdcom = interictalSpectIdcom;
	}

	public int getIctaliSpectIdcom() {
		return ictaliSpectIdcom;
	}

	public void setIctaliSpectIdcom(int ictaliSpectIdcom) {
		this.ictaliSpectIdcom = ictaliSpectIdcom;
	}

	public Boolean getSiscom() {
		return siscom;
	}

	public void setSiscom(Boolean siscom) {
		this.siscom = siscom;
	}

	public int getTimeAplicationRn() {
		return timeAplicationRn;
	}

	public void setTimeAplicationRn(int timeAplicationRn) {
		this.timeAplicationRn = timeAplicationRn;
	}

	public int getTimingiAplicationRnIdcom() {
		return timingiAplicationRnIdcom;
	}

	public void setTimingiAplicationRnIdcom(int timingiAplicationRnIdcom) {
		this.timingiAplicationRnIdcom = timingiAplicationRnIdcom;
	}

	public int getMrsProtocolIdcom() {
		return mrsProtocolIdcom;
	}

	public void setMrsProtocolIdcom(int mrsProtocolIdcom) {
		this.mrsProtocolIdcom = mrsProtocolIdcom;
	}

	public int getMrsFinfingIdcom() {
		return mrsFinfingIdcom;
	}

	public void setMrsFinfingIdcom(int mrsFinfingIdcom) {
		this.mrsFinfingIdcom = mrsFinfingIdcom;
	}

	public Boolean getDti() {
		return dti;
	}

	public void setDti(Boolean dti) {
		this.dti = dti;
	}

	public String getDetailsDtiStudie() {
		return detailsDtiStudie;
	}

	public void setDetailsDtiStudie(String detailsDtiStudie) {
		this.detailsDtiStudie = detailsDtiStudie;
	}

	public Boolean getFmri() {
		return fmri;
	}

	public void setFmri(Boolean fmri) {
		this.fmri = fmri;
	}

	public String getDetailsFmri() {
		return detailsFmri;
	}

	public void setDetailsFmri(String detailsFmri) {
		this.detailsFmri = detailsFmri;
	}

	public Boolean getWada() {
		return wada;
	}

	public void setWada(Boolean wada) {
		this.wada = wada;
	}

	public String getDetailsWada() {
		return detailsWada;
	}

	public void setDetailsWada(String detailsWada) {
		this.detailsWada = detailsWada;
	}

	public String getMriDescribe() {
		return mriDescribe;
	}

	public void setMriDescribe(String mriDescribe) {
		this.mriDescribe = mriDescribe;
	}

	public String getLocalizationSpectHypoperfuse() {
		return localizationSpectHypoperfuse;
	}

	public void setLocalizationSpectHypoperfuse(String localizationSpectHypoperfuse) {
		this.localizationSpectHypoperfuse = localizationSpectHypoperfuse;
	}

	public String getLocalizationMrsAbnormality() {
		return localizationMrsAbnormality;
	}

	public void setLocalizationMrsAbnormality(String localizationMrsAbnormality) {
		this.localizationMrsAbnormality = localizationMrsAbnormality;
	}

	public String getLocalizationPetHypometabolismu() {
		return localizationPetHypometabolismu;
	}

	public void setLocalizationPetHypometabolismu(
			String localizationPetHypometabolismu) {
		this.localizationPetHypometabolismu = localizationPetHypometabolismu;
	}

	public String getLocalizationSpectHyperperfuse() {
		return localizationSpectHyperperfuse;
	}

	public void setLocalizationSpectHyperperfuse(
			String localizationSpectHyperperfuse) {
		this.localizationSpectHyperperfuse = localizationSpectHyperperfuse;
	}

	public String getFmriProtocols() {
		return fmriProtocols;
	}

	public void setFmriProtocols(String fmriProtocols) {
		this.fmriProtocols = fmriProtocols;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	/*public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}*/
	
}
