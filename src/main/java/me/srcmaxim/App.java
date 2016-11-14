package me.srcmaxim;

import java.util.ArrayList;
import java.util.Collection;

import me.srcmaxim.dao.Address;
import me.srcmaxim.dao.User;
import me.srcmaxim.util.HibernateUtil;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Collection<User> users = createUsers();
		for (User u : users) {
			System.out.println("Saving object: " + u);
			session.save(u);
		}
		session.save(new Address(4,"", "", "", ""));
		session.getTransaction().commit();
		session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		Address address = (Address) session.get(Address.class, 4);
		address.getUser();
		System.out.println("Retrieving object: " + address);

		session.getTransaction().commit();
		session.close();
	}

	private static Collection<User> createUsers() {
		Address address1 = new Address(0, "aaaa", "aaaa", "aaaa Oblast", "50061");
		Address address2 = new Address(0, "University", "Kharkiv", "Kharkivska Oblast", "50061");
		//Address address3 = new Address(0, "bbbb", "bbbb", "bbbb Oblast", "32684");

		User user1 = new User(0, "Maxim Koval");
		User user2 = new User(0, "Vlad Koval");

		user1.getAddress().add(address1);
		user1.getAddress().add(address2);
		//user2.getAddress().add(address3);


        return new ArrayList<User>(){{add(user1);add(user2);}};
	}
}
