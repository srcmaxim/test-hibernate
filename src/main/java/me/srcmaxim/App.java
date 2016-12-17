package me.srcmaxim;

import me.srcmaxim.dao.User;

import java.util.List;
import java.util.stream.IntStream;
import static me.srcmaxim.util.HibernateUtil.*;

public class App {

	public static void main(String[] args) {
		IntStream.rangeClosed(1,10).mapToObj(i -> new User("User " + i))
				.forEach(user -> openInASession(session -> session.save(user)));

		openInASession(session -> ((List<User>)session.createQuery("from User where userId > 5").list())
				.stream().map(user -> user.getUsername()).forEach(System.out::println));
	}

}
