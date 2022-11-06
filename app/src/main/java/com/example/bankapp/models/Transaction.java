package com.example.bankapp.models;

public class Transaction {


    int Id,iconId ;
    String name , price , date ;

    public Transaction() {
    }

    public Transaction(int id, String name, String price, String date) {
        this.iconId = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
