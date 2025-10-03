package com.pluralsight;

public class Vehicle {

    private long vehicleId ;          //(ex: 101121)
    private String makeModel;           //(ex: Ford Explorer)
    private String color;               //(ex: Red)
    private int odometerReading;        //(ex: 32775)
    private float price;                //(ex: 12250.00) (no Lamborghinis here!

    public Vehicle(long vehicleId, String makeModel, int odometerReading, String color, float price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.odometerReading = odometerReading;
        this.color = color;
        this.price = price;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public String toString() {
        // Tip: format price and pad columns cleanly
        return String.format("%d  %s  %s  %d miles  $%,.2f",
                vehicleId, makeModel, color, odometerReading, price);
    }

}
