package me.srcmaxim;

import java.util.Date;
import java.util.GregorianCalendar;

import me.srcmaxim.dao.Address;
import me.srcmaxim.dao.User;
import me.srcmaxim.util.HibernateUtil;
import org.hibernate.Session;

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
	}

	private static User createUser() {
		Address address = new Address("Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061");
		GregorianCalendar createdDate = new GregorianCalendar(1995, 6, 23);
		return new User(0,"Maxim Koval", "admin", createdDate.getTime(), address);
	}
}
