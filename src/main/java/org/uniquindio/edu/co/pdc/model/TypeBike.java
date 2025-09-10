package org.uniquindio.edu.co.pdc.model;

public enum TypeBike {

    ELECTRIC(1),
    CONVENTIONAL(2);

    private int value;

    TypeBike(int value){
        this.value = value;
    }

    public int getValue(){return value;}
}
