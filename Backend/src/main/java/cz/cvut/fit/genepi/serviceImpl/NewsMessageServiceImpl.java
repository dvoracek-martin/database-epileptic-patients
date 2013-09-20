package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.DAO.NewsMessageDAO;
import cz.cvut.fit.genepi.entity.NewsMessageEntity;
import cz.cvut.fit.genepi.service.NewsMessageService;

@Service
public class NewsMessageServiceImpl extends
GenericServiceImpl<NewsMessageEntity, Serializable> implements
NewsMessageService {

	@Autowired
	private NewsMessageDAO newsMessageDAO;
}
