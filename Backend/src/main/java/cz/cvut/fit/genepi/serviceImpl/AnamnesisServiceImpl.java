package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.AnamnesisDAO;
import cz.cvut.fit.genepi.entity.AnamnesisEntity;
import cz.cvut.fit.genepi.service.AnamnesisService;

@Service
public class AnamnesisServiceImpl implements AnamnesisService {

	@Autowired
	private AnamnesisDAO anamnesisDAO;

	@Transactional
	public void save(AnamnesisEntity anamnesis) {
		anamnesisDAO.save(anamnesis);
	}
	@Transactional
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId) {
		return anamnesisDAO.findAnamnesisByPatientID(patientId);
	}
	@Transactional
	public AnamnesisEntity findLatestAnamnesisByPatientID(int patientID) {
		return anamnesisDAO.findLatestAnamnesisByPatientID(patientID);
	}
}
