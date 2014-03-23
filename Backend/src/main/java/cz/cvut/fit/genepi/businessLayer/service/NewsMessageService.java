package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.NewsMessageDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.NewsMessageVO;
import cz.cvut.fit.genepi.dataLayer.entity.NewsMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The Interface NewsMessageService extends GenericService
 */
public interface NewsMessageService {

    public List<NewsMessageDisplayVO> getSortedNewsMessages();

}