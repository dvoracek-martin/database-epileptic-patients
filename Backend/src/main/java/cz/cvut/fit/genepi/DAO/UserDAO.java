package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

public interface UserDAO extends GenericDAO<UserEntity, Serializable> {

	UserEntity findUserByID(Integer userID);
}
