package me.srcmaxim;

import me.srcmaxim.dao.User;
import org.hibernate.criterion.*;
import java.util.stream.IntStream;

import static me.srcmaxim.util.HibernateUtil.*;

public class App {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 20).mapToObj(i -> new User("User " + i))
                .forEach(user -> openInASession(session -> session.save(user)));

        openInASession(session -> {
            session.createCriteria(User.class)
                    .setProjection(Projections.count("userId"))
                    .list().stream().map(Object::toString).forEach(System.out::println);
        });


        Example example = Example.create(new User("User 1_")).enableLike();
        openInASession(session -> {
            session.createCriteria(User.class)
                    .add(example)
                    .list().stream().map(Object::toString).forEach(System.out::println);
        });
    }

}
