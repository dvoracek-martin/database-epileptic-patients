package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

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
public class PatientServiceImpl implements PatientService {

	/** The patient dao. */
	@Autowired
	private PatientDAO patientDAO;

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.PatientService#save(cz.cvut.fit.genepi.entity.PatientEntity)
	 */
	@Override
	@Transactional
	public void save(PatientEntity patient) {
		patientDAO.save(patient);
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.PatientService#findByID(int)
	 */
	@Override
	@Transactional
	public PatientEntity findByID(int id) {
		return (patientDAO.findByID(PatientEntity.class, id));
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.PatientService#findAll()
	 */
	@Override
	@Transactional
	public List<PatientEntity> findAll() {
		return patientDAO.findAll(PatientEntity.class);
	}
}
