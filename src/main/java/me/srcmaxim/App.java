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
		session.getTransaction().commit();
		session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		User user = (User) session.get(User.class, 2);
		System.out.println("Retrieving object: " + user);
		session.getTransaction().commit();
		session.close();
	}

	private static Collection<User> createUsers() {
		Address address1 = new Address(0, "aaaa", "aaaa", "aaaa Oblast", "50061");
		Address address2 = new Address(0, "University", "Kharkiv", "Kharkivska Oblast", "50061");
		Address address3 = new Address(0, "bbbb", "bbbb", "bbbb Oblast", "32684");

		User user1 = new User(0, "Maxim Koval");
		User user2 = new User(0, "Vlad Koval");

		address1.getUser().add(user1);
		user1.getAddress().add(address1);

		address2.getUser().add(user1);
		user1.getAddress().add(address2);
		address2.getUser().add(user2);
		user2.getAddress().add(address2);

		address3.getUser().add(user2);
		user2.getAddress().add(address3);


        return new ArrayList<User>(){{add(user1);add(user2);}};
	}
}
