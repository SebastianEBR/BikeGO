package org.uniquindio.edu.co.pdc.model;

public class FactoryBike {
    public static Bike createBike(String type, TypeBike typeBike, String plate){
        switch(type.toUpperCase()){
            case "TRICYCLE":
                return new Tricycle(typeBike, plate);
            case "BICYCLE":
                return new Bicycle(typeBike, plate);
            default:
                throw new IllegalArgumentException("El tipo " + type + " no es valido");
        }
    }
}
