package org.uniquindio.edu.co.pdc.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Rental {

    private final Bike bike;
    private LocalTime startTime;
    private LocalTime endTime;
    private Random code;
    private double price;

    public Rental(Bike bike, Random code) {
        this.bike = bike;
        this.code = code;
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

    public void endRental() {
        this.endTime = LocalTime.now();
        this.price = calculatePrice();
    }

    private double calculatePrice() {
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

    public String generateReceipt() {
        endRental();
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
