package ru.retail;

import ru.retail.product.Product;

import java.util.HashSet;

public class Storage {

    private static Storage instance;
    private String name;
    private boolean taskExists;
    private HashSet<Product> setOfProducts;

    private Storage(){
        this.name = "Основной склад";
        this.setOfProducts = new HashSet<Product>();
    }

    public static Storage getInstance() {
        if (instance == null){
            instance = new Storage();
        }
        return instance;
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
