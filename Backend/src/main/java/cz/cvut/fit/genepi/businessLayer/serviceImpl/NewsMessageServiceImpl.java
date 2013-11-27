package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.businessLayer.service.NewsMessageService;
import cz.cvut.fit.genepi.dataLayer.DAO.NewsMessageDAO;
import cz.cvut.fit.genepi.dataLayer.entity.NewsMessageEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class NewsMessageServiceImpl.
 */
@Service
public class NewsMessageServiceImpl extends
		GenericServiceImpl<NewsMessageEntity> implements
		NewsMessageService {

	/** The news message dao. */
	@Autowired
	private NewsMessageDAO newsMessageDAO;

}