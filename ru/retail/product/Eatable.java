package ru.retail.product;

import ru.retail.Storage;

import java.util.List;

public class Eatable extends Product {

    private String experationDate;

    public Eatable(String name, String id, float price, String experationDate){
        super(name, id, price);
        this.experationDate = experationDate;
    }

    public String getExperationDate() {
        return experationDate;
    }

    public static void buildEatable(String name, String id, float price, String experationDate, Storage storage, List<Product> lisfOfStoreProducts) {

        for (int i = 0; i < 1000; i++) {
            Eatable milk = new Eatable(name + i, id, price, experationDate);
            milk.mov(storage);
            milk.setState("В наличии");
        }


    }
}
