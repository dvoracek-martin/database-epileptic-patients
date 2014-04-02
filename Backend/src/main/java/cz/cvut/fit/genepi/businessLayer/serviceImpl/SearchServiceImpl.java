package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.AdvancedSearchDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AdvancedSearchVO;
import cz.cvut.fit.genepi.businessLayer.service.SearchService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    @Qualifier("genericDAOImpl")
    GenericDAO<AdvancedSearchEntity> genericDao;

    @Autowired
    private Mapper dozer;

    @Override
    @Transactional
    public List<List<PatientDisplayVO>> performAdvancedSearch(AdvancedSearchVO advancedSearch) {
        AdvancedSearchEntity entity = dozer.map(advancedSearch, AdvancedSearchEntity.class);
        List<PatientEntity> patientEntityList = patientDAO.performSearch(entity);

        List<List<PatientDisplayVO>> lists = new ArrayList<>();

        if (patientEntityList.isEmpty()) {
            return lists;
        } else {

            List<PatientDisplayVO> patientDisplayVoList = new ArrayList<>();

        /* java 8 lambda example
        patientEntityList.forEach((PatientEntity patientEntity) -> {
            patientDisplayVoList.add(dozer.map(patientEntity, PatientDisplayVO.class));
        });
        */

            for (PatientEntity patientEntity : patientEntityList) {
                patientDisplayVoList.add(dozer.map(patientEntity, PatientDisplayVO.class));
            }

            int pageCount;

            if (patientDisplayVoList.size() < 20) {
                pageCount = 1;
            } else {
                pageCount = patientDisplayVoList.size() / 20;
            }

            for (int i = 0; i < pageCount; i++) {
                lists.add(patientDisplayVoList.subList(i * 20, (i + 1) * 20));
            }

            if (patientDisplayVoList.size() % 20 != 0) {
                lists.add(patientDisplayVoList.subList(pageCount * 20, patientDisplayVoList.size()));
            }

            return lists;
        }
    }

    public List<AdvancedSearchDisplayVO> loadAll() {
        List<AdvancedSearchEntity> advancedSearchEntityList = genericDao.findAll(AdvancedSearchEntity.class);
        List<AdvancedSearchDisplayVO> advancedSearchDisplayVoList = new ArrayList<>();
        for (AdvancedSearchEntity advancedSearchEntity : advancedSearchEntityList) {
            advancedSearchDisplayVoList.add(dozer.map(advancedSearchEntity, AdvancedSearchDisplayVO.class));
        }
        return advancedSearchDisplayVoList;
    }
}
