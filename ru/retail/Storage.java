package ru.retail;

import ru.retail.product.Product;

import java.util.HashSet;

public class Storage {

    private String name;
    private boolean taskExists;
    private HashSet<Product> setOfProducts;

    public Storage(String name){
        this.name = name;
        this.setOfProducts = new HashSet<Product>();

    }

    public String getName() {
        return name;
    }

    public boolean isTaskExists() {
        return taskExists;
    }

    public void setTaskExists(boolean taskExists) {
        this.taskExists = taskExists;
    }

    public HashSet<Product> getSetOfProducts() {
        return setOfProducts;
    }
}
