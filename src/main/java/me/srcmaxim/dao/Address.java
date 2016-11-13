package me.srcmaxim.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private int id;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "address_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Collection<User> user = new ArrayList<User>();

    public Address() {
    }

    public Address(int id, String street, String city, String state, String zipcode, Collection<User> user) {
        this(id, street, city, state, zipcode);
        this.user = user;
    }

    public Address(int id, String street, String city, String state, String zipcode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }

    String toStringDB() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", user="  + '[' +
                user.stream().map(user -> user.toStringDB())
                        .reduce((a, b) ->  a + ", " + b) +
                ']' + '}';
    }
}
