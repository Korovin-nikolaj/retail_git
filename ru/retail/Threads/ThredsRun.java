package ru.retail.Threads;

import ru.retail.product.Product;

public class ThredsRun {

    private static Product product;

    public static void main(String[] args) {
        product = new Product("Уникальный товар", "000001", 100);
        for (int i = 0; i < 10; i++) {
            ClientSession clientSession = new ClientSession("Thread #" + i);
            clientSession.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------Start second variant-------");
        SessionCounter sessionCounter = SessionCounter.getInstance();
        for (int i = 0; i < 10; i++) {
            Thread myThread = new Thread(new ClientSessionThroughRunnable(sessionCounter), "Thread #" + i);
            myThread.start();
        }

    }

    public static Product getProduct() {
        return product;
    }

    public static void setProduct(Product product) {
        ThredsRun.product = product;
    }
}
