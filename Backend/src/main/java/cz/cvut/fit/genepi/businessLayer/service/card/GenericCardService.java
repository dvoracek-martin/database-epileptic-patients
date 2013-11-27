package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.service.GenericService;

public interface GenericCardService<T> extends GenericService<T> {

	public void hide(T entity);

	public void unhide(T entity);
}