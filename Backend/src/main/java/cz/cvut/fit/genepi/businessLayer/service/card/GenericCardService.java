package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.service.GenericService;

/**
 * The Interface HistologyService extends GenericCardService
 */
public interface GenericCardService<T> extends GenericService<T> {

	/**
	 * Hides certain card from the list of the cards (for example if user wants to "delete it")
	 */
	public void hide(T entity);
	/**
	 * Reveals hidden card
	 */
	public void unhide(T entity);
}
