package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.AnamnesisDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.AnamnesisFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.DAO.card.AnamnesisDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class AnamnesisServiceImpl.
 */
@Service
public class AnamnesisServiceImpl
        extends GenericCardServiceImpl<AnamnesisDisplayBO, AnamnesisFormBO, AnamnesisEntity>
        implements AnamnesisService {

    @Autowired
    private AnamnesisDAO anamnesisDao;

    @Transactional
    @Override
    public AnamnesisDisplayBO getRecordsByPatientId(int patientId) {
        AnamnesisEntity anamnesisEntity = anamnesisDao.getRecordsByPatientId(patientId);
        if (anamnesisEntity == null) {
            return null;
        } else {
            return dozer.map(anamnesisEntity, AnamnesisDisplayBO.class);
        }
    }
}
