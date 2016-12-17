package me.srcmaxim.dao;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USERNAME", nullable = false, length = 20)
	private String username;

	public User() {
	}

	public User(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				'}';
	}
}
