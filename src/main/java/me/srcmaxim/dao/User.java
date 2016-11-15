package me.srcmaxim.dao;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", nullable = false, length = 20)
	private int userId;

	@Column(name = "USERNAME", nullable = false, length = 20)
	private String username;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private Collection<Vehicle> vehicle = new ArrayList<>();

	public User() {
	}

	public User(int userId, String username, Collection<Vehicle> address) {
		this(userId, username);
		this.vehicle = address;
	}

	public User(int userId, String username) {
		this.userId = userId;
		this.username = username;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setVehicle(Collection<Vehicle> address) {
		this.vehicle = address;
	}

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	String toStringDB() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", vehicle=" + vehicle +
				'}';
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", vehicle=" + '[' +
				vehicle.stream().map(vehicle -> vehicle.toString())
						.reduce((a, b) ->  a + ", " + b) +
				']' + '}';
	}
}
