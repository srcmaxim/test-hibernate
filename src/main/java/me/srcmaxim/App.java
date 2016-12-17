package me.srcmaxim;

import me.srcmaxim.dao.User;
import static me.srcmaxim.util.HibernateUtil.*;

public class App {

	public static void main(String[] args) {
		User user = new User("User " + 1); // Transient state

		openInASession(session -> { // Persistent state
			session.save(user);
			user.setUsername("New Name of Persistent Object");
		});

		openInASession(session -> { // Transient state
			session.delete(user);
			user.setUsername("Object in a Transient state (don't change username)");
		});

        user.setUsername("Object in a Transient state (don't change username)"); // Detached state

        openInASession(session -> { // Persistent state. Resaving object
            session.save(user);
        });

        final User[] persistentUser = new User[1];
        openInASession(session -> { // Persistent state
            persistentUser[0] = (User) session.get(User.class, 2);
            user.setUsername("New Name of Persistent Object");
        });

        persistentUser[0].setUsername("Object in a Detached state (don't change username)"); // Detached state

	}

}
