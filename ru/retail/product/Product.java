package ru.retail.product;

import ru.retail.BarCode;
import ru.retail.Storage;

import java.util.HashSet;

public class Product{

    private String name;
    private String state;
    private BarCode barCode;


    public Product(String name, String id, float price) {
        this.name = name;
        this.barCode = new BarCode(id, price);
    }

    public String getName() {
        return name;
    }

    public void setState(String state) {
        this.state = state;
        //System.out.println("Товару " + this.name + " установлен статус " + state);
    }

    public float getPrice() {
        return barCode.getPrice();
    }

    public String getState() {
        return state;
    }

    public void mov(Storage storage) {

        if (!storage.getSetOfProducts().add(this)) {
            System.out.println("Товар " + name + " не перемещен в " + storage.getName());
        }
    }

    public BarCode getBarCode() {
        return barCode;
    }


}
