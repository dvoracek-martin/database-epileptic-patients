package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.NewsMessageDisplayVO;

import java.util.List;

/**
 * The Interface NewsMessageService extends GenericService
 */
public interface NewsMessageService {

    public List<NewsMessageDisplayVO> getSortedNewsMessages();

}
