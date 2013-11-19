package cz.cvut.fit.genepi.serviceImpl;

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
public class PatientServiceImpl extends GenericServiceImpl<PatientEntity>
		implements PatientService {

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
	@Transactional
	public PatientEntity getPatientByIdWithComplicationList(int patientId) {
		return patientDAO.getPatientByIdWithComplicationList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithDiagnosticTestScalpEEGList(int patientId) {
		return patientDAO.getPatientByIdWithDiagnosticTestScalpEEGList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId) {
		return patientDAO.getPatientByIdWithDiagnosticTestMRIList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithHistologyList(int patientId) {
		return patientDAO.getPatientByIdWithHistologyList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithInvasiveTestCorticalMappingList(
			int patientId) {
		return patientDAO
				.getPatientByIdWithInvasiveTestCorticalMappingList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId) {
		return patientDAO.getPatientByIdWithInvasiveTestECOGList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId) {
		return patientDAO.getPatientByIdWithInvasiveTestEEGList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId) {
		return patientDAO.getPatientByIdWithNeurologicalFindingList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId) {
		return patientDAO.getPatientByIdWithNeuropsychologyList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithOperationList(int patientId) {
		return patientDAO.getPatientByIdWithOperationList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithOutcomeList(int patientId) {
		return patientDAO.getPatientByIdWithOutcomeList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId) {
		return patientDAO.getPatientByIdWithPharmacotherapyList(patientId);

	}

	@Override
	@Transactional
	public PatientEntity getPatientByIdWithSeizureList(int patientId) {
		return patientDAO.getPatientByIdWithSeizureList(patientId);

	}

}
