package com.cabservice.model;

public class Admin extends Person{

    private int id;
    private String name;
    private String email;


    public Admin() {
    }

    public Admin(String username, String password, String name, String email) {
        super(username, password);
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
