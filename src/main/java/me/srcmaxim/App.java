package me.srcmaxim;

import java.util.GregorianCalendar;

import me.srcmaxim.dao.Address;
import me.srcmaxim.dao.User;
import me.srcmaxim.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.collection.PersistentIdentifierBag;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = createUser();
		System.out.println("Saving object: " + user);
		session.save(user);
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		user = createUser();
		System.out.println("Saving object: " + user);
		session.save(user);
		session.getTransaction().commit();
		session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        user = null;
		user = (User) session.get(User.class, 2);
		System.out.println("Retrieving object: " + user);
		session.getTransaction().commit();
		session.close();
	}

	private static User createUser() {
        Address home = new Address(0,"Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061");
        User user = new User(0, "Maxim Koval", home);
        return user;
	}
}
