package me.srcmaxim.dao;

import org.hibernate.annotations.Generated;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 5, scale = 0)
	private int userId;

	@Column(name = "USERNAME", nullable = false, length = 20)
	private String username;

	@Column(name = "CREATED_BY", nullable = false, length = 20)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CREATED_DATE", nullable = false, length = 7)
	private Date createdDate;

	@Embedded
	private Address address;

	public User() {
	}

	public User(int userId, String username, String createdBy, Date createdDate, Address address) {
		this.userId = userId;
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
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

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (getUserId() != user.getUserId()) return false;
		if (!getUsername().equals(user.getUsername())) return false;
		if (!getCreatedBy().equals(user.getCreatedBy())) return false;
		if (!getCreatedDate().equals(user.getCreatedDate())) return false;
		return getAddress() != null ? getAddress().equals(user.getAddress()) : user.getAddress() == null;

	}

	@Override
	public int hashCode() {
		int result = getUserId();
		result = 31 * result + getUsername().hashCode();
		result = 31 * result + getCreatedBy().hashCode();
		result = 31 * result + getCreatedDate().hashCode();
		result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", createdBy='" + createdBy + '\'' +
				", createdDate=" + createdDate +
				", address=" + address +
				'}';
	}
}
