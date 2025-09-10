package org.uniquindio.edu.co.pdc.model;

public enum TypeBike {

    ELECTRICA(1),
    CONVENCIONAL(2);

    private int value;

    TypeBike(int value){
        this.value = value;
    }

    public int getValue(){return value;}
}
