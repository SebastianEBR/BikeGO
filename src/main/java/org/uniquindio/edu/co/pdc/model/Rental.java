package org.uniquindio.edu.co.pdc.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Rental {

    private static Rental instance;
    private Bike bike;
    private LocalTime startTime;
    private LocalTime endTime;
    private Random code;
    private double price;

    private Rental() {

    }

    public static Rental getInstance(){
        if (instance == null){
            instance = new Rental();
        }
        return instance;
    }

    public Bike getBike() {
        return bike;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Random getCode() {
        return code;
    }

    public void setCode(Random code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void startRental() {
        this.startTime = LocalTime.now();
    }

    public void endRental(Bike bike) {
        this.endTime = LocalTime.now();
        this.price = calculatePrice(bike);
    }

    private double calculatePrice(Bike bike) {
        double rate;

        if (bike.getTypeBike() == TypeBike.ELECTRIC) {
            rate = 2000;
        } else {
            rate = 1000;
        }

        Duration diff = Duration.between(startTime, endTime);
        long seconds = diff.getSeconds();
        return seconds * rate;
    }

    public String generateReceipt(Bike bike) {
        endRental(bike);
        this.code = new Random();
        return toString();
    }

    @Override
    public String toString() {
        return "Rental{" +
                "price=" + price +
                ", code=" + code +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                ", bike=" + bike +
                '}';
    }
}
