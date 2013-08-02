package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.DAO.SeizureDAO;
import cz.cvut.fit.genepi.entity.SeizureEntity;
import cz.cvut.fit.genepi.service.SeizureService;

@Service
public class SeizureServiceImpl implements SeizureService {
	@Autowired
	private SeizureDAO seizureDAO;
	
	@Override
	public List<SeizureEntity> findSeizureByPatientID(int patientId) {
		return seizureDAO.findAnamnesisByPatientID(patientId);
	}

}
