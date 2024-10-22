package org.example.lifesafe.model.entities;

import jakarta.persistence.*;
import org.example.lifesafe.model.enums.InsuranceType;

@Entity
@Table(name = "automobile_insurances")
public class Automobile extends Insurance {

    @Column(name="driver_age", nullable = false)
    private int driverAge;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name="car_use",nullable = false)
    private String carUse;

    @Column(name="driving_history",nullable = false)
    private String drivingHistory;

    public Automobile(){}

    public Automobile(double price, InsuranceType type, int driverAge, String vehicleUse, String drivingHistory, Car car){
        super(price, type);
        this.driverAge = driverAge;
        this.carUse = vehicleUse;
        this.drivingHistory = drivingHistory;
        this.car = car;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getVehicleUse() {
        return carUse;
    }

    public void setVehicleUse(String carUse) {
        this.carUse = carUse;
    }

    public String getDrivingHistory() {
        return drivingHistory;
    }

    public void setDrivingHistory(String drivingHistory) {
        this.drivingHistory = drivingHistory;
    }
}