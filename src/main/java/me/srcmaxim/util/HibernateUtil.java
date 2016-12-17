package me.srcmaxim.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			//For XML mapping
			//return new Configuration().configure().buildSessionFactory();
			
			//For Annotation
			return new Configuration().configure().buildSessionFactory();
			
		} catch (Throwable ex) {
			
			throw new ExceptionInInitializerError(ex);
		}
	}

	public interface SessionQuery {
		void doActionInASession(Session session);
	}

	public static void openInASession(SessionQuery sessionQuery){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		sessionQuery.doActionInASession(session);
		session.getTransaction().commit();
		session.close();
	}

}