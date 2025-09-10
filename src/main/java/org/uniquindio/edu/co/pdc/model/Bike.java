package org.uniquindio.edu.co.pdc.model;

public class Bike {

    private TypeBike typeBike;
    private String plate;
    private User user;

    public Bike(TypeBike typeBike, String plate) {
        this.typeBike = typeBike;
        this.plate = plate;
    }

    public TypeBike getTypeBike() {
        return typeBike;
    }

    public void setTypeBike(TypeBike typeBike) {
        this.typeBike = typeBike;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "typeBike=" + typeBike +
                ", plate='" + plate + '\'' +
                ", user=" + user +
                '}';
    }
}
