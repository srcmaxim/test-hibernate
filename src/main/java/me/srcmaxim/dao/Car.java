package me.srcmaxim.dao;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_CAR")
public class Car extends Vehicle {

    private String typeOfCar;
    private String doorsCount;

    public Car(int id, int moneyPerDayCredit, String licenseNumber, String vehicleName, String typeOfCar, String doorsCount) {
        super(id, moneyPerDayCredit, licenseNumber, vehicleName);
        this.typeOfCar = typeOfCar;
        this.doorsCount = doorsCount;
    }

    public Car() {
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getDoorsCount() {
        return doorsCount;
    }

    public void setDoorsCount(String doorsCount) {
        this.doorsCount = doorsCount;
    }

    @Override
    public String toString() {
        return "Car{" +
                "typeOfCar='" + typeOfCar + '\'' +
                ", doorsCount='" + doorsCount + '\'' +
                "} " + super.toString();
    }
}
