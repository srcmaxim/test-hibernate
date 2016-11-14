package me.srcmaxim.dao;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

	/*Getting exception in combination with FETCH TYPE:
	 FetchType.LAZY exc will be in: address.getUser();
	 FetchType.EAGER exc will be in: Address address = (Address)session.get(Address.class, 100);
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.EXCEPTION)
	private Collection<Address> address = new ArrayList<Address>();

	public User() {
	}

	public User(int userId, String username, Collection<Address> address) {
		this(userId, username);
		this.address = address;
	}

	public User(int userId, String username) {
		this.userId = userId;
		this.username = username;
		this.address = address;
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

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}

	public Collection<Address> getAddress() {
		return address;
	}

	String toStringDB() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", address=" + address +
				'}';
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", address=" + '[' +
				address.stream().map(address -> address.toStringDB())
						.reduce((a, b) ->  a + ", " + b) +
				']' + '}';
	}
}
