package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.DAO.SeizureDAO;
import cz.cvut.fit.genepi.entity.SeizureEntity;
import cz.cvut.fit.genepi.service.SeizureService;

// TODO: Auto-generated Javadoc
/**
 * The Class SeizureServiceImpl.
 */
@Service
public class SeizureServiceImpl implements SeizureService {
	
	/** The seizure dao. */
	@Autowired
	private SeizureDAO seizureDAO;
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.SeizureService#findSeizureByPatientID(int)
	 */
	@Override
	public List<SeizureEntity> findSeizureByPatientID(int patientId) {
		return seizureDAO.findAnamnesisByPatientID(patientId);
	}

}
