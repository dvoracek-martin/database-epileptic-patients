package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.PatientDAO;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.PatientService;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientServiceImpl.
 */
@Service
public class PatientServiceImpl extends
		GenericServiceImpl<PatientEntity, Serializable> implements
		PatientService {

	/** The patient dao. */
	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithAllLists(int patientId) {
		return patientDAO.getPatientByIdWithAllLists(patientId);
	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithAnamnesisList(int patientId) {
		return patientDAO.getPatientByIdWithAnamnesisList(patientId);
	}

	@Override
	public PatientEntity getPatientByIdWithComplicationList(int patientId) {
		return patientDAO.getPatientByIdWithComplicationList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithDiagnosticTestEEGList(int patientId) {
		return patientDAO.getPatientByIdWithDiagnosticTestEEGList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId) {
		return patientDAO.getPatientByIdWithDiagnosticTestMRIList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithHistologyList(int patientId) {
		return patientDAO.getPatientByIdWithHistologyList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId) {
		return patientDAO.getPatientByIdWithInvasiveTestECOGList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId) {
		return patientDAO.getPatientByIdWithInvasiveTestEEGList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId) {
		return patientDAO.getPatientByIdWithNeurologicalFindingList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId) {
		return patientDAO.getPatientByIdWithNeuropsychologyList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithOperationList(int patientId) {
		return patientDAO.getPatientByIdWithOperationList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithOutcomeList(int patientId) {
		return patientDAO.getPatientByIdWithOutcomeList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId) {
		return patientDAO.getPatientByIdWithPharmacotherapyList(patientId);

	}

	@Override
	public PatientEntity getPatientByIdWithSeizureList(int patientId) {
		return patientDAO.getPatientByIdWithSeizureList(patientId);

	}

}
