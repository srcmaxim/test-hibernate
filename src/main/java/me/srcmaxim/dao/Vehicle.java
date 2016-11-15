package me.srcmaxim.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int moneyPerDayCredit;
    private String licenseNumber;
    private String vehicleName;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Vehicle(int id, int moneyPerDayCredit, String licenseNumber, String vehicleName) {
        this.id = id;
        this.moneyPerDayCredit = moneyPerDayCredit;
        this.licenseNumber = licenseNumber;
        this.vehicleName = vehicleName;
    }

    public Vehicle() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoneyPerDayCredit() {
        return moneyPerDayCredit;
    }

    public void setMoneyPerDayCredit(int moneyPerDayCredit) {
        this.moneyPerDayCredit = moneyPerDayCredit;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", moneyPerDayCredit=" + moneyPerDayCredit +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
