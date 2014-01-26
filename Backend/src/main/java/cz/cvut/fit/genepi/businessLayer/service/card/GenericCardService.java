package cz.cvut.fit.genepi.businessLayer.service.card;

/**
 * Created by Jan on 23.1.14.
 */
public interface GenericCardService<CardVO, CardEntity> {

    public CardVO getById(Class<CardVO> cardVoClass, int recordId);

    public void save( CardVO cardVo);

    public void delete (int recordId);

  /*  public void hide(int id);

    public void unhide(int id);*/
}
