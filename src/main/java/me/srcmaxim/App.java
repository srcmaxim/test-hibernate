package me.srcmaxim;

import me.srcmaxim.dao.User;

import static me.srcmaxim.util.HibernateUtil.*;

public class App {

    public static void main(String[] args) {
        openInASession(session -> {
            session.save(new User("User 1"));
        });

        openInASession(session -> {
            // new select because of closed session
            // Hibernate: select user0_.USER_ID as USER1_0_0_, user0_.USERNAME as USERNAME0_0_ from USER_DETAILS user0_ where user0_.USER_ID=?
            User userA = (User) session.get(User.class, 1);
            userA.setUsername("User 1 with changed name");
            // don't do select and get it from the cache
            User userB = (User) session.get(User.class, 1);
            // must update db
            // Hibernate: update USER_DETAILS set USERNAME=? where USER_ID=?
        });

        openInASession(session -> {
            // new select because of closed session
            // Hibernate: select user0_.USER_ID as USER1_0_0_, user0_.USERNAME as USERNAME0_0_ from USER_DETAILS user0_ where user0_.USER_ID=?
            User userA = (User) session.get(User.class, 1);
        });
    }

}
