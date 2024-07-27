package com.example.healthcare;

public class SaveOrder {
    String name,title,quntity,image,Address,pin,state,city,phone,price,date;

    public String getNames() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNames(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuntity() {
        return quntity;
    }

    public void setQuntity(String quntity) {
        this.quntity = quntity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SaveOrder(String name, String title, String quntity, String image, String address, String pin, String state, String city, String phone, String price,String date) {
        this.name = name;
        this.title = title;
        this.quntity = quntity;
        this.image = image;
        Address = address;
        this.pin = pin;
        this.state = state;
        this.city = city;
        this.phone = phone;
        this.price = price;
        this.date = date;
    }


}
