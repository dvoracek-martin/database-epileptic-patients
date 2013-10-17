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
	public PatientEntity getPatientByIdWithAnamnesis(int patientId) {
		
		return patientDAO.getPatientByIdWithAnamnesis(patientId);
	}
	
	
}
