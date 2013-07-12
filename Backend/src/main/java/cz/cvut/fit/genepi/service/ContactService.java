package cz.cvut.fit.genepi.service;

import cz.cvut.fit.genepi.entity.ContactEntity;

public interface ContactService {

	ContactEntity findByID(int id);
}
