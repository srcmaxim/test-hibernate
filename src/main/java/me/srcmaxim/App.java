package me.srcmaxim;

import me.srcmaxim.dao.User;
import org.hibernate.Query;

import java.util.List;
import java.util.stream.IntStream;
import static me.srcmaxim.util.HibernateUtil.*;

public class App {

	public static void main(String[] args) {
		IntStream.rangeClosed(1,10).mapToObj(i -> new User("User " + i))
				.forEach(user -> openInASession(session -> session.save(user)));

		openInASession(session -> {
			Query query = session.getNamedQuery("User.byId");
            int userId = 5;
			query.setInteger(0, userId);
			((List<User>) query.list()).stream().map(user -> user.getUsername()).forEach(System.out::println);
		});

        openInASession(session -> {
            Query query = session.getNamedQuery("User.byName");
            String username = "User 5";
            query.setString(0, username);
            ((List<User>) query.list()).stream().map(user -> user.getUsername()).forEach(System.out::println);
        });
	}

}
