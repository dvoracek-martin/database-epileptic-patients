package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AdvancedSearchVO;
import cz.cvut.fit.genepi.businessLayer.service.SearchService;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private Mapper dozer;

    @Override
    @Transactional
    public List<PatientDisplayVO> performAdvancedSearch(AdvancedSearchVO advancedSearch) {
        AdvancedSearchEntity entity = dozer.map(advancedSearch, AdvancedSearchEntity.class);
        List<PatientEntity> patientEntityList = patientDAO.performSearch(entity);
        List<PatientDisplayVO> patientDisplayVoList = new ArrayList<>();

        /* java 8 lambda example
        patientEntityList.forEach((PatientEntity patientEntity) -> {
            patientDisplayVoList.add(dozer.map(patientEntity, PatientDisplayVO.class));
        });
        */

        for (PatientEntity patientEntity : patientEntityList) {
            patientDisplayVoList.add(dozer.map(patientEntity, PatientDisplayVO.class));
        }

      /*  List<List<PatientDisplayVO>> lists = new ArrayList<>();

        double partCount = Math.ceil(patientDisplayVoList.size() / 20);


        for (int i = 0; i < patientDisplayVoList.size(); i += 19) {

        }*/


        return patientDisplayVoList;
    }
}
