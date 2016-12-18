package me.srcmaxim;

import me.srcmaxim.dao.User;
import org.hibernate.criterion.Restrictions;
import java.util.stream.IntStream;

import static me.srcmaxim.util.HibernateUtil.*;

public class App {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 20).mapToObj(i -> new User("User " + i))
                .forEach(user -> openInASession(session -> session.save(user)));

        openInASession(session -> {
            session.createCriteria(User.class)
                    .add(Restrictions.or(
                            Restrictions.and(
                                    Restrictions.like("username", "User 1_"),
                                    Restrictions.ge("userId", 15)),
                            Restrictions.lt("userId", 6)))
                    .list().stream().map(Object::toString).forEach(System.out::println);
        });
    }

}
