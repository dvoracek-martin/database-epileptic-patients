package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDetailDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.SeizureDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.SeizureFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class SeizureServiceImpl
        extends GenericCardServiceImpl<SeizureDetailDisplayBO, SeizureFormBO, SeizureEntity>
        implements SeizureService {

    @Autowired
    @Qualifier("genericDAOImpl")
    private GenericDAO<SeizureDetailEntity> seizureDetailDAO;

    @Override
    @Transactional
    public int save(SeizureFormBO seizure) {
        SeizureEntity entity = dozer.map(seizure, SeizureEntity.class);
        int seizureId = genericDAO.save(entity);
        for (SeizureDetailEntity seizureDetailEntity : entity.getSeizureDetailList()) {
            seizureDetailEntity.setSeizureId(seizureId);
            seizureDetailDAO.save(seizureDetailEntity);
        }
        return seizureId;
    }

    @Override
    @Transactional
    public List<SeizureDisplayBO> getRecordsByPatientId(int patientId) {
        List<SeizureEntity> seizureEntityList = genericCardDAO.getRecordsByPatientId(patientId, SeizureEntity.class);
        if (seizureEntityList.isEmpty()) {
            return null;
        } else {
            List<SeizureDisplayBO> seizureDisplayBOList = new ArrayList<>();
            for (SeizureEntity entity : seizureEntityList) {

                List<SeizureDetailEntity> seizureDetailEntityList = entity.getSeizureDetailList();
                Iterator<SeizureDetailEntity> iterator = seizureDetailEntityList.iterator();
                while (iterator.hasNext()) {
                    SeizureDetailEntity seizureDetailEntity = iterator.next();
                    if (seizureDetailEntity.isHidden() || seizureDetailEntity.isHistory()) {
                        iterator.remove();
                    }
                }
                Collections.sort(entity.getSeizureDetailList());
                Collections.reverse(entity.getSeizureDetailList());

                SeizureDisplayBO vo = dozer.map(entity, SeizureDisplayBO.class);
                seizureDisplayBOList.add(vo);
            }
            return seizureDisplayBOList;
        }
    }

    @Override
    @Transactional
    public SeizureDisplayBO getLatestRecordByPatientId(int patientId) {
        List<SeizureEntity> seizureEntityList = genericCardDAO.getRecordsByPatientId(patientId, SeizureEntity.class);
        if (seizureEntityList.isEmpty()) {
            return null;
        } else {
            SeizureEntity seizureEntity = seizureEntityList.get(0);


            Iterator<SeizureDetailEntity> iterator = seizureEntity.getSeizureDetailList().iterator();
            while (iterator.hasNext()) {
                SeizureDetailEntity seizureDetailEntity = iterator.next();
                if (seizureDetailEntity.isHidden() || seizureDetailEntity.isHistory()) {
                    iterator.remove();
                }
            }
            Collections.sort(seizureEntity.getSeizureDetailList());
            Collections.reverse(seizureEntity.getSeizureDetailList());

            return dozer.map(seizureEntity, SeizureDisplayBO.class);
        }
    }
}
