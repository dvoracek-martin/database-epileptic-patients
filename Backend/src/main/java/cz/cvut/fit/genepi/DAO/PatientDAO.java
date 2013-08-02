package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;

import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientDAO.
 */
public interface PatientDAO extends GenericDAO<PatientEntity, Serializable> {

	PatientEntity findPatientByID(Integer patientID);
	

}