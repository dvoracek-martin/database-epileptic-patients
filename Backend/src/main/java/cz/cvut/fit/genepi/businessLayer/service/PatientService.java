package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

/**
 * The Interface PatientService extends GenericService
 */
public interface PatientService extends GenericService<PatientEntity> {

	/**
	 * Finds patient and all his cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithAllLists(int patientId);

	/**
	 * Finds patient and his anamnesis cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithAnamnesisList(int patientId);

	/**
	 * Finds patient and his complication cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithComplicationList(int patientId);

	/**
	 * Finds patient and his diagnosticTestScalpEEG cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithDiagnosticTestScalpEEGList(

			/**
			 * Finds patient and his diagnosticTestScalpMRI cards according to his ID
			 * @param patientId as int
			 * @return PateintEntity
			 */	int patientId);

	public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId);

	/**
	 * Finds patient and his Histology cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithHistologyList(int patientId);

	/**
	 * Finds patient and his invasiveTestCorticalMapping cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 * @return PateintEntity
	 */
	 
	public PatientEntity getPatientByIdWithInvasiveTestCorticalMappingList(
			int patientId);

	/**
	 * Finds patient and his invasiveTestCorticalECOG cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId);

	/**
	 * Finds patient and his invasiveTestCorticalEEG cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId);

	/**
	 * Finds patient and his neurologicalFinding cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId);

	/**
	 * Finds patient and his neuropsychology cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId);

	/**
	 * Finds patient and his neuropsychologyOld cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithNeuropsychologyOldList(int patientId);

	/**
	 * Finds patient and his operation  cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithOperationList(int patientId);

	/**
	 * Finds patient and his outcome cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithOutcomeList(int patientId);

	/**
	 * Finds patient and his pharmacothrapy cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId);

	/**
	 * Finds patient and his seizure cards according to his ID
	 * @param patientId as int
	 * @return PateintEntity
	 */
	public PatientEntity getPatientByIdWithSeizureList(int patientId);
}
