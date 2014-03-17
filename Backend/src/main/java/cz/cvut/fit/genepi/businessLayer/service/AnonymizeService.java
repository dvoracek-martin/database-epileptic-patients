package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;

import java.util.List;

public interface AnonymizeService {

    public void anonymizePatients(List<PatientDisplayVO> patients);
}