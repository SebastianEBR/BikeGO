package org.uniquindio.edu.co.pdc.model;

import java.util.Arrays;

public class Station {

    private Bike[] bikes;
    private int CANTBIKES = 10;

    private Rental rental;
    private String address;

    public Station(String address){
        this.address = address;
        this.bikes = new Bike[CANTBIKES];
    }


    public Bike[] getBikes() {
        return bikes;
    }

    public void setBikes(Bike[] bikes) {
        this.bikes = bikes;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String arriveBike(Bike bike){
        String receipt = "";
        for (int i = 0; i < CANTBIKES  ; i++){
            if (bikes[i] == null){
                bikes[i] = bike;
                receipt = rental.generateReceipt();
            } else{
                throw new IllegalArgumentException("no hay mas espacio para bicicletas, esta en el tope: " + i);
            }
        }
        return receipt;
    }


    public void goBike(Bike bike){

        for (int i = 0; i < CANTBIKES  ; i++){
            if (bikes[i] == bike){
                bikes[i] = null;
                rental.startRental();
            } else{
                throw new IllegalArgumentException("no esta esa bicicleta, en la pos: " + i);
            }
        }
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
