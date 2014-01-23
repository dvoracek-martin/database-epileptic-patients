package cz.cvut.fit.genepi.businessLayer.service.card;

/**
 * Created by Jan on 23.1.14.
 */
public interface GenService<CardVO, CardEntity> {

    public CardVO getById(Class<CardVO> cardVoClass, Class<CardEntity> cardEntityClass, int recordId);

    public void save(Class<CardEntity> cardEntityClass, CardVO cardVo);

  /*  public void hide(int id);

    public void unhide(int id);*/
}
