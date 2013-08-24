package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.AnamnesisDAO;
import cz.cvut.fit.genepi.entity.AnamnesisEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisServiceImpl.
 */
@Service
public class AnamnesisServiceImpl implements AnamnesisService {

	/** The anamnesis dao. */
	@Autowired
	private AnamnesisDAO anamnesisDAO;

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.AnamnesisService#save(cz.cvut.fit.genepi.entity.AnamnesisEntity)
	 */
	@Transactional
	public void save(AnamnesisEntity anamnesis) {
		anamnesisDAO.save(anamnesis);
	}
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.AnamnesisService#findAnamnesisByPatientID(int)
	 */
	@Transactional
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId) {
		return anamnesisDAO.findAnamnesisByPatientID(patientId);
	}
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.AnamnesisService#findLatestAnamnesisByPatientID(int)
	 */
	@Transactional
	public AnamnesisEntity findLatestAnamnesisByPatientID(int patientID) {
		return anamnesisDAO.findLatestAnamnesisByPatientID(patientID);
	}
}
