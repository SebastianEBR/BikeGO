package org.uniquindio.edu.co.pdc.app;

import org.uniquindio.edu.co.pdc.model.*;


public class Main {
    public static void main(String[] args){
        Company BikeGO = Company.getInstance("name", "102121");

        Bike b1 = new Bike(TypeBike.ELECTRIC, "LCS525");
        Bike b2 = new Bike(TypeBike.ELECTRIC, "LCS555");

        User u1 = new User.Builder()
                .name("Sebas")
                .id("1059")
                .build();
        User u2 = new User.Builder()
                .name("Sebas")
                .id("1059")
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

        System.out.println(BikeGO.toString());
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
