package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.GenericDAO;
import cz.cvut.fit.genepi.service.GenericService;

@Service
public class GenericServiceImpl <T, ID extends Serializable> implements
GenericService<T, ID> {

	@Autowired
	@Qualifier("genericDAOImpl")
	protected GenericDAO<T, ID> genericDAO;
	
	@Override
	@Transactional
	public void save(T entity) {
		genericDAO.save(entity);
	}


	@Override
	@Transactional
	public void merge(T entity) {
		genericDAO.merge(entity);
	}


	@Override
	@Transactional
	public void delete(T entity) {
		genericDAO.delete(entity);
	}
	
	
	@Override
	@Transactional
	public List<T> findMany(Query query){
		return genericDAO.findMany(query);
	}
	
	

	@Override
	@Transactional
	public T findOne(Query query) {
		return genericDAO.findOne(query);
	}

	@Override
	@Transactional
	public List<T> findAll(Class<T> myClass) {
		return genericDAO.findAll(myClass);
	}

	@Override
	@Transactional
	public T findByID(Class<T> myClass, int id) {
		return genericDAO.findByID(myClass, id);
	}
}
