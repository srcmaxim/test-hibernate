package me.srcmaxim.dao;

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
	@Basic(fetch = FetchType.LAZY,optional = false)
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "street_h")),
			@AttributeOverride(name = "city", column = @Column(name = "city_h")),
			@AttributeOverride(name = "state", column = @Column(name = "state_h")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "zipcode_h"))
	})
	private Address homeAddress;

	@Embedded
	@Basic(fetch = FetchType.LAZY,optional = false)
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "street_o")),
			@AttributeOverride(name = "city", column = @Column(name = "city_o")),
			@AttributeOverride(name = "state", column = @Column(name = "state_o")),
			@AttributeOverride(name = "zipcode", column = @Column(name = "zipcode_o"))
	})
	private Address officeAddress;

	public User() {
	}

	public User(int userId, String username, String createdBy, Date createdDate, Address homeAddress, Address officeAddress) {
		this.userId = userId;
		this.username = username;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", createdBy='" + createdBy + '\'' +
				", createdDate=" + createdDate +
				", homeAddress=" + homeAddress +
				", officeAddress=" + officeAddress +
				'}';
	}
}
