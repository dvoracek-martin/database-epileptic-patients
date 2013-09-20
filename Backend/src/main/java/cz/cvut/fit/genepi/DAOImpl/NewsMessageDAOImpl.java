package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.NewsMessageDAO;
import cz.cvut.fit.genepi.entity.NewsMessageEntity;

@Repository
public class NewsMessageDAOImpl extends
		GenericDAOImpl<NewsMessageEntity, Serializable> implements
		NewsMessageDAO {
}
