package com.cabservice.model;

public class Booking {
    private int id;
    private  String cusmobile;
    private String cusname;
    private  String to;
    private String from;
    private String dname;
    private String dnumber;
    private String status;


    public Booking() {
    }

    public Booking(int id, String cusmobile, String cusname, String to, String from, String dname, String dnumber, String status) {
        this.id = id;
        this.cusmobile = cusmobile;
        this.cusname = cusname;
        this.to = to;
        this.from = from;
        this.dname = dname;
        this.dnumber = dnumber;
        this.status = status;
    }

    public Booking(String cusmobile, String cusname, String to, String from, String status) {
        this.cusmobile = cusmobile;
        this.cusname = cusname;
        this.to = to;
        this.from = from;
        this.status = status;
    }

    public Booking(String dname, String dnumber, String status) {
        this.dname = dname;
        this.dnumber = dnumber;
        this.status = status;
    }

    public Booking(String cusmobile, String cusname, String to, String from, String dname, String dnumber, String status) {
        this.cusmobile = cusmobile;
        this.cusname = cusname;
        this.to = to;
        this.from = from;
        this.dname = dname;
        this.dnumber = dnumber;
        this.status = status;
    }

    public String getCusmobile() {
        return cusmobile;
    }

    public void setCusmobile(String cusmobile) {
        this.cusmobile = cusmobile;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDnumber() {
        return dnumber;
    }

    public void setDnumber(String dnumber) {
        this.dnumber = dnumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
