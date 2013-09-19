package cz.cvut.fit.genepi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.DAO.NewsMessageDAO;

@Service
public class NewsMessageServiceImpl {

	@Autowired
	private NewsMessageDAO newsMessageDAO;
}
