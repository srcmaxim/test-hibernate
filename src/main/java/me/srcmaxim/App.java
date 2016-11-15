package me.srcmaxim;

import java.util.ArrayList;
import java.util.Collection;

import me.srcmaxim.dao.Car;
import me.srcmaxim.dao.Motorcycle;
import me.srcmaxim.dao.User;
import me.srcmaxim.dao.Vehicle;
import me.srcmaxim.util.HibernateUtil;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate Annotation + Oracle");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User(0, "Koval Maxim");
		Car car = new Car(0, 100, "Car: Shevrolet: 100", "Shevrolet Savanna", "Cabriolet", "2");
		Motorcycle moto = new Motorcycle(0, 30, "Motorcycle: Kavasaki: 30", "Kavasaki Ninja", "Sport");
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>() {{
			add(car);
			add(moto);
		}};

		User finalUser = user;
		vehicles.parallelStream().forEach(vehicle -> {
			vehicle.setUser(finalUser);
			finalUser.getVehicle().add(vehicle);
		});

		session.save(user);

		user = (User) session.get(User.class, 1);
		System.out.println("RETRIVING OBJECT: " + user);

		session.getTransaction().commit();
		session.close();
	}


}
