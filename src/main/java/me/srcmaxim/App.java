package me.srcmaxim;

import me.srcmaxim.dao.User;
import org.hibernate.Query;

import java.util.List;
import java.util.stream.IntStream;
import static me.srcmaxim.util.HibernateUtil.*;

public class App {

	public static void main(String[] args) {
		IntStream.rangeClosed(1,12).mapToObj(i -> new User("User " + i))
				.forEach(user -> openInASession(session -> session.save(user)));

		openInASession(session -> {
			Query query = session.createQuery("from User");
			query.setMaxResults(3);
			query.setFirstResult(0);
			((List<User>) query.list()).stream().map(user -> user.getUsername()).forEach(System.out::println);
			query.setFirstResult(4);
			((List<User>) query.list()).stream().map(user -> user.getUsername()).forEach(System.out::println);
		});
	}

}
