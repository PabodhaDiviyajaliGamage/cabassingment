package com.cabservice.model;

public class Vehicle {
    private  String number;
    private String model;
    private String fueltype;
    private String license;

    public Vehicle(String number, String model, String fueltype, String license) {
        this.number = number;
        this.model = model;
        this.fueltype = fueltype;
        this.license = license;
    }

    public Vehicle() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
