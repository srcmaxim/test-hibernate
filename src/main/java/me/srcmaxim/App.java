package me.srcmaxim;

import java.util.Date;

import me.srcmaxim.dao.User;
import me.srcmaxim.util.HibernateUtil;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUserId(100);
		user.setUsername("Hibernate101");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();
	}
}
