package cz.cvut.fit.genepi.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// TODO: Auto-generated Javadoc
/*
 * class that handles connection with the database via hibernate 
 */
/**
 * The Class HibernateUtil.
 */
public class HibernateUtil {


	/** The Constant sessionFactory. */
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	/**
	 * Builds the session factory.
	 *
	 * @return the session factory
	 */
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	/**
	 * Gets the session factory.
	 *
	 * @return the session factory
	 */
	public static SessionFactory getSessionFactory() {
		if (sessionFactory==null)
			buildSessionFactory();
		return sessionFactory;
	}
 
	/**
	 * Shutdown.
	 */
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	} 
}