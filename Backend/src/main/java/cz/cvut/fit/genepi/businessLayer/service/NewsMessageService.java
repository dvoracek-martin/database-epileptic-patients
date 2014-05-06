package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.display.NewsMessageDisplayBO;

import java.util.List;

/**
 * The Interface NewsMessageService extends GenericService
 */
public interface NewsMessageService {

    public List<NewsMessageDisplayBO> getSortedNewsMessages();

}
