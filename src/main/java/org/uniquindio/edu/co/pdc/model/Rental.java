package org.uniquindio.edu.co.pdc.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Rental {

    private Bike bike;
    private LocalTime startTime;
    private LocalTime endTime;
    private int code;
    private double price;

    public Rental(Bike bike) {
        this.bike = bike;
        this.startTime = LocalTime.now();
        this.code = new Random().nextInt(1000000); // código aleatorio
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void startRental() { this.startTime = LocalTime.now(); }


    public void endRental() {
        this.endTime = LocalTime.now();
        this.price = calculatePrice();
    }

    private double calculatePrice() {
        double rate = (bike.getTypeBike() == TypeBike.ELECTRIC) ? 2000 : 1000;
        Duration diff = Duration.between(startTime, endTime);
        long seconds = diff.getSeconds();
        return seconds * rate;
    }

    public String generateReceipt() {
        endRental();
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
