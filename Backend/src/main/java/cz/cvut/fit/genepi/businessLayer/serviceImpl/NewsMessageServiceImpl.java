package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.NewsMessageDisplayVO;
import cz.cvut.fit.genepi.businessLayer.service.NewsMessageService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.entity.NewsMessageEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class NewsMessageServiceImpl.
 */
@Service
public class NewsMessageServiceImpl implements NewsMessageService {

    @Autowired
    @Qualifier("genericDAOImpl")
    GenericDAO<NewsMessageEntity> genericDAO;

    @Autowired
    Mapper dozer;

    @Transactional
    @Override
    public List<NewsMessageDisplayVO> getSortedNewsMessages() {
        List<NewsMessageEntity> newsMessageEntityList = genericDAO.findAll(NewsMessageEntity.class);
        Collections.sort(newsMessageEntityList);
        List<NewsMessageDisplayVO> newsMessageDisplayVoList = new ArrayList<>();

        for (NewsMessageEntity newsMessageEntity : newsMessageEntityList) {
            NewsMessageDisplayVO newsMessageDisplayVo = dozer.map(newsMessageEntity, NewsMessageDisplayVO.class);
            newsMessageDisplayVoList.add(newsMessageDisplayVo);
        }

        return newsMessageDisplayVoList;
    }
}
