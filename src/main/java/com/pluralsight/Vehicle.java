package com.pluralsight;

public class Vehicle {
    // Class members
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private float price;

    // Constructor
    public Vehicle(){
        vehicleId = 0;
        makeModel = " ";
        color = " ";
        odometerReading = 0;
        price = 0;
    }

    // Overloaded constructor
    public Vehicle(long l, String s1, String s2, int i, float f){
        setVehicleId(l);
        setMakeModel(s1);
        setColor(s2);
        setOdometerReading(i);
        setPrice(f);
    }

    // Setters (mutators)
    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    // Getters (accessors)
    public long getVehicleId() {
        return vehicleId;
    }
    public String getMakeModel() {
        return makeModel;
    }
    public String getColor() {
        return color;
    }
    public int getOdometerReading() {
        return odometerReading;
    }
    public float getPrice() {
        return price;
    }
}
