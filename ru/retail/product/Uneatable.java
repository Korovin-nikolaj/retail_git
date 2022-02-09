package ru.retail.product;

import ru.retail.Storage;

public class Uneatable extends Product {

    private String country;

    public Uneatable(String name, String id, float price, String country){
        super(name, id, price);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public static Uneatable buildUneatable(String name, String id, float price, String country, Storage storage) {
        Uneatable toy = new Uneatable(name, id, price, country);
        toy.mov(storage);
        toy.setState("В наличии");
        return toy;
    }
}
