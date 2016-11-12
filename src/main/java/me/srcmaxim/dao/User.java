package me.srcmaxim.dao;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class User implements java.io.Serializable {

	@Id
	@Column(name = "USER_ID", nullable = false, length = 20)
	private int userId;

	@Column(name = "USERNAME", nullable = false, length = 20)
	private String username;

	@Column(name = "CREATED_BY", nullable = false, length = 20)
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CREATED_DATE", nullable = false, length = 7)
	private Date createdDate;

	@ElementCollection
	@JoinTable(name = "addresses",
		joinColumns = @JoinColumn(name = "USER_ID")
	)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = {@Column(name = "ADDRESS_ID")}, type = @Type(type = "long"), generator = "hilo-gen")
	@Basic(fetch = FetchType.LAZY)
	private Collection<Address> setOfAddresses = new ArrayList<>();

	public User() {
	}

	public User(int userId, String username, String createdBy, Date createdDate) {
		this.userId = userId;
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
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

	public Collection<Address> getSetOfAddresses() {
		return setOfAddresses;
	}

	public void setSetOfAddresses(List<Address> setOfAddresses) {
		this.setOfAddresses = setOfAddresses;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", createdBy='" + createdBy + '\'' +
				", createdDate=" + createdDate +
				", setOfAddresses=" + setOfAddresses +
				'}';
	}
}
