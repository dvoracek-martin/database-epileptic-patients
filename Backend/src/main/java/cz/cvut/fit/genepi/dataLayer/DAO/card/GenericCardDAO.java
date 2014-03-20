package cz.cvut.fit.genepi.dataLayer.DAO.card;

import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;

import java.util.List;

public interface GenericCardDAO<CardEntity> extends GenericDAO<CardEntity> {

    public void hide(int id, Class<CardEntity> entityClass);

    public void unhide(int id, Class<CardEntity> entityClass);

    public void makeHistory(int id, Class<CardEntity> entityClass);

    public List<CardEntity> getRecordsByPatientId(int patientId,Class<CardEntity> entityClass);

    public CardEntity getLatestRecordByPatientId(int patientId,Class<CardEntity> entityClass );
}