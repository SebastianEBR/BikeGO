package org.uniquindio.edu.co.pdc.model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Company {

    private static Company instance;

    private String name;
    private String nit;

    //conection with other classes
    private ArrayList<Bike> listBikes;
    private ArrayList<User> listUsuarios;
    private ArrayList<Station> listEstaciones;
    private ArrayList<Rental> listRental;

    private Rental rental;

    private Company(String name, String nit){
        this.name = name;
        this.nit = nit;
        this.listBikes = new ArrayList<>();
        this.listUsuarios = new ArrayList<>();
        this.listEstaciones = new ArrayList<>();
        this.listRental = new ArrayList<>();
    }

    public ArrayList<Station> getListEstaciones() {
        return listEstaciones;
    }

    public void setListEstaciones(ArrayList<Station> listEstaciones) {
        this.listEstaciones = listEstaciones;
    }

    public ArrayList<User> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(ArrayList<User> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public ArrayList<Bike> getListBikes() {
        return listBikes;
    }

    public void setListBikes(ArrayList<Bike> listBikes) {
        this.listBikes = listBikes;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Company getInstance(String name, String nit){
        if (instance == null){
            instance = new Company(name, nit);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", nit='" + nit + '\'' +
                ", listBikes=" + listBikes +
                ", listUsuarios=" + listUsuarios +
                ", listEstaciones=" + listEstaciones +
                ", listRental=" + listRental +
                ", rental=" + rental +
                '}';
    }

    public void registerUser(User user){
        Optional<User> uOptional = findUserByID(user.getId());
        if (uOptional.isPresent()){
            throw new IllegalArgumentException("no pueden haber 2 usuarios con el mismo ID: " + user.getId());
        } else{
            listUsuarios.add(user);
        }
    }

    public Optional<User> findUserByID(String id){
        return listUsuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }


    public void registerBike(Bike bike){
        Optional<Bike> bOptional = findBikeByPlate(bike.getPlate());
        if (bOptional.isPresent()){
            throw new IllegalArgumentException("no pueden haber 2 bicicletas con la misma placa: " + bike.getPlate());
        } else{
            listBikes.add(bike);
        }
    }

    public Optional<Bike> findBikeByPlate(String plate){
        return listBikes.stream().filter(b -> b.getPlate().equals(plate)).findFirst();
    }

    public void registerEstacion(Station station){
        Optional<Station> eOptional = findStationByAddress(station.getAddress());
        if (eOptional.isPresent()){
            throw new IllegalArgumentException("no pueden haber 2 estaciones con la misma direccion: " + station.getAddress());
        } else{
            listEstaciones.add(station);
        }
    }

    public Optional<Station> findStationByAddress(String address){
        return listEstaciones.stream().filter(e -> e.getAddress().equals(address)).findFirst();
    }


    public void registerRental(Rental rental){
        Optional<Rental> rOptional = findRentalByCode(rental.getCode());
        if (rOptional.isPresent()){
            throw new IllegalArgumentException("no pueden haber 2 alquileres con el misma codigo: " + rental.getCode());
        } else{
            listRental.add(rental);
        }
    }

    public Optional<Rental> findRentalByCode(Random code){
        return listRental.stream().filter(a -> a.getCode().equals(code)).findFirst();
    }


    public void asignarBikeStation(Bike bike, Station station){
        Optional<Station> sOptional = findStationByAddress(station.getAddress());
        Optional<Bike> bOptional = findBikeByPlate(bike.getPlate());
        if (sOptional.isPresent() && bOptional.isPresent()){
            Station sAux = sOptional.get();
            Bike[] bikes = sAux.getBikes();

            for (int i = 0; i < 10; i++){
                Bike bAux = bikes[i];

                if(bAux == null){
                    bikes[i] = bike;
                    break;
                }else{
                    if (bAux.getPlate().equals(bike.getPlate())){
                        throw new IllegalArgumentException("no pueden haber 2 bicis con el misma placa: " + bike.getPlate());
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("no estan presentes: " + bike + station);
        }

    }
}
