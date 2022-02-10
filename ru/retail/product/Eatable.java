package ru.retail.product;

import ru.retail.Storage;

import java.util.List;
import java.util.Random;

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
            lisfOfStoreProducts.add(milk);
            storage.getSetOfProducts().add(milk);
        }

    }

    public static Eatable getRandomEatable(String name, String id, float price, String experationDate){
        Random rand = new Random();
        Eatable eatable = new Eatable(name + rand.nextInt(1000), id, price, experationDate);
        return eatable;
    }

    @Override
    public String toString() {
        return super.toString() +
                "experationDate='" + experationDate + '\'';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
