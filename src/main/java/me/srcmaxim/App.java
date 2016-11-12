package me.srcmaxim;

import java.util.Date;
import java.util.GregorianCalendar;

import me.srcmaxim.dao.Address;
import me.srcmaxim.dao.SSNAndPassport;
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
        SSNAndPassport id = new SSNAndPassport(572_678_531, "AE237683");
        GregorianCalendar createdDate = new GregorianCalendar(1995, 6, 23);
		Address homeAddress = new Address("Ak. Proskury", "Kharkiv", "Kharkivska Oblast", "50061");
		Address officeAddress = new Address("Sumskaya", "Kharkiv", "Kharkivska Oblast", "50061");

		return new User(id,"Maxim Koval", "admin", createdDate.getTime(), homeAddress, officeAddress);
	}
}
