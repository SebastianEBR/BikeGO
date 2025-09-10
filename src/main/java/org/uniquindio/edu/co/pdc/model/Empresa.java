package org.uniquindio.edu.co.pdc.model;

import java.util.ArrayList;
import java.util.Optional;

public class Empresa {

    private static Empresa instance;

    private String name;
    private String nit;

    //conection with other classes
    private ArrayList<Bike> listBikes;
    private ArrayList<User> listUsuarios;
    private ArrayList<Estacion> listEstaciones;
    private ArrayList<Alquiler> listAlquireres;

    private Alquiler alquiler;

    private Empresa(){
        this.listBikes = new ArrayList<>();
        this.listUsuarios = new ArrayList<>();
        this.listEstaciones = new ArrayList<>();
        this.listAlquireres = new ArrayList<>();
    }

    public ArrayList<Estacion> getListEstaciones() {
        return listEstaciones;
    }

    public void setListEstaciones(ArrayList<Estacion> listEstaciones) {
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

    public static Empresa getInstance(){
        if (instance == null){
            instance = new Empresa();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "listEstaciones=" + listEstaciones +
                ", listUsuarios=" + listUsuarios +
                ", listBikes=" + listBikes +
                ", nit='" + nit + '\'' +
                ", name='" + name + '\'' +
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

    public void registerEstacion(Estacion estacion){
        Optional<Estacion> eOptional = findEstacionByAddress(estacion.getAddress());
        if (eOptional.isPresent()){
            throw new IllegalArgumentException("no pueden haber 2 estaciones con la misma direccion: " +estacion.getAddress());
        } else{
            listEstaciones.add(estacion);
        }
    }

    public Optional<Estacion> findEstacionByAddress(String address){
        return listEstaciones.stream().filter(e -> e.getAddress().equals(address)).findFirst();
    }


    public void registerAlquiler(Alquiler alquiler){
        Optional<Alquiler> aOptional = findAlquilerByCode(alquiler.getCode());
        if (aOptional.isPresent()){
            throw new IllegalArgumentException("no pueden haber 2 alquileres con el misma codigo: " + alquiler.getCode());
        } else{
            listAlquireres.add(alquiler);
        }
    }

    public Optional<Alquiler> findAlquilerByCode(String code){
        return listAlquireres.stream().filter(a -> a.getCode().equals(code)).findFirst();
    }


}
