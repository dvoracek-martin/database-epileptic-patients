package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	@Autowired
	private PatientDAO patientDAO;
}
