package cz.cvut.fit.genepi.service;

import cz.cvut.fit.genepi.entity.ContactEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ContactService {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the contact entity
	 */
	ContactEntity findByID(int id);
	public void merge(ContactEntity constac);
}
