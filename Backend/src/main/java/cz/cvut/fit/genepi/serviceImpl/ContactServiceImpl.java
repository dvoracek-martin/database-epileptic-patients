package cz.cvut.fit.genepi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.ContactDAO;
import cz.cvut.fit.genepi.entity.ContactEntity;
import cz.cvut.fit.genepi.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO cntactDAO;
	
	
	@Transactional
	public ContactEntity findByID(int id){
		return (cntactDAO.findByID(ContactEntity.class, id));
	}
}
