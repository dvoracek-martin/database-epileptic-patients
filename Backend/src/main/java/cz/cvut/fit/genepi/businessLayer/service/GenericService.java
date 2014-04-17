package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;

public interface GenericService<VO, Entity> {

    public int save(VO vo, Class<Entity> entityClass);

    public VO getById(int id, Class<VO> voClass, Class<Entity> entityClass);

    public void update(VO vo, Class<Entity> entityClass);

    public void delete(int id, Class<Entity> entityClass);

    public List<VO> getAll(Class<VO> voClass, Class<Entity> entityClass);
}
