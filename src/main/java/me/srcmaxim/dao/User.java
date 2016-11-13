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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"),
			inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	private Collection<Address> addresses;

	public User() {
	}

	public User(int userId, String username, Collection<Address> addresses) {

		this.userId = userId;
		this.username = username;
		this.addresses = addresses;
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

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public String toStringDB() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", addresses=" + addresses +
				'}';
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", addresses=" + '[' +
				addresses.stream().map(address -> address.toStringDB())
						.reduce((a, b) ->  a + ", " + b) +
				']' + '}';
	}
}
