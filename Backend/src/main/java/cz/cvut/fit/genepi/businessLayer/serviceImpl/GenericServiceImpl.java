package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.GenericService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericServiceImpl.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
@Service
public class GenericServiceImpl <T> implements
GenericService<T> {

	/** The generic dao. */
	@Autowired
	@Qualifier("genericDAOImpl")
	protected GenericDAO<T> genericDAO;
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#save(java.lang.Object)
	 */
	@Override
	@Transactional
	public void save(T entity) {
		genericDAO.save(entity);
	}


	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#merge(java.lang.Object)
	 */
	@Override
	@Transactional
	public void merge(T entity) {
		genericDAO.merge(entity);
	}


	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#delete(java.lang.Object)
	 */
	@Override
	@Transactional
	public void delete(T entity) {
		genericDAO.delete(entity);
	}
	
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#findMany(org.hibernate.Query)
	 */
	@Override
	@Transactional
	public List<T> findMany(Query query){
		return genericDAO.findMany(query);
	}
	
	

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#findOne(org.hibernate.Query)
	 */
	@Override
	@Transactional
	public T findOne(Query query) {
		return genericDAO.findOne(query);
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#findAll(java.lang.Class)
	 */
	@Override
	@Transactional
	public List<T> findAll(Class<T> myClass) {
		return genericDAO.findAll(myClass);
	}
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#findAll(java.lang.Class)
	 */
	@Override
	@Transactional
	public List<T> findAllWithPagination(Class<T> myClass, int maxResults, int pageNumber) {
		return genericDAO.findAllWithPagination(myClass, maxResults, pageNumber);
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.service.GenericService#findByID(java.lang.Class, int)
	 */
	@Override
	@Transactional
	public T findByID(Class<T> myClass, int id) {
		return genericDAO.findByID(myClass, id);
	}
}
