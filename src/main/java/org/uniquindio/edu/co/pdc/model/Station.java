package org.uniquindio.edu.co.pdc.model;

import java.util.Arrays;

public class Station {

    private Bike[] bikes;
    private final int CANTBIKES = 10;
    private String address;

    public Station(String address) {
        this.address = address;
        this.bikes = new Bike[CANTBIKES];
    }

    public Bike[] getBikes() {
        return bikes;
    }

    public void setBikes(Bike[] bikes) {
        this.bikes = bikes;
    }

    public int getCANTBIKES() {
        return CANTBIKES;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String arriveBike(Bike bike, Rental rental) {
        String receipt = "";
        for (int i = 0; i < CANTBIKES; i++) {
            if (bikes[i] == null) {
                bikes[i] = bike;
                User user = bike.getUser();
                if (user != null) {
                    user.setBike(null);
                }
                bike.setUser(null);

                rental.endRental();
                receipt = rental.generateReceipt();
                break;
            }
        }
        return receipt;
    }

    public Rental goBike(User user) {
        for (int i = 0; i < CANTBIKES; i++) {
            if (bikes[i] != null) {
                Bike bAux = bikes[i];
                user.setBike(bAux);
                bAux.setUser(user);
                bikes[i] = null;

                Rental rental = new Rental(bAux);
                rental.startRental();
                return rental;
            }
        }
        throw new IllegalArgumentException("No hay bicicletas en esta estación: " + address);
    }

    @Override
    public String toString() {
        return "Station{" +
                "bikes=" + Arrays.toString(bikes) +
                ", CANTBIKES=" + CANTBIKES +
                ", address='" + address + '\'' +
                '}';
    }
}
