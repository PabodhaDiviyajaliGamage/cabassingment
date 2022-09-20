package com.cabservice.model;

public class Customer extends  Person{
    private int id;
    private String name;
    private int pnber;
    private String address;
    private String license;

    public Customer() {
    }

    public Customer(String username, String password, String name, int pnber, String address) {
        super(username, password);
        this.name = name;
        this.pnber = pnber;
        this.address = address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPnber() {
        return pnber;
    }

    public void setPnber(int pnber) {
        this.pnber = pnber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
