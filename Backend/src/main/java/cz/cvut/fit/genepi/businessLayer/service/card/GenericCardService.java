package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.service.GenericService;

import java.util.List;

public interface GenericCardService<CardDisplayVo, CardFormVo, CardEntity> extends GenericService<CardFormVo, CardEntity> {

    public void hide(int id, Class<CardEntity> entityClass);

    public void unhide(int id, Class<CardEntity> entityClass);

    public void makeHistory(int id, Class<CardEntity> entityClass);

    public List<CardDisplayVo> getRecordsByPatientId(int patientId, Class<CardDisplayVo> voClass, Class<CardEntity> entityClass);

    public CardDisplayVo getLatestRecordByPatientId(int patientId, Class<CardDisplayVo> voClass, Class<CardEntity> entityClass);
}
