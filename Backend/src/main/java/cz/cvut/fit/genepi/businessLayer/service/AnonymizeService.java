package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import java.util.List;

/**
 * Created by Jan on 28.2.14.
 */
public interface AnonymizeService {

    public void anonymizePatients( List<PatientEntity> patients);
}
