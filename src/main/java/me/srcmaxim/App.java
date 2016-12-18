package me.srcmaxim;

import me.srcmaxim.dao.User;

import java.util.stream.IntStream;

import static me.srcmaxim.util.HibernateUtil.*;

public class App {

    public static void main(String[] args) {
        openInASession(session -> {
            IntStream.rangeClosed(1, 10).forEach(i -> session.save(new User("User " + i)));
        });

        openInASession(session -> session.createCriteria(User.class).setCacheable(true)
                .list().stream().forEach(System.out::println));

        openInASession(session -> session.createCriteria(User.class).setCacheable(true)
                .list().stream().forEach(System.out::println));
    }

}
