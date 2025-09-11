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
        Rental rental = Rental.getInstance();
        String receipt = "";
        for (int i = 0; i < CANTBIKES  ; i++){
            if (bikes[i] == null){
                bikes[i] = bike;
                User user = bike.getUser();
                user.setBike(null);
                bike.setUser(null);

                receipt = rental.generateReceipt(bike);
                break;
            }
        }
        return receipt;
    }


    public void goBike(User user){
        Rental rental = Rental.getInstance();
        for (int i = 0; i < CANTBIKES  ; i++){

            if (bikes[i] != null){
                Bike bAux = bikes[i];
                user.setBike(bAux);
                bAux.setUser(user);
                bikes[i] = null;
                rental.startRental();
                break;
            } else{
                throw new IllegalArgumentException("no hay bicicletas en esta estacion: ");
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
