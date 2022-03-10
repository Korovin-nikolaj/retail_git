package ru.retail.Threads;

import ru.retail.product.Product;

public class ThredsRun {

    private static Product product;
    public static void main(String[] args) {
        product = new Product("Уникальный товар", "000001", 100);
        for (int i = 0; i < 10; i++ ){
            new ClientSession("Thread #" + i).start();
        }
    }

    public static Product getProduct() {
        return product;
    }

    public static void setProduct(Product product) {
        ThredsRun.product = product;
    }
}
