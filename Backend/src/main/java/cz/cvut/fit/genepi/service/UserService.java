package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.UserEntity;

public interface UserService {
	public void save(UserEntity user);

	public UserEntity findByID(int id);

	public List<UserEntity> findAll();

	public UserEntity findUserByID(Integer userID);
}
