package com.example.allotaxi;

public class Taxi {
    private int image;
    private String driverName;
    private String price;
    private String phoneNumber;


    public Taxi(int image, String driverName, String price, String phoneNumber) {
        this.image = image;
        this.driverName = driverName;
        this.price = price;
        this.phoneNumber = phoneNumber;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
