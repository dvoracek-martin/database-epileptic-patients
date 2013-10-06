package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

public interface ExportToDocxService {
	public void export(PatientEntity patient, UserEntity user, List<String> exports);
}
