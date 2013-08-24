package cz.cvut.fit.genepi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.ContactDAO;
import cz.cvut.fit.genepi.entity.ContactEntity;
import cz.cvut.fit.genepi.service.ContactService;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service
public class ContactServiceImpl implements ContactService {

	/** The cntact dao. */
	@Autowired
	private ContactDAO cntactDAO;
	
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.ContactService#findByID(int)
	 */
	@Transactional
	public ContactEntity findByID(int id){
		return (cntactDAO.findByID(ContactEntity.class, id));
	}
}
