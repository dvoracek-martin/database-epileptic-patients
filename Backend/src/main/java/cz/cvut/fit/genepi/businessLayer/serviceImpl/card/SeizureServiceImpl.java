package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDetailDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.SeizureDAO;
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
        extends GenericCardServiceImpl<SeizureDetailDisplayVO, SeizureVO, SeizureEntity>
        implements SeizureService {

    @Autowired
    @Qualifier("genericDAOImpl")
    private GenericDAO<SeizureDetailEntity> seizureDetailDAO;

    @Autowired
    private SeizureDAO seizureDAO;

    @Override
    @Transactional
    public int save(SeizureVO seizure) {
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
    public List<SeizureDisplayVO> getRecordsByPatientId(int patientId) {
        List<SeizureEntity> seizureEntityList = genericCardDAO.getRecordsByPatientId(patientId, SeizureEntity.class);
        if (seizureEntityList.isEmpty()) {
            return null;
        } else {
            List<SeizureDisplayVO> seizureDisplayVoList = new ArrayList<>();
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

                SeizureDisplayVO vo = dozer.map(entity, SeizureDisplayVO.class);
                seizureDisplayVoList.add(vo);
            }
            return seizureDisplayVoList;
        }
    }

    @Override
    @Transactional
    public SeizureDisplayVO getLatestRecordByPatientId(int patientId) {
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

            return dozer.map(seizureEntity, SeizureDisplayVO.class);
        }
    }
}