package com.example.bankapp;

public class Transaction {

    int iconId ;
    String name , price , date ;

    public Transaction(int iconId, String name, String price, String date) {
        this.iconId = iconId;
        this.name = name;
        this.price = price;
        this.date = date;
    }
}
