package com.cabservice.model;

public class Driver extends Person{

    private String name;
    private String Lisence;
    private int phonenumber;
    private String address;
    private String image;
    public Driver() {
    }

    public Driver(String username, String password, String name, String lisence, int phonenumber, String address) {
        super(username, password);
        this.name = name;
        Lisence = lisence;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public Driver(String username, String password, String name, String lisence, int phonenumber, String address, String image) {
        super(username, password);
        this.name = name;
        Lisence = lisence;
        this.phonenumber = phonenumber;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLisence() {
        return Lisence;
    }

    public void setLisence(String lisence) {
        Lisence = lisence;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
