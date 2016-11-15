package me.srcmaxim.dao;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_MOTO")
public class Motorcycle extends Vehicle {

    private String typeOfMotorcycle;

    public Motorcycle(int id, int moneyPerDayCredit, String licenseNumber, String vehicleName, String typeOfMotorcycle) {
        super(id, moneyPerDayCredit, licenseNumber, vehicleName);
        this.typeOfMotorcycle = typeOfMotorcycle;
    }

    public Motorcycle() {
    }

    public String getTypeOfMotorcycle() {
        return typeOfMotorcycle;
    }

    public void setTypeOfMotorcycle(String typeOfMotorcycle) {
        this.typeOfMotorcycle = typeOfMotorcycle;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "typeOfMotorcycle='" + typeOfMotorcycle + '\'' +
                "} " + super.toString();
    }
}
