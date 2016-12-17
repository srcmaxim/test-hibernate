package me.srcmaxim;

import me.srcmaxim.dao.User;
import static me.srcmaxim.util.HibernateUtil.*;

import java.util.stream.IntStream;

public class App {

	public static void main(String[] args) {
		openInASession(session -> IntStream.rangeClosed(1,10)
					.forEach(i -> session.save(new User("User " + i))));

		openInASession(session -> System.out.println(session.get(User.class, 1)));

		openInASession(session -> session.delete(
				session.get(User.class, 1)));

		openInASession(session -> System.out.println(session.get(User.class, 1)));

		openInASession(session -> {
			User user = (User) session.get(User.class, 2);
			user.setUsername("Username updated");
			session.update(user);
		});

		openInASession(session -> System.out.println(session.get(User.class, 2)));
	}

}
