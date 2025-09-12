package org.uniquindio.edu.co.pdc.model;

public class Bicycle extends Bike implements IBike {

    public Bicycle(TypeBike typeBike, String plate) {
        super(typeBike, plate);
    }


    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}
