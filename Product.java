package com.FSD.JPA;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name ;
    private double price;

    public Product()
    {
    }
    public Product(String name, double price)
    {
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

}
