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
        user = null;
        user = (User) session.get(User.class, 0);
        session.getTransaction().commit();
        session.close();
        System.out.println(user.getSetOfAddresses().size());
        System.out.println("Retrieving object: " + user);
    }

	private static User createUser() {
        GregorianCalendar createdDate = new GregorianCalendar(1995, 6, 23);
		Address home = new Address("Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061");
		Address office = new Address("Sumskaya", "Kharkiv", "Kharkivska Oblast", "50061");
		Address university = new Address("Sumskaya", "Kharkiv", "Kharkivska Oblast", "50061");

        User user = new User(0, "Maxim Koval", "admin", createdDate.getTime());
        user.getSetOfAddresses().add(home);
        user.getSetOfAddresses().add(office);
        user.getSetOfAddresses().add(university);
        return user;
	}
}
