package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientService.
 */
public interface PatientService extends GenericService<PatientEntity> {

	public PatientEntity getPatientByIdWithAllLists(int patientId);

	public PatientEntity getPatientByIdWithAnamnesisList(int patientId);

	public PatientEntity getPatientByIdWithComplicationList(int patientId);

	public PatientEntity getPatientByIdWithDiagnosticTestScalpEEGList(int patientId);

	public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId);

	public PatientEntity getPatientByIdWithHistologyList(int patientId);

	public PatientEntity getPatientByIdWithInvasiveTestCorticalMappingList(
			int patientId);

	public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId);

	public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId);

	public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId);

	public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId);

	public PatientEntity getPatientByIdWithOperationList(int patientId);

	public PatientEntity getPatientByIdWithOutcomeList(int patientId);

	public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId);

	public PatientEntity getPatientByIdWithSeizureList(int patientId);
}
