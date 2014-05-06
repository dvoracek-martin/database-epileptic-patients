package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.BO.display.AdvancedSearchDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.AdvancedSearchFormBO;
import cz.cvut.fit.genepi.businessLayer.service.AnonymizeService;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.SearchService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Autowired
    private UserService userService;

    @Autowired
    private AnonymizeService anonymizeService;


    @Autowired
    private AuthorizationChecker authorizationChecker;

    @Override
    @Transactional
    public List<List<PatientDisplayBO>> performAdvancedSearch(AdvancedSearchFormBO advancedSearch) {
        AdvancedSearchEntity entity = dozer.map(advancedSearch, AdvancedSearchEntity.class);
        List<PatientEntity> patientEntityList = patientDAO.performSearch(entity);

        /* TODO hotfix START */
        if (!advancedSearch.getOperationCount().equals("")) {
            Iterator<PatientEntity> i = patientEntityList.iterator();
            while (i.hasNext()) {
                PatientEntity patientEntity = i.next();
                if (advancedSearch.getOperationCountFilter().equals("=")) {
                    if (patientEntity.getOperationList().size() != Integer.parseInt(advancedSearch.getOperationCount())) {
                        i.remove();
                    }
                } else if (advancedSearch.getOperationCountFilter().equals(">")) {
                    if (patientEntity.getOperationList().size() <= Integer.parseInt(advancedSearch.getOperationCount())) {
                        i.remove();
                    }
                } else if (advancedSearch.getOperationCountFilter().equals("<")) {
                    if (patientEntity.getOperationList().size() >= Integer.parseInt(advancedSearch.getOperationCount())) {
                        i.remove();
                    }
                } else if (advancedSearch.getOperationCountFilter().equals(">=")) {
                    if (patientEntity.getOperationList().size() < Integer.parseInt(advancedSearch.getOperationCount())) {
                        i.remove();
                    }
                } else if (advancedSearch.getOperationCountFilter().equals("<=")) {
                    if (patientEntity.getOperationList().size() > Integer.parseInt(advancedSearch.getOperationCount())) {
                        i.remove();
                    }
                }
            }
        }

        /* hotfix END */


        List<List<PatientDisplayBO>> lists = new ArrayList<>();

        if (patientEntityList.isEmpty()) {
            return lists;
        } else {

            List<PatientDisplayBO> patientDisplayBOList = new ArrayList<>();

        /* java 8 lambda example
        patientEntityList.forEach((PatientEntity patientEntity) -> {
            patientDisplayBOList.add(dozer.map(patientEntity, PatientDisplayBO.class));
        });
        */

            for (PatientEntity patientEntity : patientEntityList) {
                patientDisplayBOList.add(dozer.map(patientEntity, PatientDisplayBO.class));
            }

            if (authorizationChecker.onlyResearcher()) {
                anonymizeService.anonymizePatients(patientDisplayBOList);
            }

            int pageCount = patientDisplayBOList.size() / 20;

            for (int i = 0; i < pageCount; i++) {
                lists.add(patientDisplayBOList.subList(i * 20, (i + 1) * 20));
            }

            if (patientDisplayBOList.size() % 20 != 0) {
                lists.add(patientDisplayBOList.subList(pageCount * 20, patientDisplayBOList.size()));
            }

            return lists;
        }

    }

    @Override
    @Transactional
    public void save(AdvancedSearchFormBO advancedSearch) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = auth.getName();

        advancedSearch.setUserId(userService.getUserByUsername(name).getId());
        genericDao.save(dozer.map(advancedSearch, AdvancedSearchEntity.class));
    }

    @Override
    @Transactional
    public List<AdvancedSearchDisplayBO> loadAll() {
        List<AdvancedSearchEntity> advancedSearchEntityList = genericDao.findAll(AdvancedSearchEntity.class);
        List<AdvancedSearchDisplayBO> advancedSearchDisplayBOList = new ArrayList<>();
        for (AdvancedSearchEntity advancedSearchEntity : advancedSearchEntityList) {
            advancedSearchDisplayBOList.add(dozer.map(advancedSearchEntity, AdvancedSearchDisplayBO.class));
        }
        return advancedSearchDisplayBOList;
    }
}
