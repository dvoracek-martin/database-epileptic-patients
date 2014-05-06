package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;

import java.util.List;

public interface AnonymizeService {

    public void anonymizePatients(List<PatientDisplayBO> patients);
}
