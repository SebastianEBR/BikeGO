package org.uniquindio.edu.co.pdc.app;

import org.uniquindio.edu.co.pdc.model.*;


public class Main {
    public static void main(String[] args){
        Company BikeGO = Company.getInstance("name", "102121");

        Bike b1 = FactoryBike.createBike("TRICYCLE", TypeBike.ELECTRIC, "LCS 525");
        Bike b2 = FactoryBike.createBike("BICYCLE", TypeBike.CONVENTIONAL, "LCS 252");

        User u1 = new User.Builder()
                .name("Sebas")
                .id("1059")
                .build();
        User u2 = new User.Builder()
                .name("Sebas")
                .id("1058")
                .address("Carrera")
                .phone("313131")
                .build();

        Station s1 = new Station("carrera 8");
        Station s2 = new Station("carrera 9");

        BikeGO.registerBike(b1);
        BikeGO.registerBike(b2);
        BikeGO.registerEstacion(s1);
        BikeGO.registerEstacion(s2);
        BikeGO.registerUser(u1);
        BikeGO.registerUser(u2);

        BikeGO.asignarBikeStation(b1, s1);
        BikeGO.asignarBikeStation(b2, s1);

        s1.goBike(u1);

        Rental rental = new Rental(b1);
        String recibo = s2.arriveBike(b1, rental);
        System.out.println(recibo);
        System.out.println(BikeGO);
    }
}
