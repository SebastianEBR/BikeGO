package org.uniquindio.edu.co.pdc.model;

import java.util.List;
import java.util.Optional;

public class Estacion {

    private Bike[] bikes;
    private int CANTBIKES = 10;

    private String address;

    public Estacion(String address){
        this.address = address;
        this.bikes = new Bike[CANTBIKES];
    }

    public void arriveBike(Bike bike){

        for (int i = 0; i < CANTBIKES  ; i++){
            if (bikes[i] == null){
                bikes[i] = bike;
            } else{
                throw new IllegalArgumentException("no hay mas espacio para bicicletas, esta en el tope: " + i);
            }
        }
    }


    public void removeBike(Bike bike){

        for (int i = 0; i < CANTBIKES  ; i++){
            if (bikes[i] == bike){
                bikes[i] = null;
            } else{
                throw new IllegalArgumentException("no esta esa bicicleta, en la pos: " + i);
            }
        }
    }




}
