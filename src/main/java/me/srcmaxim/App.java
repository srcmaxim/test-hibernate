package me.srcmaxim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Set;

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
		User user = createUserMaxim();
		System.out.println("Saving object: " + user);
		session.save(user);
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		user = createUserVlad();
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

	private static User createUserMaxim() {
		Collection<Address> addresses = new ArrayList<Address>(){{
			add(new Address(0,"Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061"));
			add(new Address(0,"Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061"));
        }};
        User user = new User(0, "Maxim Koval", addresses);
        return user;
	}

	private static User createUserVlad() {
		Collection<Address> addresses = new ArrayList<Address>(){{
			add(new Address(0,"Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061"));
			add(new Address(0,"Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061"));
		}};
		User user = new User(0, "Vlad Koval", addresses);
        return user;
	}
}
