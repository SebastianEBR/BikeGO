package org.uniquindio.edu.co.pdc.model;

public class Tricycle extends Bike implements IBike{

    public Tricycle(TypeBike typeBike, String plate) {
        super(typeBike, plate);
    }


    @Override
    public void run(){
        System.out.println("run");
    }

    @Override
    public void stop(){
        System.out.println("stop");
    }


}
