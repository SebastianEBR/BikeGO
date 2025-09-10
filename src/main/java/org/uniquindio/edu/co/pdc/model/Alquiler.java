package org.uniquindio.edu.co.pdc.model;

public class Alquiler {

    private Bike bike;
    private double ELECTRICAS = 2000;
    private double CONVENCIONALES = 1000;
    private int timeStart;
    private int timeEnd;
    private int code;
    private double price;

    public Alquiler(Bike bike, int timeStart, int timeEnd, int code) {
        this.bike = bike;
        this.timeStart = timeStart;
        this.timeEnd = timeStart;
        this.code = code;
    }

    public double calculatePriceElectric(Bike bike, int timeStart, int timeEnd, String code, double price){
        double total;

        if (bike.getTypeBike() == TypeBike.ELECTRICA){
            total = (goBike(timeStart) - arriveBike(timeEnd)) * 2000;

        } else if (bike.getTypeBike() == TypeBike.CONVENCIONAL){
            total = (goBike(timeStart) - arriveBike(timeEnd)) * 1000;
        }
        return total;
    }

    private int goBike(int timeStart) {

    }


    @Override
    public String toString() {
        return "Alquiler{" +
                "bike=" + bike +
                ", time=" + timeStart +
                ", time=" + timeEnd +
                ", code=" + code +
                '}';
    }
}
